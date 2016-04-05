function userRoleSetter() {
	if ($('#userSelect').val() != '-1') {
		$('#roles').show();
		jQuery.ajax({
			url : "/blog-web/roleGetter",
			dataType : "json",
			data : {
				'userName' : $("#userSelect").val(),
			},
			success : function(data) {
				$("#roles").children("input").prop("checked", false);
				$(data).each(function(index, value) {
					$("#c" + value.id).prop("checked", true);
				})
			}
		})
	} else {
		$('#roles').hide();
	}
}
