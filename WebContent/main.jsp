<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
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
<script type="text/javascript" src="js/flatpickr.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<meta http-equiv="Cache-Control" content="no-cache">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/stylepart.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="css/flatpickr.min.css" rel="stylesheet" type="text/css" />

</head>

<body>











<!--侧栏-->
<div class="aside">
    <div class="aside_wrapper">
        <!-- Logo (200px wide) -->
        <a href="#" ><img class="logo" id="myLogo" src="images/logo.png" alt="电梯信息管理系统" /></a>

        <ul class="main_nav">  <!-- main Menu -->
            
            
            <c:forEach items="${roleMenus }" var="roleMenuF">
            	<li class="">
            	<c:if test="${roleMenuF.menu['pid'] eq '-1' }">
            		
            		<a href="#" onClick="fun('${roleMenuF.menu.url}')" class="nav_top_item ">${roleMenuF.menu['menuname']}</a>
            	</c:if>
            	
            	<ul class="sub_menu hide">
            		<c:forEach items="${roleMenus}" var="roleMenuS">
            			<c:if test="${roleMenuF.menuid eq roleMenuS.menu['pid']}">
            				<li><a href="#" onClick="fun('${roleMenuS.menu.url}')">${ roleMenuS.menu['menuname']}</a></li>
            			</c:if>
            		
            		</c:forEach>
            	</ul>
            	</li>
            </c:forEach>
            

    </div>
</div>
<!--END 侧栏-->
<!-- main -->
<div class="main">
    <!--顶部top_bar-->
    <div class="top_bar">
        <div class="top_bar_inner fr">
            <div class="logout">
                <a href="${pageContext.request.contextPath }/logout.action" title="退出">
                    <i class="icon">&#xe60c;</i>
                    退出
                </a>
            </div>
            <div class="welcome">
                <span class="fr">${oneRole['role'].name} &nbsp ${oneRole.name}</span>
                <img class="fr" src="images/avatar.jpg" alt="隔壁老王" />
                <div class="clear"></div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <!--END 顶部top_bar-->


    <!--content-->
	
	
	<iframe scrolling="yes" frameborder="0" src="${pageContext.request.contextPath }/index.action" id="external-frame"  width=100% height="680px">
		
	
	</iframe>
	
	
    <!--END content-->
</div>
<!-- END main -->

<script type="text/javascript">

$(function(){
	$("#myLogo").bind("click",function(){
		
		$("#external-frame").attr("src","index.action");
		
	})
});


</script>



<script type="text/javascript">

function fun(url){
	if(url != "#"){
		
	$.cookie('which', url);
	$("#external-frame").attr("src",url);
	//$("#external-frame").attr("src","jsp/supplier_list.jsp");
	//setIframeHeight(document.getElementById('external-frame'));
	}
}



</script>




<script type="text/javascript">
$(function(){
	
	$("ul li a").bind("click",function(){	
	
	    $(this).parent().parent().find("ul").slideUp(); 
		$(this).parent().children("ul").slideDown();
		$(this).addClass("hover");

	})
	
});

</script>
<script type="text/javascript">
$(function(){
	
$("ul li a").bind("click",function(){

	$(this).parent().parent().find("a").removeClass("hover"); 
	$(this).parent().parent().find("a").removeClass("current"); 
	$(this).addClass("hover");
	$(this).addClass("current");
	
	
	
})
});

</script>

<script>
	
	function setIframeHeight(iframe) {
	if (iframe) {
	var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
	if (iframeWin.document.body) {
	iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
	}
	}
	};
	

	
</script>


<script type="text/javascript">



var value = $.cookie('acUrl');
if(value != ""){
	
	$("a[href='"+value+"']").addClass("hover");
	$("a[href='"+value+"']").addClass("current");
	$("a[href='"+value+"']").parent().parent().slideDown();
	$("a[href='"+value+"']").parent().parent().parent().children("a").addClass("hover");
	
	
}

 $.removeCookie('acUrl'); 



</script>



</body>

</html>