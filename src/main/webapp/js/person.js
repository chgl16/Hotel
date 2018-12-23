$(document).ready(function(){
	$(".changed").click(function(){
		console.log($(this).prev().val());
	});
});