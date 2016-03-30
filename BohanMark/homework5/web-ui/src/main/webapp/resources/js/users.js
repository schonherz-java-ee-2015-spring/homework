
function selectedUser(id, name){
	$("#cuser").html(name);
	$("#selected_user_id").val(id);
}

function newUser(){
	var username = $("#new_user").val();
	$("#new_user").val("new user");
	jQuery.ajax({
		url : "user/new/"+username,
		cache : false
	});
}

function getUsers() {

	$("#userlist").html("");
	jQuery.ajax({
		url : "user",
		dataType : "json",
		success : function(data) {

			$(data).each(function(index, value) {
				jQuery.ajax({
					url : "resources/templates/users.html",
					success : function(template) {
						var find = '#id';
						var re = new RegExp(find, 'g');
						template = template.replace(re, value.id);
						var findN = '#name';
						template = template.replace(findN, "'"+value.name+"'");
						template = template.replace(findN, value.name);
						$("#userlist").append(template);
						
					}
				});
			});
		},

	});

}