
function selectedProduct(id, name, price){
	$("#cproduct").html(name + " (" + price + ")");
	$("#selected_product_id").val(id);
}

function newProduct(){
	var productname = $("#new_product_name").val();
	$("#new_product_name").val("new product");
	var productprice = $("#new_product_price").val();
	$("#new_product_price").val("100");
	jQuery.ajax({
		url : "product/new/"+productname + "/" + productprice,
		cache : false
	});
}

function getProducts() {

	$("#productlist").html("");
	jQuery.ajax({
		url : "product",
		dataType : "json",
		success : function(data) {

			$(data).each(function(index, value) {
				jQuery.ajax({
					url : "resources/templates/products.html",
					success : function(template) {
						var find = '#id';
						var re = new RegExp(find, 'g');
						template = template.replace(re, value.id);
						var findN = '#name';
						template = template.replace(findN, "'"+value.name+"'");
						template = template.replace(findN, value.name);
						var findP = '#price';
						var re = new RegExp(findP, 'g');
						template = template.replace(re, value.price);
						$("#productlist").append(template);
						
					}
				});
			});
		},

	});

}