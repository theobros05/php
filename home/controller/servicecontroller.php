<?php
session_start();
include '../model/servicemodel.php';
require '../webroot/pdf/fpdf.php';
require '../webroot/phpmailer/phpmailer.php';
require '../webroot/phpmailer/PHPMailerAutoload.php';

$object = new servicecontroller();
class servicecontroller
	{

		function __construct()
			{
				
				 if(!empty($_REQUEST['payment']))
					{	
						Self::fnpayment();
					}
				else if(!empty($_REQUEST['email']))
					{	
						Self::forgotpassword();
					}
				else
				{
					exit();
				}
				
				
			}

		function forgotpassword()
			{
				$toMail = $_REQUEST['forgotemail'];

				$querymail = new servicemodel();
				$forgotmail = $querymail->forgotmail($toMail);

				if($forgotmail)
					{
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
				        $mail->Subject = 'New Login Password';
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
				                echo "<script>alert('Check your mail for the new Login password...'); window.location.href='../view/customer/login.php';</script>";
				            }
				 }
			}



		

		function fnpayment()
			{	
				$uname = $_SESSION['username'];
				$querypdf = new servicemodel();
				$result = $querypdf->fninvoice($uname);
				$pdf = new FPDF();
				$pdf->AddPage();
				$pdf->SetFont( 'Arial', '', 12 );

				$pdf->Ln( 12 );
						$pdf->Cell(50,10,'',2);
						$pdf->Ln( 12 );
						$pdf->Cell(50,10,'',2);
						$pdf->Cell(120,10,'Payment Invoice',2);
						$pdf->Ln( 12 );
						$pdf->Cell(50,10,'',2);
						$pdf->Cell(50,10,'OrderId',1);
						$pdf->Cell(50,10,$result['orderId'],1);
						$pdf->Ln( 12 );
						$pdf->Cell(50,10,'',2);
						$pdf->Cell(50,10,'Product',1);
						$pdf->Cell(50,10,$result['productName'],1);
						$pdf->Ln( 12 );
						$pdf->Cell(50,10,'',2);
						$pdf->Cell(50,10,'Quantity',1);
						$pdf->Cell(50,10,$result['quantity'],1);
						$pdf->Ln( 12 );
						$pdf->Cell(50,10,'',2);
						$pdf->Cell(50,10,'Customer Name',1);
						$pdf->Cell(50,10,$result['userName'],1);
						$pdf->Ln( 12 );
						$pdf->Cell(50,10,'',2);
						$pdf->Cell(50,10,'Amount',1);
						$pdf->Cell(50,10,$result['price'],1);
						$pdf->Ln( 12 );
						$pdf->Cell(50,10,'',2);
						$pdf->Cell(50,10,'Contact',1);
						$pdf->Cell(50,10,$result['contactNo'],1);	
						$pdf->Ln( 12 );
						$pdf->Cell(50,10,'',2);
						$pdf->Cell(50,10,'Invoice date',1);
						$pdf->Cell(50,10,$result['createdDate'],1);
						$pdf->Ln( 12 );
						$pdf->Cell(50,10,'',2);
						$pdf->Cell(50,10,'Delivery Address',1);
						$pdf->Cell(50,10,$result['add1'],1);		
						$pdf->Output();
				
				}

				
	}

?>
