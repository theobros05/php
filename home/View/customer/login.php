<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../webroot/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="../../webroot/css/bootstrap.css"/>
		<script type="text/javascript" src="../../webroot/js/jquery.min.js"></script>
		<script type="text/javascript" src="../../webroot/js/validate.js"></script>
		<script type="text/javascript" src="../../webroot/js/bootstrap.min.js"></script>
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
<body>
	<div style="background-color:Orange;">
		<br>
    	<h1 align="center">Shopping Cart</h1>
    	<br>      
    </div>
		<form name="frmlogin" id="frmlogin" method="POST" action="../../controller/customercontroller.php">
				<center>
				<br><br><br><br>
					<h1>Login Here</h1>
					<table>
						<tr><td>User Name</td>
							<td><input type="text" name="username" id="username" placeholder="Enter your Username"></td>
						</tr>
						<tr><td>Password</td>
							<td><input type="password" name="pword" id="pword" placeholder="Enter your password"></td>
						</tr>
						<tr>
							<td colspan=2 align="center">
							<input type="submit" class="button" name="login" id="login" value="Login">&nbsp&nbsp&nbsp
							<input type="reset" class="button" name="reset" value="Reset"></td>
						</tr>
					</table>
					<h3><a href="signup.php">Signup Here</a>&nbsp&nbsp&nbsp
						<a id="click-me">Forgot password</a></h3>
			</form>

			<form name="frmforgotpassword" id="frmforgotpassword" method="POST" action="../../controller/servicecontroller.php">
		        <div class="modal" id="popup" style="display: none;">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">Close</button>
		                <h3>Forgot password&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</h3>
		            </div>
		            <div class="modal-body">
		                
		               <input type="text" name="forgotemail" id="forgotemail" placeholder="Your Registered Email">

		            </div>
		            <div class="modal-footer">
		                <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
		                <input type="submit" id="email" name="email" class="btn btn-primary" value="Submit">
		            </div>
		        </div>
		     </form>
	</body>
</html>
