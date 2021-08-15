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





    <!--content-->
    <div class="content">
        <!--发货通知单录入-->
        <div class="add_delivery_notice">
            <div class="box">
                <div class="box_t">
                    <h3>电梯业务情况-查询信息</h3>
                </div>
                <div class="box_c">
                    <form action="${pageContext.request.contextPath }/businessAssignList.action" method="post">
                        <fieldset>
                        
                        
                            <div class="box_c_item">
                            
                           
                            
                            
                                    <label class="l_title">业务类型：</label>
                    <select class="text_input w200 fl" id="businesstypeS" name="businesstypeS" >
                          <option selected  style="display:none" value="" >请选择...</option>
                          <c:forEach items="${businessTypes }" var="businesstype">
                          	<option value="${businesstype.valueid }" >${businesstype.valuename }</option>
                          </c:forEach>
                    </select>            
                                    
                    <div class="clear"></div>  
                            </div>
                            <div class="box_c_item">
                                    <label class="l_title">客户单位：</label>
                                    <input class="text_input w200 fl" type="text" name="customerS" id="customerS" placeholder="请输入收货单位"> 
                                                                      
                                    <label class="l_title">电梯工号：</label>
                                    <input class="text_input w200 fl" type="text" name="numS" id="numS" placeholder="请输入收货单位">  
                                    
                                    <label class="l_title">电梯注册代码：</label>
                                    <input class="text_input w200 fl" type="text" name="codeS" id="codeS" placeholder="请输入收货单位">  
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
                    <h3>电梯业务情况-业务信息</h3>
                </div>
                <div class="box_c box_c_reset">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>创建日期</th>
                                <th>设备名称</th>
                                <th>工号</th>
                                <th>注册代码</th>
                                <th>客户单位</th>
                                <th>业务类型</th>
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
                        	<c:forEach items="${page.rows}" var="business">
                            <tr>
                                <td><%=++num%></td>
                                <td><fmt:formatDate value="${business.createtime }" pattern="yyyy-MM-dd"/></td>
                                <td>${business['equipment'].name }</td>
                                <td>${business['equipment'].num }</td>
                                <td>${business['equipment'].code }</td>
                                <td>${business.equipment['customer'].name }</td>
                                <td>
                                	<c:forEach items="${businessTypes}" var="businesstype">
                                		<c:if test="${businesstype.valueid eq business.type}">
                                			 ${businesstype.valuename}
                                		</c:if>
                                	</c:forEach>                                
                                </td>
                                <%-- <td ><fmt:formatDate value="${order.createtime }" pattern="yyyy-MM-dd"/></td> --%>
                                <td class="text-right"><a href="#" onclick="getBusinessAssign(${business.id})">分派</a>
                                </td>
                            </tr><!-- 最多7行 -->
                            </c:forEach>
                        </tbody>
                    </table>

					<div class="clear"></div>
                    <!-- 页码框选项，与页面跳转实现 -->
					<itcast:page url="${pageContext.request.contextPath }/businessAssignList.action" />
                


            </div>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
                            
<div class="box_c hide" id="businessDetail_list_form">
	 <form action="${pageContext.request.contextPath }/businessAssign.action" method="post" id="assignForm">
			<fieldset>
			
			
<table class="table" width="80%"  style="border-spacing:0; border-collapse: collapse;text-align: center;" border="1">
<thead style="width:99%;display: table;table-layout: fixed;">
  <tr>
    <th colspan="10"><div align="center">业务表-基本信息</div></th>
  </tr>
</thead>
<tbody style="display: block;height:100%;">
  <tr style=" display: table;width: 99%;table-layout: fixed;">
  
  
    <td >
    <input class="text_input w150" type="hidden" name="businessId" id="businessId"  value=""  > 
    <div align="right">电梯名称</div>
    </td>    
    <td colspan="3" id="eleNameD" name="business.equipment.name"></td>
    
    
    
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
    <th colspan="10">
    <div align="center">订单表-商品信息</div>   
    
    </th>
  </tr>
  <tr>
    <th colspan="1"><div align="center">序号</div></th>
    <th colspan="2"><div align="center">姓名</div></th>
    <th colspan="2"><div align="center">电话</div></th>
    <th colspan="2"><div align="center">职位</div></th>
    <th colspan="2"><div align="center">工作类型</div></th>
    <th colspan="1"><div align="center">操作</div></th>
  </tr>
</thead>

<tbody style="display: block;height:180px;overflow-y: scroll;"  id="BusinessDEmps">


	

</tbody>

</table>

<div class="layui-layer-btn">
	<a class="layui-layer-btn1" onClick="addEmpToBusiness()">分派</a>
	<a class="layui-layer-btn0" onclick="document:assignForm.submit()">提交</a>
	<a class="layui-layer-btn2">取消</a>
	
</div>


			</fieldset>
			</form>
		</div>       
		
		
		
		
		
		<div class="box_c hide" id="emp_detail_form">
			<fieldset>
				<input class="text_input w150" type="hidden" name="empId" id="empId"  value=""  > 
				<div class="box_c_item">
					<label class="l_title" align="center">姓名：</label> 
					 <input class="text_input w200 fl" type="text" name="empName" id="empName"  onChange="getEmpByName()" required> 
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">性别：</label> <span class="l_con" id="empGender">
					</span>
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">手机号码：</label> <span class="l_con" id="empTele"></span>
					<div class="clear" />
				</div>
				
				<div class="box_c_item">
					<label class="l_title">邮箱：</label> <span class="l_con" id="empEmail"></span>
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">所属部门：</label> <span class="l_con" id="empDep" ></span>
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">职位：</label> <span class="l_con" id="empRole" ></span>
					<div class="clear" />
				</div>
			</fieldset>
			<div class="clear"></div>
		</div>		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		  
            
            
        </div>
      
        <!-- END 发货通知单产品录入弹窗-->
    </div>
    <!--END content-->
