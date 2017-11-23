<!DOCTYPE html>
<?php include 'header.php'; ?>
<html>
  <head>
  <title>Registration</title>
    
   
    
  </head>
  <body class="registration" style="background-image: url(image/les.jpg);">
    
    <form action="register.php" method="POST" enctype="multipart/form-data">
      
      <h2 align="center">REGISTRATION</h2>
        <table align="center" style="">
          <tr><td>Name<sup>*</sup></td><td><input type="text" id="name" maxlength="10" name="name"></td></tr>
          <tr><td>Password<sup>*</sup></td><td><input type="password" id="pword" maxlength="10" name="pword"></td></tr>
          <tr><td>Gender<sup>*</sup></td>
            <td>
              <label for="male">Male</label><input type="radio" name="gender" id="male" value="1">
                <label for="female">Female</label><input type="radio" name="gender" id="female" value="2">
            </td>
          </tr>
          <tr><td>User Type<sup>*</sup></td>
            <td><select name="usertype" id="utype">
              <option value="">Select</option>
              <option value="1">Admin</option>
              <option value="2">Employee</option>
              <option value="3">Student</option>
              </select>
            </td>
          </tr>

          <tr><td>Address1<sup>*</sup></td><td><textarea id="add1" name="add1"></textarea></td></tr>
          <tr><td>Address2</td><td><textarea name="add2"></textarea></td></tr>
          <tr><td>Contact No<sup>*</sup></td><td><input type="text" id="contact" name="contact" maxlength="10"></td></tr>
          <tr><td>Pincode<sup>*</sup></td><td><input type="text" id="pcode" maxlength="6" name="pcode"></td></tr>
          <tr><td>Payment<sup>*</sup></td>
            <td>
              <input type="checkbox" name="check" id="check" value="1"><label for="check">Check</label>
              <input type="checkbox" name="cash" id="cash" value="2"><label for="cash">Cash</label>
              <input type="checkbox" name="credit" id="creditcard" value="3"><label for="creditcard">Credit Card</label>
              </td>
            </tr>
          <tr><td>Email<sup>*</sup></td><td><input type="text" id="email" name="email"></td></tr>
          <tr><td>Image<sup>*</sup></td><td><input type="file" id="img" name="img" /></td></tr>
          <tr><td></td>
            <td><input class="grey" type="submit" id="reg" value="Register">

              <input class="grey" type="reset"  value="Reset">

            </td>
          </tr> 
        </table>
    </form>
  </body>
</html>