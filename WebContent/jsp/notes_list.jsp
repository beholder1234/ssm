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


<%-- 	<form id="check"
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
		action="${pageContext.request.contextPath }/notesList.action"
		method="post">
		<table width="100%">
			<tr>
			
				<td>
				<input class="text_input w150" type="hidden" name="which"  value="businessDealWith"  > 
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
                <div class="box_t box_t_bottom" id="bNotes">
                    <h3 >业务通知</h3>
                </div>
                <div class="box_c box_c_reset" id="bNotes2">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>处理日期</th>
                                <th>设备名称</th>
                                <th>客户单位</th>
                                <th>联系人</th>
                                <th>电话</th>
                                <th>设备地址</th>
                                <th>状态</th>
                                <th>业务类型</th>
                                <th class="text-right">操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                                          	<!-- 行号设初始值 -->
								<%
									int num = 0;
								%>

                        	<c:forEach items="${businesses}" var="business">
                            <tr>
                                <td><%=++num%></td>
                                <td><fmt:formatDate value="${business.starttime }" pattern="yyyy-MM-dd"/></td>
                                <td>${business['equipment'].name }</td>
                                <td>${business['equipment'].customer['name'] }</td>
                                <td>${business['equipment'].customer['contact'] }</td>
                                <td>${business['equipment'].customer['tele'] }</td>
                                <td>${business.equipment.customer['address'] }</td>
                                <td>
                                	<c:forEach items="${businessStates}" var="businessState">
                                		<c:if test="${businessState.valueid eq business.state}">
                                			 ${businessState.valuename}
                                		</c:if>
                                	</c:forEach>
                                </td>
                                <td>
                                	<c:forEach items="${businessTypes}" var="businesstype">
                                		<c:if test="${businesstype.valueid eq business.type}">
                                			 ${businesstype.valuename}
                                		</c:if>
                                	</c:forEach>                                
                                
                                
                                </td>
                                 <td class="text-right"><a href="#" onclick="getBusinessdetailList(${business.id})">业务明细</a>
                                
                                </td> 
                            </tr><!-- 最多7行 -->
                            </c:forEach>
                        </tbody>
                    </table>

					<div class="clear"></div>
                


            </div>
           </div>
           <br>
         <div class="box">
                <div class="box_t box_t_bottom" id="sNotes">
                    <h3>库存通知</h3>
                </div>
                <div class="box_c box_c_reset" id="sNotes2" >
                    <table class="table">
                        <thead>
                            <tr>
                                <th >序号</th>
                                <th>货物名称</th>
                                <th>货物型号</th>
                                <th>供应商</th>
                                <th>所属仓库</th>
                                <th>货物类型</th>                                
                                <th>单位</th>
                                <th>库存数量</th>
                                <th class="text-right">要求数量</th>                                
                                
                            </tr>
                        </thead>
                        <tbody>
                        
                       			 <!-- 行号设初始值 -->
								<%
									int num2 = 0;
								%>
                        
                        	<c:forEach items="${storedetails}" var="stdetail">
                            <tr>
                                <td ><%=++num2%></td>
                                <td>${stdetail['goods'].name }</td>
                                <td >${stdetail['goods'].model }</td>
                                <td >${stdetail['supplier'].name }</td>
                                <td >${stdetail['store'].name }</td>
                                <td >${stdetail['goods'].goodstype.name }</td>
                                <td >${stdetail['goods'].unit }</td>
                                <td >${stdetail.totalnum }</td>
                                <td class="text-right">${stdetail['goods'].alertnum }</td>
                               
                                
                            </tr><!-- 最多7行 -->
                            
                          </c:forEach>
                        </tbody>
                    </table>
                     <div class="clear"></div>

            </div>
            
            
            
            
            
            
            
                            
<div class="box_c hide" id="businessDetail_list_form">
	 <form action="${pageContext.request.contextPath }/saveGoods.action" method="post">
			<fieldset>
			
			
<table class="table" width="80%"  style="border-spacing:0; border-collapse: collapse;text-align: center;" border="1">
<thead style="width:99%;display: table;table-layout: fixed;">
  <tr>
    <th colspan="10"><div align="center">业务表-基本信息</div></th>
  </tr>
