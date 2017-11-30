<?php
session_start();
include '../Model/customermodel.php';
require '../webroot/phpmailer/phpmailer.php';
require '../webroot/phpmailer/PHPMailerAutoload.php';

$object = new customercontroller();

class customercontroller
      {
	       function __construct()
            {
	            if(!empty($_REQUEST['register']))
               {
	     	         Self::signup();
	             }
              else if(!empty($_REQUEST['login']))
                {
                  Self::fnlogin();
                }
              else if(!empty($_REQUEST['changepword']))
               {  
                  Self::changepassword();
               }  
              else if(!empty($_REQUEST['updatedetail']))
               {  
                  Self::updatedetail();
               }  
               
         
      }
      
      function signup()
         {
            $queryreg = new customermodel();
            print_r($stack);
            $username = $_REQUEST['username'];   
            $gender   = $_REQUEST['gender']; 
            $paddress = $_REQUEST['paddress'];      
            $contact  = $_REQUEST['contact'];
            $pincode  = $_REQUEST['pincode'];  
            $email    = $_REQUEST['email'];
   	        $curdate = date('Y-m-d h:i:s');
            $createdby = $username ;
            $delflag = '0';
           
            $countdata = $queryreg->countgen(); 
            $uidgen = "USR";           
            $uid = str_pad($countdata,3,"0",STR_PAD_LEFT);
            $userid = $uidgen.$uid ;

          
       	      $register = $queryreg->fnsignup($userid,$username,$gender,$paddress,$contact,
                               $pincode,$email,$curdate,$createdby,$delflag);
                if ($register)
                   {
                      Self::otp();
                   }
          }

            function otp()
              {
                $toMail = $_REQUEST['email'];
                $querymail = new customermodel();
                    $random   = mt_rand(100000,999999);
                    $password = md5($random);
                    $querymailupdate = $querymail->passwordupdate($password,$toMail);

                    $mail = new PHPMailer();
                        $mail->isSMTP();
                        $mail->SMTPDebug = 0;
                        $mail->Debugoutput = 'html';
                        $mail->Host = 'smtp.gmail.com';
                        $mail->Port = 587;
                        $mail->SMTPSecure = 'tls';
                        $mail->SMTPAuth = true;
                        $mail->Username = "madasamy838@gmail.com";
                        $mail->Password = "meenatchi";
                        $mail->setFrom('looser.mca@gmail.com', 'Shopping Cart');
                        $mail->addReplyTo('looser.mca@gmail.com', 'Shopping Cart');
                        $mail->addAddress( $toMail,'');
                        $mail->Subject = 'Login Password';
                        $mail->msgHTML($random);
                        $mail->AltBody = 'sddsfsd23';
                        if (!$mail->send()) 
                            {
                              echo "<script>
                                      alert('Check your mail whether it was correct...');
                                    </script>";
                            }
                        else 
                            {
                                echo "<script>alert('Check your Email for your Login password...'); window.location.href='../view/customer/login.php';</script>";
                            }
                 
              }




              function fnlogin()
                  {
                      $uname = $_REQUEST['username'];
                      $pword = $_REQUEST['pword'];
                      $pass  = md5($pword);
                      $query = new customermodel();
                      $login = $query->login($uname,$pass);
                      
                      if($login)
                         {  
                            $row = $query->getupdate($uname);
                            require_once('../View/customer/customerindex.php');
                         }
                      else
                         {  
                           echo "<script>
                                       alert('Wrong Username or Password');
                                       window.location.href='../view/customer/login.php';
                                   </script>";
                         }
                  }


              function changepassword()
                 {     
                    $uname = $_REQUEST['hid_uname'];
                    $oldpassword = md5($_REQUEST['oldpassword']);
                    $newpassword = md5($_REQUEST['newpassword']);
                    $repeatnewpassword = md5($_REQUEST['repeatnewpassword']);

                     $querypword = new customermodel();

                     $row = $querypword->pwordchk($uname);
                     $oldpassworddb = $row['password'];
                        if($oldpassword == $oldpassworddb)
                           {
                           if($newpassword==$repeatnewpassword)
                              {
                                 $change = $querypword->pwordchange($uname,$newpassword);
                                 if($change)
                                    { 
                                       header('location:../View/customer/logout.php');
                                    }
                              }
                        else 
                            echo "<script>
                                    alert('New password dont match!');
                                  </script>";
                            }
                      else
                        echo "<script>
                                    alert('Old password doesnt match!');
                              </script>"; 
                    }


              function updatedetail()
                {
                  $session  = $_SESSION['username'];
                  $uname    = $_REQUEST['uname'];   
                  $paddress = $_REQUEST['paddress']; 
                  $saddress = $_REQUEST['saddress'];      
                  $contact  = $_REQUEST['contact'];
                  $email    = $_REQUEST['email'];
                  
                $querypword = new customermodel();
                $update = $querypword->updetail($uname,$paddress,$saddress,$contact,$email,$session);

                  if($update)
                      { 
                        echo "<script>
                                 alert('Details updated!  Please Login Again...');
                                 window.location.href='../view/customer/logout.php';
                              </script>";
                      }
                  else 
                        echo "<script>
                                alert('Details not updated!');
                                window.location.href='../view/customer/customerindex.php';
                              </script>";
                }
          }

    ?>