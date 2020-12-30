let index2 = {
	init: function() {
		$("#username").change(function() { 
			let data = {
				username: $("#username").val()
			};
			console.log(typeof(data.username));
			$.ajax({
				type: "POST",
				url: "/auth/api/user/" + encodeURIComponent(data.username),
				data: JSON.stringify(data),
	 			contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp) {
				if(resp.status === 500) {
					$("#usernameMsg").show();
				} else {
					$("#usernameMsg").hide();
				}
			}).fail(function(error) {
				alert(JSON.stringify(error));
			});
		});
	}
}

index2.init();