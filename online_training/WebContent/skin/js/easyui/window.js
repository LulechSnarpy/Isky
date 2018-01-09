$(function(){
	
	$("#et").window({
		title : "窗口",
		width : 300,
		height : 200,
		closed : true,
		fit : true,
		href : pathContext + "/pages/easyui/form.jsp"
	});
	
});

function open1(){
	$('#et').window('open');     
}

function close1(){
	$('#et').window('close');    
}