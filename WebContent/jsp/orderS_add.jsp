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
<script type="text/javascript" src="js/flatpickr.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<meta http-equiv="Cache-Control" content="no-cache">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/stylepart.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="css/flatpickr.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.cookie.js"></script>

<!--弹窗插件  -->
<script type="text/javascript" src="js/popup.js"></script>
<link href="css/popup.css" rel="stylesheet" type="text/css" />

  <style>
  .ui-autocomplete {
    max-height: 100px;
    overflow-y: auto;
    /* 防止水平滚动条 */
    overflow-x: hidden;
  }
  /* IE 6 不支持 max-height
   * 我们使用 height 代替，但是这会强制菜单总是显示为那个高度
   */
  * html .ui-autocomplete {
    height: 100px;
  }
  </style>



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
   
    --%>
   
   
   
   
   
   
    <!--content-->
    <div class="content">
        <!--采购单录入-->
        <div class="add_supplier">
            <form action="saleOrderAdd.action" method="post">
                <div class="box">
                    <div class="box_t">
                        <h3>销售单录入-供应商信息</h3>
                    </div>
                    <div class="box_c">
                        <fieldset>
                        
                        	<!-- id hidden -->
                        	<input class="text_input w150" type="hidden" name="empId"  id="empId"  >
                        	<input class="text_input w150" type="hidden" name="id"  id="customerId"  value="">
                        
                            <div class="box_c_item">
                                 <div class="fl">
                                    <label class="l_title">购方单位：</label>
                                    <input class="text_input w300" type="text" name="name" id="customerName" placeholder="请输入供应商名称" onChange="getCustomerByNameOrContact(1)" required>
                                
                                </div>
                                 <div class="fl">
                                    <label class="l_title">销方单位：</label>
                                    <span class="l_con w300">深圳市富士乐电梯有限公司</span>
                                    </div>                                

                                <div class="clear"></div>
                            </div>
                            <div class="box_c_item">
                                <div class="fl">
                                    <label class="l_title">联系人：</label>
                                    <input class="text_input w300" type="text" name="contact" id="customerContact" placeholder="请输入供应商名称" onChange="getCustomerByNameOrContact(2)" required>
                                    </div>                               
                                <div class="fl">
                                    <label class="l_title">下单人：</label>
                                    	<span class="l_con w300"> ${oneRole.name} </span>
                                
                                </div>
                                <div class="clear"></div>
                            </div>    
                            <div class="box_c_item">

                                <div class="fl">
                                    <label class="l_title">电话：</label>
                                     <input class="text_input w300" type="text" name="tele" id="customerTele" placeholder="请输入供应商名称" onChange="setCustOtherCondition()" required>
                               
                                    </div>
                                <div class="fl">
                                    <label class="l_title">电话：</label>
                                    <span class="l_con w300"> ${oneRole.tele }</span>
                               
                                    </div>
                                <div class="clear"></div>
                            </div>                                                 
                            <div class="box_c_item">
                                <div class="fl">
                                    <label class="l_title">邮箱：</label>
                                    <input class="text_input w300" type="text" name="email" id="customerEmail" placeholder="请输入供应商名称" onChange="setCustOtherCondition()" email>
                                
                                    </div>

                                <div class="fl">
                                    <label class="l_title">邮箱：</label>
                                   <span class="l_con w300" id="empEmail" > ${oneRole.email} </span>
                               
                                    </div>
                                <div class="clear"></div>
                            </div>
                            <div class="box_c_item">
                                  <div class="fl">
                                    <label class="l_title">单位地址：</label>
                                    <input class="text_input w300" type="text" name="address" id="customerAddress" placeholder="请输入供应商名称" onChange="setCustOtherCondition()" required>
                                
                                    </div>                          
                                  <div class="fl">
                                    <label class="l_title">单位地址：</label>
                                     <span class="l_con w300">深圳市</span>
                               
                                   </div>
                                <div class="clear"></div>
                            </div>

                        </fieldset>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="box">
                    <div class="box_t box_t_bottom">
                        <h3 class="fl">销售单录入-原材料信息</h3>
                        <button id="goods_add_button" class="btn btn_add fr" type="button"><i class="icon">&#xe61e;</i>&nbsp;录入</button>
                        <div class="clear"></div>
                    </div>
                    <div class="box_c box_c_reset">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>名称</th>
                                    <th>型号</th>
                                    <th>单位</th>
                                    <th>数量</th>
                                    <th>单价</th>
                                    <th>金额</th>
                                    <th class="text-right">操作</th>
                                </tr>
                            </thead>
                            <tbody id="goodsOrder">
                            
                            
                            
                            
                            </tbody>
                        </table>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="fr">
                    <label class="l_title"></label>
                    <button class="btn btn_commit" type="sumbit">确认提交</button> 
                </div>
                <div class="clear"></div>
            </form>
        </div>
        <!--END 采购单录入-->
        <!--采购单原材料信息录入表单弹窗-->
        
        
        
        
      <div class="box_c hide" id="extraMessage_form">
			<fieldset>
				<div class="box_c_item">
					<label class="l_title" align="center">电梯工号：</label> 
					 <input class="text_input w200 fl" type="text"  id="numM"   required> 
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">注册编号：</label> 
					 <input class="text_input w200 fl" type="text"  id="codeM"   required> 
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">层数：</label> 
					 <input class="text_input w200 fl" type="text"  id="layerM"   required> 
					<div class="clear" />
				</div>
				
				<div class="box_c_item">
					<label class="l_title">站数：</label> 
					 <input class="text_input w200 fl" type="text"  id="stationM"   required> 
					<div class="clear" />
				</div>
				<div class="box_c_item">
					<label class="l_title">安装地址：</label> 
					 <input class="text_input w200 fl" type="text" id="addressM"   required> 
					<div class="clear" />
				</div>
			</fieldset>
			<div class="clear"></div>
		</div>	
        
        
        
        
        
        
        
        
        
        
        
        
        
        <div class="box_c hide" id="goods_add_form">
            <fieldset>
            	
            	<input  type="hidden" name="id"  id="goodsId"  >
            	
                <div class="box_c_item">
                <div class="fl">  
					<label class="l_title">供应商：</label>
                	<select class="w150" id="supplierName" onChange="getGoodsAutocomplete()" >
                          <option selected  style="display:none"  value="">请选择...</option>
                    </select>
                  </div>  
                  <div class="clear"></div>	
                </div>
                

                    	
                
                
                <div class="box_c_item">
                    <div class="fl"> 	
 					<label class="l_title">名称：</label>
                	<select class="w150" id="goodsName"  name="goodsName" onChange="getGoodsByNameOrModel(1)" >
                          
                    </select>    
                    </div> 
                    
                     <div class="fl">              	                  	
 					<label class="l_title">型号：</label>
                	<select class="w150" id="goodsModel" name="goodsModel" onChange="getGoodsByNameOrModel(2)" >
                    </select>                   	                  	
                    	</div>
