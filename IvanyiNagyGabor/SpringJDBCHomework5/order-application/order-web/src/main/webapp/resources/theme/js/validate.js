function validateFormForUser() {
	var x = document.forms["form"]["name"].value;
	if (x == null || x.trim().length < 2) {
		alert("User name must be at least two characters");
		return false;
	}
}


function validateFormForProduct() {
	if (validateProductName() == false) {
		alert("Product name must be at least three characters");
		return false;
	} else if (isPositiveNumber() == false) {
		alert('Price must be zero or greater');
		document.form.price.focus();
		return false;
	}
}

function isPositiveNumber() {
	var numbers = /^[0-9]+$/;
	var inputtxt = document.forms["form"]["price"].value;
	if (!inputtxt.match(numbers) || Number(inputtxt) < 0) {
		return false;
	}
}

function validateProductName() {
	var x = document.forms["form"]["name"].value;
	if (x == null || x.trim().length < 3) {
		return false;
	}
}


