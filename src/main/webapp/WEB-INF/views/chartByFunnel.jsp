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
	var myChart = echarts.init(document.getElementById('main3')); 
	//==================================                    
	option = {
    title : {
        text: '车险产品漏斗图',
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c}%"
    },
    legend: {
        data : ${productName}
    },
    calculable : true,
    series : [
        {
            name:'漏斗图',
            type:'funnel',
            width: '50%',
            data:${dataMap}
        },
        {
            name:'金字塔',
            type:'funnel',
            x : '50%',
            sort : 'ascending',
            itemStyle: {
                normal: {
                    // color: 各异,
                    label: {
                        position: 'left'
                    }
                }
            },
            data:${dataMap}
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
	<div id="main3" style="height: 500px;width: 1200px;"></div>
</body>
</html>