</thead>
<tbody style="display: block;height:100%;">
  <tr style=" display: table;width: 99%;table-layout: fixed;">
  
  
    <td ><div align="right">电梯名称</div></td>    
    <td colspan="3" id="eleNameD"></td>
    
    
    
    <td><div align="right">客户单位</div></td>
    <td colspan="3" id="custNameD"><div align="center"></div></td>
    
    
    
    <td><div align="right">业务类型</div></td>
    <td colspan="1" id="businesstypeD"><div align="right"></div></td>
    
    
  </tr>
  
  <tr style=" display: table;width: 99%;table-layout: fixed;">
  
    <td ><div align="right">工号</div></td>
    <td colspan="3"  id="numD"><div align="right"></div></td>
    
    
    <td><div align="right" >联系人</div></td>
    <td colspan="3" id="custContactD"><div align="right"></div></td>
    
    
    <td><div align="right">业务状态</div></td>
    <td colspan="1" id="businessStateD"><div align="right"></div></td>
    
    
  </tr>
  
  
  
  <tr style=" display: table;width: 99%;table-layout: fixed;">
  
    <td><div align="right">注册编号</div></td>
    <td colspan="3" id="codeD"><div align="right"></div></td>
    
    
    <td><div align="right" >电话</div></td>
    <td colspan="3" id="custteleD"><div align="right"></div></td>
    
    
    <td ><div align="right" >创建日期</div></td>
    <td colspan="1" id="beTimeD"><div align="right"></div></td>
    
    
  </tr>
  
  <tr style=" display: table;width: 99%;table-layout: fixed;">
  
    <td><div align="right">机型</div></td>
    <td colspan="3" id="modelD"><div align="right"></div></td>
    
    
    <td><div align="right" >邮箱</div></td>
    <td colspan="3" id="custemailD"><div align="right"></div></td>
    
    
    <td><div align="right">处理日期</div></td>
    <td colspan="1" id="startTimeD"><div align="right"></div></td>
  </tr>
  
  <tr style=" display: table;width: 99%;table-layout: fixed;">
  
    <td><div align="right">设备地址</div></td>
    <td colspan="3" id="eleAddressD"><div align="right"></div></td>
    
    
    <td><div align="right" >单位地址</div></td>
    <td colspan="3" id="custAddressD"><div align="right"></div></td>
    
    
    <td><div align="right">完成日期</div></td>
    <td colspan="1" id="endTimeD"><div align="right"></div></td>
  </tr>
</tbody>

<thead 	style="width:98%;display: table;table-layout: fixed;">
  <tr>
    <th colspan="10"><div align="center">订单表-商品信息</div></th>
  </tr>
  <tr>
    <th colspan="2"><div align="center">序号</div></th>
    <th colspan="2"><div align="center">姓名</div></th>
    <th colspan="2"><div align="center">电话</div></th>
    <th colspan="2"><div align="center">职位</div></th>
    <th colspan="2"><div align="center">工作类型</div></th>
  </tr>
</thead>

<tbody style="display: block;height:180px;overflow-y: scroll;"  id="BusinessDEmps">


	

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



$(document).ready(function(){
  $("#bNotes").click(function(){
    $("#bNotes2").slideToggle("slow");
    $("#sNotes2").slideToggle("slow");
  });
});
$(document).ready(function(){
  $("#sNotes").click(function(){
    $("#bNotes2").slideToggle("slow");
    $("#sNotes2").slideToggle("slow");
  });
});



</script>










<script type="text/javascript">
	function updateBusinessToOn(businessId) {
		
		 
			//信息框-例2

			layer.msg('确定处理吗？', {
			  time: 0 //不自动关闭
			  ,btn: ['确定', '取消']
			  ,yes: function(index){
			    layer.close(index);

				$.ajax({
					type : "post",
					url : "updateBusinessToOn.action",
					contentType : "application/x-www-form-urlencoded;charset=utf-8",
					data : {
						"businessId" : businessId,
					},
					success : function(data) {
						if(!data){
							win1("订单未处理，确定失败...");
						}
						else{
							
							win1("确认成功");
							location.reload();
						}
					},
					error : function() {
						win1("删除失败");
					}
				});
			    
			    
			  }
			});

		 
		 
		 
		 
		 

		
	}
</script>

