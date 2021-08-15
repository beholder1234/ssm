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
</head>
<body>
<!-- main -->











        <!--content-->
    <div class="content">
        <!--生产单列表-->
        <div class="manufacture_list">
            <div class="box">
                <div class="box_t box_t_bottom">
                    <h3 >客户列表</h3>
                    <form class="search_box fr" id="check" action="${pageContext.request.contextPath }/customerList.action" method="post">
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
							<c:forEach items="${page.rows}" var="customer">	
                            <tr>
                                <td><%=++num%></td>
                                <td>${customer.name }</td>
                                <td>${customer.contact }</td>
                                <td>${customer.tele }</td>
                                <td>${customer.email }</td>
                                <td>${customer.address}</td>
                                <td class="text-right"><a href="#" onclick="editCustomer(${customer.id})">编辑</a> | <a href="#" onclick="deleteCustomer(${customer.id})">删除</a></td>
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                    <div class="clear"></div>
                    <!-- 页码框选项，与页面跳转实现 -->
					<itcast:page url="${pageContext.request.contextPath }/customerList.action" />
                </div>
            </div>
        <!--END 新增部门-->
        
        
        

<div class="box_c hide" id="customer_edit_form">
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
                    <button class="btn btn_commit" type="button"  id="saveButton" onclick="saveCustomer()">保存</button>
                    <div class="clear"></div>
                </div>

			</fieldset>
			<div class="clear"></div>
		</div>


<div class="box_c hide" id="customer_insert_form">
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
                    <button class="btn btn_commit" type="button"  onclick="insertCustomer()" id="insertButton">保存</button>
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
	function editCustomer(cId) {
		
		
		$.ajax({
			type : "post",
			url : "getCustomer.action",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : {
				customerId : cId
			},
			success : function(customer) {
				if(customer.name != null){
					
					$("#nameE").val(customer.name);
					
					
					
					$("#saveButton").val(customer.id);
					/* win1($("#saveButton").val()); */
					if(customer.contact != null)
					$("#contactE").val(customer.contact);
					else 
						$("#contactE").val("");
					
					if(customer.tele != null)
					$("#teleE").val(customer.tele);
					else 
						$("#teleE").val("");
					
					if(customer.email != null)
					$("#emailE").val(customer.email);
					else 
						$("#emailE").val("");
					
					if(customer.address != null)
					$("#addressE").val(customer.address);
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
					 content : $(customer_edit_form)
					 });  
			},
			error : function() {
				win1("失败");
			}
		});
		
	}
</script>


<script type="text/javascript">
	function saveCustomer() {
		
		var customer={ "id":$("#saveButton").val(),
			"name":$("#nameE").val(),
			"contact":$("#contactE").val(),
			"tele":$("#teleE").val(),
			"email":$("#emailE").val(),
			"address":$("#addressE").val(),
			"state":0
			}
		
		
		
		
		$.ajax({
			type : "post",
			url : "saveCustomer.action",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : customer,
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
	function deleteCustomer(customerId) {
		
		
		layer.msg('确定删除吗？', {
			  time: 0 //不自动关闭
			  ,btn: ['确定', '取消']
			  ,yes: function(index){
			    layer.close(index);


				$.ajax({
					type : "post",
					url : "deleteCustomerById.action",
					contentType : "application/x-www-form-urlencoded;charset=utf-8",
					data : {
						"customerId" : customerId,
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
			 content : $(customer_insert_form)
			 });  
		
		
		
	}

</script>

<script type="text/javascript">
	function insertCustomer() {
		/* win1("确定吗？"); */
		
		
		
		//信息框-例2

		layer.msg('确定吗？', {
		  time: 0 //不自动关闭
		  ,btn: ['确定', '取消']
		  ,yes: function(index){
		    layer.close(index);

		    var customer={ 
					"name":$("#nameI").val(),
					"contact":$("#contactI").val(),
					"tele":$("#teleI").val(),
					"email":$("#emailI").val(),
					"address":$("#addressI").val(),
					"state":0
					}
				
				
				
				
				$.ajax({
					type : "post",
					url : "insertCustomer.action",
					contentType : "application/x-www-form-urlencoded;charset=utf-8",
					data : customer,
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