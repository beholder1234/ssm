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




<%-- 	<form id="check"
		action="${pageContext.request.contextPath }/customerList2.action"
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
                    <h3 >客户列表</h3>
                    <form class="search_box fr" id="check" action="${pageContext.request.contextPath }/customerList2.action" method="post">
						<input name="target" class="fl" type="text" placeholder="请输入单位名称" />
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
                                <th>序号</th>
                                <th>单位名称</th>
                                <th>联系人</th>
                                <th>电话</th>
                                <th>邮箱地址</th>
                                <th>地址</th>
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
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                    <div class="clear"></div>
                    <!-- 页码框选项，与页面跳转实现 -->
					<itcast:page url="${pageContext.request.contextPath }/customerList2.action" />
                </div>
            </div>
        <!--END 新增部门-->
        
        
        
     
        
        
        
            </div>
        </div>
        <!--END 生产单列表-->
    </div>
    <!--END content-->
    
</div>











</body>
</html>