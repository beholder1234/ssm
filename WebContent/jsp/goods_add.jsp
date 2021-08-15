<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>电梯信息管理系统</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/flatpickr.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<meta http-equiv="Cache-Control" content="no-cache">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/stylepart.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="css/flatpickr.min.css" rel="stylesheet" type="text/css" />


<!--弹窗插件  -->
<script type="text/javascript" src="js/popup.js"></script>
<link href="css/popup.css" rel="stylesheet" type="text/css" />


</head>
<body>

    <!--content-->
    <div class="content">
        <!--个人信息-->
        <div class="profile">
            <div class="box">
                <div class="box_t">
                    <h3>新商品</h3>
                </div>
                <div class="box_c">
                    <form action="insertGoods.action" method="post">
                       <fieldset>
            	
            	
                <div class="box_c_item">
                	<div class="fl">
                    	<label class="l_title">供应商：</label>
                    	<input class="text_input w150" type="text" placeholder="请输入原材料名称" id="supplierName"  name="supplierName" >
                    </div>
                    					<div class="clear"></div>
				</div> 
				<div class="box_c_item">
                	<div class="fl">
                    	<label class="l_title">名称：</label>
                    	<input class="text_input w150" type="text" placeholder="请输入原材料名称" id="goodsName"  name="name" >
                    </div> 
                   					<div class="clear"></div>
				</div> 
				<div class="box_c_item">
                    <div class="fl">                
                    	<label class="l_title">型号：</label>
                   	 	<input class="text_input w150" type="text" placeholder="请输入原材料名称" id="goodsModel" name="model">
                   	</div>                    
                 					<div class="clear"></div>
				</div>
				<div class="box_c_item">
                   	<div class="fl">   	
                    	<label class="l_title">规格：</label>
                    	<input class="text_input w150" id="goodsSpecs" name="specs" type="text" placeholder="请输入原材料名称">
                    </div>  
                                     					<div class="clear"></div>
				</div> 
                <div class="box_c_item">
	
                    <div class="fl">
                        <label class="l_title">类型：</label>
                        <select class="w150" id="goodstype" name="goodstype">
                          <option selected disabled style="display:none"  value="">请选择...</option>
                          <c:forEach items="${goodstypes}" var="goodstype">
                          	<option  value="${goodstype.id }" >${goodstype.name }</option>
                          </c:forEach>
                   		 </select>
                    </div>                   
                    <div class="clear"></div>
                </div>
                <div class="box_c_item">
                    <div class="fl">
                        <label class="l_title">单位：</label>
                        <input class="text_input w150" type="text" id="goodsUnit" name="unit" placeholder="请输入原材料单价" >
                    </div>                             

                    <div class="clear"></div>
                </div>
                <div class="box_c_item">
                    <label class="l_title"></label>
                    <button class="btn btn_commit" type="submit" id="addGoods" >保存</button>
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

	var datas = getData();
	 $( "#supplierName" ).autocomplete({
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


</html>