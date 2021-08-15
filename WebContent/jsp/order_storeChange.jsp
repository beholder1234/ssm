<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>电梯信息管理系统</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/flatpickr.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<meta http-equiv="Cache-Control" content="no-cache">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/stylepart.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="css/flatpickr.min.css" rel="stylesheet" type="text/css" />


<!--弹窗插件  -->
<script type="text/javascript" src="js/popup.js"></script>
<link href="css/popup.css" rel="stylesheet" type="text/css" />	

<script type="text/javascript">


//1秒自动消失弹窗
function win1(msg){
    var popup = new Popup({
        'type': 'info',
        'title': '提示信息',
        'text': msg,
        'color': '#fff',
        'bgcolor': '#353b4b',
        'autohide': true,
        'showtime': 1000
    });	
	
}


</script>




</head>


<body>
<!-- main -->

<%-- 
	<form id="check"
		action="${pageContext.request.contextPath }/login.action"
		method="post">
		<table width="100%">
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>





	<form id="check"
		action="${pageContext.request.contextPath }/orderList.action"
		method="post">
		<table width="100%">
			<tr>
			
				<td>
				<input class="text_input w150" type="hidden" name="which"  value="orderStoreChange"  > 
				</td>
			</tr>		
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>


 --%>










    <!--content-->
    <div class="content">
        <!--发货通知单录入-->
        <div class="add_delivery_notice">
            <div class="box">
                <div class="box_t">
                    <h3>订单情况-查询信息</h3>
                </div>
                <div class="box_c">
                    <form action="${pageContext.request.contextPath }/orderStoreChange.action" method="post">
                        <fieldset>
                        
                        
                            <div class="box_c_item">
                            
                           
                            
                                    
                                    <label class="l_title">订单状态：</label>
                    <select class="text_input w200 fl" id="orderstateS" name="orderstateS" >
                          <option selected value="4" >待入库</option>
                          <option  value="5" >待出库</option>
                    </select>            
                    
                    
                    
                                                                    
                                    
                                   <div class="clear"></div>                             
                            </div>
                                                    
                            
                            <div class="box_c_item">
                                    <label class="l_title">下单员：</label>
                                    <input class="text_input w200 fl" type="text" name="Emp1S" id="Emp1S" placeholder="请输入公司名称"> 
                                    
                                    <label class="l_title">审核员：</label>
                                    <input class="text_input w200 fl" type="text" name="Emp2S" id="Emp2S" placeholder="请输入收货单位">  
                                    
                                    <label class="l_title">采购员：</label>
                                    <input class="text_input w200 fl" type="text" name="Emp3S" id="Emp3S" placeholder="请输入收货单位">  
                                   <div class="clear"></div>                             
                            </div>                            
                                                       
                            
                            <div class="fr">
                        		<label class="l_title"></label>
                        		<button class="btn btn_commit" type="submit">确认提交</button>
                   			</div>
                        </fieldset>
                    </form>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="box">
                <div class="box_t box_t_bottom">
                    <h3>订单情况-订单信息</h3>
                </div>
                <div class="box_c box_c_reset">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>采购完成日期</th>
                                <th>商品名称</th>
                                <th>型号</th>
                                <th>商品类型</th>
                                <th>单价</th>
                                <th>数量</th>
                                <th>状态</th>
                                <th class="text-right">操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                        
                                          	<!-- 行号设初始值 -->
								<%
									int num = -1;
								%>
								<c:forEach begin="0" end="${(page.page-1)*page.size}">
									<%
										num++;
									%>
								</c:forEach>
                        	<c:forEach items="${page.rows}" var="order">
                        		

                        			
                            <tr>
                                <td rowspan="${order['orderdetails'].size()}"><%=++num%></td>
                                <td rowspan="${order['orderdetails'].size()}">  <fmt:formatDate value="${order.starttime}" pattern="yyyy-MM-dd"/></td>
                                
                                <c:forEach items="${order['orderdetails']}" var="orderdetail">
                                <td>${orderdetail['goods'].name } </td>
                                <td>${orderdetail['goods'].model }</td>
                                <td>${orderdetail.goods['goodstype'].name }</td>
                                <td>${orderdetail.price }</td>
                                <td>${orderdetail.num }</td>
                                <td>
                                <c:if test="${orderdetail.state eq 3 }">
                                		已完成
                                </c:if>
                                <c:if test="${orderdetail.state != 3 }">
                                 	<c:if test="${order.type eq 1 }">
                                		待入库
                                	</c:if>
                                	<c:if test="${order.type eq 2 }">
                                		待出库
                                	</c:if>                               
                                </c:if>

                                
                                </td>
                                <td class="text-right"><a href="#" onclick="getOrderdetailList(${order.id})">订单明细</a> 
                                	<c:if test="${order.type eq 1 }">
                                	<c:if test="${orderdetail.state != 3 }">
                                		|<a href="#" onclick="putGoodsInStore(${order.id},${orderdetail.id},${oneRole.id })">入库</a>
                                	</c:if>
                                	</c:if>
                                	<c:if test="${order.type eq 2 }">
                                	<c:if test="${orderdetail.state != 3 }">
                                		|<a href="#" onclick="putGoodsOutStore(${order.id},${orderdetail.id},${oneRole.id })">出库</a>
                                	</c:if>                                	
                                	</c:if>                                
                                
                                </td>
                                 </c:forEach>
                            </tr><!-- 最多7行 -->
	                           
	                            
	                            
                        		
                        		
                        		
                        	
                            </c:forEach>
                        </tbody>
                    </table>

					<div class="clear"></div>
                    <!-- 页码框选项，与页面跳转实现 -->
					<itcast:page url="${pageContext.request.contextPath }/orderStoreChange.action" />
                


            </div>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
                            
