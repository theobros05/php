<!DOCTYPE html>
<?php include 'header.php'; ?>
<html>
<head>
  <title>Update database</title>
</head>
<body>
<?php  

session_start();

    $del=$_REQUEST['del'];


$con=mysql_connect("localhost", "root", "");// or die (mysql_error()); //Connect to server
          mysql_select_db("phpproject",$con);// or die ("Cannot connect to database"); //Connect to database

$query = "UPDATE msdUser SET delFlag = '1' WHERE userid = '$del'";

if(mysql_query($query)){

  header('location:sucess.php');

}
else{

echo "fail";}

// elseif(!empty($del)){ // to select the table values by page nation
//  $query=mysql_query("UPDATE msdUser SET delFlag = '1' WHERE userid = '$del'",$con);
// }

?>
</body>
</html>

