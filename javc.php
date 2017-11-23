<?php
if(!empty($_POST['lname'])) {
    $valueOfInput = $_POST['lname'];
    echo "$valueOfInput";
    die(json_encode(array('status' => 'success', 'lname' => $valueOfInput)));
}
?>
<html>
    <head>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    </head>
    <body>
        <input type="text" id="lname" name="lname" value="" />
        <script type="text/javascript">
            $(document).ready(function() {
                $("#lname").on("keypress", function() { // waiting for keypress event to be fired
                    setTimeout(function() { // delay to have the key value inserted into input, and affect value param
                        $.post(document.location.href, { lname: $("#lname").val() }, function(data) { // sending ajax post request
                            console.log(data);
                        });
                    }, 50);
                });
            });
        </script>
    </body>
</html>