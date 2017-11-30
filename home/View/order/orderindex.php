<!DOCTYPE html>
<?php session_start(); ?>
<html lang="en">
<head>
  <title>Orders List View</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="../webroot/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="../webroot/css/common.css">
  <script src="../webroot/js/jquery.min.js"></script>
  <script src="../webroot/js/bootstrap.min.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){

    $("#stxt").click(function(){
      $("#orderform").submit();
    });
    
  });
  </script>
</head>
<body>
    <form action="../controller/ordercontroller.php?" name="orderform" id="orderform" method="POST">
<div style="background-color:#27AE60;">
    <br>
      <h1 align="center">Shopping Cart</h1><br>    
    </div>
        <h3 align="center">My Orders</h3>  
            
                        
            
            <div align="right">
            <input type="submit" class="btn btn-primary" name="prodlist" id="prodlist" value="View Product List">&nbsp&nbsp

           <!--  <a href="" class="btn btn-primary" id="prodlist" name="prodlist" role="button">Product List</a> -->
           <a href="../View/order/addtocart.php" class="btn btn-primary" id="pro" name="pro" role="button">Add Cart Page</a>
            <a href="#" class="btn btn-primary" role="button">Cart</a>&nbsp&nbsp
            <a href="../View/customer/customerindex.php" class="btn btn-primary" role="button">My Account</a>&nbsp&nbsp
            <a href="../View/customer/logout.php" class="btn btn-primary" role="button">Logout</a>&nbsp&nbsp

        </div>     
</div>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <div class="navbar-header" >
      </div> 
    <div class="input-group">
  </div>
</div>

<div class="col-sm-9">
  <br><br> 
  <input type="text" name="search" id="search" >

  <input type="submit" value="Search" id="stxt" name="stxt"> 
    <table  class="table table-striped">
      <tr>
        <th>OrderID</th>
        <th>Date</th>
        <th>Name</th>
        <th>Total</th>
      </tr>
    <?php $i=0;
      while($data=mysql_fetch_array($result)) { ?>
        <tr>
          <td><a class="text-primary" href="javascript:single('<?php echo $data ['orderId'];?>');">                    <?php echo $data ['orderId'];?></a></td>
          <td><?php echo $data ['createdDate']; ?></td>
          <td><?php echo $data ['userName']; ?></td>
          <td><?php echo $data ['price']; ?></td>
        </tr><?php $i++;
  } ?>

    </table>

    </div>

    <h3><a href="../view/service/payment.php" align="right">Make Payment</a></h3> 
  </form>
<?php  
  // code for pagenation
if ($page>1) {
  echo '<a href="?page=1"><b>First</b></a>&nbsp;';
  
  echo '<a href="?page='.($page-1).'"><b>Prevoius</b></a>&nbsp;';
}else{
  echo'&nbsp;First&nbsp;';
  echo'&nbsp;Prevoius&nbsp;';
}
$start=1;
$end=3;
if ($page>3) {
  $start=$page-1;
  $end=$page+1;
  if ($end>$totalpage) {
    $start=$totalpage-2;
    $end=$totalpage;
  }
}
for($i=$start;$i<=$end;$i++){
    if($i==$page){
    echo '&nbsp;<strong>'.$i.'</storng>&nbsp;';   
    }
    else{
      echo '&nbsp;<a href="?page='.$i.'">'.$i.'</a>&nbsp;';
  }
}

if($page<$totalpage){

  echo '&nbsp;<a href="?page='.($page+1).'"><b>next</b></a>&nbsp;';
  echo '&nbsp;<a href="?page='.$totalpage.'"><b>last</b></a>&nbsp;';
}
else{
  
   echo '&nbsp;Next&nbsp;';
   echo '&nbsp;Last&nbsp;';
}

?>
</body>
</html>
