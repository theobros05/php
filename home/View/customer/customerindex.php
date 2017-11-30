<?php session_start(); ?>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../webroot/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="../webroot/css/bootstrap.css"/>
		<script type="text/javascript" src="../webroot/js/jquery.min.js"></script>
		<script type="text/javascript" src="../webroot/js/validate.js"></script>
		<script type="text/javascript" src="../webroot/js/bootstrap.min.js"></script>
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

			$(document).ready(function() {
	    		$("#popup1").modal({
	        		show: false,
		        	backdrop: 'static'
	    		});
	    
	    	$("#clickupdate").click(function() {
	        $("#popup1").modal("show");             
	    		});
			});
		</script>
	</head>
<body>
	<div style="background-color:Orange;">
		<br>
    	<h1 align="center">Shopping Cart</h1><br>    
    </div>
	<form name="userindex" id="userindex" method="POST" action="customercontroller.php">
	<input type="hidden" name="hid_uname" id="hid_uname" value="<?php echo $_SESSION['username']; ?>">
	<center>
	<br><br>

	<div align="right">
		<a href="ordercontroller.php" class="button" id="myorder" name="myorder">My Orders</a>&nbsp&nbsp
		<a href="" id="click-me" class="button">Change Password</a>&nbsp&nbsp
		<a href="" id="clickupdate" class="button">Update Details</a>&nbsp&nbsp
		<a href="../view/customer/logout.php" class="button">Logout</a>&nbsp&nbsp&nbsp&nbsp&nbsp
	</div>
		<h3><center>Welcome <?php echo $_SESSION['username'];?></center></h3>
		

		<form name="changepassword" id="changepassword" method="POST" action="customercontroller.php">
		    <div class="modal" id="popup" style="display: none;">
		        <div class="modal-header">
		       <button type="button" class="close" data-dismiss="modal" aria-hidden="true">Close</button>
		        <h3>Change Password&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</h3>
		        </div>
		            <div class="modal-body">
		        <center>
            <table>
                <tr><td>Old password:</td><td><input type ='password' id='oldpword' name ='oldpassword' required></td></tr>
                <tr><td>New password:</td><td><input type='password' id='newpword' name='newpassword' required></td></tr>
                <tr><td>Confirm new password</td><td><input type='password' id='renewpword' name='repeatnewpassword' required></td></tr>
            </table>
				</center> 
		            </div>
		    <div class="modal-footer">
		        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
		       <input type="submit" id="changepword" name="changepword" class="btn btn-primary" value="Change Password">
		    </div>
		        </div>
		     </form>



		<form name="frmupdetail" id="frmupdetail" method="POST" action="customercontroller.php">
		    <div class="modal" id="popup1" style="display: none;">
		        <div class="modal-header">
		       <button type="button" class="close" data-dismiss="modal" aria-hidden="true">Close</button>
		        <h3>Update Details&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</h3>
		        </div>
		            <div class="modal-body">
		        <center>
            <table>
                <tr><td>Username:</td><td><input type ='text' id='uname' name ='uname' 
                	value="<?php echo $row['userName']; ?>"></td></tr>
                <tr><td>Contact:</td><td><input type='text' id='contact' name='contact'
                	value="<?php echo $row['contact']; ?>"></td></tr>
                <tr><td>Email:</td><td><input type='email' id='email' name='email'
                	value="<?php echo $row['eMail']; ?>"></td></tr>
                <tr><td>Permanent Address:</td>
					<td><textarea id="paddress" name="paddress">
							<?php echo $row['pAddress']; ?>
						</textarea></td></tr>
				<tr><td>Shipping Address:</td>
					<td><textarea id="saddress" name="saddress">
							<?php echo $row['sAddress']; ?>
					</textarea></td></tr>
            </table>
				</center> 
		            </div>
		    <div class="modal-footer">
		        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
		       <input type="submit" id="updatedetail" name="updatedetail" class="btn btn-primary" 
		       				value="Update">
		    </div>
		</div>
	</form>

		    

		<form name="frmcheckout" id="frmcheckout" method="POST" action="ordercontroller.php">

			<input type="submit" name="checkout" id="checkout" value="Checkout">
		</form>

	</center>
</form>
</body>
</html>