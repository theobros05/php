<?php
	
class servicemodel
	{
		public $con;
		function servicemodel()
			{	
				$this->con = mysql_connect("localhost","root","");
				mysql_select_db("cart",$this->con);
			}


		
		
		function forgotmail($toMail)
			{
				$row = mysql_query("SELECT password FROM usertable WHERE eMail = '$toMail'",$this->con);
				$querymail = mysql_fetch_array($row);
				return $querymail;
			}

		function passwordupdate($password,$toMail)
			{
				$querymailupdate = mysql_query("UPDATE usertable SET password = '$password' WHERE eMail='$toMail'",$this->con);

			}

		function fninvoice($uname)
			{
				
				$row = mysql_query("SELECT orderId,productName,quantity,userName,price,contactNo,createdDate,add1 FROM ordertable where userName='$uname'",$this->con);
				
				$result = mysql_fetch_array($row);
				return $result;
				
			}


	}

?>