<div class="box_c hide" id="ordertail_list_form">
	 <form action="${pageContext.request.contextPath }/saveGoods.action" method="post">
			<fieldset>
			
			
<table class="table" width="80%"  style="border-spacing:0; border-collapse: collapse;text-align: center;" border="1">
<thead style="width:99%;display: table;table-layout: fixed;">
  <tr>
    <th colspan="10"><div align="center">订单表-基本信息</div></th>
  </tr>
</thead>
<tbody style="display: block;height:100%;">
  <tr style=" display: table;width: 99%;table-layout: fixed;">
  
  
    <td id="DSuppOrCust"><div align="right"></div></td>    
    <td colspan="3" id="DSuppOrCustName"></td>
    
    
    
    <td><div align="right">生成日期</div></td>
    <td colspan="2" id="DCreateTime"><div align="center"></div></td>
    
    
    
    <td><div align="right">下单员</div></td>
    <td colspan="2" id="DCreater"><div align="right"></div></td>
    
    
  </tr>
  
  <tr style=" display: table;width: 99%;table-layout: fixed;">
  
    <td ><div align="right">联系人</div></td>
    <td colspan="3"  id="DContact"><div align="right"></div></td>
    
    
    <td><div align="right" >审核日期</div></td>
    <td colspan="2" id="DCheckTime"><div align="right"></div></td>
    
    
    <td><div align="right">审核员</div></td>
    <td colspan="2" id="DChecker"><div align="right"></div></td>
    
    
  </tr>
  
  
  
  <tr style=" display: table;width: 99%;table-layout: fixed;">
  
    <td><div align="right">电话</div></td>
    <td colspan="3" id="DTele"><div align="right"></div></td>
    
    
    <td><div align="right" >采购日期</div></td>
    <td colspan="2" id="DStartTime"><div align="right"></div></td>
    
    
    <td id="starterType"><div align="right"></div></td>
    <td colspan="2" id="DStarter"><div align="right"></div></td>
    
    
  </tr>
  
  <tr style=" display: table;width: 99%;table-layout: fixed;">
  
    <td><div align="right">地址</div></td>
    <td colspan="3" id="DAddress"><div align="right"></div></td>
    
    
    <td><div align="right" >完成日期</div></td>
    <td colspan="2" id="DEndTime"><div align="right"></div></td>
    
    
    <td><div align="right">订单总价</div></td>
    <td colspan="2" id="DTotalprice"><div align="right"></div></td>
  </tr>
</tbody>

