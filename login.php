<!DOCTYPE html>
<html>
<head>
  <title>login.php</title>
<body>
  <style>
      h1{text-align: center;}
      body{background-color: yellow}
      h2{text-align: center;}
      
 
    </style>
</head>
<body>
<?php
session_start();

  $userid=$_REQUEST['uid'];// get user name from form

    $pass=$_REQUEST['pword'];// get password from form
    $passw=md5($pass); // password encrypt file.

 $con=mysql_connect("localhost", "root", "");// or die (mysql_error()); //Connect to server
          mysql_select_db("phpproject",$con);// or die ("Cannot connect to database"); //Connect to database

$query=mysql_query("SELECT * FROM msdUser Where userid='$userid' AND password='$passw'",$con); 

$login=mysql_fetch_array($query);

$_SESSION['uid']=$login['name'];


if ($login) {

echo "password ok";

   header('Location:sucess.php');
  }else {

echo "password wrong";

  header('Location:index.php');
 } 
 ?>


 </body>
</html>