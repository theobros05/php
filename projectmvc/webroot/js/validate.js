 $(document).ready(function(){

      // alert("This is Login page");

    $("#btnlogin").click(function(){

      var name=$("#uid").val();

      var pword=$("#pword").val();

            if(name==""){
             alert("Enter your USERID");  return false; 
           }else if(pword=="")
            { alert("Enter password");   return false; }
            else { $("#formlogin").submit(); }
    });
  });


      $(document).ready(function(){

        //alert("This is Registration page");
        $("#reg").click(function()
        {

    // password validation 



          // name validation
          var name=$("#name").val();

          var pword=$("#pword").val();
          var usertype=$("#utype").val();
          var add1=$("#add1").val();
          var contact=$("#contact").val();
          var pcode=$("#pcode").val();
          var check = $("input[name='check']:checked").size();
          var cash = $("input[name='cash']:checked").size();
          var credit = $("input[name='credit']:checked").size();
          var email=$("#email").val();
          var img=$("#img").val();
          var ext=img.substring(img.lastIndexOf('.')+1).toLowerCase();
          var alpha=/^[A-Za-z]+$/;
              var num=/^[0-9]+$/;
              var alphanum=/^[A-Za-z0-9]+$/;
          var emailid=/^[A-Za-z]([A-Za-z0-9_-]|(\.[A-Za-z0-9]))+@[A-Za-z0-9](([A-Za-z0-9]|(-[A-Za-z0-9]))+)\.([A-Za-z]{2,6})(\.([A-Za-z]{2}))?$/;
          if(name=="")
            { alert("Enter your name");  return false; }
            else if(!alpha.test(name))
              { alert("Enter characters only in Name"); return false;}
          else if(pword=="")
            { alert("Enter password");   return false; }
          else if($("input[name='gender']:checked").size()==0)
            { alert('Pick your Gender'); return false; }
          else if(usertype=="")
            { alert("Pick your usertype"); return false;} 
          else if(add1=="")
            { alert("Enter Address1");   return false; }  
          else if(contact=="")
            { alert("Enter ContactNo");  return false; }
            else if(!num.test(contact))
              { alert("Enter Numeric only in Contact"); return false;}
              else if(contact.length<10)
                { alert("Contact must be above 10 characters"); return false;}
          else if(pcode=="")
            { alert("Enter Pincode");    return false; }
            else if(!num.test(pcode))
              { alert("Enter Numeric only in Pincode"); return false;}
              else if(pcode.length<6)
                { alert("Pincode must be above 6 characters"); return false;}
          else if (check==0 && cash==0 && credit==0 )
            { alert('Select Payment');   return false; }
          else if(email=="")
            { alert("Enter Email");      return false; }
            else if(!emailid.test(email))
                { alert("Invalid email id"); return false;}
          else if(img=="")
            { alert("Select an Image");  return false; }
              else if(ext != "jpg")
              { alert("Invalid Image");    return false; }
          else
            { 
            if(confirm("Do you want to Register ?"))
              { alert("Registration Success");
                return true;}
            else
              { return false; }
            }
        });
      });
    