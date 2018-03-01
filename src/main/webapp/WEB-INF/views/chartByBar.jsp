<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/static/plugins/echarts/echarts-all.js"></script>
<script type="text/javascript">
	$(function() {
		// 基于准备好的dom，初始化echarts图表
		var myChart = echarts.init(document.getElementById('main')); 
		//==================================
		 option = {
		    title : {
		        text: '新增客户报表',
		        x : 'center'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['新增客户报表'],
		    	y : 'bottom',
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            data : ${realname},
		           //data : ["惊雪无常","chenming","lk","Will","lucy","貂蝉","钟无艳","赵云","马可波罗","不知火舞"]
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value',
		        }
		    ],
		    series : [
		        {
		            name:'新增客户人数',
		            type:'bar',
		            data:${count},
		            //data:['30','25','40','32','40','17','11','34','27','49']
		        }
		    ]
		};
                    
		//================================
		// 为echarts对象加载数据 
		myChart.setOption(option);

	});
</script>

</head>
<body>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="height: 500px; width: 1200px;"></div>
</body>
</html>
