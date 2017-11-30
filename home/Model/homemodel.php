<?php
	
class homemodel
	{
		public $con;
		function homemodel()
			{	
				$this->con = mysql_connect("localhost","root","");
				mysql_select_db("cart",$this->con);
			}




	}

?>