<!--                 	<div class="fl">
                    	<label class="l_title">名称：</label>
                    	<input class="text_input " type="text" placeholder="请输入原材料名称" id="goodsName"  name="goodsName" onChange="getGoodsByNameOrModel(1)" >
                    </div> 
        
                                 
                    <div class="fl">                
                    	<label class="l_title">型号：</label>
                   	 	<input class="text_input w150" type="text" placeholder="请输入原材料名称" id="goodsModel" name="goodsModel" onChange="getGoodsByNameOrModel(2)">
                   	</div>  -->                   
                 
                    <div class="clear"></div>
                </div>
  
                <div class="box_c_item">
	                   	<div class="fl">   	
                    	<label class="l_title">规格：</label>
                    	<span class="l_con w150" id="goodsSpecs"></span>
                    	<!-- <input class="text_input w150" id="goodsSpecs" type="text" placeholder="请输入原材料名称"> -->
                    </div> 
                    <div class="clear"></div>
                </div>
                <div class="box_c_item">
                    <div class="fl">
                        <label class="l_title">类型：</label>
                        <input id="goodstypeId" type="hidden">
                        <span class="l_con w150" id="goodstype" name="goodstype"></span>
                       <!--  <input class="text_input w150" type="text" id="goodstype" placeholder="请输入原材料单位" name="goodstype"> -->
                    </div>                   
                    <div class="clear"></div>
                </div>
                <div class="box_c_item"> 
                <div class="fl">
                        <label class="l_title">数量(<b id="goodsUnit" name="goodsUnit"></b>)：</label>
                        <input class="text_input w150" type="text" id="goodsNum" name="goodsNum" placeholder="请输入原材料数量" onChange="calcTotalprice()" value="0" >
                    </div>                
                    <div class="fl">
                        <label class="l_title">单价：</label>
                        <input class="text_input w150" type="text" id="goodsPrice" name="goodsPrice" placeholder="请输入原材料单价" onChange="calcTotalprice()" value="0">
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="box_c_item"> 
                
                    <div class="fl">
                        <label class="l_title">金额：</label>
                         <span class="l_con w150" id="goodsTotalprice" name="goodsTotalprice" value="0"></span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="box_c_item">
                    <label class="l_title"></label>
                    <button class="btn btn_commit" type="button" id="addGoods" onClick="addGoodsToOrder()">保存</button>
                    <div class="clear"></div>
                </div>
            </fieldset>
            <div class="clear"></div>
        </div>

        <!--END 采购单原材料信息录入表单弹窗-->
    </div>
    <!--END content-->
