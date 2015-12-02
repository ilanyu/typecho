/**
 * Created by ilanyu on 2015/12/2.
 */
function usersProfile() {
	var screenName = $('#screenName').val();
	var url = $('#url').val();
	var mail = $('#mail').val();
	$.getJSON("./admin/users-profile", {"screenName": screenName, "url": url, "mail": mail}, function (data) {
		if (data["status"] = "OK") {
			$('#updateSuccess').modal();
		} else {
			$('#updateFailed').modal();
		}
	});
}
