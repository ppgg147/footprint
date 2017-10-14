/**
 * wjp
 *自定义加载对话框 
 *2017-10-14
 */
$(function (){
	$("body").append("<div id='loadingDialog'>" +
			"<div class='double-bounce1'></div>" +
			"<div class='double-bounce2'></div>" +
			"</div>");
	function showDialog() {
		$("#loadingDialog").css("display", "block");
	}
	function closeDialog() {
		$("#loadingDialog").css("display", "none");
	}
});
