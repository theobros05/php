<!DOCTYPE html>
<?php include 'header.php'; ?>

<html>
<head>
    <title></title>
    <script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>

 <style>
    #form label{float:left; width:140px;}
    #error_msg{color:red; font-weight:bold;}
 </style>

 <script>
    $(document).ready(function(){
        var $submitBtn = $("#form input[type='submit']");
        var $passwordBox = $("#password");
        var $confirmBox = $("#confirm_password");
        var $errorMsg =  $('<span id="error_msg">Passwords do not match.</span>');

        // This is incase the user hits refresh - some browsers will maintain the disabled state of the button.
        $submitBtn.removeAttr("disabled");

        function checkMatchingPasswords(){
            if($confirmBox.val() != "" && $passwordBox.val != ""){
                if( $confirmBox.val() != $passwordBox.val() ){
                    $submitBtn.attr("disabled", "disabled");
                    $errorMsg.insertAfter($confirmBox);
                }
            }
        }

        function resetPasswordError(){
            $submitBtn.removeAttr("disabled");
            var $errorCont = $("#error_msg");
            if($errorCont.length > 0){
                $errorCont.remove();
            }  
        }


        $("#confirm_password, #password")
             .on("keydown", function(e){
                /* only check when the tab or enter keys are pressed
                 * to prevent the method from being called needlessly  */
                if(e.keyCode == 13 || e.keyCode == 9) {
                    checkMatchingPasswords();
                }
             })
             .on("blur", function(){                    
                // also check when the element looses focus (clicks somewhere else)
                checkMatchingPasswords();
            })
            .on("focus", function(){
                // reset the error message when they go to make a change
                resetPasswordError();
            })

    });
  </script>
</head>
<body>

    <?php
if( isset($_GET['submit']) )
{
    //be sure to validate and clean your variables
    $val1 = htmlentities($_GET['val1']);
    $val2 = htmlentities($_GET['val2']);

    //then you can use them in a PHP function. 
    //$result = myFunction($val1, $val2);
echo "$val1";
echo "$val2";
    function myFunction($a,$b)
    {
        $c=$a;
        $d=$b;

        echo "$c";
        echo "$d";
    }
}
?>

<?php if( isset($result) ) echo $result; //print the result above the form ?>

<form action="" method="get">
    New password: 
    <input type="text" name="val1" id="val1"></input>

    <?php echo ""; ?>

    <br></br>
    Confirm password:
    <input type="text" name="val2" id="val2"></input>

    <br></br>

    <input type="submit" name="submit" value="send"></input>
</form>
</body>
</html>