</div>

</body>



<script type="text/javascript">
            $("#goods_add_button").bind("click",function(){

          	
            	
            	
            	if(!checkEmpandCustomer()){
            		
            		
            		return ;
            		
            	}
            	
            	
                layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['780px', '420px'], //宽高
                    title: false,
                    closeBtn: 1,
                    shadeClose: true,
                    content: $("#goods_add_form")
                });
                
                
$("#goodsName").empty();                                            
$("#goodsModel").empty();                                            
                
    


/* <c:forEach items="${suppliers }" var="supplier">
<option  >${supplier.name }</option>
</c:forEach> */

var option1= "<option>"
var option2="</option>"



$.ajax({
		type : "POST",
		url : "getGoodsNameBySupplierId.action",
		dataType : "json",
		cache : false,
		async:false,
		success : function(datas) {
				var first= "<option selected  style='display:none'  value=''>请选择...</option>"
					 $("#goodsName").append(first);			
			/* alert(datas == null); */
			for(var i=0;i<datas.length;i++){
				 var name= datas[i]
				 
				 var hang = option1 +name +option2;
				 $("#goodsName").append(hang);
			}
		}
	});
$.ajax({
		type : "POST",
		url : "getGoodsModelNameBySupplierId.action",
		dataType : "json",
		cache : false,
		async:false,
		success : function(datas) {
				var first= "<option selected  style='display:none'  value=''>请选择...</option>"
					 $("#goodsModel").append(first);			
			/* alert(datas == null); */
			for(var i=0;i<datas.length;i++){
				 var name= datas[i]
				 
				 var hang = option1 +name +option2;
				 $("#goodsModel").append(hang);
			}
		}
	});





                
                
                
            });
        </script>

<script type="text/javascript">



function checkEmpandCustomer(){
	
	


	if($("#customerId").val() == null || $("#customerId").val() == ""){
		
		if($("#customerName").val() == null || $("#customerName").val() == ""){
			
			win1("请填写售方单位...");
			return false;
			
		}
		if($("#customerContact").val() == null || $("#customerContact").val() == ""){
			
			win1("请填写联系人...");
			return false;
			
		}
		if($("#customerTele").val() == null || $("#customerTele").val() == ""){
			
			win1("请填写联系电话...");
			return false;
			
		}
		if($("#customerAddress").val() == null || $("#customerAddress").val() == ""){
			
			win1("请填写单位地址...");
			return false;
			
		}
		if(insertAlert()){
			return true;
		}
		else{return false;}
		
		
	}	
	
	return true;
	
}


