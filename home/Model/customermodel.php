<?php	
class customermodel{
		public $con;
		function customermodel()
			{
				$this->con = mysql_connect("localhost","root","");
				mysql_select_db("cart",$this->con);
			}

		function countgen()
			{
				$count = mysql_query("SELECT COUNT(*) as cnt FROM usertable",$this->con);
				$total = mysql_fetch_array($count);
				$countdata = $total['cnt']+1;
				return $countdata;
			}

		function fnsignup($userid,$username,$gender,$paddress,$contact,
                           $pincode,$email,$curdate,$createdby,$delflag)
            {
            	$queryreg = mysql_query("INSERT INTO usertable(userID,userName,gender,contact,
            					eMail,pAddress,pincode,createdDate,createdBy,delFlag)
								VALUES('$userid','$username','$gender','$contact','$email',
								'$paddress','$pincode','$curdate','$createdby','$delflag')",$this->con);
				return $queryreg ;
            }	

            function login($uname,$pass)
			{	
				session_start();
				$value = mysql_query("SELECT * FROM usertable Where userName='$uname' AND 
										password='$pass'",$this->con);
				$query = mysql_fetch_array($value);
				$_SESSION['username'] = $query['userName'];
				
				return $query ;
			}

			function getupdate($uname)
				{
					$sql=mysql_query("SELECT * FROM usertable WHERE userName='$uname'",$this->con);
					$row = mysql_fetch_array($sql);
					return $row;
				}

        function passwordupdate($password,$toMail)
			{
				$querymailupdate = mysql_query("UPDATE usertable SET password = '$password' WHERE eMail='$toMail'",$this->con);
			}


        function pwordchk($uname)
        	{
        		$get = mysql_query("SELECT password FROM usertable WHERE userName='$uname'",$this->con);
          		$row = mysql_fetch_array($get);
          		return $row;
        	}

        function pwordchange($uname,$newpassword)
        	{
        		$change = mysql_query("UPDATE usertable SET password='$newpassword' WHERE 
        								userName='$uname'",$this->con);
        		return $change;
        	}

        function updetail($uname,$paddress,$saddress,$contact,$email,$sesion)
			{
				$update = mysql_query("UPDATE usertable SET userName='$uname',pAddress='$paddress',sAddress='$saddress',contact='$contact',eMail='$email' Where userName='$sesion'",
					$this->con);
				return $update;
			}
     }
?>