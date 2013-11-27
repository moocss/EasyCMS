/**
 * 
 */
function findUser() {

}

jQuery(document).ready(function() {
	
	var username = $("#username").val();
	if (username != "") {
		$.post("v_findUser.do", {
			"username" : username
		}, function(data) {
			if (data.result) {
				if (data.exist) {
					$("#usernameMsg").html("没有此用户");
					$("#username").val("");
				} else {
					$("#usernameMsg").html("");
				}
			} else {
				alert("请先登录");
			}
		}, "json");
	}
});