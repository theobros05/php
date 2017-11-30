<html>
<head>
	<script type="text/javascript" src="../../webroot/js/jquery.min.js"></script>
	<script type="text/javascript"src="../../webroot/js/validate.js"></script>
	<script>
	$(document).ready(function(){
      $("#pdchange").click(function(){
        var opwd=$("#old").val();
        var npwd=$("#new").val();
        var cpwd=$("#confirm").val();
      if(opwd==""){
        alert("enter old password");
        return false;
      } 
      else if(npwd==""){
        alert("enter  new password");
        return false;
      }
      else if(cpwd==""){
        alert("enter confirm password");
        return false;
      }
      else{
        $("#frmmlogin").submit();
        }
    });
  });
	</script>
</head>	
<?php 
session_start();
?>
<body>
<center>
<form name="frmlogin" id="frmmlogin" action="pwdchanged.php">
<table border="3">
<tr><td>userId</td>
<td><input type="text" name="idd" id="idd">
</td></tr>
<tr><td >Old Password</td>
<td><input type="text" name="oldd" id="old"></td></tr>
<tr><td>New Password</td>
<td><input type="text" name="neww" id="new"></td></tr>
<tr><td>confirm Password</td>
<td><input type="text" name="confirmm" id="confirm"></td></tr>
<tr align="center">
<td colspan=2> <input type="submit" value="pwdchange" id="pdchange"></td>
</tr>
</table>
</center>
</form>
</body>
</html>