</div>

</body>




<script type="text/javascript">



function getEmpByName(){
	
	$.ajax({
		type : "post",
		url : "getEmpByName.action",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		data : {empName : $("#empName").val()
		},
		success : function(emp) {
			
			if(emp != null){
				
				$("#empId").val(emp.id);
				$("#empName").val(emp.name);
				
				if(emp.gender == 0){
					
					$("#empGender").text("男");
					
				}
				else if(emp.gender == 1){
					
					$("#empGender").text("女");
					
				}
				else $("#empGender").text("");
				
				$("#empTele").text(emp.tele);
				$("#empEmail").text(emp.email);
				$("#empDep").text(emp['dep'].name);
				$("#empRole").text(emp['role'].name);
				
				
				
				
			}
			else
				{
				
				$("#empId").val("");
				$("#empName").val("");
				$("#empGender").text("");
				$("#empTele").text("");
				$("#empEmail").text("");				
				$("#empDep").text("");
				$("#empRole").text("");
				
				
				}
			
			
		},
		error : function() {
			win1("保存失败");
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

function getBusinessAssign(businessId) {
	
	$.ajax({
		type : "post",
		url : "getBusinessdetailList.action",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		data : {
			businessId : businessId
		},
		success : function(business) {
			
			
			
			
			if(business != null){
				
					$("#businessId").val(business.id);
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
					

					$("#beTimeD").text(formatDate(new Date(business.createtime)));
					$("#startTimeD").text(formatDate(new Date(business.starttime)));
					$("#endTimeD").text(formatDate(new Date(business.endtime)));
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
				
			}
 			layer.open({
				 type : 1,
				 skin : 'layui-layer-rim', //加上边框
				 area : [ '900px', '400	px' ], //宽高
				 title : false,
				 closeBtn : 1,
				 shadeClose : true,
				 content : $(businessDetail_list_form),
				 yes:function (index, layero) {
					 //$("#BusinessDEmps").empty();
				 },
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


function addEmpToBusiness(){
	
		layer.open({
			 type : 1,
			 skin : 'layui-layer-rim', //加上边框
			 area : [ '700px', '400	px' ], //宽高
			 title : false,
			 closeBtn : 1,
			 shadeClose : true,
			 content : $(emp_detail_form),
			 btn:['确定','取消'],
			 yes:function (index, layero) {
				
					var  count =$('#BusinessDEmps  tr').length;
				 	count = count +1;
				 
				 
					var id= $("#empId").val();
					var name= $("#empName").val();
					var tele = $("#empTele").text();
					var role = $("#empRole").text();
					
					var hangLeft_L = "<tr style=' display: table;width: 100%;table-layout: fixed;' id='Row";
					var hangLeft_R = "'>  ";
					var hangRight= "</tr>" ;
					var hangCenterLetf1="<td colspan='1'>";
					var hangCenterLetf2="<td colspan='2'>";
					var hangCenterRight="</td>";
					 var IdHandLeft = " <td   style='display:none'> <input type = 'hidden' name='empIds'  value= '";
					 var IdHandRight = "'> </td >";
				 
					 
					 var operL = "<td colspan='1' class='text-right'><a href='#' onClick='deleteEmp(Row";
				 	 var operR= ")'>删除</a></td>"
					 
					 var data = IdHandLeft + id + IdHandRight;
					 data = data + hangCenterLetf1 + count + hangCenterRight;
					 data = data + hangCenterLetf2 + name + hangCenterRight;
					 data = data + hangCenterLetf2 + tele + hangCenterRight;
					 data = data + hangCenterLetf2 + role + hangCenterRight;
					 data = data + hangCenterLetf2 + "处理" + hangCenterRight;
					 data = data + operL + count + operR;
					 
					var hang = hangLeft_L +count+ hangLeft_R + data + hangRight;
					$("#BusinessDEmps").append(hang);
			 },
			 cancel: function (index, layero) {//取消事件
				 
				
			 }
			 });  
	
	
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
			 $( "#empName" ).autocomplete({
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

function deleteEmp(RowId){
	
	$(RowId).remove();
	
	var  count =$('#BusinessDEmps  tr').length;

	//改行号，与id属性值
	for(var i=1;i<=count;i++){
		
		/* $('#goodsOrder  tr td:eq(1)').text(i) */
		
		index = i-1;
		$('#BusinessDEmps  tr:eq('+ index+ ')').attr("id","Row"+i);
		// td:eq(1)为序号列的原因：因 tr：eq（0） 为type=”hidden“，存goodsid， td：eq（1）才是 序号
		$('#BusinessDEmps  tr:eq('+ index+ ') td:eq(1)').text(i);
		
		$('#BusinessDEmps  tr:eq('+ index+ ') td:eq(6) a').attr("onClick","deleteEmp(Row"+i +")");
		
	}
	

	
	
	
	
}












</script>








</html>