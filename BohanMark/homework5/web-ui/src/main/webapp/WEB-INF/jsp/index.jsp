<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>shop</title>
<script type="text/javascript" src="resources/js/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="resources/js/users.js"></script>
<script type="text/javascript" src="resources/js/products.js"></script>
<script type="text/javascript" src="resources/js/order.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" />

<!-- Optional theme -->
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-theme.min.css" />

<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
	<input type="hidden" id="selected_user_id" value="" />
	<input type="hidden" id="selected_product_id" value="" />
	<div class="container">
		<!-- <div class="page-header">
			<h1>
				Panels with nav tabs.<span class="pull-right label label-default">:)</span>
			</h1>
		</div> -->
		<div class="row">
			<div class="col-md-6">
				<div class="panel with-nav-tabs panel-default">
					<div class="panel-heading">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab1default" data-toggle="tab">user</a></li>
							<li><a href="#tab2product" data-toggle="tab">product</a></li>
							<li><a href="#tab3order" data-toggle="tab" onclick="fillOrderTab()">order</a></li>
						</ul>
					</div>
					<div class="panel-body">
						<div class="tab-content">
							<div class="tab-pane fade in active" id="tab1default">
								current user: <a href="#" data-toggle="dropdown"
									onclick="getUsers()"><span id="cuser">&nbsp</span><span
									class="caret"></span></a>
								<ul class="dropdown-menu" role="menu" id="userlist">
								</ul>
								<br /> <input id="new_user" type="text" value="new user" />
								<button type="button" class="btn btn-default"
									onclick="newUser()">Add new user</button>
							</div>
							<div class="tab-pane fade" id="tab2product">

								current product: <a href="#" data-toggle="dropdown"
									onclick="getProducts()"><span id="cproduct">&nbsp</span><span
									class="caret"></span></a>
								<ul class="dropdown-menu" role="menu" id="productlist">
								</ul>
								<br /> <input id="new_product_name" type="text" value="new product" />
								price: <input id="new_product_price" type="number" min="1" max="999999" />
								<button type="button" class="btn btn-default"
									onclick="newProduct()">Add new Product</button>
							</div>
							
							<div class="tab-pane fade" id="tab3order" >
							
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br />
</body>
</html>
