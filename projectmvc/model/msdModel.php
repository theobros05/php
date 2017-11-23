<?php
 session_start();

class msdModel {

	public $con;
	function msdModel(){
		$this->con=mysql_connect("localhost", "root", "");
        mysql_select_db("phpproject",$this->con);
	}
	function fnloginchk($userid,$pwd){
		session_start();

		$query=mysql_query("SELECT * FROM msdUser Where userid='$userid' AND password='$pwd'",$this->con); 
		$val=mysql_fetch_array($query);

		$_SESSION['userid']=$val['userid'];
		return $val;

	}
	function countgen(){
		$count=mysql_query("SELECT count(*) as cnt FROM msdUser",$this->con); 
		$total =mysql_fetch_array($count); // get the data in array form
		$cd=$total['cnt']+1; // increase row count by 1
		return $cd;
	}
	function fnregchk($userid,$name,$passw,$name,$date,$delFlag,$gender,$usertype,$Address,$contact,$pincode,$payment,$email,$imgnam){
		session_start();

		$query=mysql_query("INSERT INTO msdUser(userid,name,password,createdBy,createdDate,delFlag,gender,userType,address,contact,pincode,payment,email,image)VALUES('$userid','$name','$passw','$name','$date','$delFlag','$gender','$usertype','$Address','$contact','$pincode','$payment','$email','$imgnam')",$this->con);
		return $query;
		
	}
	function countpage() {
			$count =mysql_query("SELECT COUNT(*) FROM msdUser where delFlag='0'",$this->con);  
            $row = mysql_fetch_row($count); 
            $totalrecord = $row[0];
            return $totalrecord;
    } 


	function viewprocess(){
		
		return mysql_query("SELECT * FROM msdUser Where delFlag='0'",$this->con);
	}
	function gender($fil){
		return mysql_query("SELECT * FROM msdUser Where gender='$fil' AND delFlag='0'",$this->con);
    }
    function search($search){
		return mysql_query("SELECT * FROM msdUser where name like '%$search%' AND delFlag='0'",$this->con);
    }
    function usertype($ut){
		return mysql_query("SELECT * FROM msdUser where delFlag='0' ORDER BY $ut ASC",$this->con);
    }
    function single($single){
		return mysql_query("SELECT * FROM msdUser where userid='$single' AND delFlag='0'",$this->con);
    }
    function pagenation($startresult,$limit) {
			return mysql_query("SELECT * FROM msdUser  where delFlag='0' LIMIT $startresult,$limit",$this->con); 
		}

	
}

?>