<thead 	style="width:98%;display: table;table-layout: fixed;">
  <tr>
    <th colspan="10"><div align="center">订单表-商品信息</div></th>
  </tr>
  <tr>
    <th><div align="center">序号</div></th>
    <th><div align="center">商品名称</div></th>
    <th><div align="center">型号</div></th>
    <th><div align="center">商品类型</div></th>
    <th><div align="center">单价</div></th>
    <th><div align="center">数量</div></th>
    <th><div align="center">总价</div></th>
    <th><div align="center">仓库</div></th>
    <th><div align="center">仓管员</div></th>
    <th ><div align="center">状态</div></th>
  </tr>
</thead>

<tbody style="display: block;height:180px;overflow-y: scroll;"  id="OrderDGoods">


	

</tbody>

</table>

 <button class="btn btn_commit" type="sumbit"  id="saveButton" style="float:right">保存</button>

			</fieldset>
			</form>
		</div>         
            
            
        </div>
      
        <!-- END 发货通知单产品录入弹窗-->
    </div>
    <!--END content-->
</div>

</body>

<script type="text/javascript">


  

$(function(){
	
	
	//使用jQuery
	$(".calendar").flatpickr();  
	
	
	
});


</script>






<script type="text/javascript">

function getOrderdetailList(orderId) {
	
	$.ajax({
		type : "post",
		url : "getorderdetailList.action",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		data : {
			orderId : orderId
		},
		success : function(order) {
			
			
			
			
			if(order != null){
				
				
				if(order.supplier != null){
					
					$("#DSuppOrCust").text("供应商");
					$("#DSuppOrCustName").text(order.supplier.name);
					$("#DContact").text(order.supplier.contact);
					$("#DTele").text(order.supplier.tele);
					$("#DAddress").text(order.supplier.address);
					$("#starterType").text("采购员");
					
				}
				else if(order.customer != null){
					
					$("#DSuppOrCust").text("客户");
					$("#DSuppOrCustName").text(order.customer.name)
					$("#DContact").text(order.customer.contact);
					$("#DTele").text(order.customer.tele);
					$("#DAddress").text(order.customer.address);					
					$("#starterType").text("销售员");
				}

				
				
				$("#DCreateTime").text(formatDate(new Date(order.createtime)));
				$("#DCheckTime").text(formatDate(new Date(order.checktime)));
				$("#DStartTime").text(formatDate(new Date(order.starttime)));
				$("#DEndTime").text(formatDate(new Date(order.endtime)));
				
				
				$("#DCreater").text(order.creater);
				$("#DChecker").text(order.checker);
				$("#DStarter").text(order.starter);
				$("#DTotalprice").text(order.totalprice);
				
				var hangLeft = "<tr style=' display: table;width: 100%;table-layout: fixed;' > ";
				var hangRight= "</tr>" ;
				var hangCenterLetf="<td>";
				var hangCenterRight="</td>";				
				
				
				
				
				var orderD = order.orderdetails;
				
 				for(var i=0 ; orderD[i] != null;i++){

 					

 					
 					
					/*  win1(orderD[i].goods.name); */
					var goods = orderD[i].goods;
					var store = orderD[i].store;
					
					var count = i+1;
					var name = goods.name;
					var model = goods.model;
					var goodstype =  goods['goodstype'].name;
					var price = orderD[i].price;
					var num = orderD[i].num;
					var totalprice = price * num;
					var storeName = store.name;
					var storekeeper = orderD[i].storekeeper;
					var state;
					
					if(orderD[i].state == 1){
						
						state = "待处理";
						
					}

					if(orderD[i].state == 2){
						
						state = "已入库";
						
					}
					
					if(orderD[i].state == 3){
						
						state = "已出库";
						
					}
					
					
					var data = hangCenterLetf + count + hangCenterRight;
					var data =data + hangCenterLetf + name + hangCenterRight;
					var data =data + hangCenterLetf + model + hangCenterRight;
					var data =data + hangCenterLetf + goodstype + hangCenterRight;
					var data =data + hangCenterLetf + price + hangCenterRight;
					var data =data + hangCenterLetf + num + hangCenterRight;
					var data =data + hangCenterLetf + totalprice + hangCenterRight;
					var data =data + hangCenterLetf + storeName + hangCenterRight;
					var data =data + hangCenterLetf + storekeeper + hangCenterRight;
					var data =data + hangCenterLetf + state + hangCenterRight;
					
					
					
					var hang = hangLeft + data + hangRight;
					$("#OrderDGoods").append(hang);
					
				} 
				
				
				
			}
 			layer.open({
				 type : 1,
				 skin : 'layui-layer-rim', //加上边框
				 area : [ '900px', '400	px' ], //宽高
				 title : false,
				 closeBtn : 1,
				 shadeClose : true,
				 content : $(ordertail_list_form),
				 cancel: function (index, layero) {//取消事件
					 
					 $("#OrderDGoods").empty();
				 }
				 });  
		},
		error : function() {
			win1("失败");
		}
	});
	
}


