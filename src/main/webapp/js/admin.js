/**
 * Created by ilanyu on 2015/12/2.
 */
function usersProfile() {
	var screenName = $('#screenName-0-1').val();
	var url = $('#url-0-2').val();
	var mail = $('#mail-0-3').val();
	$.getJSON("./users-profile", {"screenName": screenName, "url": url, "mail": mail}, function (data) {
		if (data["status"] = "OK") {
			$('#updateSuccess').modal();
		} else {
			$('#updateFailed').modal();
		}
	});
}

function usersPassword() {
	var password = $('#password-0-4').val();
	var confirm = $('#confirm-0-5').val();
	if (password != confirm) {
		$('#updateFailed').modal();
		return;
	}
	$.getJSON("./users-profile", {"password": password}, function (data) {
		if (data["status"] = "OK") {
			$('#updateSuccess').modal();
		} else {
			$('#updateFailed').modal();
		}
	});
}