</script>



<script type="text/javascript">

	var datas = getcustNames();
	 $( "#customerName" ).autocomplete({
	      source: datas
	    });

		var empNames = getEmpNames();
		 $( "#empName" ).autocomplete({
		      source: empNames
		    });

		 function getcustNames(){
			 	var result;
			 	$.ajax({
			 		type : "POST",
			 		url : "getCustomerName.action",
			 		dataType : "json",
			 		cache : false,
			 		async:false,
			 		success : function(datas) {
			 			/* alert(datas == null); */
			 			result = [datas.length];
			 			for(var i=0;i<datas.length;i++){
			 				result[i] = datas[i];
			 			}
			 			}
			 		});
			 	return result;
			 }
 
 
function getEmpNames(){
 	var result;
 	$.ajax({
 		type : "POST",
 		url : "getEmpName.action",
 		dataType : "json",
 		cache : false,
 		async:false,
 		success : function(datas) {
 			/* win1(datas == null); */
 			result = [datas.length];
 			for(var i=0;i<datas.length;i++){
 				result[i] = datas[i];
 			}
 			}
 		});
 	return result;
 } 

/* <c:forEach items="${suppliers }" var="supplier">
<option  name="${supplier.id }" >${supplier.name }</option>
</c:forEach> */

var option1= "<option  name= '"
var option2="'>"
var option3="</option>"



$.ajax({
		type : "POST",
		url : "getAllSupplier.action",
		dataType : "json",
		cache : false,
		async:false,
		success : function(suppliers) {
			
			/* alert(datas == null); */
			for(var i=0;i<suppliers.length;i++){
				 var name= suppliers[i].name;
				 var id= suppliers[i].id;
				 
				 var hang = option1 + id +option2 +name +option3;
				 $("#supplierName").append(hang);
			}
		}
	});














</script>

<script type="text/javascript">




function insertAlert(){
	var r=confirm("系统未备案该客户，是否新增该客户？？？");
	if (r==true){
		/* var x="你按下了\"确定\"按钮!"; */
		
		

		
var	customer = {


  name:	$("#customerName").val(),
contact:	$("#customerContact").val(),
  tele:	$("#customerTele").val(),
 email:	$("#customerEmail").val(),
address:	$("#customerAddress").val(),
state:0


}	
		
	 	$.ajax({
	 		type : "POST",
	 		url : "insertCustomerByOrderAdd.action",
	 		dataType : "json",
	 		cache : false,
	 		async:false,
	 		data:customer,
	 		success : function(customer) {
	 			/* win1(datas == null); */
	 			win1("已保存新客户");
	 			$("#customerId").val(customer.id);
	 			}
	 		});
	            				
		
		return true;
		
		
	}
	else{
		/* var x="你按下了\"取消\"按钮!"; */
		
		return false;
	}
}






</script>

<script type="text/javascript">
function getCustomerByNameOrContact(who){
	
	if(who == 1){
		$("#customerContact").val("")
		
		
	}
	else if(who == 2){
		$("#customerName").val("")
		
	}
	
	$.ajax({
		type : "post",
		url : "getCustomerByNameAndContact.action",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		data : {customerName : $("#customerName").val(),
				customerContact :$("#customerContact").val()
		},
		success : function(customer) {
			if(customer != "" ){
				$("#customerId").val(customer.id);
				$("#customerName").val(customer.name);
				$("#customerContact").val(customer.contact);
				$("#customerTele").val(customer.tele);
				$("#customerEmail").val(customer.email);
				$("#customerAddress").val(customer.address);
			}
			else{
				
				$("#customerId").val("");
				
			}
		},
		error : function() {
			win1("保存失败");
		}
	});	
	
}
</script>

<script type="text/javascript">



