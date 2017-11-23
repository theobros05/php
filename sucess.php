<!DOCTYPE html>
<?php include 'header.php'; ?>
<html>
<head>
<title>success</title>

<link rel="stylesheet" href="css/boot.min.css">
<!-- <script type="text/javascript" charset="utf8" src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.3.js"></script> -->
<!-- <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
<!-- <link rel="stylesheet" href="css/simplePagination.css" />
<script src="js/jquery.simplePagination.js"></script> -->

</head>
<script> // to pass value of usertype to $ut.
function test(a) {
var x = (a.value || a.options[a.selectedIndex].value);  //crossbrowser solution =)
//loading the url with usertype value
window.location.href = "sucess.php?x=" + x; 
}
</script>
<body class="success" >
	<form method="post" action="sucess.php" id="nameform">
<?php

session_start();
$con=mysql_connect("localhost", "root", "");// or die (mysql_error()); //Connect to server
mysql_select_db("phpproject",$con);// or die ("Cannot connect to database"); //Connect to database

?>


<h4 align="right" style="font-family:Times New Roman;" ><a href="logout.php">Logout~<?php echo $_SESSION['uid']; ?></a></h4>
<h4 align="right" style="font-family:Times New Roman;" ><a href="pdf.php">PDF Download</a></h4> 

<h3 align="center">success page Table view</h3>
<div style='text-align:center'><h3>Welcome-<?php echo $_SESSION['uid'];?></h3></div>
<center>

<font color="#030005">


<select onchange="test(this)" id="select_id">
        <option value="">-Select-</option>
        <option value="userid">UserId</option>
        <option value="name">Name</option>
        <option value="userType">UserType</option>
        <option value="email">Email</option>
</select>
<!-- code check -->

<?php 
$ut = $_REQUEST['x'];
echo "$ut"; ?>


<?php $gender=$_REQUEST['gen']; // including html tag in php, loading href with gender value 

				if ($gender=='') { echo "ALL"; } else{ ?>
					
				<a href="sucess.php" style="color:black">All</a>  

				<?php }

				if ($gender=='1') { echo "MALE"; } else{ ?>
					
				<a href="sucess.php?gen=1" style="color:black">Male</a>  

				<?php } 
				if ($gender=='2') { echo "FEMALE"; } else{ ?>
				<a href="sucess.php?gen=2" style="color:black">Female</a> 
				<?php } ?>

<input type="text" name="search" id="search" >

<input type="submit" value="search" id="search" form="nameform">

<?php  $s=$_REQUEST['search'];
echo"$s";
?>
</font>
</center>



<?php
session_start();

// $page = $_REQUEST['page'];

// if ($page<1) {
// 	$page=1;
// }
 
// code for pagenation 
$limit = 2;  
if (isset($_GET["page"])) { $page  = $_GET["page"]; } else { $page=1; };

$start_from = ($page-1) * $limit;
$query=mysql_query("SELECT COUNT(id) FROM msdUser",$con); 

$row = mysql_fetch_row($query);  
$total_records = $row[0];  
$total_pages = ceil($total_records / $limit);


if (!empty($gender)) { // to select table by gender

$query=mysql_query("SELECT * FROM msdUser Where gender='$gender' AND delFlag='0'",$con);	
}
elseif(!empty($s)){ // to select by like mothod in query with input from serach box ex=a;
$query = mysql_query("SELECT * FROM msdUser where name like '%$s%' AND delFlag='0'",$con);

 }
elseif(!empty($ut)) { // to sort by user type
 $query = mysql_query("SELECT * FROM msdUser where delFlag='0' ORDER BY $ut ASC",$con);
}
elseif(!empty($page)){ // to select the table values by page nation
 $query=mysql_query("SELECT * FROM msdUser where delFlag='0' ORDER BY id ASC LIMIT $start_from, $limit",$con);
}
else{ // to select all the table values
$query=mysql_query("SELECT * FROM msdUser Where delFlag='1'",$con);
}
?>



<table class="table table-bordered table-striped" style="font-family:sans serif;" align="center" border="1" bgcolor="white">
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

	 	<td>  <a href="detail.php?id=<?php echo $data['userid'];?>"><?php echo $data ['userid'];?></a>
	        
	 	</td>
	 	<td><?php echo $data ['name']; ?></td>

	 	<td><?php echo $data ['gender']>1?"Female":"Male"; ?></td>

	 	<!-- <td><?php if($data ['userType']==1){ echo "Admin";}; ?></td> -->

	 	<td><?php $n=$data ['userType'];  

	 	switch ($n) {
    case 1:
        echo "Admin";
        break;
    case 2:
        echo "Employee";
        break;
    case 3:
        echo "Student";
        break;
    default:
        echo "not available";
}      ?></td> 


	 	<td><?php echo $data ['address']; ?></td>
	 	<td><?php echo $data ['contact']; ?></td>
	 	<td><?php echo $data ['pincode']; ?></td>

	 	<td><?php $str=$data ['payment']; 

  	$p = explode(',',$str);
    

    if (in_array("1", $p)) {
    echo "check ";
}
	if (in_array("2", $p)) {
    echo "cash ";
}
	if (in_array("3", $p)) {
    echo "card";
}
     

	 	?></td>

	 	<td><?php echo $data ['email']; ?></td>
	 </tr> <?php $i++;
	} ?>
</table>

</form>

<?php  
  // code for pagenation
if ($page>1) {
	echo '<a href="?page=1"><b>First</b></a>&nbsp;';
	echo '<a href="?page='.($page-1).'"><b>Prevoius</b></a>&nbsp;';
}else{
	echo'&nbsp;First&nbsp;';
	echo'&nbsp;Prevoius&nbsp;';
}
$start=1;
$end=3;
if ($page>3) {
	$start=$page-1;
	$end=$page+1;
	if ($end>$total_pages) {
		$start=$total_pages-2;
		$end=$total_pages;
	}
}
for($i=$start;$i<=$end;$i++){
    if($i==$page){
    echo '&nbsp;<strong>'.$i.'</storng>&nbsp;';		
    }
    else{
      echo '&nbsp;<a href="?page='.$i.'">'.$i.'</a>&nbsp;';
  }
}

if($page<$total_pages){

	echo '&nbsp;<a href="?page='.($page+1).'"><b>next</b></a>&nbsp;';
	echo '&nbsp;<a href="?page='.$total_pages.'"><b>last</b></a>&nbsp;';
}
else{
	
	 echo '&nbsp;Next&nbsp;';
	 echo '&nbsp;Last&nbsp;';
}

?>
</body>
</html>
