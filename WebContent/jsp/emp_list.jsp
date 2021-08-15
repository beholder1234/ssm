<%@page import="lj.elevator.erp.pojo.Emp"%>
<%@page import="lj.elevator.erp.utils.Page"%>
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
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	
	
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
		action="${pageContext.request.contextPath }/empList.action"
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
					<h3>职员列表</h3>
					<form class="search_box fr" id="check" action="${pageContext.request.contextPath }/empList.action" method="post">
						<input name="target" class="fl" type="text" placeholder="请输入姓名/职位/部门名称" />
						<button class="fl" type="submit">
							<i class="icon">&#xe617;</i>
						</button>
					</form>
				</div>
				<!--新增部门-->

				<div class="box">

					<div class="box_c box_c_reset">
						<table class="table">
							<thead>
								<tr>
								<tr>
									<th>序号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>联系电话</th>
									<th>所属部门</th>
									<th>职位</th>
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

								<c:forEach items="${page.rows}" var="emp">
									<tr>
										<td><%=++num%></td>
										<td>${emp.name }</td>
										<td><c:if test="${emp.gender eq '0' }">
                                			男
                                		</c:if> <c:if test="${emp.gender eq '1' }">
                                			女
                                		</c:if></td>
										<td>${emp.tele }</td>
										<td>${emp['dep'].name}</td>
										<td>${emp['role'].name}</td>
										<td class="text-right">
										    <a id="emp_detail_button" onclick="getEmpDetail(${emp.id})"  href="#">详情</a> |
										    <a href="#" onclick="editEmp(${emp.id})">编辑</a> | 
											<a href="#" onclick="deleteEmp(${emp.id})">删除</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="clear"></div>
						<!-- 页码框选项，与页面跳转实现 -->
						<itcast:page url="${pageContext.request.contextPath }/empList.action" />
					</div>
				</div>
				<!--END 新增部门-->


		<div class="box_c hide" id="emp_detail_form">
			<fieldset>
				<div class="box_c_item">
					<label class="l_title">姓名：</label> <span class="l_con" id="nameD"></span>
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">性别：</label> <span class="l_con" id="genderD">
					</span>
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">手机号码：</label> <span class="l_con" id="teleD"></span>
					<div class="clear" />
				</div>
				
				<div class="box_c_item">
					<label class="l_title">邮箱：</label> <span class="l_con" id="emailD"></span>
					<div class="clear" />
				</div>
				
				<div class="box_c_item">
					<label class="l_title">出生日期：</label> <span class="l_con" id="birthdayD"></span>
					<div class="clear" />
				</div>
				
				<div class="box_c_item">
					<label class="l_title">所属部门：</label> <span class="l_con" id="depNameD" ></span>
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">职位：</label> <span class="l_con" id="roleNameD" ></span>
					<div class="clear" />
				</div>

				<div class="box_c_item">
					<label class="l_title">系统账号名：</label> <span class="l_con" id="userNameD" ></span>
					<div class="clear" />
				</div>


			</fieldset>
			<div class="clear"></div>
		</div>


<div class="box_c hide" id="emp_edit_form">
			<fieldset>
				<div class="box_c_item">
					<label class="l_title">姓名：</label> <span class="l_con" id="nameE"></span>
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title">性别：</label> <span class="l_con" id="genderE">
					</span>
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
					<label class="l_title">出生日期：</label> 
					<span class="l_con" id="birthdayE"></span>
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">所属部门：</label> 
					<select class="w150" id="depNameE" onChange="setRole()">
                          <option selected disabled style="display:none"  >请选择...</option>
                          <c:forEach items="${deps }" var="dep">
                          	<option  name="${dep.roles[0].name }" >${dep.name }</option>
                          </c:forEach>
                    </select>
					
					
					
					
					
					<!-- <input class="text_input w150" type="text" name="product_spec" id="depNameE" > -->
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">职位：</label> 
					<select class="w150" id="roleNameE" onChange="setDep()">
                          <option selected disabled style="display:none"  >请选择...</option>
                          <c:forEach items="${roles }" var="role">
                          	<option  name="${role['dep'].name }" >${role.name }</option>
                          </c:forEach>
                    </select>
					
					
					
					<!-- <input class="text_input w150" type="text" name="product_spec" id="roleNameE" > -->
					<div class="clear"></div>
				</div>

				<div class="box_c_item">
					<label class="l_title">系统账号名：</label> <span class="l_con" id="userNameE" ></span>
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
                    <label class="l_title"></label>
                    <button class="btn btn_commit" type="button"  id="saveButtton" onclick="saveEmp()">保存</button>
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

</body>


	
		
