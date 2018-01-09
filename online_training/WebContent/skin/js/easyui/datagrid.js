$(function(){
	
	$("#et").datagrid({
		//是否设置单选（true）、多选（false）
		singleSelect : true,
		//列自适应
		fitColumns : true,
		//自适应父元素
		fit : true,
		//远程访问服务端 访问后台
		url : pathContext + "/datagrid",
		//发送post请求
		method : "post",
		//设置斑马线  奇数 偶数
		striped : true,
		//延迟信息
		loadMsg : "正在玩命加载，请稍等...",
		//行号
		rownumbers : true,
		//分页工具栏
		pagination : true,
		//当前页
		pageNumber : 1,
		//每页记录数
		pageSize : 3,
		//每页记录数列表
		pageList : [3,10,50,100],
		//额外参数
		queryParams : {
			"etoak" : "et1707"
		},
		columns : [[
		            {field:"id",title:"主键ID",/*hidden:true,*/checkbox:true},
		            {field:"username",title:"用户名",width:80,align:"center"},
		            {field:"password",title:"密码",width:80,align:"center"},
		            {field:"nickname",title:"昵称",width:40,align:"center"},
		            {field:"email",title:"邮箱",width:100,align:"center"},
		            {field:"tel",title:"联系方式",width:80,align:"center"},
		            {field:"state",title:"状态",width:50,align:"center",
		            	//value表示当前列的值
		            	//row表示一行数据
		            	//index表示当前列的所在行的下标   下标从0开始
		            	formatter: function(value,row,index){
		            		console.log(row.username + "|" + index);
		            		if(value == 1) {
		            			return "启用";
		            		} else if(value == 0) {
		            			return "禁用";
		            		}
		            		
		            		return value;
		    			}
		            },
		            {field:"createTime",title:"创建时间",width:120,align:"center"}
		          ]]
		
	});
	
});