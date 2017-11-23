<!DOCTYPE html>
<?php

session_start();
?>
<html>
<head>
<title>success</title>

    <link rel="stylesheet" type="text/css" href="../webroot/css/bootstrap.min.css">
    <script type="text/javascript" src="../webroot/js/jquery.min.js"></script>
<!--   	<script type="text/javascript" src="../webroot/js/validate.js"></script>
 --><script type="text/javascript">
	function filter(gen){
		$('#hidgen').val(gen);
		$("#succform").submit();
	}
	function single(d){
		 //alert(d);
		$('#hidsin').val(d);
	  	$("#succform").submit();
	}	
	 $(document).ready(function(){

    $("#stxt").click(function(){
    	$("#succform").submit();
    });
    $("#select_id").change(function(){
    	$("#succform").submit();
    });


  });
	
	</script>
</head>
<body> 
<form action="../controller/msdcontroller.php?time=<?php echo date('dmYHis')?>" name="succform" id="succform" method="POST">
<input type="hidden" name="hidsin" id="hidsin">

<h4 align="right" style="font-family:Times New Roman;" ><a href="logout.php">Logout~<?php echo $_SESSION['userid']; ?></a></h4> 
<h4 align="center">success page Table view</h4>
<div style='text-align:center'><h5>Welcome-<?php echo $_SESSION['userid'];?></h5></div>
<center>

<font color="#030005">


<select name="select_id" id="select_id">
        <option value="">-Select-</option>
        <option value="userid">UserId</option>
        <option value="name">Name</option>
        <option value="userType">UserType</option>
        <option value="email">Email</option>
</select>

<input type="text" name="search" id="search" >

<input type="submit" value="Search" id="stxt" name="stxt">

<input type="hidden" name="hidgen" id="hidgen">
<a href="javascript:filter(0);">All</a>
<a href="javascript:filter(1);">Male</a>
<a href="javascript:filter(2);">Female</a>
</font>
</center>

<table class="table table-striped" align="center">
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
	while ($data=mysql_fetch_array($result)) { ?>
	 <tr>
	 	<td><?php echo $i+1; ?></td> 

	 	<td> 
	 	 	
	 	<a class="text-primary" href="javascript:single('<?php echo $data ['userid'];?>');"><?php echo $data ['userid'];?></a>
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
	if ($end>$totalpage) {
		$start=$totalpage-2;
		$end=$totalpage;
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

if($page<$totalpage){

	echo '&nbsp;<a href="?page='.($page+1).'"><b>next</b></a>&nbsp;';
	echo '&nbsp;<a href="?page='.$totalpage.'"><b>last</b></a>&nbsp;';
}
else{
	
	 echo '&nbsp;Next&nbsp;';
	 echo '&nbsp;Last&nbsp;';
}

?>
</body>
</html>
