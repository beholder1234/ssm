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










<%-- 		<form id="check"
		action="${pageContext.request.contextPath }/login.action"
		method="post">
		<table width="100%">

			<tr>
				<td colspan="2" align="center"><input type="submit" value="登陆" />
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
                    <h3>电梯设备情况-查询信息</h3>
                </div>
                <div class="box_c">
                    <form action="${pageContext.request.contextPath }/equipmentList.action" method="post">
                        <fieldset>
                            <div class="box_c_item">
                                    <label class="l_title">电梯工号：</label>
                                    <input class="text_input w200 fl" type="text" name="num" id="corporate_name" placeholder="请输入公司名称"> 
                                    
                                    <label class="l_title">注册代码：</label>
                                    <input class="text_input w200 fl" type="text" name="code" id="consignee" placeholder="请输入收货单位">  
                                     <label class="l_title">客户：</label>
                                    <input class="text_input w200 fl" type="text" name="customerName" id="customerS" placeholder="请输入收货单位">  
                                                                      
                                   <div class="clear"></div>                             
                            </div>
                            
                            <div class="box_c_item">
                                    <label class="l_title">电梯名称：</label>
                                   <!--  <input class="text_input w200 fl" type="text" name="name" id="corporate_name" placeholder="请输入公司名称">  -->
                    <select class="text_input w200 fl" id="ordertypeS" name="name" >
                          <option selected  style="display:none" value="" >请选择...</option>
                          <c:forEach items="${equipmentNames }" var="equipmentName">
                          	<option value="${equipmentName.valuename }" >${equipmentName.valuename }</option>
                          </c:forEach>
                    </select>                                    

                                    <label class="l_title">状态：</label>
                                  <!--   <input class="text_input w200 f1" type="text" name="state" id="receiver" placeholder="请输入公司名称">  -->
                    <select class="text_input w200 fl" id="ordertypeS" name="state" >
                          <option selected  style="display:none" value="" >请选择...</option>
                          <c:forEach items="${equipmentStates }" var="equipmentState">
                          	<option value="${equipmentState.valueid }" >${equipmentState.valuename }</option>
                          </c:forEach>
                    </select>                                      
                                    
                                   <div class="clear"></div>                             
                            </div>
                            
<!--                             
                            <div class="box_c_item">
                                    <label class="l_title">下次安检日期：</label>
                                    <input class="text_input w200 fl" type="text" name="corporate_name" id="corporate_name" placeholder="请输入公司名称"> 
									<span class="l_con">-</span>
                                    <input class="text_input w200 fl" type="text" id="consignee" placeholder="请输入收货单位">  
                                    
                                                                        <label class="l_title">下次年申日期：</label>
                                    <input class="text_input w200 fl" type="text" name="corporate_name" id="corporate_name" placeholder="请输入公司名称"> 
									<span class="l_con">-</span>
                                    <input class="text_input w200 fl" type="text" id="consignee" placeholder="请输入收货单位"> 
 
                                   <div class="clear"></div>                             
                            </div>   -->                          
                            
                            <div class="fr">
                        		<label class="l_title"></label>
                        		<button class="btn btn_commit" type="sumbit">确认提交</button> 
                   			</div>
                        </fieldset>
                    </form>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
       </div>
            <div class="box">
                <div class="box_t box_t_bottom">
                    <h3>电梯设备情况-设备信息</h3>
                  
                </div>
                
                <div class="box_c box_c_reset">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>电梯工号</th>
                                <th>注册代码</th>
                                <th>机型</th>
                                <th>电梯名称</th>
                                <th>安检日期</th>
                                <th>年检日期</th>
                                <th>状态</th>
                                <th style="text-align: right">操作</th>
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
							<c:forEach items="${page.rows}" var="equiment">	
                            <tr>
                                <td><%=++num%></td>
                                <td>${equiment.num }</td>
                                <td>${equiment.code }</td>
                                <td>${equiment.model }</td>
                                <td>${equiment.name }</td>
                                <td><fmt:formatDate value="${equiment.secexamtime }" pattern="yyyy-MM-dd"/></td>
                                <td><fmt:formatDate value="${equiment.annualexamtime }" pattern="yyyy-MM-dd"/></td>
                                <td>
                                <c:forEach items="${ equipmentStates}" var="equipmentState">
                                	<c:if test="${equipmentState.valueid eq  equiment.state}">
                                		${equipmentState.valuename}
                                	</c:if>
                                </c:forEach>
                                
                                
                                </td>
                                <td class="text-right"><a href="#" onClick="eqDetail(${equiment.id})">详情</a> <!-- | <a href="#">编辑</a> --> </td>
                            </tr><!-- 最多7行 -->
                            	</c:forEach>
                        </tbody>
                    </table>
                    <div class="clear"></div>
                    <div class="clear"></div>
                    <itcast:page url="${pageContext.request.contextPath }/equipmentList.action" />
					
            	</div>	
        	</div>
