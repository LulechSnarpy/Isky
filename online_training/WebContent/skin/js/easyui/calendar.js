$(function(){
	
	$("#et").calendar({
		
		fit : true,
		border : false,
		//firstDay : 1,
		//weeks : ['abc','T','W','T','F','S','S']
		//year : 2017,
		formatter: function(date){
			return '<div style="background-color:red;height:30px;">' + date.getDate() + '</div>';
		},
		onSelect : function(date){
			alert(date);
		}
	});
	
});