<script type="text/javascript">
	function updateBusinessToFinish(businessId) {
		 
		 

			//信息框-例2

			layer.msg('确定完成任务吗？', {
			  time: 0 //不自动关闭
			  ,btn: ['确定', '取消']
			  ,yes: function(index){
			    layer.close(index);

				$.ajax({
					type : "post",
					url : "updateBusinessToFinish.action",
					contentType : "application/x-www-form-urlencoded;charset=utf-8",
					data : {
						"businessId" : businessId,
					},
					success : function(data) {
						if(!data){
							win1("业务未处理，确定失败...");
						}
						else{
							
							win1("确认成功");
							location.reload();
						}
					},
					error : function() {
						win1("删除失败");
					}
				});
			    
			    
			  }
			});

		 
		 
		 
		 

		
	}
</script>

<script type="text/javascript">


  

$(function(){
	
	
	//使用jQuery
	$(".calendar").flatpickr();  
	
	
	
});


</script>






<script type="text/javascript">

function getBusinessdetailList(businessId) {
	
	$.ajax({
		type : "post",
		url : "getBusinessdetailList.action",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		data : {
			businessId : businessId
		},
		success : function(business) {
			
			
			
			
			if(business != null){
				
				
					
					$("#eleNameD").text(business['equipment'].name);
					$("#numD").text(business['equipment'].num);
					$("#codeD").text(business['equipment'].code);
					$("#modelD").text(business['equipment'].model);					
					$("#eleAddressD").text(business['equipment'].address);

				
					$("#custNameD").text(business.equipment['customer'].name);
					$("#custContactD").text(business.equipment['customer'].contact);
					$("#custTeleD").text(business.equipment['customer'].tele);
					$("#custEmailD").text(business.equipment['customer'].email);					
					$("#custAddressD").text(business.equipment['customer'].address);
					
					
					switch(business.type) {
				     case "1":
				    	$("#businesstypeD").text("安装");
				        break;
				     case "2":
				    	 $("#businesstypeD").text("安检");
				        break;
				     case "3":
				    	$("#businesstypeD").text("年审");
				        break;
				     default:
				    	 $("#businesstypeD").text("");
				} 
					switch(business.state) {
				     case "1":
				    	$("#businessStateD").text("待分派");
				        break;
				     case "2":
				    	 $("#businessStateD").text("待处理");
				        break;
				     case "3":
				    	$("#businessStateD").text("处理中");
				        break;
				     case "4":
				    	$("#businessStateD").text("已处理");
				        break;
				     default:
				    	 $("#businessStateD").text("");
				} 
					
				


					
				
				$("#beTimeD").text(formatDate(new Date(business.createtime)));
				$("#startTimeD").text(formatDate(new Date(business.starttime)));
				$("#endTimeD").text(formatDate(new Date(business.endtime)));
				
				

				
				var hangLeft = "<tr style=' display: table;width: 100%;table-layout: fixed;' > ";
				var hangRight= "</tr>" ;
				var hangCenterLetf="<td>";
				var hangCenterRight="</td>";				
				
				
				
				
				var businessR = business.businessemprecords;
				
 				for(var i=0 ; businessR[i] != null;i++){
 					var count = i+1;
					var empname = businessR[i].emp.name;
					var emptele = businessR[i].emp.tele;
					var empRole = businessR[i].emp['role'].name;
					switch(business.state) {
				     case "1":
				    	var workType = "分派";
				        break;
				     case "2":
				    	 var workType = "处理";
				        break;
				     default:
				    	 var workType = "";
					} 
					
					var data = hangCenterLetf + count + hangCenterRight;
					var data =data + hangCenterLetf + empname + hangCenterRight;
					var data =data + hangCenterLetf + emptele + hangCenterRight;
					var data =data + hangCenterLetf + empRole + hangCenterRight;
					var data =data + hangCenterLetf + workType + hangCenterRight;
					
					
					/* alert(data); */
					
					var hang = hangLeft + data + hangRight;
					$("#BusinessDEmps").append(hang);
					
				} 
				
				
				
			}
 			layer.open({
				 type : 1,
				 skin : 'layui-layer-rim', //加上边框
				 area : [ '900px', '400	px' ], //宽高
				 title : false,
				 closeBtn : 1,
				 shadeClose : true,
				 content : $(businessDetail_list_form),
				 cancel: function (index, layero) {//取消事件
					 
					 $("#BusinessDEmps").empty();
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
		 			/* alert(datas == null); */
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












</html>