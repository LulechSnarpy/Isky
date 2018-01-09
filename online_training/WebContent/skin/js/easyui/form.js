$(function(){
	
	//用户名
	$("#username").textbox({
		required : true,
		width : 180,
		iconCls : "icon-man"
	});
	
	//密码
	$("#password").textbox({
		width : 180,
		iconCls : "icon-lock",
		type : "password"
	});
	
	//生日
	$("#birthDay").datebox({
		width : 180,
		editable : false
	});
	
	//年龄
	$("#age").numberbox({
		width : 180
	});
	
	//状态 是否启用
	$("#state").combobox({
		url : pathContext + "/combobox",
		method : "post",
		width : 180,
		editable : false,
		panelHeight : 0,
		textField : "text",
		valueField : "value"/*,
		data : [
		        {
		        	"text" : "禁用",
		        	"value" : "0"
		        },
		        {
		        	"text" : "启用",
		        	"value" : "1"
		        }
		       ],
		onSelect : function(r){
			var text = r.text;
			var value = r.value;
			console.log(text + "|" + value);
		}*/
	});
	
	//图片
	$("#pic").filebox({
		width : 180,
		buttonText: '选择文件'
	});
	
});


//事件
var objEvent = {
	ok : function(){
		$("#form").form("submit",{
			//访问后台url请求地址
			url : pathContext + "/form",
			//在url请求地址之前触发onSubmit事件 返回true效验通过 反之不通过
			onSubmit : function(p){
				//提交额外参数
				p.etoak =" et1707";
				return $(this).form("validate");
			},
			//后台响应成功触发success函数
			success : function(result){
				//easyui响应不处理任何数据类型，需要自己转换
				var data = $.parseJSON(result);
				alert(data.success);
				objEvent.cancel();
			}/*,queryParam : {
				etoak : "et1707"
			}*/
		});
	},
	cancel : function(){
		$("#form").form("clear");
	}
}