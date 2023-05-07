const toogleSidebar = () => {
	
	console.log("hii")
	if ($('.sidebar').is(":visible")) {
		$(".sidebar").css("display", "none");
		$(".menu").css("display", "block");



	}
	else {
		$(".sidebar").css("display", "block");
		$(".menu").css("display", "none");


	}
	}