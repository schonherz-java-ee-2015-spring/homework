$(document).ready(function() {
	getUsers();
});

// THE WHOLE FILE IS ADMIN PART
function getUsers(){
	jQuery.ajax({
		url : "/hw6-web/admin",
		dataType : "json",
		success : function(data) {
			$(data).each(
					function(index, value) {
						
						if( value.roles.length > 0 && value.roles[0].id == 1 ){
							document.getElementById(value.id+ "u").checked = true;
						}
						if( value.roles.length > 1 && value.roles[1].id == 2 ){
							document.getElementById(value.id+ "b").checked = true;
						}
						if( value.roles.length > 2 && value.roles[2].id == 3 ){
							document.getElementById(value.id+ "a").checked = true;
						}
						document.getElementById(value.id + "u").value = "1";
						document.getElementById(value.id + "b").value = "2";
						document.getElementById(value.id + "a").value = "3";
						
						document.getElementById(value.id + "u").name = value.id + "u";
						document.getElementById(value.id + "b").name = value.id + "b";
						document.getElementById(value.id + "a").name = value.id + "a";

					});
		}
	});
}