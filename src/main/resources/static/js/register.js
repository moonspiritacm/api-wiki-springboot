$("#registerBtn").click(function login() {
	console.log("register()");
	$.ajax({
		url : '/api/register',
		type : 'post',
		dataType : 'json',
		data : {
			"username" : $("#username").val(),
			"phone" : $("#phone").val(),
			"password" : $("#password").val()
		},
		success : function(data) {
			if (data.code == 200) {
				layer.msg("注册成功");
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