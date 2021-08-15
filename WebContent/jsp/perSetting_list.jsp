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
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/file-explore.js"></script>
<script type="text/javascript" src="js/flatpickr.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<meta http-equiv="Cache-Control" content="no-cache">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/stylepart.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="css/flatpickr.min.css" rel="stylesheet" type="text/css" />
<!--  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" /> -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="css/file-explore.css" rel="stylesheet" type="text/css"> 

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




    <!--content-->
    <div class="content">
        <!--发货通知单录入-->
        <div class="add_delivery_notice">
            <div class="box">
                <div class="box_t">
                    <h3>角色权限设置-查询信息</h3>
                </div>
                <div class="box_c">
                               
                    <fieldset>                
                     <div class="box_c_item">                
					<label class="l_title">职位：</label> 
					<select class="text_input w200 fl" id="roleNameE" onChange="setMenu()">
                          <option selected disabled style="display:none"  >请选择...</option>
                          <c:forEach items="${roles }" var="role">
                          	<option  name="${role.id}" >${role.name }</option>
                          </c:forEach>
                    </select>  
                    <div class="fr">
                        	<label class="l_title"></label>
                        	<button class="btn btn_commit" type="button" onClick="saveSet()">保存</button>
                   	</div>
                    </div>
                    </fieldset>
                </div>
                <div class="clear"></div>
            </div>
            <div class="box">
                <div class="box_t box_t_bottom">
                    <h3>角色权限设置-权限信息</h3>
                </div>
                                    <div class="box_c box_c_reset">
                        <fieldset>
                            <table class="table">
<!--                                 <thead>
                                    <tr>
                                        <th colspan="4" class="box_t">菜单名称</th>
                                    </tr>
                                </thead> -->
                                <tbody>
                                	<c:forEach items="${menuList }" var="MenuF">
                                	
                                		<c:if test="${MenuF['pid'] eq '-1' }">
            		
                                    		<tr>
                                        		<td >${MenuF['menuname']}</td>
                                        		<td ><label><input type="checkbox" class="ace"  id="menuF${MenuF['menuid']}" name="No">全选</label></td>
                                        		<td colspan="2"></td>
                                    		</tr>
                                    		<tr>
            									<c:forEach items="${menuList}" var="MenuS">
            										<c:if test="${MenuF.menuid eq MenuS['pid']}">
                                        				<td colspan="1"><input type="checkbox" class="ace" id="menuS${MenuS['menuid']}" name="menuF${MenuF['menuid']}">|—&nbsp;&nbsp;${MenuS['menuname']}</td>
            										</c:if>
            									</c:forEach>            							
            								</tr>
            							</c:if>
            							
                                	
                                	
                                	</c:forEach>
                                

                                  
                                </tbody>
                            </table>

                            

                   			
                        </fieldset>
                        
                    </div>
 
            
            
           
        </div>
      
        <!-- END 发货通知单产品录入弹窗-->
    </div>
    <!--END content-->
</div>



       

</body>


<script type="text/javascript">

function setMenu(){
	
	
	
	var roleId = $("#roleNameE").find("option:selected").attr("name");
	
	$.ajax({
		type : "post",
		url : "getRoleMenuList.action",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		data : {
			"roleId" : roleId,
		},
		success : function(data) {
			/* $("#menuS16").attr("checked","checked") */
			/* alert(data[0].menu['menuid']);  */
			
			if(data != null){
				deleteCheckedAttr();
				for(var i=0;i<data.length;i++){
					if(data[i].menu['pid'] != -1){
						/* alert("删除成功"); */
						
						/* alert(id); */
						$("#menuS"+data[i].menu['menuid']).attr("checked","checked");
					}
					if(data[i].menu['pid'] == -1){
						$("#menuF"+data[i].menu['menuid']).attr("checked","checked");
						for(var j=0;j<data.length;j++){
							if(data[i].menu['menuid'] == data[j].menu['pid']){
								$("#menuF"+data[i].menu['menuid']).removeAttr("checked");
								break;
							}
						}
					}
					
				}
				
				
				
			}
			
			
		},
		error : function() {
			win1("删除失败");
		}
	});
	
	/* checked="checked" */	
	
}



function deleteCheckedAttr(){
	$(".ace").removeAttr("checked");
	
}
</script>


<script type="text/javascript">


$(".ace").click(function(){
	  /* alert($(this).attr("checked")); */
	  //取消选择
	  if($(this).attr("checked") == undefined){
		  
		  //MenuF
		  if($(this).attr("name")=="No"){
			  var select = "[name="+$(this).attr("id")+"]";
			  /* alert(select); */
			  $(select).removeAttr("checked");
		  }
		  else{
			  var idF = "#"+$(this).attr("name");
			  /* alert(idF); */
			  $(idF).removeAttr("checked");
			  
		  }

		  
		 /*  alert("undefined12"); */
	  }
	  //选中
	  if($(this).attr("checked") == "checked"){
		  
		  
		  //MenuF
		  if($(this).attr("name")=="No"){
			  var select = "[name="+$(this).attr("id")+"]";
			  /* alert(select); */
			  $(select).attr("checked","checked");
		  }/*  else
		  {
			  
			  // "Not"=未设值； "undefined" = 不存在该attr ；"checked" = attr为checked
			  var array = ["Not","Not","Not","Not"];
			  
			  var select = "[name="+$(this).attr("name")+"]";
			  for(var i=0;select== "checked" ;i++){
				  
				  var select = "[name="+$(this).attr("id")+"]";
				  $(select).removeAttr("checked");
				  
			  }
			   $(select).attr("checked");
			  var ii= $(select).attr("checked");
			  alert(ii); 
			  }  */
		  
		  
	  }
	});






</script>

<script type="text/javascript">


function saveSet(){
	
	
	var result=false;
	var array;
	$.ajax({
		type : "post",
		url : "getMenuListForSetting.action",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		cache : false,
 		async:false,
		success : function(data) {
    		 array = [data.length];
    	for(var i=0;i<data.length;i++){
    		
    		if(data[i].pid == -1){
    			
    			if($("#menuF"+data[i].menuid).attr("checked") == "checked" ){
    				array[i]=data[i].menuid;
    				/* alert(array[i]); */
    				
    			}
    			else{
    				//没被选择或二级菜单部分被选择设为-1
    				array[i]=-1;
    			}
    			
    		}
    		else{
    			
    			if($("#menuS"+data[i].menuid).attr("checked") == "checked"){
    				array[i]=data[i].menuid;
    				
    			}
    			else{
    				//二级菜单没被选择
    				array[i]=-1;
    			}
    			
    		}
    	}
    	
    	result = true;
    	
		},
		error : function() {
			win1("删除失败");
		}
	});
	
	
	if(result){
		setRoleMenu(array);
		
	}
	
}


function setRoleMenu(array){
	
	var roleId = $("#roleNameE").find("option:selected").attr("name");
	
	$.ajax({
		type : "post",
		url : "setRoleMenu.action",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		traditional:true,
		data : {
			array : array,
			roleId:roleId
		},
		success : function() {
		
			win1("已设置....");
			
		},
		error : function() {
			win1("删除失败");
		}
	});
	
	
}








</script>

</html>