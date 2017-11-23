<?php
    require 'PHPMailer/PHPMailerAutoload.php';

        //Create a new PHPMailer instance
        $mail = new PHPMailer();
        //Tell PHPMailer to use SMTP
        $mail->isSMTP();
        //Enable SMTP debugging
        // 0 = off (for production use)
        // 1 = client messages
        // 2 = client and server messages
        $mail->SMTPDebug = 2;
        //Ask for HTML-friendly debug output
        $mail->Debugoutput = 'html';
        //Set the hostname of the mail server
        $mail->Host = 'smtp.gmail.com';
        //Set the SMTP port number - 587 for authenticated TLS, a.k.a. RFC4409 SMTP submission
        $mail->Port = 587;
        //Set the encryption system to use - ssl (deprecated) or tls
        $mail->SMTPSecure = 'tls';
        //Whether to use SMTP authentication
        $mail->SMTPAuth = true;
        //Username to use for SMTP authentication - use full email address for gmail
        $mail->Username = "madasamy838@gmail.com";
        //Password to use for SMTP authentication
        $mail->Password = "meenatchi";
        //Set who the message is to be sent from
        $mail->setFrom('sample@gmail.com', 'Evoting System');
        //Set an alternative reply-to address
        $mail->addReplyTo('sample@gmail.com', 'Evoting System');
        //Set who the message is to be sent to
        $mail->addAddress('theobros05@gmail.com', '');
        //Set the subject line
        $mail->Subject = 'EVoting Otp ';
        //Read an HTML message body from an external file, convert referenced images to embedded,
        //convert HTML into a basic plain-text alternative body
        $mail->msgHTML('23bj34');
        //Replace the plain text body with one created manually
        $mail->AltBody = 'sddsfsd23';
        //Attach an image file
        // $mail->addAttachment('images/phpmailer_mini.gif');

        // send the message, check for errors
        if (!$mail->send()) {
             echo "Mailer Error: " . $mail->ErrorInfo;
        } else {
     echo "Message sent!";
        }

?>