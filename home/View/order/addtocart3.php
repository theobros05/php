<?php

	session_start();

	include_once('config.php');

		$itemCount = 0;

        if(isset($_SESSION['cart'])){

        $itemCount = count(isset($_SESSION['cart']) ? $_SESSION['cart'] : array());

        }
?>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="css/css.css" type="text/css" />
		<title>Cart</title>
    </head>

<body>


<div class="hdr"><img src=""/></div>


<h2 class="hlab">Shopping cart</h2>





<nav>

<div class="nav-bar">


        <ul>

               <li><a href="index.php">Home</a></li>
               <li><a href="cart.php">View Cart</a></li>
               <li><a href="#">Checkout</a></li>
               <li><div class="cart-a">{ <?=$itemCount?> }</div></li>   

        </ul>


        <div class="clear"></div>


  </div>


</nav>


			<div class="container main-cude">

				<p class="msg">

				<?php if(isset($_REQUEST['msg'])){

					$msg ="";

					switch($_REQUEST['msg']):

					case 'add':


                    $msg = '<b>'.$_REQUEST['p'] . "</b> was added to your cart.";


                    break;


                    case 'exists':


                    $msg = '<b>'.$_GET['p'] . "</b> already in your cart.";


                    break;


                    case 'removed':


                    $msg = '<b>'.$_GET['p'] . "</b> was removed from your cart.";


                    break;


                    endswitch;


                    echo $msg;


                     }


                ?>

            </p>


    <?php

    // If cart is empty and user click on cart button show default product list

    if($itemCount == 0){

    echo '<b>Your Cart is empty!.';

    echo ' Add items to it. </b>';

    ?>

    <ul class="item-cont">
        <li>Product Name</li>
        <li>Price</li>
    </ul>

    <div class="clear"></div>

    <?php

    $qur = mysqli_query($con,"SELECT * FROM  `product` ");

    while($r = mysqli_fetch_array($qur)){

    extract($r);

    ?>

    <div>

		<div class="inline-pr"><?=$productName?></div>

		<div class="inline-pr"><?=$price?></div>

		<div class="inline-pr"><a href="curd.php?action=add&pid=<?=$productID?>&p=<?=$productName?>" class="button-cart">Add to Cart</a></div>


    </div>


    <?php }

       }

    // If user add product to its cart

    else{?>

        <h2>Products in your CART</h2>

        <?php

			$pids = "";

			foreach($_SESSION['cart'] as $id){

			$pids = $pids. $id.',';

            }


                        $pids = rtrim($pids, ",");

						$sql = "SELECT productID, productName, price FROM product WHERE productID IN (".$pids.")";

						$qur = mysqli_query($con,$sql);

						$row = mysqli_num_rows($qur);  // Count num of rows

						if($row == 0){

					         echo '<p class="msg">No products found in your cart.</p>';

						}else{

                        ?>

        <ul class="item-cont">

				<li>Product Name</li>
				<li>Price</li>

		</ul>

		<div class="clear"></div>

        <?php

            $totalPrice = '';

			while($res = mysqli_fetch_array($qur)){

			extract($res);

			$totalPrice += $price;

        ?>


            <div>


                <div class="inline-pr"><?=$productName?></div>

                <div class="inline-pr"><?=$price?></div>

                <div class="inline-pr"><a href="curd.php?action=remove&pid=<?=$productID?>&p=<?=$productName?>" class="button-cart red-bt">Remove</a></div>


            </div>


        <?php } ?>


            <div style="margin-top: 20px; border-top: #999 solid 1px;">


                <div class="inline-pr"><b>Total</b></div>

				<div class="inline-pr" style="font-weight: bold;">RS. <?=$totalPrice?></div>

				<div class="inline-pr">&nbsp;</div>


            </div>


        <?php } } ?>


    <div class="clear"></div>


</div>



</body>
</html>
