$("#loginBtn").click(function login() {
	console.log("login() ******");
	$.ajax({
		url : '/api/login',
		type : 'post',
		dataType : 'json',
		data : {
			"email" : $("#email").val(),
			"password" : $("#password").val()
		},
		success : function(data) {
			if (data.code == 200) {
				layer.msg("登录成功");
				window.location.href = "/editor";
			} else {
				layer.msg(data.msg);
			}
		},
		error : function(data) {
			layer.msg(data.msg);
		}
	})
})