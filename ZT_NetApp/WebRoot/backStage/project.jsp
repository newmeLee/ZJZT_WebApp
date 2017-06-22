<%@page import="zjzt.entity.Project"%>
<%@page import="java.util.List"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目管理</title>
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
						<li ><a href="getAllProduct">产品服务管理</a></li>
						<li class="active"><a href="project">项目管理</a></li>
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
				List<Project> projects=(List<Project>)req.get("projectList");	
		 	%>
		<!-- 新闻管理部分 -->
		<section id="news">
		<div class="panel panel-primary">
			<div class="panel-heading">项目列表</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>项目名称</th>
							<th>编辑</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
					<%
					if(projects!=null){
						for(int i=0;i<projects.size();i++){
					 %>
						<tr>
							<td><%=projects.get(i).getProjectName() %></td>
							<td><button class="btn btn-mini btn-info" 
							onclick="project_click(<%=projects.get(i).getId()%>)">编辑</button></td>
							<td><button class="btn btn-mini btn-danger" 
							onclick="project_delete(<%=projects.get(i).getId()%>)">删除</button></td>
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
			<div class="panel-heading">项目管理</div>
			<div class="panel-body">
			
		 	<form action="addOrUpdateProduct" method="post">
				<table class="table">
					<tr style="display: none;">
						<td width="10%">项目id：</td>
						<td><textarea rows="1"  id="id"
								name="id"></textarea>
						</td>
					</tr>
					<tr>
						<td>项目名称：</td>
						<td><textarea rows="1" id="name" ></textarea>
						</td>
					</tr>
					<tr>
						<td>客户名称：</td>
						<td><textarea rows="1" id="customer"></textarea>
						</td>
					</tr>
					<tr>
						<td>项目介绍：</td>
						<td><textarea rows="6" id="content"></textarea>
						</td>
					</tr>
					<tr>
						<td>产品图片1：</td>
						<td><input style="display: none;" id="picUrl1"> 
							<input type="file" id="file1" name="file" /> <input type="button"
							value="上传" onclick="ajaxFileUpload(1);">
							<img id="proPic1" width="150px" alt=""
							src=""></td>
					</tr>
					<tr>
						<td>产品图片2：</td>
						<td><input style="display: none;" id="picUrl2"> <input
							type="file" id="file2" name="file" /> <input type="button"
							value="上传" onclick="ajaxFileUpload(2);">
							<img id="proPic2" width="150px" alt=""
							src=""></td>
					</tr>
					<tr>
						<td>产品图片3：</td>
						<td><input style="display: none;" id="picUrl3"> <input
							type="file" id="file3" name="file" /> <input type="button"
							value="上传" onclick="ajaxFileUpload(3);">
							<img id="proPic3" width="150px" alt=""
							src=""></td>
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
function project_click(id){
	$("#id").val(id);
	$.ajax({
		type : "POST",//方法
		url : "getJsonProjectById",//链接
		dataType : "json",
		data : {
			id : id,
		},
		success : function(data) {
			$("#id").val(data.project.id);
			$("#name").val(data.project.projectName);
			$("#customer").val(data.project.customeName);
			$("#content").val(data.project.projectContent);
			$("#proPic1").attr("src",data.project.picUrl1);
			$("#picUrl1").val(data.project.picUrl1);
			$("#proPic2").attr("src",data.project.picUrl2);
			$("#picUrl2").val(data.project.picUrl2);
			$("#proPic3").attr("src",data.project.picUrl3);
			$("#picUrl3").val(data.project.picUrl3);
		}
	}); 
}
function project_delete(id){
	if(window.confirm("你确定要删除该产品吗！")){
		location="deleteProject?id="+id+"";
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
           	url:"uploadProjectPic",//用于文件上传的服务器端请求地址
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
	var name = $("#name").val();
	var customer = $("#customer").val();
	var content = $("#content").val();
	var picUrl1=$("#picUrl1").val();
	var picUrl2=$("#picUrl2").val();
	var picUrl3=$("#picUrl3").val();
	if($.trim(name)==''){
		alert('项目名称不能为空！');
		return;
	}else if($.trim(content)==''){
		alert('项目介绍不能为空！');
		return;
	}
	$.ajax({
		type : "POST",
		url : "addOrUpdateProject",
		dataType : "json",
		data : {
			id : id,
			name : name,
			customer : customer,
			content : content,
			picUrl1: picUrl1,
			picUrl2: picUrl2,
			picUrl3: picUrl3,
		},
		success : function(data) {
			if(data.result=="200"){
				window.location.href="project";	
			}
		},
		error:function(result){
			alert(result.responseText);
		}
	});
});
</script> 
</html>