let index2 = {
	init: function() {
		$("#username").change(function() { 
			let data = {
				username: $("#username").val()
			};
			
			if(data.username !== "") {
				$.ajax({
					type: "POST",
					url: "/auth/api/user/" + encodeURIComponent(data.username),
					data: JSON.stringify(data),
		 			contentType: "application/json; charset=utf-8",
					dataType: "json"
				}).done(function(resp) {
					if(resp.status === 500) {
						$("#usernameMsg").text(resp.data);
						$("#isPossibleUsername").val("false");
					} else {
						$("#usernameMsg").empty();
						$("#isPossibleUsername").val("true");
					}
				}).fail(function(error) {
					alert(JSON.stringify(error));
				});
			} else {
				$("#isPossibleUsername").val("true");
				$("#usernameMsg").empty();
			}
		});
	}
}

index2.init();