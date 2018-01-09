$(function(){
	
	/**
	 * js初始化对象 例如 $("#ID").组件名称({属性、事件、方法});
	 * */
	
	
	$("#et").textbox({
		required : true,
		width : 200,
		height : 30/*,
		value : "abc"*/
	});
	
	//先初始化对象，再调用方法
	//$("#et").textbox("setValue","et1707");
	var options = $("#et").textbox("options");
	console.log(options);
	console.log("buttonAlign:" + options.buttonAlign);
	
	var tBox = $("#et").textbox("textbox");
	console.log(tBox);
});


function set(){
	$("#et").textbox("setValue","abc1232");
}

function get(){
	var v = $("#et").textbox("getValue");
	alert(v);
}

function disable(){
	$("#et").textbox("disable");
}

function enable(){
	$("#et").textbox("enable");
}

function readonlyT(){//不可以输入信息
	$("#et").textbox("readonly",true);
}

function readonlyF(){//可以输入信息
	$("#et").textbox("readonly",false);
}

function clear1(){
	$("#et").textbox("clear");
}

function reset1(){
	$("#et").textbox("reset");
}


