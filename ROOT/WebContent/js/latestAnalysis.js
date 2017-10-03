function getLatestAnalysis(callback){
	var userID = readCookie('user_id');

	$.ajax({
		type: 'POST',
		url: 'VC/rest/getAnalysis',
		contentType: 'text/plain',
		data: userID,
		success: function(result){
			callback(result);
		},
		error: function(result){
			alert('Error in the ajax request.');
		}
	});
}
