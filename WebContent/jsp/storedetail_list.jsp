<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>电梯信息管理系统</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<meta http-equiv="Cache-Control" content="no-cache">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/stylepart.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />


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
				<td colspan="2" align="center"><input type="submit" value="登陆" />
				</td>
			</tr>

		</table>

	</form>











	<form id="check"
		action="${pageContext.request.contextPath }/storedetailList.action"
		method="post">
		<table width="100%">

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
                    <h3>仓库情况-查询信息</h3>
                </div>
                <div class="box_c">
                    <form action="${pageContext.request.contextPath }/storedetailList.action" method="post">
                        <fieldset>
                            <div class="box_c_item">
                                    <label class="l_title">仓库：</label>
                                    <!-- <input class="text_input w200 fl" type="text" name="targets" id="corporate_name" placeholder="请输入公司名称">  -->
                                    <select class="text_input w200 fl" name="storeS" >
                         				 <option selected  style="display:none"  value="" >请选择...</option>
                          				<c:forEach items="${stores }" var="store">
                          					<option>${store.name }</option>
                         			 	</c:forEach>
                    				</select>          
                                    
                               
                                    
                                      <label class="l_title">商品类型：</label>
                                    <!-- <input class="text_input w200 fl" type="text" name="targets" id="consignee" placeholder="请输入收货单位">   -->
                                    <select class="text_input w200 fl" name="gtypeS" >
                         				 <option selected  style="display:none" value="">请选择...</option>
                          				<c:forEach items="${goodstypes }" var="gtype">
                          					<option >${gtype.name }</option>
                         			 	</c:forEach>
                    				</select>                                   
                                   
                                   
                                   
                                   
                                   
                                   
                                   <label class="l_title">供应商：</label>
                                    <input class="text_input w200 f1" type="text" name="supplierS" id="supplierS" placeholder="请输入公司名称" > 
                                    
                                   <div class="clear"></div>                             
                            </div>
                            
                            <div class="box_c_item">
                                    <label class="l_title">货物名称：</label>
                                    <input class="text_input w200 fl" type="text" name="goodsS" id="goodsS" placeholder="请输入公司名称"> 
                                    
                                  
                                    
                                    <label class="l_title">货物型号：</label>
                                    <input class="text_input w200 fl" type="text" name="modelS"  id="modelS" placeholder="请输入收货单位">  
                                    
                                   <div class="clear"></div>                             
                            </div>
                            
                            
                                                   
                            
                            <div class="fr">
                        		<button class="btn btn_commit" type="sumbit">确认提交</button> 
                   			</div>
                        </fieldset>
                    </form>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="box">
                <div class="box_t box_t_bottom">
                    <h3>仓库情况-库存信息</h3>
                </div>
                <div class="box_c box_c_reset">
                    <table class="table">
                        <thead>
                            <tr>
                                <th >序号</th>
                                <th>货物名称</th>
                                <th>货物型号</th>
                                <th>供应商</th>
                                <th>所属仓库</th>
                                <th>货物类型</th>
                                <th >购价</th>
                                <th >售价</th>
                                <th >数量</th>
                                <th class="text-right">总数量</th>                                
                                
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
                        
                        	<c:forEach items="${page.rows}" var="stdetail">
                            <tr>
                                <td rowspan="${stdetail['goodsprices'].size()+1}"><%=++num%></td>
                                <td rowspan="${stdetail['goodsprices'].size()+1}">${stdetail['goods'].name }</td>
                                <td rowspan="${stdetail['goodsprices'].size()+1}">${stdetail['goods'].model }</td>
                                <td rowspan="${stdetail['goodsprices'].size()+1}">${stdetail['supplier'].name }</td>
                                <td rowspan="${stdetail['goodsprices'].size()+1}">${stdetail['store'].name }</td>
                                <td rowspan="${stdetail['goodsprices'].size()+1}">${stdetail['goods'].goodstype.name }</td>
                                	
                                
                                		<% boolean bool = true; %>
                                	<c:forEach items="${stdetail['goodsprices']}" var="goodsprice">
                                		
                                		<tr>
                                			<td >
                                		${goodsprice.inprice}
                                			</td>
                                			
                                			<td >
                                		${goodsprice.outprice}
                                			</td>
                                			
                                			<td >
                                		${goodsprice.num}(${stdetail['goods'].unit })
                                			</td>
                                			
                                			<c:if test="<%=bool %>">
                                			
                                			
											<td class="text-right" rowspan="${stdetail['goodsprices'].size()+1}">
												${stdetail.totalnum}(${stdetail['goods'].unit })
											</td> 
                                			
                                			<%bool=false; %>
                                			
                                			</c:if>
                       			
                                			
                                		</tr>
                                		
                                		
                                	
                                	</c:forEach>
                                	
                                
                               
                               
                                
                            </tr><!-- 最多7行 -->
                            
                          </c:forEach>
                        </tbody>
                    </table>
                     <div class="clear"></div>
						<!-- 页码框选项，与页面跳转实现 -->
						<itcast:page url="${pageContext.request.contextPath }/storedetailList.action" />

            </div>
        </div>

    </div>
    <!--END content-->
</div>

</body>


<script type="text/javascript"> 


 	var datas = getData();
	 $( "#supplierS" ).autocomplete({
	      source: datas
	    });
	 
	 var datas1 = getData1();
	 $( "#goodsS" ).autocomplete({
	      source: datas1
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

	 
	 
	 function getData1(){
		 	var result;
		 	$.ajax({
		 		type : "POST",
		 		url : "getGoodsName.action",
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

</script>




</html>