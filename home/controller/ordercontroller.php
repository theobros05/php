<?php
include '../Model/ordermodel.php';

session_start();
$object = new ordercontroller();

class ordercontroller
	{

		function __construct()  
    		{  
       			if (!empty($_REQUEST['addsub'])) {

                 $this->addview();
            }
        elseif(!empty($_REQUEST['prodlist'])) {
        	
          $this->productlist();
        }
         elseif(!empty($_REQUEST['prosub'])) {
        	
          $this->productcart();
        }
        elseif(!empty($_REQUEST['checkout'])) {
       
          $this->view();
        }
        elseif(!empty($_REQUEST['input_name'])) {
       
          $this->cartinsert();

        }elseif(!empty($_REQUEST['prodtocart'])) {
       
          $this->prodpagetocart();

        }elseif(!empty($_REQUEST['addtocart'])) {
       
          $this->productcart();
        }
        else{
            $this->view();
        }

    }   

    	
		function view(){
			$query=new ordermodel();
			
			$uname = $_SESSION['username'];
			$adcart = $_REQUEST['prodtocart'];
			// $page=$_GET["page"];
			$page=$_REQUEST["page"];

		    $Search=$_REQUEST['search'];
	         if ($page<1) { $page  = 1; } 
	        $limit = 10;  
	        $startresult = ($page-1) * $limit; 
	        $count=$query->countpage();
	        $totalpage = ceil($count/$limit);
									
			if (!empty($pro)) {

				$result=$query->productlistm();
				require_once('../View/order/productlist.php');

			}elseif(!empty($adcart)) {

				$products=$query->addtocartdefault();
				
                require_once('../View/order/addtocart.php');
			}
			elseif(!empty($Search)){
        		
            $result=$query->search($Search);
            
            require_once('../View/order/orderindex.php');

        }
			elseif (!empty($page)) {
                $result=$query->pagenation($startresult,$limit);
            require_once('../View/order/orderindex.php');
 
        }
        else{

				$result=$query->viewprocess();
            	require_once('../View/order/orderindex.php');
			}
			
		}function prodpagetocart(){
			$query=new ordermodel();
			$products=$query->addtocartdefault();
            require_once('../View/order/addtocart.php');
		}function productlist(){
			$query=new ordermodel();
			$result=$query->productlistm();
			require_once('../View/order/productlist.php');
		}
		function addview(){
			$uname = $_SESSION['username'];
			$query=new ordermodel();
			$result=$query->viewprocess($uname);
            require_once('../View/order/orderindex.php');
		}
		
		function product_list(){
			$query=new ordermodel();
			$result=$query->productlistm();
            require_once('../View/order/productlist.php');
		}
		function productcart(){
			$query=new ordermodel();
			// $result=$query->productlistm();
            require_once('../View/order/addtocart.php');
		}
		function cartinsert(){
			$query=new ordermodel();
			$update = $_SESSION['username'];
		    $resulr=$query->cartinsert1();
            require_once('../View/order/orderindex.php');
		}

		
	}




?>
