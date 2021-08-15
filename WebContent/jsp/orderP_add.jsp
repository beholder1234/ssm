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


<!--弹窗插件  -->
<script type="text/javascript" src="js/popup.js"></script>
<link href="css/popup.css" rel="stylesheet" type="text/css" />



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
            <form action="purOrderAdd.action" method="post">
                <div class="box">
                    <div class="box_t">
                        <h3>采购单录入-供应商信息</h3>
                    </div>
                    <div class="box_c">
                        <fieldset>
                        
                        	<!-- id hidden -->
                        	<input class="text_input w150" type="hidden" name="empId"  id="empId"  >
                        	<input class="text_input w150" type="hidden" name="id"  id="supplierId"  value="">
                        
                            <div class="box_c_item">
                                 <div class="fl">
                                    <label class="l_title">购方单位：</label>
                                    <span class="l_con w300">深圳市富士乐电梯有限公司</span>
                                </div>
                                 <div class="fl">
                                    <label class="l_title">销方单位：</label>
                                    <input class="text_input w300" type="text" name="name" id="supplierName" placeholder="请输入供应商名称" onChange="getSupplierByNameAndContact(1)" required>
                                </div>                                

                                <div class="clear"></div>
                            </div>
                            <div class="box_c_item">
                                <div class="fl">
                                    <label class="l_title">下单人：</label>
                                    <span class="l_con w300"> ${oneRole.name} </span>
                                </div>                               
                                <div class="fl">
                                    <label class="l_title">联系人：</label>
                                    	<input class="text_input w300" type="text" name="contact" id="supplierContact" placeholder="请输入供应商联系人" onChange="getSupplierByNameAndContact(2)" required>

                                </div>
                                <div class="clear"></div>
                            </div>    
                            <div class="box_c_item">

                                <div class="fl">
                                    <label class="l_title">电话：</label>
                                    <span class="l_con w300"> ${oneRole.tele }</span>
                                </div>
                                <div class="fl">
                                    <label class="l_title">电话：</label>
                                    <input class="text_input w300" type="text" name="tele" id="supplierTele" placeholder="请输入供应商电话" onChange="setSuppOtherCondition()" required>
                                </div>
                                <div class="clear"></div>
                            </div>                                                 
                            <div class="box_c_item">
                                <div class="fl">
                                    <label class="l_title">邮箱：</label>
                                    <span class="l_con w300" id="empEmail" > ${oneRole.email} </span>
                                </div>

                                <div class="fl">
                                    <label class="l_title">邮箱：</label>
                                    <input class="text_input w300" type="text" name="email" id="supplierEmail" placeholder="请输入供应商邮箱" onChange="setSuppOtherCondition()" email>
                                </div>
                                <div class="clear"></div>
                            </div>
                            <div class="box_c_item">
                                  <div class="fl">
                                    <label class="l_title">单位地址：</label>
                                    <span class="l_con w300">深圳市</span>
                                </div>                          
                                  <div class="fl">
                                    <label class="l_title">单位地址：</label>
                                    <input class="text_input w300" type="text" name="address" id="supplierAddress" placeholder="请输入供应商单位地址" onChange="setSuppOtherCondition()" required>
                                </div>
                                <div class="clear"></div>
                            </div>

                        </fieldset>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="box">
                    <div class="box_t box_t_bottom">
                        <h3 class="fl">采购单录入-原材料信息</h3>
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
        <div class="box_c hide" id="goods_add_form">
            <fieldset>
            	
            	<input  type="hidden" name="id"  id="goodsId"  >
            	
                <div class="box_c_item">
                	<div class="fl">
                    	<label class="l_title">名称：</label>
                    	<input class="text_input w150" type="text" placeholder="请输入原材料名称" id="goodsName"  name="goodsName" onChange="getGoodsByNameAndModel()" >
                    </div> 
                    
                    <div class="fl">                
                    	<label class="l_title">型号：</label>
                   	 	<input class="text_input w150" type="text" placeholder="请输入原材料名称" id="goodsModel" name="goodsModel" onChange="getGoodsByNameAndModel()">
                   	</div>                    
                 
                    <div class="clear"></div>
                </div>
                   	<div class="fl">   	
                    	<label class="l_title">规格：</label>
                    	<input class="text_input w150" id="goodsSpecs" type="text" placeholder="请输入原材料名称">
                    </div>   
                <div class="box_c_item">
	
                    <div class="fl">
                        <label class="l_title">类型：</label>
                        <input id="goodstypeId" type="hidden">
                        <input class="text_input w150" type="text" id="goodstype" placeholder="请输入原材料单位" name="goodstype">
                    </div>                   
                    <div class="clear"></div>
                </div>
                <div class="box_c_item">
                    <div class="fl">
                        <label class="l_title">单位：</label>
                        <input class="text_input w150" type="text" id="goodsUnit" name="goodsUnit" placeholder="请输入原材料单价">
                    </div>                
                    <div class="fl">
                        <label class="l_title">数量：</label>
                        <input class="text_input w150" type="text" id="goodsNum" name="goodsNum" placeholder="请输入原材料数量" onChange="calcTotalprice()" value="0" >
                    </div>              

                    <div class="clear"></div>
                </div>
                <div class="box_c_item">            
                    <div class="fl">
                        <label class="l_title">单价：</label>
                        <input class="text_input w150" type="text" id="goodsPrice" name="goodsPrice" placeholder="请输入原材料单价" onChange="calcTotalprice()" value="0">
                    </div>
                    <div class="fl">
                        <label class="l_title">金额：</label>
                         <span class="l_con w150" id="goodsTotalprice" name="goodsTotalprice" placeholder="请输入原材料金额" value="0"></span>
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

          	
            	
            	
            	if(!checkEmpandSupplier()){
            		
            		
            		return ;
            		
            	}
            	
