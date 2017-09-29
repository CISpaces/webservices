$("#login").on("click", function(event){
   event.preventDefault();

   var object =  {
     "username"  : $("#uname").val(),
     "password" : $("#psw").val()
   };

   var userID = "5a90c91f-1884-4f45-bc2e-49057745293c";
   createCookie('user_id', userID, 2);
   window.location.assign("index.html");

   /*
   $.ajax({
     type: 'POST',
     url: 'VC/rest/user',
     //dataType: 'text',
     contentType: 'application/json',
     data: JSON.stringify(object),
     success: function(result){
       if(result == "fail"){
         alert('This user does not exist in the system! Please try again.');
       }else{
         var userID = result.substring(9, result.length - 1);
         createCookie('user_id', userID, 2);
         window.location.assign("index.html");
       }
     },
     error: function(result){
       alert('Something went wrong. Please try again.');
     }
     */
   });
});
