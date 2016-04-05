$(function() {
	$("#category").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "/blog-web/categorySearch",
				type : "GET",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
					response(data);
				}
			})
		}
	});
});