</div>
    <!--END content-->


<div class="box_c hide" id="equipment_detail_form">
			<fieldset>
				<div class="box_c_item">
					<label class="l_title">电梯工号：</label> <span class="l_con" id="numD"></span>
					<label class="l_title">注册代号：</label> <span class="l_con" id="codeD"></span>
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title">电梯名称：</label> <span class="l_con" id="nameD"></span>
					<label class="l_title">机型：</label> <span class="l_con" id="modelD"></span>
					<div class="clear"></div>
				</div>
				


				<div class="box_c_item">
					<label class="l_title">安装日期：</label> <span class="l_con" id="intimeD"></span>
					<label class="l_title">运行日期：</label> <span class="l_con" id="operTimeD"></span>
					<label class="l_title"> 解约日期：</label> <span class="l_con" id="scrapTimeD"></span>
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title"> 安检日期：</label> <span class="l_con" id="secTimeD"></span>
					<label class="l_title">年审日期：</label> <span class="l_con" id="annualTimeD"></span>
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">客户单位：</label> <span class="l_con" id="custNameD"></span><br>
					</span>
					<div class="clear"></div>
				</div>			
				<div class="box_c_item">
					<label class="l_title">联系人：</label> <span class="l_con" id="custContactD"></span>
					</span>
					<div class="clear"></div>
				</div>			
				<div class="box_c_item">
					<label class="l_title">电话：</label> <span class="l_con" id="teleD">
					</span>
					<div class="clear"></div>
				</div>			

			</fieldset>
			<div class="clear"></div>
		</div>





</body>

<script type="text/javascript">

var custNames = getcustNames();
$( "#customerS" ).autocomplete({
     source: custNames
   });


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

</script>


<script type="text/javascript">
	function eqDetail(eqId) {
		
		$.ajax({
			type : "post",
			url : "getEquipmentDetail.action",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : {
				eqId : eqId
			},
			success : function(equipment) {
				if(equipment.id != null){
					
					$("#numD").text(equipment.num);
					$("#codeD").text(equipment.code);
					$("#nameD").text(equipment.name);
					$("#modelD").text(equipment.model);
					
					$("#custNameD").text(equipment['customer'].name);
					$("#custContactD").text(equipment['customer'].contact);
					$("#teleD").text(equipment['customer'].tele);
					
					
					$("#intimeD").text(formatDate(new Date(equipment.installtime)));
					$("#operTimeD").text(formatDate(new Date(equipment.opertime)));
					$("#scrapTimeD").text(formatDate(new Date(equipment.scrapdate)));
					$("#secTimeD").text(formatDate(new Date(equipment.secexamtime)));
					$("#annualTimeD").text(formatDate(new Date(equipment.annualexamtime)));
					
					
					
					
				/* 	$("#DEndTime").text(formatDate(new Date(order.endtime)));
					 */
					
				}
	 			layer.open({
					 type : 1,
					 skin : 'layui-layer-rim', //加上边框
					 area : [ '998px', '400px' ], //宽高
					 title : false,
					 closeBtn : 1,
					 shadeClose : true,
					 content : $(equipment_detail_form)
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

</html>