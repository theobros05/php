<!DOCTYPE html>
<?php include 'header.php'; ?>
<html>
<head>
	<title>REGISTER DATABASE</title>
<body class="register">
	<h4 align="right" style="font-family:Times New Roman;" ><a href="logout.php">Logout~<?php session_start(); echo $_SESSION['uid']; ?></a></h4> 
</head>
<body>

<?php
session_start();


   // $username=$_REQUEST['uid'];// get user name from form
    $name=$_REQUEST['name'];
    echo "$name";

    $pass=$_REQUEST['pword'];// get password from form
    $passw=md5($pass); // password encrypt file.

    $date = date('Y-m-d H:i:s'); // get date
    $delFlag='0';

    $gender=$_REQUEST['gender']; // set gender as 1 for male and 2 for female

    $usertype=$_REQUEST['usertype']; // set user type as 1,2,3,4
    $Address=$_REQUEST['add1']; // set address

    $contact=$_REQUEST['contact']; // set contact 
    $pincode=$_REQUEST['pcode']; // set pincode
    $email=$_REQUEST['email'];

    $check=$_REQUEST['check']; // modyfying payment type to 1,2,3
     $cash=$_REQUEST['cash'];
    $credit=$_REQUEST['credit'];

    
$payment=$check.",".$cash.",".$credit;// set payment type

         $img=$_FILES['img']; // to upload files 

         print_r($img);


         $imgname=$img['name'];
         $imgtemp=$img['tmp_name'];
// to copy file from one location to another useing script in php
         $path="upload/"; // file path
          $imgnam=$imgname;
      $ext=substr(strtolower(strchr($imgname,'.')),1); // to get image extension
      $array_ext=array('jpg','jpeg','png'); 
      
      if (in_array($ext,$array_ext))  // check image file location
        {
          move_uploaded_file($imgtemp,$path.$imgname);

          $con=mysql_connect("localhost", "root", "");// or die (mysql_error()); //Connect to server
          mysql_select_db("phpproject",$con);// or die ("Cannot connect to database"); //Connect to database

      $count = mysql_query("SELECT COUNT(*) as cnt FROM msdUser",$con); // get total number of rows from table


// 4 line code to create a unique userid 
      $total =mysql_fetch_array($count); // get the data in array form

      $cd=$total['cnt']+1; // increase row count by 1

      $s="TEN"; // user id constant value

      $uid=str_pad($cd,4,"0",STR_PAD_LEFT); // modify user id to TENOO01

      $userid=$s.$uid; // final user id


          $query=mysql_query("INSERT INTO msdUser(userid,name,password,createdBy,createdDate,delFlag,gender,userType,address,contact,pincode,payment,email,image)VALUES('$userid','$name','$passw','$name','$date','$delFlag','$gender','$usertype','$Address','$contact','$pincode','$payment','$email','$imgnam')",$con);
          // header('localhost:index.html');
        }
      else {
         echo "Invaild Image Format";
          exit();
        }

/* table should have , requied fields
1. id should be primary key and auto increment and dont allow null
2. created by, give used name ex admin varchar
3.created date give date
4.updatedby, 
5.updated date, 
6.del flg should not allow null
should 0 as active user if the user is not active make del flg as 1
** madatory fields should not allow null values

for numbers givetype  int, big int
for text give type as text
password length- 255

*/


?>
</body>
</html>