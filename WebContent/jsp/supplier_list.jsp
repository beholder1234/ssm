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
<script type="text/javascript" src="layer/layer.js"></script>
<meta http-equiv="Cache-Control" content="no-cache">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/stylepart.css" rel="stylesheet" type="text/css" />




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
		action="${pageContext.request.contextPath }/supplierList.action"
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
        <!--生产单列表-->
        <div class="manufacture_list">
            <div class="box">
                <div class="box_t box_t_bottom">
                    <h3 >供应商列表</h3>
                    <form class="search_box fr" id="check" action="${pageContext.request.contextPath }/supplierList.action" method="post">
						<input name="target" class="fl" type="text" placeholder="请输入单位名称" />
						<button class="fl" type="submit">
							<i class="icon">&#xe617;</i>
						</button>
					</form>
                    
                    
                    <button id="add_quotation_button" class="btn btn_add fr" type="button" onclick="insertForm()"><i class="icon">&#xe61e;</i>&nbsp;录入</button>
       
                </div>
                 <!--新增部门-->
            <div class="box">
                <div class="box_c box_c_reset">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>单位名称</th>
                                <th>联系人</th>
                                <th>电话</th>
                                <th>邮箱地址</th>
                                <th>地址</th>
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
							<c:forEach items="${page.rows}" var="supplier">	
                            <tr>
                                <td><%=++num%></td>
                                <td>${supplier.name }</td>
                                <td>${supplier.contact }</td>
                                <td>${supplier.tele }</td>
                                <td>${supplier.email }</td>
                                <td>${supplier.address}</td>
                                <td class="text-right"><a href="#" onclick="editSupplier(${supplier.id})">编辑</a> | <a href="#" onclick="deleteSupplier(${supplier.id})">删除</a></td>
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                    <div class="clear"></div>
                    <!-- 页码框选项，与页面跳转实现 -->
					<itcast:page url="${pageContext.request.contextPath }/supplierList.action" />
                </div>
            </div>
        <!--END 新增部门-->
        
        
        

<div class="box_c hide" id="supplier_edit_form">
			<fieldset>
				<div class="box_c_item">
					<label class="l_title">单位名称：</label> 
					<input class="text_input w150" type="text" name="product_spec" id="nameE" >
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title">联系人：</label> 
					<input class="text_input w150" type="text" name="product_spec" id="contactE" >
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title">手机号码：</label> 
					<input class="text_input w150" type="text" name="product_spec" id="teleE" >
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">邮箱：</label> 
					<input class="text_input w150" type="text" name="product_spec" id="emailE" >
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">地址：</label> 
					<input class="text_input w300" type="text" name="product_spec" id="addressE" >
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
                    <label class="l_title"></label>
                    <button class="btn btn_commit" type="button"  id="saveButtton" onclick="saveSupplier()">保存</button>
                    <div class="clear"></div>
                </div>

			</fieldset>
			<div class="clear"></div>
		</div>


<div class="box_c hide" id="supplier_insert_form">
			<fieldset>
				<div class="box_c_item">
					<label class="l_title">单位名称：</label> 
					<input class="text_input w150" type="text" name="product_spec" id="nameI" >
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title">联系人：</label> 
					<input class="text_input w150" type="text" name="product_spec" id="contactI" >
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title">手机号码：</label> 
					<input class="text_input w150" type="text" name="product_spec" id="teleI" >
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">邮箱：</label> 
					<input class="text_input w150" type="text" name="product_spec" id="emailI" >
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">地址：</label> 
					<input class="text_input w300" type="text" name="product_spec" id="addressI" >
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
                    <label class="l_title"></label>
                    <button class="btn btn_commit" type="button"  onclick="insertSupplier()" id="insertButtton">保存</button>
                    <div class="clear"></div>
                </div>

			</fieldset>
			<div class="clear"></div>
		</div>
        
        
        
        
        
        
        
        
            </div>
        </div>
        <!--END 生产单列表-->
    </div>
    <!--END content-->
    
</div>











<script type="text/javascript">
	function editSupplier(cId) {
		
		
		$.ajax({
			type : "post",
			url : "getSupplier.action",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : {
				supplierId : cId
			},
			success : function(supplier) {
				if(supplier.name != null){
					
					$("#nameE").val(supplier.name);
					
					
					
					$("#saveButtton").val(supplier.id);
					/* win1($("#saveButtton").val()); */
					if(supplier.contact != null)
					$("#contactE").val(supplier.contact);
					else 
						$("#contactE").val("");
					
					if(supplier.tele != null)
					$("#teleE").val(supplier.tele);
					else 
						$("#teleE").val("");
					
					if(supplier.email != null)
					$("#emailE").val(supplier.email);
					else 
						$("#emailE").val("");
					
					if(supplier.address != null)
					$("#addressE").val(supplier.address);
					else 
						$("#addressE").val("");
					
					
					
				}
	 			layer.open({
					 type : 1,
					 skin : 'layui-layer-rim', //加上边框
					 area : [ '998px', '480	px' ], //宽高
					 title : false,
					 closeBtn : 1,
					 shadeClose : true,
					 content : $(supplier_edit_form)
					 });  
			},
			error : function() {
				win1("失败");
			}
		});
		
	}
</script>


<script type="text/javascript">
	function saveSupplier() {
		
		var supplier={ "id":$("#saveButtton").val(),
			"name":$("#nameE").val(),
			"contact":$("#contactE").val(),
			"tele":$("#teleE").val(),
			"email":$("#emailE").val(),
			"address":$("#addressE").val(),
			"state":0
			}
		
		
		
		
		$.ajax({
			type : "post",
			url : "saveSupplier.action",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : supplier,
			success : function(data) {
				location.reload();
				win1("保存成功");
			},
			error : function() {
				win1("保存失败");
			}
		});
		
	}
</script>


<script type="text/javascript">
	function deleteSupplier(supplierId) {

		layer.msg('确定删除吗？', {
		  time: 0 //不自动关闭
		  ,btn: ['确定', '取消']
		  ,yes: function(index){
		    layer.close(index);

			$.ajax({
				type : "post",
				url : "deleteSupplierById.action",
				contentType : "application/x-www-form-urlencoded;charset=utf-8",
				data : {
					"supplierId" : supplierId,
				},
				success : function(data) {
					location.reload();
					win1("删除成功");
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


	function insertForm(){
		
		layer.open({
			 type : 1,
			 skin : 'layui-layer-rim', //加上边框
			 area : [ '998px', '480	px' ], //宽高
			 title : false,
			 closeBtn : 1,
			 shadeClose : true,
			 content : $(supplier_insert_form)
			 });  
		
		
		
	}

</script>

<script type="text/javascript">
	function insertSupplier() {
		
		
		layer.msg('确定吗？', {
			  time: 0 //不自动关闭
			  ,btn: ['确定', '取消']
			  ,yes: function(index){
			    layer.close(index);

				var supplier={ 
						"name":$("#nameI").val(),
						"contact":$("#contactI").val(),
						"tele":$("#teleI").val(),
						"email":$("#emailI").val(),
						"address":$("#addressI").val(),
						"state":0
						}
					
					
					
					
					$.ajax({
						type : "post",
						url : "insertSupplier.action",
						contentType : "application/x-www-form-urlencoded;charset=utf-8",
						data : supplier,
						success : function(data) {
							location.reload();
							win1("保存成功");
						},
						error : function() {
							win1("保存失败");
						}
					});
			    
			    
			  }
			});
		
		

		
		
		
		
	}
</script>

</body>
</html>