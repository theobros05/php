<!DOCTYPE html>
<html>
<head>
   <title>pagenation</title>

<link rel="stylesheet" href="css/bootstrap.min.css">

<link rel="stylesheet" href="css/simplePagination.css" />
<script src="js/jquery.simplePagination.js"></script>
 <script type="text/javascript">
            $(document).ready(function(){

            $('.pagination').pagination({
                    items: <?php echo $total_records;?>,
                    itemsOnPage: <?php echo $limit;?>,
                    cssStyle: 'dark-theme',
                    currentPage : <?php echo $page;?>,
                    hrefTextPrefix : 'page.php?page='
                });
                });
            </script>
</head>
<body>
<?php
session_start();
$con=mysql_connect("localhost", "root", "");// or die (mysql_error()); //Connect to server
 mysql_select_db("phpproject",$con);// or die ("Cannot connect to database"); //Connect to database


$limit = 3;  
if (isset($_GET["page"])) { $page  = $_GET["page"]; } else { $page=1; };  
$start_from = ($page-1) * $limit;

$query=mysql_query("SELECT * FROM msdUser ORDER BY userid ASC LIMIT $start_from, $limit",$con); 


  
?>

<table class="table table-bordered table-striped">  
        <thead>  
        <tr>  
        <th>Userid</th>  
        <th>Name</th>
        <th>Contact</th>  
        </tr>  
        </thead>  
        <tbody>  
        <?php  
        while ($row = mysql_fetch_array($query)) {  
?>   
                    <tr>  
                    <td><?php echo $row["userid"]; ?></td>  
                    <td><?php echo $row["name"]; ?></td>  
                    <td><?php echo $row["contact"]; ?></td>  
                    </tr>  
        <?php  
        };  
        ?>  
        </tbody>  
        </table>
          
        <?php  
  
$query=mysql_query("SELECT COUNT(id) FROM msdUser",$con); 

$row = mysql_fetch_row($query);  
$total_records = $row[0];  
$total_pages = ceil($total_records / $limit);  
$pagLink = "<div class='pagination'>";  
for ($i=1; $i<=$total_pages; $i++) {  
             $pagLink .= "<a href='page.php?page=".$i."'>".$i."</a>";  
} 
echo $pagLink . "</div>";  
?>

</body>
</html>