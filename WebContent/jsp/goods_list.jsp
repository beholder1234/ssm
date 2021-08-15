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
		action="${pageContext.request.contextPath }/goodsList.action"
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
                    <form action="${pageContext.request.contextPath }/goodsList.action" method="post">
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
                                <th>商品类型</th>
                                <!-- <th>预警数量</th> -->
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
							<c:forEach items="${page.rows}" var="goods">	
                            <tr>
                                <td><%=++num%></td>
                                <td>${goods.model }</td>
                                <td>${goods.name }</td>
                                <td>${goods.specs }</td>
                                <td>${goods.supplier }</td>
                                <td>${goods['goodstype'].name }</td>
                                <%-- <td>${goods.alertnum }</td> --%>
                                <td class="text-right">
									<%-- <a id="emp_detail_button" onclick="getEmpDetail(${emp.id})"  href="#">查看库存(UnDone)</a> | --%>
									<a href="#" onclick="editGoods(${goods.id})">编辑</a> | 
									<a href="#" onclick="deleteGoods(${goods.id})">删除</a>
								</td>
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                    <div class="clear"></div>
                    <div class="clear"></div>
						<!-- 页码框选项，与页面跳转实现 -->
						<itcast:page url="${pageContext.request.contextPath }/goodsList.action" />
					
                </div>
                
                

                
                
<div class="box_c hide" id="goods_edit_form">
	 <form action="${pageContext.request.contextPath }/saveGoods.action" method="post">
			<fieldset>
			
				<input class="text_input w150" type="hidden" name="id"  id="id"  >
			
				<div class="box_c_item">
					<label class="l_title">型号：</label> 
					<input class="text_input w150" type="text" name="model" id="modelE" >
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title">名称：</label>
					<input class="text_input w150" type="text" name="name" id="nameE" >
					<div class="clear"></div>
				</div>
				<div class="box_c_item">
					<label class="l_title">规格(/载重，速度)：</label> 
					<input class="text_input w150" type="text" name="specs" id="specsE" >
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">供应商：</label> 
					<input class="text_input w150" type="text" name="supplier" id="supplierE" >
					<div class="clear"></div>
				</div>
				
				<div class="box_c_item">
					<label class="l_title">商品类型：</label> 
					<select class=" w150" id="goodstypeE" name= goodstype.name>
                         	<option selected disabled style="display:none"  >请选择...</option>
                          	<c:forEach items="${goodstypes }" var="gtype">
                          			<option>${gtype.name }</option>
                         	</c:forEach>
                    </select>
					
					<div class="clear"></div>
				</div>
				
<!-- 				<div class="box_c_item">
					<label class="l_title">预警数量：</label> 
					<input class="text_input w150" type="text" name="alertnum" id="alertnumE" >
 -->
					
					
					
				<div class="box_c_item">
                    <label class="l_title"></label>
                    <button class="btn btn_commit" type="sumbit"  id="saveButton" >保存</button>
                    <!-- onclick="saveGoods()" -->
                    <div class="clear"></div>
                </div>

			</fieldset>
			<div class="clear"></div>
			</form>
		</div>



                
                
                
                
            </div>

        <!--END 新增部门-->
            
        </div>
        <!--END 生产单列表-->
    </div>
    <!--END content-->
    
</div>

</body>


<script type="text/javascript">


	function editGoods(gId) {
		
		$.ajax({
			type : "post",
			url : "getGoods.action",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : {
				goodsId : gId
			},
			success : function(goods) {
				if(goods.name != null){
					
					$("#modelE").val(goods.model);
					$("#nameE").val(goods.name);
					
					
					$("#saveButton").val(goods.id);
					$("#id").val(goods.id);
					
					
					
					if(goods.specs != null)
					$("#specsE").val(goods.specs);
					else if(goods.specs != null)
						$("#specsE").val("");
					
					$("#supplierE").val(goods.supplier);
					$("#goodstypeE").val(goods['goodstype'].name);
					if(goods.alertnum == null)
						$("#alertnumE").val("");
					else if(goods.alertnum != null && goods.alertnum == -1)
						$("#alertnumE").val("");
					else
					$("#alertnumE").val(goods.alertnum);
					
					
				}
	 			layer.open({
					 type : 1,
					 skin : 'layui-layer-rim', //加上边框
					 area : [ '998px', '480	px' ], //宽高
					 title : false,
					 closeBtn : 1,
					 shadeClose : true,
					 content : $(goods_edit_form)
					 });  
			},
			error : function() {
				win1("失败");
			}
		});
		
	}
</script>




<script type="text/javascript"> 


 	var datas = getData();
	 $( "#supplierS" ).autocomplete({
	      source: datas
	    });

	 $( "#supplierE" ).autocomplete({
	      source: datas
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


</script>

<script type="text/javascript">

function saveGoods(){
	

	 

	 
	var goods = {
    		 "id":$("#saveButton").val(),
    		 "model":$("#modelE").val(),
    		 "name":$("#nameE").val(),
    		 "specs":$("#specsE").val(),
    		 "supplier":$("#supplierE").val(),
    		 "alertnum":$("#alertnumE").val()
     }
	
	


		$.ajax({
			type : "post",
			url : "saveGoods.action",
			raditional : true,
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : {goods:goods,goodstypename:$("#goodstypeE").val()},
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


function deleteGoods(goodsId) {
	
	
	
	
	//信息框-例2

	layer.msg('确定删除吗？', {
	  time: 0 //不自动关闭
	  ,btn: ['确定', '取消']
	  ,yes: function(index){
	    layer.close(index);

		$.ajax({
			type : "post",
			url : "deleteGoodsById.action",
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			data : {
				"goodsId" : goodsId,
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


</html>