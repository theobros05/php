<!DOCTYPE html>
<?php include 'header.php'; ?>
<html>
<head>
<title>Admin View</title>
<h3 align="right"><a href="admin.php">Admin</a></h3>

</head>
<body class="admin">

<?php

 $con=mysql_connect("localhost", "root", "");// or die (mysql_error()); //Connect to server
          mysql_select_db("phpproject",$con);// or die ("Cannot connect to database"); //Connect to database

$query=mysql_query("SELECT * FROM msdUser",$con); 

?>

<h2 align="center" font face="verdana" >Admin View table</h2>

<table align="center" border="2px" >
  <tr>
    <td>S.No</td>
    <td>UserId</td>
    <td>Name</td>
    <td>Gender</td>
    <td>UserType</td>
    <td>Address</td>
    <td>Contact Number</td>
    <td>pincode</td>
    <td>payment</td>
    <td>Email</td>
  </tr>
  <?php $i=0;
  while ($data=mysql_fetch_array($query)) { ?>
   <tr>
    <td><?php echo $i+1; ?></td>
    <td><?php echo $data ['userid']; ?></td>
    <td><?php echo $data ['name']; ?></td>

    <td><?php echo $data ['gender']>1?"Female":"Male"; ?></td>
    <td><?php echo $data ['userType']; ?></td>
    <td><?php echo $data ['address']; ?></td>
    <td><?php echo $data ['contact']; ?></td>
    <td><?php echo $data ['pincode']; ?></td>

    <td><?php echo $data ['payment']; ?></td>

    <td><?php echo $data ['email']; ?></td>
   </tr> <?php $i++;
  } ?>
</table>


</body>
</html>
