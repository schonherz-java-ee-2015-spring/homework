$(document).ready(function() {
	var old = $('#oldPageSize').val();
	if (old) {
		$('#pageSize').val(old);
	}

	checkPage();
	getBlogs();
});

function getBlogs() {

	jQuery.ajax({
		url : "/blog-web/blog",
		dataType : "json",
		data : {
			'size' : $("#pageSize").val(),
			'page' : ($("#currentPage").val() ? $("#currentPage").val() : 0),
		},
		success : function(data) {
			$('#blogs').html('');
			
			
			if (data.length == 0) {
				repairPage();
			}
			$(data).each(
					function(index, value) {
						jQuery.ajax({
							async : false,
							url : "/blog-web/resources/template/blog.html",
							success : function(template) {
								template = template.replace('#title',
										value.title);
								template = template
										.replace('#text', value.text);
								template = template.replace('#createDate',
										value.createDate);
								template = template.replace('#creater',
										value.creator.userName);
								var find = '#id';
								var re = new RegExp(find, 'g');
								template = template.replace(re, value.id);
								$('#blogs').append(template);
							}
						});
					});
		},
	});
}


function searchBlogs() {

	jQuery.ajax({
		url : "/blog-web/blogSearch",
		dataType : "json",
		data : {
			'size' : $("#pageSize").val(),
			'page' : 0,
			'title' : $("#searchTitle").val()
		},
		success : function(data) {
			$('#blogs').html('');
			$(data).each(
					function(index, value) {
						jQuery.ajax({
							async : false,
							url : "/blog-web/resources/template/blog.html",
							success : function(template) {
								template = template.replace('#title',
										value.title);
								template = template
										.replace('#text', value.text);
								template = template.replace('#createDate',
										value.createDate);
								template = template.replace('#creater',
										value.creator.userName);
								var find = '#id';
								var re = new RegExp(find, 'g');
								template = template.replace(re, value.id);
								$('#blogs').append(template);
							}
						});
					});
		},

	});

}

function addBlog() {
	console.log('add');
	jQuery.ajax({
		url : "/blog-web/blog",
		type : "POST",
		data : {
			'creator' : 'test user',
			'title' : $("#title").val(),
			'text' : $("#text").val()
		},
		success : function(data) {
			console.log(data);
			getBlogs();
			dialog.dialog("close");
		}
	});
}

function page(p) {
	var currentPage = $('#currentPage').val();
	$('#currentPage').val(new Number(currentPage) + p);

	checkPage();
	getBlogs();

}

function getMaxBlogValue() {
	var blogSize = $('#blogSize').val();
	var pageSize = $("#pageSize").val();
	var max = Math.ceil(blogSize / pageSize) - 1;
	return max;
}

function repairPage() {
	
	$('#currentPage').val(new Number(getMaxBlogValue()));
	checkPage();
	getBlogs();
}

function checkPage() {
	var currentPage = $('#currentPage').val();
	var max = getMaxBlogValue();

	if (currentPage == max) {
		$('#previous').hide();
	} else {
		$('#previous').show();
	}

	if (currentPage == 0) {
		$('#next').hide();
	} else {
		$('#next').show();
	}
}