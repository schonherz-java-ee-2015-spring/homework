
function fillOrderTab(){
	if($("#selected_product_id").val() === "" || 
			$("#selected_user_id").val() === "")
	$("#tab3order").html("<h1 style=\"color:red\">Select user and product first!</h1>");
	else
		$("#tab3order").html("<button type=\"button\" class=\"btn btn-default\"onclick=\"newOrder()\">Order</button>");
		
}

function newOrder(){
	var productid = $("#selected_product_id").val();
	var userid = $("#selected_user_id").val();
	jQuery.ajax({
		url : "order/new/"+userid + "/" + productid,
		cache : false
	});
	fillOrderTab();
}