<script type="text/javascript">
	function getEmpDetail(eId) {
	
		$.ajax({
			type : "post",
			url : "getEmpDetail.action",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : {
				empId : eId
			},
			success : function(emp) {
				if(emp != null){
					if(emp.name != null)
					$("#nameD").text(emp.name);
					
					if(emp.gender != null && emp.gender == 0)
						$("#genderD").text("男");
					else if(emp.gender == 1)
						$("#genderD").text("女");
					if(emp.tele != null)
					$("#teleD").text(emp.tele);
					if(emp.tele == null)
						$("#teleD").text("");
					
					if(emp.email != null)
					$("#emailD").text(emp.email);
					else if(emp.email == null)
						$("#emailD").text("");
					/* alert("12313131313"); */
					if(emp.birthday != null)
					$("#birthdayD").text(formatDate(new Date(emp.birthday)));
					if(emp['dep'].name != null)
					$("#depNameD").text(emp['dep'].name);
					else if(emp['dep'].name == null)
						$("#depNameD").text("");
						
					
					
					if(emp['role'].name != null)
					$("#roleNameD").text(emp['role'].name);
					else if(emp['role'].name == null)
						$("#roleNameD").text("");
					if(emp.username != null)
					$("#userNameD").text(emp.username);
					
				}
	 			layer.open({
					 type : 1,
					 skin : 'layui-layer-rim', //加上边框
					 area : [ '998px', '480	px' ], //宽高
					 title : false,
					 closeBtn : 1,
					 shadeClose : true,
					 content : $(emp_detail_form)
					 });  
			},
			error : function() {
				win1("失败");
			}
		});

		
	}
</script>


<script type="text/javascript">
	function editEmp(eId) {
		
		$.ajax({
			type : "post",
			url : "getEmpDetail.action",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : {
				empId : eId
			},
			success : function(emp) {
				if(emp.name != null){
					$("#nameE").text(emp.name);
					
					
					$("#saveButtton").val(emp.id);
					if(emp.gender != null && emp.gender == 0)
						$("#genderE").text("男");
					else if(emp.gender == 1)
						$("#genderE").text("女");
					if(emp.tele != null)
					$("#teleE").val(emp.tele);
					else if(emp.tele == null)
						$("#teleE").val("");
					
					if(emp.email != null)
					$("#emailE").val(emp.email);
					else if(emp.email == null)
						$("#emailE").val("");
					if(emp.birthday != null)
					$("#birthdayE").text(formatDate(new Date(emp.birthday)));
					
					
					if(emp['dep'].name != null)
					$("#depNameE").val(emp['dep'].name);
					//目的让select标签显示 默认标签
					else if(emp['dep'].name == null)
						$("#depNameE").val("请选择...");
					
					if(emp['role'].name != null)
					$("#roleNameE").val(emp['role'].name);
					else if(emp['role'].name == null)
						$("#roleNameE").val("请选择...");
					
					if(emp.username != null)
					$("#userNameE").text(emp.username);
					
				}
	 			layer.open({
					 type : 1,
					 skin : 'layui-layer-rim', //加上边框
					 area : [ '998px', '480	px' ], //宽高
					 title : false,
					 closeBtn : 1,
					 shadeClose : true,
					 content : $(emp_edit_form)
					 });  
			},
			error : function() {
				win1("失败");
			}
		});
		
	}
</script>

<script type="text/javascript">
	function saveEmp() {
		
		var empId = $("#saveButtton").val();	
		var tele = $("#teleE").val();
		var email = $("#emailE").val();
		var depName = $("#depNameE").val();
		var roleName = $("#roleNameE").val();
		
		
		
		
		
		
		$.ajax({
			type : "post",
			url : "saveEmp.action",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : {
				"empId" : empId,
				"tele":tele,
				"email":email,
				"depName":depName,
				"roleName":roleName
				
			},
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
	function deleteEmp(empId) {
		
		
		

		//信息框-例2

		layer.msg('确定删除吗？', {
		  time: 0 //不自动关闭
		  ,btn: ['确定', '取消']
		  ,yes: function(index){
		    layer.close(index);

		    
		    $.ajax({
				type : "post",
				url : "deleteEmpById.action",
				contentType : "application/x-www-form-urlencoded;charset=utf-8",
				data : {
					"empId" : empId,
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
	function setRole() {
		
		
		var roleNameE = $("#depNameE").find("option:selected").attr("name");	
		/* win1("确定吗？"+roleNameE); */
		$("#roleNameE").val(roleNameE);
	}
</script>


<script type="text/javascript">
	function setDep() {
		
		
		var depNameE = $("#roleNameE").find("option:selected").attr("name");	
		/* win1("确定吗？"+roleNameE); */
		$("#depNameE").val(depNameE);
	}
</script>


<script type="text/javascript">


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