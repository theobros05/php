<!DOCTYPE html>
<html>
<head>
<title>Login</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="../../webroot/js/validate.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/css/bootstrap.css" rel="stylesheet"/>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
    $("#popup").modal({
        show: false,
        backdrop: 'static'
    });
    
    $("#click-me").click(function() {
       $("#popup").modal("show");             
    });
});
</script>


</head>
<body class="index" style="background-image: url(../../webroot/image/les.jpg);">


<h2 align="center">LOGIN</h2>
<!-- take userid and password send to login.php for validation 

-->
<form name="formlogin" action="../../controller/msdcontroller.php?time=<?php echo date('dmYHis')?>" id="formlogin" method="POST"> 

<div align="center"><TABLE>
<TABLE BORDER="2" CELLPADDING="2" CELLSPACING="2">
<tr>
  <td bgcolor="#00BFFF">UserId</td>
  <td> <input type="text" maxlength="10" value="" name="uid" id="uid"></td>

</tr>

<td bgcolor="#00BFFF">Password</td>
<td><input type="password" maxlength="10" value="" name="pword" id="pword"></td></tr>

<td colspan="2" align="center" >

  <input type="submit" value="Login" id="btnlogin" name="btnlogin" class="grey">
  <!-- using btnlogin in validate.js to validate alert -->
  <input class="grey" type="reset"  value="Reset"> 
  <a href="registration.php">Sign up/Register</a>

</td>

</table>
</div>
</form>
<form name="passval" method="post" action="passval.php" >
<div class="modal" id="popup" style="display: none;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h3>Enter Email Id</h3>
            </div>
            <div class="modal-body">

                <input type="text" name="mail" id="mail">
              
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                <button class="btn btn-primary">Submit</button>
                <!-- onclick="location.href='passval.php'" -->
            </div>
        </div>
        <div align="center">
        <a id="click-me" class="btn btn-primary">Forgot Password</a> 
        </div>
        </form>
    </body>
        <script type="text/javascript" src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.1.0/js/bootstrap.min.js"></script>
</html>