function getEmpByName(){
	
	$.ajax({
		type : "post",
		url : "getEmpByName.action",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		data : {empName : $("#empName").val()
		},
		success : function(emp) {
			
			if(emp != null){
				
				
				$("#empId").val(emp.id);
				$("#empName").val(emp.name);
				$("#empTele").text(emp.tele);
				$("#empEmail").text(emp.email);
				
				
				
				
			}
			else
				{
				
				$("#empId").val("");
				$("#empName").val("");
				$("#empTele").text("");
				$("#empEmail").text("");				
				
				
				
				}
			
			
		},
		error : function() {
			win1("保存失败");
		}
	});	
	
	
	
	
}	
	


</script>



<script type="text/javascript">

function getGoodsAutocomplete(){
	
	
	$("#goodsId").val("");
	$("#goodsModel").val("");
	$("#goodsName").val("");
	$("#goodsSpecs").text("");
	$("#goodstype").text("");
	$("#goodstypeId").val("");
	$("#goodsUnit").text("");
	$("#goodsNum").val("0");
	$("#goodsPrice").val("0");
	$("#goodsTotalprice").text("0");
	
	var supplierId =  $("#supplierName").find("option:selected").attr("name");
 	
    
 	$("#goodsName").empty();                                            
 	$("#goodsModel").empty();                                            

 	/* <c:forEach items="${suppliers }" var="supplier">
 	<option  >${supplier.name }</option>
 	</c:forEach> */

 	var option1= "<option>"
 	var option2="</option>"

 		

 	$.ajax({
 			type : "POST",
 			url : "getGoodsNameBySupplierId.action",
 			dataType : "json",
 			cache : false,
 			async:false,
 			data:{supplierId:supplierId},
 			success : function(datas) {
 				
 				var first= "<option selected  style='display:none'  value=''>请选择...</option>"
 					 $("#goodsName").append(first);
 				/* alert(datas == null); */
 				for(var i=0;i<datas.length;i++){
 					 var name= datas[i]
 					 
 					 var hang = option1 +name +option2;
 					 $("#goodsName").append(hang);
 				}
 			}
 		});
 	$.ajax({
 			type : "POST",
 			url : "getGoodsModelNameBySupplierId.action",
 			dataType : "json",
 			cache : false,
 			async:false,
 			data:{supplierId:supplierId},
 			success : function(datas) {
 				var first= "<option selected  style='display:none'  value=''>请选择...</option>"
					 $("#goodsModel").append(first);
 				/* alert(datas == null); */
 				for(var i=0;i<datas.length;i++){
 					 var name= datas[i]
 					 
 					 var hang = option1 +name +option2;
 					 $("#goodsModel").append(hang);
 				}
 			}
 		});


/* 
 	var datas = getData();

 	
	 $( "#goodsName" ).autocomplete({
	      source: datas
	    });	
	
	
	//获取所有不重复名称
	//获取所有不重复名称
	//获取所有不重复名称
	
	 function getData(){
		 var supplierId =  $("#supplierName").find("option:selected").attr("name");
		 	var result;
		 	$.ajax({
		 		type : "POST",
		 		url : "getGoodsNameBySuppIdAndGNameAndGModel.action",
		 		dataType : "json",
		 		cache : false,
		 		async:false,
		 		data:{
		 		    supplierId : supplierId, 
		 			goodsName : "",
		 			goodsModel : ""
		 			
		 			
		 			
		 		},
		 		success : function(datas) {
		 			
		 			result = [datas.length];
		 			for(var i=0;i<datas.length;i++){
		 				result[i] = datas[i];
		 			}
		 			}
		 		});
		 	return result;
		 }	 */
	
	
	
	
}







</script>



<script type="text/javascript">


