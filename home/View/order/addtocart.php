<!DOCTYPE html>
<?php
error_reporting(1);
//Setting session start
session_start();


//Database connection, replace with your connection string.. Used PDO
$conn = new PDO("mysql:host=localhost;dbname=cart", 'root', '');    
$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);


//get action string
$action = isset($_GET['action'])?$_GET['action']:"";

//Add to cart
if($action=='addcart' && $_SERVER['REQUEST_METHOD']=='POST') {
  
  //Finding the product by code
  $query = "SELECT * FROM products WHERE sku=:sku";
  $stmt = $conn->prepare($query);
  $stmt->bindParam('sku', $_POST['sku']);
  $stmt->execute();
  $product = $stmt->fetch();
  
  $currentQty = $_SESSION['products'][$_POST['sku']]['qty']+1; //Incrementing the product qty in cart
  $_SESSION['products'][$_POST['sku']] =array('qty'=>$currentQty,'name'=>$product['name'],'image'=>$product['image'],'price'=>$product['price']);
    $product='';
  header("Location:addtocart.php");
}

//Empty All
if($action=='emptyall') {
  $_SESSION['products'] =array();
  header("Location:addtocart.php"); 
}

//Empty one by one
if($action=='empty') {
  $sku = $_GET['sku'];
  $products = $_SESSION['products'];
  unset($products[$sku]);
  $_SESSION['products']= $products;
  header("Location:addtocart.php"); 
}


 
 
 //Get all Products
$query = "SELECT * FROM products";
$stmt = $conn->prepare($query);
$stmt->execute();
$products = $stmt->fetchAll();

?>
<html lang="en">
<head>
  <title>Add to Cart</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="../../webroot/css/bootstrap.min.css">
  <script src="../../webroot/js/jquery.min.js"></script>
  <script src="../../webroot/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
    $("#quantity").click(function(){
        $("#subTotal").val(parseInt($(this).val()) * parseInt($("#price").val()));
        $('body').append($form);
          $form.submit();
    });

    $("#quantity").click(function(){
        $("#subTotal").val(parseInt($(this).val()) * parseInt($("#price").val()));
        $('body').append($form);
          $form.submit();
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
                  <h4 align="center">Add to cart</h4>      
            </div>
            <div align="right">
            <a href="#" class="btn btn-primary" role="button">Home</a>
            <a href="" class="btn btn-primary" role="button">My Account</a>
            </div> 

</div>
<div class="container">
  <?php if(!empty($_SESSION['products'])):?>
  <nav class="navbar navbar-inverse" style="background:#428bca;">
    <div class="container-fluid pull-left" style="width:300px;">
      <div class="navbar-header"> <a class="navbar-brand" href="#" style="color:#FFFFFF;">Shopping Cart</a> </div>
    </div>
    <div class="pull-right" style="margin-top:7px;margin-right:7px;">
      <a href="addtocart.php?action=emptyall" class="btn btn-danger">Empty cart</a>
      <form action="../../controller/ordercontroller.php?time=<?php echo date('dmYHis')?>" name="addform" id="addform" method="POST">
           <input type="submit" name="addsub" id="addsub" class="btn btn-danger" value="Add to order">
           <?php 
            session_start();
            $stack = array(); 
    foreach ($_SESSION["products"] as $item){
       
   // use your product attributes like this.
   $prod = $item["name"];
   $quan = $item["qty"];
   $pric=$item["price"];
   $subtotal=$item['qty']*$item['price']; 
   $tot+=$subtotal;

   $newarray = array("name" => "$prod","quantity" => "$quan", "price" => "$pric","Total" => "$tot");
   $exampleEncoded = json_encode($newarray);

  
  //$data = serialize( $newarray );

  }
 ?>
<input type='hidden' name='input_name' id="input_name" value='<?php echo $exampleEncoded; ?>' />
           </form>
    </div>
  </nav>
  <form>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Actions</th>
      </tr>
    </thead>
    <?php foreach($_SESSION['products'] as $key=>$product):?>
      <?php $b=$product['image'];
        ?>
    <tr>
      <td><img src="../../webroot/upload/images/<?php echo $b ?>"></td>
      <td><?php print $product['name']?></td>
      <td><form>
    <input type="text" class="form-control" id="price" value="<?php print $product['price']?>" readonly>
</td>

      <td>
        <input type="number" min="0" class="form-control" id="quantity" value="1">
</td>

<td>
    <input type="text" class="form-control" id="subTotal" value="">
</td> </form>
               
        </td>
      <td><a href="addtocart.php?action=empty&sku=<?php print $key?>" class="btn btn-danger">Delete</a>
      </td>

    </tr>
    </form>
    <?php

    $total=0; 
    foreach($_SESSION['products'] as $key=>$product) {  
    $subtotal=$product['qty']*$product['price']; 
    $total+=$subtotal;
    }
    ?>


    <?php endforeach;?>
    <tr><td colspan="5" align="right"><h4>Total:$<?php print $total?></h4></td></tr>
  </table>
  <?php endif;?>
  <nav class="navbar navbar-inverse" style="background:#428bca;">
    <div class="container-fluid">
      <div class="navbar-header"> <a class="navbar-brand" href="#" style="color:#FFFFFF;">Products</a>
        
       </div>
    </div>
  </nav>
  <div class="row">
    <div class="container">
      <?php foreach($products as $product):?>
        <?php $a=$product['image'];
        ?>
          <div class="col-md-4">
        <div class="thumbnail"> <img src="../../webroot/upload/images/<?php echo $a ?>">
          <div class="caption">
            <p style="text-align:center;"><?php print $product['name']?></p>
            <p style="text-align:center;color:#04B745;"><b>$<?php print $product['price']?></b></p>
            <form method="post" action="addtocart.php?action=addcart">
              <p style="text-align:center;color:#04B745;">
                <button type="submit" class="btn btn-primary">Add To Cart</button>
                <input type="hidden" name="sku" value="<?php print $product['sku']?>">
              </p>
            </form>
          </div>
        </div>
      </div>
      <?php endforeach;?>
    </div>
  </div>
</div>
</body>
</html>
