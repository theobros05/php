<!DOCTYPE html>
<?php include 'header.php'; ?>
<html>
<head>
  <title>Update database</title>
</head>
<body>
<?php  

session_start();
    $upuser=$_REQUEST['upusid'];
    $name=$_REQUEST['upname'];
    $gen=$_REQUEST['gen'];

    $usertype=$_REQUEST['upusertype'];
    $Address=$_REQUEST['upadd'];

    $contact=$_REQUEST['upcon'];
    $pincode=$_REQUEST['uppin']; 
    $email=$_REQUEST['upemail'];

    $check=$_REQUEST['check']; // modyfying payment type to 1,2,3
     $cash=$_REQUEST['cash'];
    $credit=$_REQUEST['credit'];

    
$payment=$check.",".$cash.",".$credit;// set payment type

echo"$upuser";
echo"$name";
echo"$gen";
echo"$usertype";
echo"$Address";
echo"$contact";
echo"$pincode";
echo"$email";
echo "$payment";


$con=mysql_connect("localhost", "root", "");// or die (mysql_error()); //Connect to server
          mysql_select_db("phpproject",$con);// or die ("Cannot connect to database"); //Connect to database

$query = "UPDATE msdUser SET name = '$name', gender='$gen',userType='$usertype',address='$Address',contact='$contact',pincode='$pincode',email='$email',payment='$payment' WHERE userid = '$upuser'";

if(mysql_query($query)){
echo "updated";}
else{
echo "fail";}

?>
</body>
</html>