function getGoodsByNameOrModel(who){
	
	if(who == 1){
		
		$("#goodsModel").val("");
	}
	if(who == 2){
		
		$("#goodsName").val("");
	}
	/* var supplierId =  $("#supplierName").find("option:selected").attr("name"); */
	
 	$.ajax({
 		type : "POST",
 		url : "getGoodsByNameAndModel.action",
 		dataType : "json",
 		cache : false,
 		async:false,
 		data:{
 			goodsName : $("#goodsName").val(),
 			goodsModel : $("#goodsModel").val()
 		},
 		success : function(goods) {
 			if(goods != ""){
 			var id = goods.id;
 			var model = goods.model;
 			var name = goods.name;
 			var specs = goods.specs;
 			var goodstype = goods['goodstype'].name;
 			var goodstypeId = goods['goodstype'].id;
 			var unit = goods.unit;
 			
			$("#goodsId").val(id);
			$("#goodsModel").val(model);
			$("#goodsName").val(name);
			$("#goodsSpecs").text(specs);
			$("#goodstype").text(goodstype);
			$("#goodstypeId").val(goodstypeId);
			$("#goodsUnit").text(unit);
 			}
 			else{
 				
 				$("#goodsId").val("");
 				
 			}
 			}
 		});	
	
	
	
	
	
	
}









</script>

<script type="text/javascript">
function calcTotalprice(){
	
	
	
	var num = $("#goodsNum").val();
	var price = $("#goodsPrice").val();
	
	$("#goodsTotalprice").text(num * price);
}









</script>




<script type="text/javascript">


//取消该方法的插入新商品
//取消该方法的插入新商品
//取消该方法的插入新商品
//取消该方法的插入新商品
//取消该方法的插入新商品，改为不存在则提示，不存在,用select标签便不会出这问题了
function addGoodsToOrder(){
	
	
/* 
	if($("#goodsId").val() == ""){
		
		
		
		var r=confirm("系统未备案该商品，是否继续添加该商品？？？");
		
		if(r){
			
			
			
var goods = {
		
		model:$("#goodsModel").val(),
		name:$("#goodsName").val(),
		specs:$("#goodsSpecs").text(),
		goodstypeid:$("#goodstypeId").val(),
		unit:$("#goodsUnit").text(),
		supplier:$("#supplierName").val(),
		supplierid:$("#supplierId").val()
		
}			
			
		 	$.ajax({
		 		type : "POST",
		 		url : "insertGoodsByAddOrder.action",
		 		dataType : "json",
		 		cache : false,
		 		async:false,
		 		data:goods,
		 		success : function(goods) {
		 			$("#goodsId").val(goods.id);
		 			}
		 		});
			
		}
		else{
			
			return ;
		}

		
	} */
	
	var goodstypeId =  $("#goodstypeId").val();
	/* alert(goodstypeId); */
	if(goodstypeId == "6"){
		
			var index=layer.open({
				 type : 1,
				 skin : 'layui-layer-rim', //加上边框
				 area : [ '900px', '400	px' ], //宽高
				 title : false,
				 closeBtn : 1,
				 shadeClose : true,
				 content : $(extraMessage_form),
				 btn:['确定','取消'],
				 yes:function (index, layero) {
					var  count =$('#goodsOrder  tr').length;
					var num = $("#numM").val();
					var code = $("#codeM").val();
					var layer = $("#layerM").val();
					var station = $("#stationM").val();
					var address = $("#addressM").val();
					
					/* alert('num'+count); */
					$.cookie('num'+count,num);
					$.cookie('code'+count,code);
					$.cookie('layer'+count,layer);
					$.cookie('station'+count,station);
					$.cookie('address'+count,address);
					addGoods(index);
					
					
				 },
				 cancel: function (index, layero) {//取消事件
					
				 }
				 }); 
			
	}
	else{
		
		addGoods(null);
	}

	
	function addGoods(index){
		
		if(index!= null){
			layer.close(index);
		}
		var Id=$("#goodsId").val();
		var model=$("#goodsModel").val();
		var name =$("#goodsName").val();
		var unit=$("#goodsUnit").text();
		var num = $("#goodsNum").val();
		var price =$("#goodsPrice").val();
		var totalprice=$("#goodsTotalprice").text();

		
		
		if(Id == "" || Id== null || num=="0" || price=="0"  ){
			
			
			win1("信息不足，添加失败");
			return ;
		}
		
		
		var hangLeft_L = "<tr id='Row";
		var hangLeft_R = "'>  ";
		var hangRight= "</tr>" ;
		var hangCenterLetf="<td>";
		var hangCenterRight="</td>";		
		
		
		var  count =$('#goodsOrder  tr').length;
		 count = count +1;
	 	/* <input type = 'hidden' name='goodsId' value=Id>  */
		
		 var IdHandLeft = " <td   style='display:none'> <input type = 'hidden' name='goodsId' value= '  ";
		 var IdHandRight = "  '> </td >";
		 
		 var NumHandLeft = " <td   >";
		 var NumHiddenL = " <input type = 'hidden' name='num' value= ' ";
		 var NumHiddenR = " '> ";
		 var NumHandRight = " </td >";
		 
		 var PriceHandLeft = " <td name='price' >";
		 var PriceHiddenL = " <input type = 'hidden' name='price' value= ' ";
		 var PriceHiddenR = " '> ";
		 var PriceHandRight = " </td >";
		 
		 var operL = "<td class='text-right'><a href='#' onClick='deleteGoods(Row";
		 var operR = ")'>删除</a></td>";
		 
		 
		var data = IdHandLeft + Id + IdHandRight;
	 	var data = data +hangCenterLetf + count + hangCenterRight; 
		var data = data + hangCenterLetf + name  + hangCenterRight;
		var data = data + hangCenterLetf + model  + hangCenterRight;
		var data = data + hangCenterLetf + unit  + hangCenterRight;
		var data = data + NumHandLeft + NumHiddenL+  num + NumHiddenR + num  + NumHandRight;
		var data = data + PriceHandLeft +PriceHiddenL+  price +PriceHiddenR + price + PriceHandRight;
		var data = data + hangCenterLetf + totalprice  + hangCenterRight;
		var data = data + operL +count +operR;
	    
		var hang = hangLeft_L +count + hangLeft_R+ data + hangRight;
		$("#goodsOrder").append(hang);
		
	}
	
	
	
	
	
	
	
}











