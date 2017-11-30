<?php
session_start();	
?>
<!DOCTYPE html>
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
	<center>
		<div style="background-color:Orange;">
	    	<h1 align="center">Shopping Cart</h1>
    	</div>
    <div align="right">
    	<a href="../../controller/ordercontroller.php" class="button" id="myorder" name="myorder">My Orders</a>&nbsp&nbsp
		<a href="../../customer/customercontroller.php" id="login" name="login" class="button"
		 value="<?php echo $_SESSION['username'];?>">My Account</a>
		&nbsp&nbsp
		<a href="../customer/logout.php" class="button">Logout</a>&nbsp&nbsp&nbsp&nbsp&nbsp
	</div>

	<form id="frmpayment" name="frmpayment" method="POST" action="../../controller/servicecontroller.php">

	<input type="hidden" name="hid_uname" id="hid_uname" value="<?php echo $_SESSION['username']; ?>">
			<h2>Select Payment Method<h2>
			<div style="background-color: #adf0af ;">
				<br><br>
					<input type="radio" name="pay" id="cashondelivery" value="1">&nbsp
					 Cash on Delivery &nbsp&nbsp 
					<input type="radio" name="pay" id="click-me" value="2">&nbspOnline
				<br><br>
					<input type="submit" name="payment" id="payment" value="Print Invoice" class="btn btn-primary">
				<br><br>
			</div> 	
		</form>
	</center>


	<form name="paypal" id="paypal" method="POST" action="../../controller/servicecontroller.php">
		        <div class="modal" id="popup" style="display: none;">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">Close</button>
		                <h3>Pay Pal&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</h3>
		            </div>
		            <div class="modal-body">
		            <table>   
		            	<tr><td>Card No:</td><td><input type ='text' id='cardno' name ='cardno' required></td></tr>
               			<tr><td>CVV No:</td><td><input type='text' id='cvv' name='cvv' required></td></tr>
               			<tr><td>Name on Card:</td><td><input type='text' id='name' name='name' required></td></tr>
                	</table>
		            </div>
		            <div class="modal-footer">
		                <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
		                <input type="submit" id="payment" name="payment" class="btn btn-primary" value="Pay Amount">
		            </div>
		        </div>
		     </form>


</body>
</html>
