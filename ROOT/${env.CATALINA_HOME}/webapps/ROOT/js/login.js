$("#login").on("click", function(event){
   event.preventDefault();
   var uname = document.getElementById("uname").value;
   var psw = document.getElementById("psw").value;
   var object =  { "username"  : uname, "password" : psw };
   var auth_token;

   $.ajax({
     type: 'POST',
     url: 'VC/rest/login',
     //dataType: 'text',
     contentType: 'application/json',
     dataType: "json",
     data: JSON.stringify(object),
     success: function(result, status, request){
         console.log("Authorized");
         auth_token = request.getResponseHeader('Authorization');
         localStorage.setItem("auth_token",auth_token);
         var userID = result.user_id;
        createCookie('user_id',userID,2);
        createCookie('user_name', uname, 2);
        window.location.assign("index.html");
     },
     error: function(result){
       alert('Login failed. Check username and password and try again.');
     }
   });
});