</script>







<script type="text/javascript">

function deleteGoods(RowId){
	/* win1("I in") */
	$(RowId).remove();
	
	var  count =$('#goodsOrder  tr').length;

	//改行号，与id属性值
	for(var i=1;i<=count;i++){
		
		/* $('#goodsOrder  tr td:eq(1)').text(i) */
		
		index = i-1;
		$('#goodsOrder  tr:eq('+ index+ ')').attr("id","Row"+i);
		// td:eq(1)为序号列的原因：因 tr：eq（0） 为type=”hidden“，存goodsid， td：eq（1）才是 序号
		$('#goodsOrder  tr:eq('+ index+ ') td:eq(1)').text(i);
		
		$('#goodsOrder  tr:eq('+ index+ ') td:eq(8) a').attr("onClick","deleteGoods(Row"+i +")");
		
	}
	

	
	
	
	
}

</script>


<script type="text/javascript">


function setCustOtherCondition(){
//当supplier tele，email，address，改变时，说明为新供应商，原给你供应商数据要改变



	
	if($("#customerId").val() != "" && ($("#customerTele").val() !="" || $("#customerEmail").val()!="" || $("#customerAddress").val() != "") ){
		
		
		
		$("#customerId").val("") ;
		$("#customerContact").val("") ;
		$("#customerTele").val("") ;
		$("#customerEmail").val("") ;
		$("#customerName").val("") ;
		$("#customerAddress").val("") ;
		
	}
	
	
	
	
	
	
	
}



</script>


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




<!-- ------------------------------OrderResponse(必须写在Win1函数定义之后，因在加载页面是便要使用)---------------------------------------------- -->   
   

   <c:if test="${OrderResponse eq  false}">
   
   <script type="text/javascript">
   win1("信息不全，订单创建失败....");
   </script>
  		
   
   </c:if>
   <c:if test="${OrderResponse eq  true}">
   
   <script type="text/javascript">
   
   win1("订单创建成功...");
   </script>
   
  		
   
   </c:if>   



</html>