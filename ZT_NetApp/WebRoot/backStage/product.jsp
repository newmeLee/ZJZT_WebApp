<%@page import="zjzt.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>产品服务管理后台</title>
<!-- 解决IE11不兼容的问题 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/docs.css">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/panel.css" />
<link href="../bootstrap/css/bootstrap-combined.no-icons.min.css"
	rel="stylesheet">
<link href="../bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link href="../bootstrap/css/fileinput.min.css" rel="stylesheet">
<script src="../js/jquery-1.7.2.min.js"></script>
<script src="../js/ajaxfileupload.js"></script>
</head>
<body style="padding: 20px">
	<div class="container-fluid">
		<div class="row">
			<div class="navbar navbar-fixed-top">
				<div class="navbar-inner">
					<ul class="nav">
						<li class="active"><a href="getAllProduct">产品服务管理</a></li>
						<li><a href="project">项目管理</a></li>
						<li><a href="news">新闻管理</a></li>
						<li><a href="feedback">反馈信息</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 套餐列表 -->
	<div class="span4">
			<%
				Map<String,Object> req=(Map<String,Object>)ActionContext.getContext().get("request");
				List<Product> products=(List<Product>)req.get("productList");	
		 	%>
		<!-- 新闻管理部分 -->
		<section id="news">
		<div class="panel panel-primary">
			<div class="panel-heading">产品列表</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>产品名</th>
							<th>编辑</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
					<%
					if(products!=null){
						for(int i=0;i<products.size();i++){
					 %>
						<tr>
							<td><%=products.get(i).getTitle() %></td>
							<td><button class="btn btn-mini btn-info" 
							onclick="product_click(<%=products.get(i).getId()%>)">编辑</button></td>
							<td><button class="btn btn-mini btn-danger" 
							onclick="product_delete(<%=products.get(i).getId()%>)">删除</button></td>
						</tr>
						<%
						}
						}
						 %>
					</tbody>
				</table>
			</div>
		</div>
		</section>
	</div>
	<div class="span8">
		<section id="news">
		<div class="panel panel-primary">
			<div class="panel-heading">反馈信息列表</div>
			<div class="panel-body">
			
		 	<form action="addOrUpdateProduct" method="post">
				<table class="table">
					<tr style="display: none;">
						<td width="10%">产品id：</td>
						<td><textarea rows="1"  id="id"
								name="id"></textarea>
						</td>
					</tr>
					<tr>
						<td>产品名称：</td>
						<td><textarea rows="1" id="title" ></textarea>
						</td>
					</tr>
					<tr>
						<td>关键字：</td>
						<td><textarea rows="1" id="keyword"></textarea>
						</td>
					</tr>
					<tr>
						<td>产品介绍：</td>
						<td><textarea rows="6" id="content"></textarea>
						</td>
					</tr>
					<tr>
						<td>辅助介绍1：</td>
						<td><textarea rows="3" id="describe1"></textarea>
						</td>
					</tr>
					<tr>
						<td>辅助介绍2：</td>
						<td><textarea rows="3" id="describe2"></textarea>
						</td>
					</tr>
					<tr>
						<td>辅助介绍3：</td>
						<td><textarea rows="3" id="describe3"></textarea>
						</td>
					</tr>
					<tr>
						<td>辅助介绍4：</td>
						<td><textarea rows="3" id="describe4"></textarea>
						</td>
					</tr>
					<tr>
						<td>辅助介绍5：</td>
						<td><textarea rows="3" id="describe5"></textarea>
						</td>
					</tr>
					<tr>
						<td>产品图片1：</td>
						<td><input style="display: none;" id="picUrl0"> 
							<input type="file" id="file0" name="file" /> <input type="button"
							value="上传" onclick="ajaxFileUpload(0);">
							<img id="proPic0" width="150px" alt=""
							src="<%=req.get("equipPicUrl")%>"></td>
					</tr>
					<tr>
						<td>产品图片2：</td>
						<td><input style="display: none;" id="picUrl1"
							<%if (req.get("equipPicUrl") != null) {%>
							value="<%=req.get("equipPicUrl")%>"
							<%}%>> <input
							type="file" id="file1" name="file" /> <input type="button"
							value="上传" onclick="ajaxFileUpload(1);">
							<img id="proPic1" width="150px" alt=""
							src="<%=req.get("equipPicUrl")%>"></td>
					</tr>
					<tr>
						<td>产品图片3：</td>
						<td><input style="display: none;" id="picUrl2"
							<%if (req.get("equipPicUrl") != null) {%>
							value="<%=req.get("equipPicUrl")%>"
							<%}%>> <input
							type="file" id="file2" name="file" /> <input type="button"
							value="上传" onclick="ajaxFileUpload(2);">
							<img id="proPic2" width="150px" alt=""
							src="<%=req.get("equipPicUrl")%>"></td>
					</tr>
					<tr>
						<td>产品图片4：</td>
						<td><input style="display: none;" id="picUrl3"
							<%if (req.get("equipPicUrl") != null) {%>
							value="<%=req.get("equipPicUrl")%>"
							<%}%>> <input
							type="file" id="file3" name="file" /> <input type="button"
							value="上传" onclick="ajaxFileUpload(3);">
							<img id="proPic3" width="150px" alt=""
							src="<%=req.get("equipPicUrl")%>"></td>
					</tr>
					
					<tr>
						<td>产品类型：
						</td>
							<td><select id="type" name="type">
									<option value="1">门禁安防</option>
									<option value="2">智能家居</option>
									<option value="3">健康医疗</option>
							</select>
						</td>
						
					</tr>
					<tr>
						<td colspan="2">
							<button class="btn btn-info" type="button" id="btnCommit">提交</button>
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		</section>
	</div>
