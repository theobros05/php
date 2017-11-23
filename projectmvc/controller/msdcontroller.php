<?php
include '../Model/msdModel.php';

$object= new msdcontroller();

class msdcontroller{
	
	function __construct()  
    {  
       if (!empty($_REQUEST['btnlogin'])) {
              	
        	 //self::fnlogin();
        	  $this->fnlogin();
           
        }elseif(!empty($_REQUEST['reg'])) {
          
          $this->fnreg();
        }else{
            $this->view();
        }

    } 

    function fnlogin(){
    	$userid=$_REQUEST['uid'];// get user name from form
   		$pass=$_REQUEST['pword'];// get password from form
    	$pwd=md5($pass); // password encrypt file.
    	$query=new msdModel();
    	$login=$query->fnloginchk($userid,$pwd);

    	if ($login) {
    	       $this->view();
    	}else{
            
    		header('location:../view/home/login.php');
    	}
    }

    function fnreg(){
      $name=$_REQUEST['name'];

    $pass=$_REQUEST['pword'];// get password from form
    $passw=md5($pass); // password encrypt file.

    $date = date('Y-m-d H:i:s'); // get date
    $delFlag='0';

    $gender=$_REQUEST['gender']; // set gender as 1 for male and 2 for female

    $usertype=$_REQUEST['usertype']; // set user type as 1,2,3,4
    $Address=$_REQUEST['add1']; // set address

    $contact=$_REQUEST['contact']; // set contact 
    $pincode=$_REQUEST['pcode']; // set pincode
    $email=$_REQUEST['email'];

    $check=$_REQUEST['check']; // modyfying payment type to 1,2,3
     $cash=$_REQUEST['cash'];
    $credit=$_REQUEST['credit'];
    $payment=$check.",".$cash.",".$credit;// set payment type

    $img=$_FILES['img']; // to upload files 

    $imgname=$img['name'];
    $imgtemp=$img['tmp_name'];
    // to copy file from one location to another useing script in php
    $path="../webroot/upload"; // file path
    $imgnam=$imgname;
    //move_uploaded_file($imgtemp,$path.$imgname);

    $ext=substr(strtolower(strchr($imgname,'.')),1); // to get image extension
    $array_ext=array('jpg','jpeg','png'); 
    if (in_array($ext,$array_ext))  // check image file location
        {
          move_uploaded_file($imgtemp,$path.$imgname);

        }
    $query=new msdModel();

    $count=$query->countgen();

    $s="TEN"; // user id constant value

    $uid=str_pad($count,4,"0",STR_PAD_LEFT); // modify user id to TENOO01

    $userid=$s.$uid; // final user id

    $reg=$query->fnregchk($userid,$name,$passw,$name,$date,$delFlag,$gender,$usertype,$Address,$contact,$pincode,$payment,$email,$imgnam);
    if ($reg) {
            header('location:../view/home/login.php');
        }else{
            header('location:../view/home/registration.php');

        }

 }
    function view(){
        $query=new msdModel();

        $fil=$_REQUEST['hidgen'];
        $search=$_REQUEST['search'];
        $ut=$_REQUEST['select_id'];
        $single=$_REQUEST['hidsin'];

        $page=$_GET["page"];
        if ($page<1) { $page  = 1; } 
        $limit = 10;  
        $startresult = ($page-1) * $limit; 
        $count=$query->countpage();
        $totalpage = ceil($count/$limit);

        if (!empty($fil)) {

            $result=$query->gender($fil);
            require_once('../view/home/success.php');

        }elseif(!empty($search)){

            $result=$query->search($search);
            require_once('../view/home/success.php');

        }elseif(!empty($single)){

            $result=$query->single($single);
            require_once('../view/home/detail.php');


        }elseif(!empty($ut)){

            $result=$query->usertype($ut);
                    require_once('../view/home/success.php');

        }
        elseif (!empty($page)) {
                $result=$query->pagenation($startresult,$limit);
                        require_once('../view/home/success.php');
 
        }else{
            $result=$query->viewprocess();
            require_once('../view/home/success.php');


        }
         


    }
 }  	
?>