<!DOCTYPE html>
<html lang="en">
<head>
  <title>Product List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="../webroot/css/bootstrap.min.css">
  <script src="../webroot/js/jquery.min.js"></script>
  <script src="../webroot/js/bootstrap.min.js"></script>
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
<div class="container-fluid">
  <div class="container-fluid" style="background-color: grey">
    <h1 align="center">Shopping Inc.</h1>      
    
  </div>
          
            <div>
                  <h4 align="center">Product List</h4>      
            </div>
            <div align="right">
            <a href="#" class="btn btn-primary" role="button">Cart</a>
            <a href="#" class="btn btn-primary" role="button">My Account</a>
            <a href="#" class="btn btn-primary" role="button">Logout</a>

        </div>     
</div>

<nav class="navbar navbar-inverse" style="background:#428bca;">
    <div class="container-fluid">
      <div class="navbar-header"> <a class="navbar-brand" href="#" style="color:#FFFFFF;">Products</a>
        <!-- <form action="../controller/ordercontroller.php?time=<?php echo date('dmYHis')?>" name="productform" id="productform" method="POST">
                    <input type="submit" class="btn btn-danger" name="prodtocart" id="prodtocart" value="Add to Cart"> -->
        </form>  
       </div>
    </div>
  </nav>
  
 <?php   while($row = mysql_fetch_array($result)){
    $rows[] = $row;
 }
foreach($rows as $row){ 
    $name = stripslashes($row['name']);
    $price = stripcslashes($row['price']);
    $details = stripslashes($row['details']);
    $img = stripslashes($row['image']);
    ?>
 
<div class="container">
          <div class="row">
               <div class="col-xs-4 item-photo">

                <input type="image" src="../webroot/upload/images/<?php echo $img ?>" name="click-me" id="click-me">
          
         

                    <!-- <img style="max-width:100%;" type="image" name="saveForm" class="btTxt submit" id="saveForm" src="../webroot/upload/images/<?php echo $img ?>"> -->
                </div>
                <div class="col-xs-5" style="border:0px solid gray">
                    
                    <h3><?php print $name?></h3>    
                   
                    <h3 style="margin-top:0px;">$<?php print $price?></h3>

                    <h4 style="margin-top:0px;"><?php print $details?></h4>
        
                    <div class="section" style="padding-bottom:20px;">
                     <a href="../View/order/addtocart.php" class="btn btn-danger" id="pro" name="pro" role="button">Go To Cart Page</a>    
                   </div>                                        
                </div>                              
        
                 
            </div>
        </div>        

<?php } ?>


      
    



</body>
</html>
