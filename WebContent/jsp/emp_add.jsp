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
<!-- <script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<meta http-equiv="Cache-Control" content="no-cache">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/stylepart.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/flatpickr.js"></script> -->


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




	    <!--content-->
    <div class="content">
        <!--个人信息-->
        <div class="profile">
            <div class="box">
                <div class="box_t">
                    <h3>个人信息</h3>
                </div>
                <div class="box_c">
                    <form action="${pageContext.request.contextPath }/insertEmp.action" id="empForm" method="post">
                       	<fieldset>
				<div class="box_c_item">
					<label class="l_title">姓名：</label> 
					<input class="text_input w150" type="text" name="name" id="name" required>
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title">性别：</label> 
					<select class="w150" id="gender" name="gender" required>
                          	<option selected disabled style="display:none"  value="">请选择...</option>
                          	<option    value="0">男</option>
                          	<option    value="1">女</option>
                    </select>
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title">手机号码：</label> 
					<input class="text_input w150" type="text" name="tele" id="tele" required>
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">邮箱：</label> 
					<input class="text_input w150" type="text" name="email" id="email" 	email>
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">出生日期：</label> 
					<input class="calendar  text_input w150 fl" type="text" name="birthday" id="birthday" value="2000-1-1"	date required>
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">地址：</label> 
					<input class="  text_input w150 " type="text" name="address" id="address" required>
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">所属部门：</label> 
					<select class="w150" id="depNameE" name="depName" onChange="setRole()" required>
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
					<select class="w150" id="roleNameE" name="roleName" onChange="setDep()" required>
                          <option selected disabled style="display:none"  >请选择...</option>
                          <c:forEach items="${roles }" var="role">
                          	<option  name="${role['dep'].name }" >${role.name }</option>
                          </c:forEach>
                    </select>
					
					<!-- <input class="text_input w150" type="text" name="product_spec" id="roleNameE" > -->
					<div class="clear"></div>
				</div>

				<div class="box_c_item">
					<label class="l_title">系统账号名：<br><font color="red">(初始密码：123456)</font></label> 
					<input class="text_input w150" type="text" name="username" id="username" onChange="checkRepeat()" required>
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
                    <label class="l_title"></label>
                    <button class="btn btn_commit" type="submit"  id="saveButtton">保存</button>
                    <div class="clear"></div>
                </div>

			</fieldset>
                    </form>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <!--END 个人信息-->
    </div>
    <!--END content-->

</body>

<script type="text/javascript">
	function setRole() {
		
		
		var roleNameE = $("#depNameE").find("option:selected").attr("name");	
		 /* win1("确定吗？？"+roleNameE);  */
		$("#roleNameE").val(roleNameE);
		/* $("#roleNameE").val($("#"+roleNameE).text()); */
		/* win1($("#roleNameE").text()); */
		/* win1($("#roleNameE").val());  */
	}
</script>


<script type="text/javascript">
	function setDep() {
		
		
		var depNameE = $("#roleNameE").find("option:selected").attr("name");	
		/*  win1("确定吗？"+roleNameE); */ 
		$("#depNameE").val(depNameE);
	}
</script>


<script type="text/javascript">




function checkRepeat(){
	
	
	var username = $("#username").val();
	$.ajax({
		type : "post",
		url : "getUsername.action",
		cache : false,
 		async:false,
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		success : function(data) {
			
			for(var i=0;i<data.length;i++){
				if(data[i] == username){
					win1("账号已存在...");
					$("#username").val("");
					return ;
				}
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
</html>