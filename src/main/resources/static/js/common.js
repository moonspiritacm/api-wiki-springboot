$("#logoutBtn").click(function logout() {
	console.log("logout()");
	$.ajax({
		url : '/api/logout',
		type : 'get',
		dataType : 'json',
		data : {},
		success : function(data) {
			if (data.code == 200) {
				layer.msg("注销成功");
				window.location.href = "/login";
			} else {
				layer.msg(data.msg);
			}
		},
		error : function(data) {
			layer.msg("未知错误");
		}
	})
})