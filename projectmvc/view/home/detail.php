<!DOCTYPE html>
<?php session_start(); ?>
<html>
<head>
    <title>Detail page</title>
    <script type="text/javascript" src="../webroot/js/jquery.min.js"></script>
    <script type="text/javascript" src="../webroot/js/validate.js"></script>
    <link rel="stylesheet" type="text/css" href="../webroot/css/bootstrap.min.css">
<script type="text/javascript">
    function single(d){
         //alert(d);
        $('#hidsin').val(d);
        $("#succform").submit();
    }
</script>
</head>
<body class="detail">
    <h5 align="center">Single View</h5>
     <h4 align="right" style="font-family:Times New Roman;" ><a href="logout.php">Logout~<?php session_start(); echo $_SESSION['userid']; ?></a></h4> 


<h5 align="right" style="font-family:Times New Roman;"><a onclick="javascript:popup(this.href); return false;" href="delete.php?del=<?php echo $id;?>"><b>Click here to Disable User </b></a></h5>

<form action="../controller/msdcontroller.php?time=<?php echo date('dmYHis')?>" method="POST" >
    <input type="hidden" name="delusr" id="delusr">

<table class="table table-striped">
    
    <?php $i=0;

    while ($data=mysql_fetch_array($result)) { ?>

    <tr><td> S.No </td><td><input type="text" id="sno" name="upid" value="<?php echo $data ['id']; ?> " readonly></td></tr>

    <tr><td> UserId </td><td><input type="text" id="upusid" name="upusid" value="<?php echo $data ['userid']; ?> " readonly></td></tr>

    <tr><td> Name </td><td><input type="text" name="upname" id="upname"  value="<?php echo $data ['name']; ?> "></td></tr>


    <tr><td> Gender </td><td>



    <input type="radio" name="gen" <?php echo ($data ['gender']=='1')? 'checked':'' ?> value="1">Male<br>
    <input type="radio" name="gen" <?php echo ($data ['gender']=='2')? 'checked':'' ?> value="2">Female<br></td>
</tr>


 

    <tr><td> UserType </td><td>

<select name="upusertype">
    <option value="" <?php if($data ['userType']==""){echo "selected";}?>>--select--</option>
    <option value="1" <?php if($data ['userType']=="1"){echo "selected";}?>>Admin</option>
    <option value="2" <?php if($data ['userType']=="2"){echo "selected";}?>>Employee</option>
    <option value="3" <?php if($data ['userType']=="3"){echo "selected";}?>>Student</option>
    
</select>  
    </td></tr>
    <tr><td> Address </td><td><input type="text" id="upadd" name="upadd" value="<?php echo $data ['address']; ?> " ></td></tr>

    <tr><td> Contact </td><td><input type="text" id="upcon" name="upcon" value="<?php echo $data ['contact']; ?> "></td></tr>

    <tr><td> pincode </td><td><input type="text" id="uppin" name="uppin" value="<?php echo $data ['pincode']; ?> "></td></tr>
<?php 

$p = explode(',',$data ['payment']);

    $check=$p[0];
    $cash=$p[1];
    $card=$p[2];

    ?>
    <tr><td colspan="1"> Payment </td><td>
        <input type="checkbox" id="uppin" name="check" value="1" <?php if($check=="1"){echo "checked";} ?>><label>Check</label>
        <input type="checkbox" id="uppin" name="cash" value="2" <?php if($cash=="2"){echo "checked";} ?>><label>Cash</label>
        <input type="checkbox" id="uppin" name="credit" value="3" <?php if($card=="3"){echo "checked";} ?>><label>Credit Card</label>
    </td></tr>

    <tr><td> Email </td><td><input type="text" id="upemail" name="upemail" value="<?php echo $data ['email']; ?> " ></td></tr>

    <tr><td> Image </td><td><img src="upload/<?php echo $data ['image']; ?> " height="100px" width="100px"></td></tr>
   <?php } 

   ?>  
    

          
 </table>
       
  
<!-- to update some values in table by validating in updated.php page -->
<center>
<!--     <input type="submit" name="Submit" value="UPDATE" />
 -->    
</center>
</form>

</body>
</html>
