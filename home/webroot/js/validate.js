$(document).ready(function()
{
	$("#register").click(function(){
			var name 	= $("#username").val();
			var pword 	= $("#password").val();
			var padd    = $("#paddress").val();
			var contact = $("#contact").val();
			var pincode	= $("#pincode").val();
			var email 	= $("#email").val();
			var alpha 	= /^[A-Za-z]+$/;
	        var num 	= /^[0-9]+$/;
	        var alphanum= /^[A-Za-z0-9]+$/;
			var emailid	= /^[A-Za-z]([A-Za-z0-9_-]|(\.[A-Za-z0-9]))+@[A-Za-z0-9](([A-Za-z0-9]|(-[A-Za-z0-9]))+)\.([A-Za-z]{2,6})(\.([A-Za-z]{2}))?$/;
			if(name=="")
				{	alert("Enter your name");  return false;	}
			else if(!alpha.test(name))
				{	alert("Enter characters only in Name"); return false;	}
				else if(pword=="")
					{	alert("Enter password");   return false;	}
					else if(pword.length<6)
						{	alert("Password must be above 6 characters"); return false;	}
			else if($("input[name='gender']:checked").size()==0)
				{	alert('Pick your Gender'); return false;	}
			else if(padd=="")
				{	alert("Enter Permanent address");   return false; 	} 	
			else if(contact=="")
				{	alert("Enter ContactNo");  return false; 	}
			else if(!num.test(contact))
					{	alert("Enter Numeric only in Contact"); return false;	}
					else if(contact.length<10)
						{	alert("Contact must be 10 Digit only"); return false;	}
						else if(contact.length>10)
							{	alert("Contact must be 10 Digit only"); return false;	}
			else if(pincode=="")
				{	alert("Enter Pincode");    return false;	}
				else if(!num.test(pincode))
					{	alert("Enter Numeric only in Pincode"); return false;	}
					else if(pincode.length<6)
						{	alert("Pincode must be above 6 characters"); return false;	}
						else if(pincode.length>6)
							{	alert("Pincode must be below 6 characters"); return false;	}
			else if(email=="")
				{	alert("Enter Email");	     return false;	}
				else if(!emailid.test(email))
						{	alert("Invalid email id"); return false;	}
			else
				{ 
				if(confirm("Do you want to Register ?"))
					{	alert("Registration Success");
					  return true;	}
				else
					{ return false;	}
				}
			});
	

		 	$("#login").click(function()
        	{
				var name  = $("#username").val();
				var pword = $("#pword").val();
				if(name=="")
					{ alert("Enter username");  return false; }
					else if(pword=="")
						{ alert("Enter password");   return false; }
						else if(pword.length<6)
							{ alert("Password must be above 6 characters"); return false;}
				else { $("#frmlogin").submit(); }
				
			});
		 	
		 	$("#email").click(function()
        	{
				var email = $("#forgotemail").val();
				var emailid=/^[A-Za-z]([A-Za-z0-9_-]|(\.[A-Za-z0-9]))+@[A-Za-z0-9](([A-Za-z0-9]|(-[A-Za-z0-9]))+)\.([A-Za-z]{2,6})(\.([A-Za-z]{2}))?$/;
				if(email=="")
					{ alert("Enter Email");  return false; }
					else if(!emailid.test(email))
								{ alert("Invalid email id"); return false;}
						else { $("#frmforgotpassword").submit(); }
			});


			$("#payment").click(function()
        	{
				if($("input[name='pay']:checked").size()==0)
					{	alert('Pick your Payment Type'); return false;	}
				else
					{ $("#frmpayment").submit(); }
				
			});

		 });

		
