<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>电梯信息管理系统</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/flatpickr.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<meta http-equiv="Cache-Control" content="no-cache">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/stylepart.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/echarts.min.js"></script>
</head>
<body>
<!--END 侧栏-->

        <!--content-->
        <div class="content">
            <!--首页-->
            <div class="index">
                <div class="box">
                    <div class="box_t">
                        <h3>消息中心</h3>
                    </div>
                    <div class="box_c">
                        <div class="box_c_l fl">
                            <h4>业务提醒</h4>
                            <a href="javascript:;" title="系统提醒">
                                <i class="icon" style="color: #fe942d;font-size: 25px;">&#xe60e;</i>
                                +10
                                <em class="icon">&#xe60f;</em>
                            </a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="box">
                    <div class="box_t">
                        <h3>月订单总量</h3>
                    </div>
                    <div class="box_c" >
                        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    					<div id="main" style="width: 600px;height:400px;margin:auto" ></div>
                    </div>
                </div>
            </div>
            <!--END 首页-->
        </div>
        <!--END content-->




    
</body>

<script type="text/javascript">

function getSOrderNumArByM(){
	
	
	var result;
 	$.ajax({
 		type : "POST",
 		url : "getSOrderNumArByM.action",
 		dataType : "json",
 		cache : false,
 		async:false,
 		success : function(datas) {
 			/* alert(datas == null); */
 			result = [datas.length];
 			for(var i=0;i<datas.length;i++){
 				result[i] = datas[i];
 			}
 			}
 		});
 	return result;
 
	
	
	
}

function getPOrderNumArByM(){
	
	
	var result;
 	$.ajax({
 		type : "POST",
 		url : "getPOrderNumArByM.action",
 		dataType : "json",
 		cache : false,
 		async:false,
 		success : function(datas) {
 			/* alert(datas == null); */
 			result = [datas.length];
 			for(var i=0;i<datas.length;i++){
 				result[i] = datas[i];
 			}
 			}
 		});
 	return result;
 
	
	
	
}




</script>

<script type="text/javascript">

	var POrder=getPOrderNumArByM();
	var SOrder=getSOrderNumArByM();



        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        option = {
    title: {
        text: '月订单总量'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['采购单', '销售单']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
    },
    yAxis: {
        type: 'value',
        min:0,
        max:70
    },
    series: [
        {
            name: '采购单',
            type: 'line',
            stack: '总量',
            data: POrder
        },
        {
            name: '销售单',
            type: 'line',
            stack: '总量',
            data: SOrder
        }
    ]
};

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</html>