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




    <!--content-->
    <div class="content">
        <!--修改密码-->
        <div class="change_pwd">
            <div class="box">
                <div class="box_t">
                    <h3>密码修改 </h3>
                </div>
                <div class="box_c">
                    <form action="changePwd.action" method="post">
                        <fieldset>
                            <div class="box_c_item">
                                <label class="l_title">原密码：</label>
                                <input class="text_input w300" type="password" name="originPwd" placeholder="请输入原密码">
                                <div class="clear"></div>
                            </div>
                            <div class="box_c_item">
                                <label class="l_title">新密码：</label>
                                <input class="text_input w300" type="password" name="newPwd" placeholder="请输入新密码">
                                <div class="clear"></div>
                            </div>
                            <div class="box_c_item">
                                <label class="l_title">新密码确认：</label>
                                <input class="text_input w300" type="password" name="newPwd2" placeholder="请再次输入新密码">
                                <div class="clear"></div>
                            </div>
                            <div class="box_c_item">
                                <label class="l_title"></label>
                                <button class="btn btn_commit" type="submit">确认</button>
                               <div class="clear"></div>
                        </div>
                        </fieldset>
                    </form>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <!--END 修改密码-->
    </div>
    <!--END content-->

</body>

   <c:if test="${PwdChangeResponse eq  false}">
   
   <script type="text/javascript">
   win1("原/新密码错误,修改失败...");
   </script>
  		
   
   </c:if>
   <c:if test="${PwdChangeResponse eq  true}">
   
   <script type="text/javascript">
   
  
$(function(){
		$.ajax({
			type:"post",
			dataType:"json",
			url:"logout.action",
			cache:false,
			async:false,

		});
   			 window.parent.location.href ="login.jsp"; 
   			 win1("修改成功...");
});
   
   </script>
   
  		
   
   </c:if>  


                
</html>