<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../webroot/css/common.css"/>
		<script type="text/javascript" src="../../webroot/js/jquery.min.js"></script>
		<script type="text/javascript" src="../../webroot/js/validate.js"></script>
	</head>

		<body>
	<div style="background-color:Orange;">
	  	<h1 align="center">Shopping Cart</h1>
    </div>
    <p align="left">Already Member &nbsp&nbsp <a href="login.php" class="button">Login</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</p> 
  <h2 align="center">Register Here</h2><br>
<form name="frmsignup" id="frmsignup" method="POST" action="../../controller/customercontroller.php">
 	<center>
		<table align="center">
			<tr><td>Name<sup>*</sup></td>
				<td><input type="text" id="username" name="username"></td></tr>
			
			<tr><td>Gender<sup>*</sup></td>			
				<td>
					<label for="male">Male</label><input type="radio" name="gender" id="male" value="1">
			    	<label for="female">Female</label><input type="radio" name="gender" id="female" value="2">
				</td>
			<tr><td>Permanent Address<sup>*</sup></td>
				<td><textarea id="paddress" name="paddress"></textarea></td></tr>
			<tr><td>Contact No<sup>*</sup></td>
				<td><input type="text" id="contact" name="contact"></td></tr>
			<tr><td>Pincode<sup>*</sup></td>
				<td><input type="text" id="pincode" name="pincode"></td></tr>
			<tr><td>Email<sup>*</sup></td><td><input type="text" id="email" name="email">
								<label>Please enter active Email Id</label></td></tr>
			<tr><td colspan="2" align="center">
					<input class="button" type="submit" id="register" name="register" value="Register">
					<input class="button" type="reset"  value="Reset">
				</td></tr>	
		</table>		
	</form>
	</body>				
</html>
