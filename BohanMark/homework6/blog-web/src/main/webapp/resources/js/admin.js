$(document).ready(function() {
	
	getUsers();
	
});

function getUsers() {

	jQuery.ajax({
		url : "/blog-web/AdminServlet",
		dataType : "json",
		data : {},
		success : function(data) {
			$(data).each(
					function(index, value) {
						jQuery.ajax({
							url : "/blog-web/resources/template/admin.html",
							async : false,
							success : function(template) {
								template = template.replace('#user',
										value.userName);
								template = template.replace('#user',
										value.userName);
								template = template.replace('#user', "'"
										+ value.userName + "'");
								template = template.replace('#user',
										value.userName);
								template = template.replace('#user', "'"
										+ value.userName + "'");
								template = template.replace('#user',
										value.userName);
								template = template.replace('#user', "'"
										+ value.userName + "'");
								$('#userList').append(template);
								jQuery.ajax({
									url : "/blog-web/AdminServlet",
									dataType : "json",
									data : {
										'username' : value.userName,
									},
									success : function(data) {
										$(data).each(
												
												function (i, val){
													if(val.name==="USER_ROLE"){
														$("#"+value.userName+"_u").prop('checked', true);
													}
													if(val.name==="BLOGGER_ROLE"){
														$("#"+value.userName+"_b").prop('checked', true);
													}
													if(val.name==="ADMIN_ROLE"){
														$("#"+value.userName+"_a").prop('checked', true);
													}
												}
												
												
												);
									}
								});
							}
						});

					})
		},

	});

}

function setUser(id){
	setARole(id, "USER_ROLE");
}

function setBlogger(id){
	setARole(id, "BLOGGER_ROLE");
}

function setAdmin(id){
	setARole(id, "ADMIN_ROLE");
}

function setARole(name, role){
	jQuery.ajax({
		url : "/blog-web/AdminServlet",
		data : {
			'username' : name,
			'role' : role
		}

	});
}

