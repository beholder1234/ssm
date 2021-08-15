<%@page import="lj.elevator.erp.pojo.Emp"%>
<%@page import="lj.elevator.erp.utils.Page"%>
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
					<h3>个人信息</h3>

				</div>

				<div class="box">

					<div class="box_c box_c_reset">
						<div class="box_c_item">
					<label class="l_title">姓名：</label> <span class="l_con" id="nameD">${oneRole.name }</span>
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">性别：</label>
					 <span class="l_con" id="genderD">
					<c:if test="${oneRole.gender eq 0 }">
					男
					</c:if>
					<c:if test="${oneRole.gender eq 1 }">
					女
					</c:if>
					
					</span>
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">手机号码：</label> <span class="l_con" id="teleD">${oneRole.tele }</span>
					<div class="clear" />
				</div>
				
				<div class="box_c_item">
					<label class="l_title">邮箱：</label> <span class="l_con" id="emailD">${oneRole.email }</span>
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">地址：</label> <span class="l_con" id="addressD">${oneRole.address }</span>
					<div class="clear" />
				</div>
				
				<div class="box_c_item">
					<label class="l_title">出生日期：</label>
					 <span class="l_con" id="birthdayD ">
					 <fmt:formatDate value="${oneRole.birthday }" pattern="yyyy-MM-dd"/>
					 </span>
					<div class="clear" />
				</div>
				
				<div class="box_c_item">
					<label class="l_title">所属部门：</label> <span class="l_con" id="depNameD" >${oneRole['dep'].name }</span>
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">职位：</label> <span class="l_con" id="roleNameD" >${oneRole['role'].name }</span>
					<div class="clear" />
				</div>

				<div class="box_c_item">
					<label class="l_title">系统账号名：</label> <span class="l_con" id="userNameD" >${oneRole.username }</span>
					<div class="clear" />
				</div>
					</div>
				</div>




			</div>
		</div>
		<!--END 生产单列表-->
	</div>
	<!--END content-->
	</div>

</body>


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