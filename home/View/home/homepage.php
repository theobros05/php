<html>
<head> 
<link rel="stylesheet" type="text/css" href="../../webroot/css/common.css"/> 
<style>
      .topnav {
          overflow: hidden;
          background-color:orange;
        }
      .topnav a {
          float: left;
          color: #f2f2f2;
          text-align: center;
          padding: 14px 16px;
          text-decoration: none;
          font-size: 17px;
        }
      .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<body>
  <div style="background-color:Orange;">
      <h1 align="center">Shopping Cart</h1>     
        <p align="left">
          <a href="homepage.php" class="button">Home</a>
          <a href="../order/productlist.php" class="button">Products</a>
          <a href="../customer/login.php" class="button">Login</a>
          <a href="../customer/signup.php" class="button">Signup</a>
        </p>
  </div>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.mySlides {display:none;}
</style>
  <div class="upload-content upload-section" style="max-width:1400px">
  <img class="mySlides" src="../../webroot/upload/images/ddddd.jpg" width="100%" height="60%">
  <img class="mySlides" src="../../webroot/upload/images/ggggg.jpg" width="100%" height="60%">
  <img class="mySlides" src="../../webroot/upload/images/hhhhh.jpg" width="100%" height="60%">
  <img class="mySlides" src="../../webroot/upload/images/uuuuu.jpg" width="100%" height="60%">
  <img class="mySlides" src="../../webroot/upload/images/zzzzz.jpg" width="100%" height="60%">
  <img class="mySlides" src="../../webroot/upload/images/wwwww.jpg" width="100%" height="60%">
  <img class="mySlides" src="../../webroot/upload/images/aaaaa.jpg" width="100%" height="60%">
</div>
<script>
var myIndex =0;
carousel();
function carousel() {
  //var ext=photo.substring(photo.lastindexof(',')+1.)tolowercase();
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";        
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000);
}
</script>
<table>
<tr>
<td width="30%">
<img src="../../webroot/upload/images/ggggg.jpg" width="50%"><br>
samsung<br>min 50-80%off<br>
<a href="../customer/login.php" class="button">Buy Now</a>
</td>
<td width="50%">
<img src="../../webroot/upload/images/zzzzz.jpg" width="60%"><br>
iphone<br>min 70-80%off<br>
<a href="../customer/login.php" class="button">Buy Now</a>
</td>
<td width="100%">
<img src="../../webroot/upload/images/hhhhh.jpg" width="130%"><br>
tablet<br>min 90-80%off<br>
<a href="../customer/login.php" class="button">Buy Now</a>
</td></tr>
<tr><td width="20%">
<img src="../../webroot/upload/images/uuuuu.jpg" width="100%"><br>
tablet<br>min 50-60%off<br>
<a href="../customer/login.php" class="button">Buy Now</a>
</td>
<td width="20%">
<img src="../../webroot/upload/images/wwwww.jpg" width="50%"><br>
tablet<br>min 15-30%off<br>
<a href="../customer/login.php" class="button">Buy Now</a>
</td>
<td width="20%">
<img src="../../webroot/upload/images/ddddd.jpg" width="100%"><br>
index<br>min 100-80%off<br>
<a href="../customer/login.php" class="button">Buy Now</a>
</td>
</tr>
</table>
</body>
</html>
