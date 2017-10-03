function getLatestAnalysis(callback){
	var userID = readCookie('user_id');

	$.ajax({
		type: 'POST',
		url: 'VC/rest/getAnalysis',
		contentType: 'text/plain',
        //Supply the JWT auth token
        headers: {"Authorization": localStorage.getItem('auth_token')},
		data: userID,
		success: function(result){
			callback(result);
		},
		error: function(result){
					alert('An error occurred fetching data.');
					//callback(result);
				}
		});
}
