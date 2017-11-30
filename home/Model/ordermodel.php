<?php
	 session_start();
	
class ordermodel
	{
		public $con;
		function ordermodel()
			{	
				$this->con = mysql_connect("localhost","root","");
				mysql_select_db("cart",$this->con);
				   
			}


		function viewprocess()
		{
		
		return mysql_query("SELECT * FROM ordertable",$this->con);
		}
	    function addtocartdefault(){

	    	return mysql_query("SELECT * FROM products",$this->con);

	    }
	    function productlistm(){

	    return mysql_query("SELECT * FROM products",$this->con);

	    }

	    function orderlist()
	    	{
	    		return mysql_query("SELECT * FROM ordertable Where userName='$uname'",$this->con);
	    	}
	    function cartinsert1()
	    	{
	    	  mysql_query("SELECT * FROM ordertable Where userName='$uname'",$this->con);
	    	}
	    function countpage() {
			$count =mysql_query("SELECT COUNT(*) FROM ordertable",$this->con);  
            $row = mysql_fetch_row($count); 
            $totalrecord = $row[0];
            return $totalrecord;
    }   
        function pagenation($startresult,$limit) {
			return mysql_query("SELECT * FROM ordertable LIMIT $startresult,$limit",$this->con); 
		}
		function search($Search){
		return mysql_query("SELECT * FROM ordertable where userName like '%$Search%'",$this->con);
		echo "$Search";
    }


	 }

?>