function formatDate(date) {
	   var y = date.getFullYear();
	    var m = date.getMonth() + 1;
	    m = m < 10 ? '0' + m : m;
	    var d = date.getDate();
	    d = d < 10 ? ('0' + d) : d;
	    return y + '-' + m + '-' + d;//这里可以写格式
	    //输出：2017-10-9
	}



</script>







<script type="text/javascript"> 


 	var datas = getData();
	 $( "#supplierS" ).autocomplete({
	      source: datas
	    });

	 
	 	var custNames = getcustNames();
		 $( "#customerS" ).autocomplete({
		      source: custNames
		    });	 

		var empNames = getEmpNames();
			 $( "#Emp1S" ).autocomplete({
			      source: empNames
			    });			 
			 $( "#Emp2S" ).autocomplete({
			      source: empNames
			    });			 
			 $( "#Emp3S" ).autocomplete({
			      source: empNames
			    });			 
		 
	 function getData(){
	 	var result;
	 	$.ajax({
	 		type : "POST",
	 		url : "getSupplierName.action",
	 		dataType : "json",
	 		cache : false,
	 		async:false,
	 		success : function(datas) {
	 			
	 			result = [datas.length];
	 			for(var i=0;i<datas.length;i++){
	 				result[i] = datas[i];
	 			}
	 			}
	 		});
	 	return result;
	 }
	 
	 
	 function getcustNames(){
		 	var result;
		 	$.ajax({
		 		type : "POST",
		 		url : "getCustomerName.action",
		 		dataType : "json",
		 		cache : false,
		 		async:false,
		 		success : function(datas) {
		 			/* win1(datas == null); */
		 			result = [datas.length];
		 			for(var i=0;i<datas.length;i++){
		 				result[i] = datas[i];
		 			}
		 			}
		 		});
		 	return result;
		 }
	 
	 
	 
	 

	 function getEmpNames(){
		 	var result;
		 	$.ajax({
		 		type : "POST",
		 		url : "getEmpName.action",
		 		dataType : "json",
		 		cache : false,
		 		async:false,
		 		success : function(datas) {
		 			/* win1(datas == null); */
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




function putGoodsInStore(orderId,orderdetailId,storekeeperId){
	
	
var r=confirm("确定完成入库吗？？？");	
	
	if(r){
 	$.ajax({
 		type : "POST",
 		url : "putGoodsInStore.action",
 		dataType : "json",
 		cache : false,
 		async:false,
 		data:{orderId:orderId,
 			orderdetailId:orderdetailId,
 			storekeeperId:storekeeperId},
 		success : function(datas) {
 			win1("确定完成");
 			location.reload();
 			
 			},
 		error : function() {
			win1("确定失败");
			}
 		});
	
	
	
	}
	else{return;}
	
	
}










</script>


<script type="text/javascript">




function putGoodsOutStore(orderId,orderdetailId,storekeeperId){
	
	
var r=confirm("确定完成出库吗？？？");	
	
	if(r){
 	$.ajax({
 		type : "POST",
 		url : "putGoodsOutStore.action",
 		dataType : "json",
 		cache : false,
 		async:false,
 		data:{orderId:orderId,
 			orderdetailId:orderdetailId,
 			storekeeperId:storekeeperId},
 		success : function(datas) {
 			win1("确定完成");
 			location.reload();
 			
 			},
 		error : function() {
			win1("确定失败");
			}
 		});
	
	
	
	}
	else{return;}
	
	
}










</script>





</html>