$("#goodsName").val("");
$("#goodsModel").val("") ;     	
getGoodsAutocomplete();
            	
                layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['780px', '420px'], //宽高
                    title: false,
                    closeBtn: 1,
                    shadeClose: true,
                    content: $("#goods_add_form")
                });
                
                
                                            
                
                
                
                
                
            });
        </script>

<script type="text/javascript">



function checkEmpandSupplier(){
	
	

	if($("#supplierId").val() == null || $("#supplierId").val() == ""){
		
		if($("#supplierName").val() == null || $("#supplierName").val() == ""){
			
			win1("请填写售方单位...");
			return false;
			
		}
		if($("#supplierContact").val() == null || $("#supplierContact").val() == ""){
			
			win1("请填写联系人...");
			return false;
			
		}
		if($("#supplierTele").val() == null || $("#supplierTele").val() == ""){
			
			win1("请填写联系电话...");
			return false;
			
		}
		if($("#supplierAddress").val() == null || $("#supplierAddress").val() == ""){
			
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

	var datas = getData();
	 $( "#supplierName" ).autocomplete({
	      source: datas
	    });

/* 		var empNames = getEmpNames();
		 $( "#empName" ).autocomplete({
		      source: empNames
		    }); */

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








</script>

<script type="text/javascript">




function insertAlert(){
	var r=confirm("系统未备案该供应商，是否要向该供应商购买商品？？？");
	if (r==true){
		/* var x="你按下了\"确定\"按钮!"; */
		
		

		
var	supplier = {


  name:	$("#supplierName").val(),
contact:	$("#supplierContact").val(),
  tele:	$("#supplierTele").val(),
 email:	$("#supplierEmail").val(),
address:	$("#supplierAddress").val(),
state:0


}	
		
	 	$.ajax({
	 		type : "POST",
	 		url : "insertSupplierByOrderAdd.action",
	 		dataType : "json",
	 		cache : false,
	 		async:false,
	 		data:supplier,
	 		success : function(supplier) {
	 			/* win1(datas == null); */
	 			win1("已保存新供应商");
	 			$("#supplierId").val(supplier.id);
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
function getSupplierByNameAndContact(condition){
	
	if(condition == 1){
		name =  $("#supplierName").val();
		contact = "";
	}
	else if(condition == 2){
		
		name =  "";
		contact = $("#supplierContact").val();
	}
		 /* alert(contact); */ 
	
	$.ajax({
		type : "post",
		url : "getSupplierByNameAndContact.action",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		data : {supplierName : name,
				supplierContact :contact
		},
		success : function(supplier) {
			if(supplier != "" ){
				$("#supplierId").val(supplier.id);
				$("#supplierName").val(supplier.name);
				$("#supplierContact").val(supplier.contact);
				$("#supplierTele").val(supplier.tele);
				$("#supplierEmail").val(supplier.email);
				$("#supplierAddress").val(supplier.address);
			}
			else{
				
				$("#supplierId").val("");
				
			}
		},
		error : function() {
			win1("保存失败");
		}
	});	
	
}
</script>
<!-- 
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

 -->

<script type="text/javascript">

function getGoodsAutocomplete(){
	
 	var datas = getData();
	 $( "#goodsName" ).autocomplete({
	      source: datas
	    });	
	
	
	
	
	
	
	 function getData(){
		 	var result;
		 	$.ajax({
		 		type : "POST",
		 		url : "getGoodsNameBySuppIdAndGNameAndGModel.action",
		 		dataType : "json",
		 		cache : false,
		 		async:false,
		 		data:{
		 			supplierId : $("#supplierId").val(),
		 			goodsName : $("#goodsName").val(),
		 			goodsModel : $("#goodsModel").val()
		 			
		 			
		 			
		 		},
		 		success : function(datas) {
		 			
		 			result = [datas.length];
		 			for(var i=0;i<datas.length;i++){
		 				result[i] = datas[i];
		 			}
		 			}
		 		});
		 	return result;
		 }	
	
	
	
	
}







</script>



<script type="text/javascript">


function getGoodsByNameAndModel(){
	
	
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
			$("#goodsSpecs").val(specs);
			$("#goodstype").val(goodstype);
			$("#goodstypeId").val(goodstypeId);
			$("#goodsUnit").val(unit);
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



function addGoodsToOrder(){
	
	

	if($("#goodsId").val() == ""){
		
		
		
		var r=confirm("系统未备案该商品，是否继续添加该商品？？？");
		
		if(r){
			
			
			
var goods = {
		
		model:$("#goodsModel").val(),
		name:$("#goodsName").val(),
		specs:$("#goodsSpecs").val(),
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

		
	}
	

	var Id=$("#goodsId").val();
	var model=$("#goodsModel").val();
	var name =$("#goodsName").val();
	var unit=$("#goodsUnit").text();
	var num = $("#goodsNum").val();
	var price =$("#goodsPrice").val();
	var totalprice=$("#goodsTotalprice").text();
	
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











</script>







<script type="text/javascript">

function deleteGoods(RowId){
	win1("I in");
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


function setSuppOtherCondition(){
//当supplier tele，email，address，改变时，说明为新供应商，原给你供应商数据要改变



	
	if($("#supplierId").val() != "" && ($("#supplierTele").val() !="" || $("#supplierEmail").val()!="" || $("#supplierAddress").val() != "") ){
		
		
		
		$("#supplierId").val("") ;
		$("#supplierContact").val("") ;
		$("#supplierTele").val("") ;
		$("#supplierEmail").val("") ;
		$("#supplierName").val("") ;
		$("#supplierAddress").val("") ;
		
	}
	
	
	
	
	
	
	
}



</script>


<script type="text/javascript">


//2秒自动消失弹窗
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