</body>
<script type="text/javascript">
/* 新闻列表点击编辑 */
function product_click(id){
	$("#id").val(id);
	$.ajax({
		type : "POST",//方法
		url : "getJsonProductById",//链接
		dataType : "json",
		data : {
			id : id,
		},
		success : function(data) {
			$("#id").val(data.product.id);
			$("#title").val(data.product.title);
			$("#keyword").val(data.product.keyword);
			$("#content").val(data.product.content);
			$("#describe1").val(data.product.describe1);
			$("#describe2").val(data.product.describe2);
			$("#describe3").val(data.product.describe3);
			$("#describe4").val(data.product.describe4);
			$("#describe5").val(data.product.describe5);
			$("#proPic0").attr("src",data.product.picUrl);
			$("#picUrl0").val(data.product.picUrl);
			$("#proPic1").attr("src",data.product.picUrl1);
			$("#picUrl1").val(data.product.picUrl1);
			$("#proPic2").attr("src",data.product.picUrl2);
			$("#picUrl2").val(data.product.picUrl2);
			$("#proPic3").attr("src",data.product.picUrl3);
			$("#picUrl3").val(data.product.picUrl3);
			$("#type").val(data.product.type);
		}
	}); 
}
function product_delete(id){
	if(window.confirm("你确定要删除该产品吗！")){
		location="deleteProduct?id="+id+"";
	}
	else{
		 return false;
	}
}
</script>
<script type="text/javascript"> 
  function ajaxFileUpload(id){
  		var fileElementId="file"+id;
        $.ajaxFileUpload({
           	url:"uploadProductPic",//用于文件上传的服务器端请求地址
            secureuri:false,//一般设置为false
         	fileElementId:fileElementId,//文件上传空间的id属性  <input type="file" id="file" name="file" />
            dataType: 'json',//返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
             	//alert(data.message);
             	alert("图片保存成功！");
             	$("#proPic"+id).attr("src",data.message);
             	$("#picUrl"+id).val(data.message);
            },
            error: function (data, status, e){
                //服务器响应失败处理函数
                alert(e);
            }
        });
}
</script>
<script type="text/javascript">
/* 新增产品信息 */
$("#btnCommit").click(function() {
	var id=$("#id").val();
	if($.trim(id)==''){
		id='-1';
	}
	var title = $("#title").val();
	var keyword = $("#keyword").val();
	var content = $("#content").val();
	var describe1=$("#describe1").val();
	var describe2=$("#describe2").val();
	var describe3=$("#describe3").val();
	var describe4=$("#describe4").val();
	var describe5=$("#describe5").val();
	var picUrl=$("#picUrl0").val();
	var picUrl1=$("#picUrl1").val();
	var picUrl2=$("#picUrl2").val();
	var picUrl3=$("#picUrl3").val();
	var type=$("#type").val();
	if($.trim(title)==''){
		alert('产品名不能为空！');
		return;
	}else if($.trim(content)==''){
		alert('产品说明不能为空！');
		return;
	}
	$.ajax({
		type : "POST",
		url : "addOrUpdateProduct",
		dataType : "json",
		data : {
			id : id,
			title : title,
			keyword : keyword,
			content : content,
			describe1 : describe1,
			describe2 : describe2,
			describe3 : describe3,
			describe4 : describe4,
			describe5: describe5,
			picUrl: picUrl,
			picUrl1: picUrl1,
			picUrl2: picUrl2,
			picUrl3: picUrl3,
			type:type
		},
		success : function(data) {
			if(data.result=="200"){
				window.location.href="getAllProduct";	
			}
		},
		error:function(result){
			alert(result.responseText);
			
		}
	});
});
</script> 
</html>