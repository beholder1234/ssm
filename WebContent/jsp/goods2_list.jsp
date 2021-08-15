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
		action="${pageContext.request.contextPath }/goodsList2.action"
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
            
            
            
            
                <div class="box_t">
                    <h3>商品-查询信息</h3>
                </div>
                <div class="box_c">
                    <form action="${pageContext.request.contextPath }/goodsList2.action" method="post">
                        <fieldset>
                            <div class="box_c_item">
                                    <label class="l_title">商品类型：</label>
                                    <!-- <input class="text_input w200 fl" type="text"  name="goodsTypeS" placeholder="请输入公司名称">  -->
                                    <select class="text_input w200 fl" name="goodsTypeS" >
                         				 <option selected disabled style="display:none"  >请选择...</option>
                          				<c:forEach items="${goodstypes }" var="gtype">
                          					<option>${gtype.name }</option>
                         			 	</c:forEach>
                    				</select>
                                    
                                    
                                    
                                    <label class="l_title">供应商：</label>
                                    <input class="text_input w200 fl" type="text" name="supplierS" id="supplierS" placeholder="请输入收货单位" >  

															


                                    
                                    <label class="l_title">商品名称：</label>
                                    <input class="text_input w200 f1" type="text" name="goodsNameS" placeholder="请输入公司名称"> 
                            </div>
                       
                            <div class="fr">
                        		<button class="btn btn_commit" type="sumbit" >确认提交</button> 
                   			</div>
                        </fieldset>
                    </form>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
                
                
                
                
                
                
                
                </div>
                
                 <!--新增部门-->

                        <div class="box">
                <div class="box_t box_t_bottom">
                    <h3>商品-商品信息</h3>
                </div>
                <div class="box_c box_c_reset">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>型号</th>
                                <th>名称</th>
                                <th>规格(/载重，速度)</th>
                                <th>供应商</th>
                                <th class="text-right">商品类型</th>
                                <!-- <th class="text-right">预警数量</th> -->
                                <!-- <th class="text-right">操作</th> -->
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
							<c:forEach items="${page.rows}" var="goods">	
                            <tr>
                                <td><%=++num%></td>
                                <td>${goods.model }</td>
                                <td>${goods.name }</td>
                                <td>${goods.specs }</td>
                                <td>${goods.supplier }</td>
                                <td class="text-right">${goods['goodstype'].name }</td>
                                <%-- <td class="text-right">${goods.alertnum }</td> --%>
                                <%-- <td class="text-right">
									<a id="emp_detail_button" onclick="getEmpDetail(${emp.id})"  href="#">查看库存(UnDone)</a> 
								</td> --%>
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                    <div class="clear"></div>
                    <div class="clear"></div>
						<!-- 页码框选项，与页面跳转实现 -->
						<itcast:page url="${pageContext.request.contextPath }/goodsList2.action" />
					
                </div>
                
                

                

                
                
                
                
            </div>

        <!--END 新增部门-->
            
        </div>
        <!--END 生产单列表-->
    </div>
    <!--END content-->
    
</div>

</body>







</html>