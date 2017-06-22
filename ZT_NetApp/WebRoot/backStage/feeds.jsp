<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="zjzt.entity.Feedback"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>反馈信息列表</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- CSS Files -->
<!-- CSS Files -->
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap-responsive.min.css">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/docs.css">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/panel.css" />
<link href="netCss/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="netCss/bootstrap-responsive.min.css" rel="stylesheet">
<script src="netJs/jquery.min.js"></script>
<!--[if it IE 9]  -->
<style>

.warp {
	width: 100px;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow:hidden;
}
</style>
</head>
<body>
<body style="padding: 20px;font-size: 12px">
	<div class="container-fluid">
		<div class="row">
			<div class="navbar navbar-fixed-top">
				<div class="navbar-inner">
					<ul class="nav">
						<li><a href="getAllProduct">产品服务管理</a></li>
						<li><a href="project">项目管理</a></li>
						<li ><a href="news">新闻管理</a></li>
						<li class="active"><a href="feedback">反馈信息</a></li>
					</ul>
				</div>
			</div>

			<div class="span4">
				<%
					Map<String, Object> req = (Map<String, Object>) ActionContext
							.getContext().get("request");
					List<Feedback> feedbackList = (List<Feedback>) req.get("feedbackList");
				%>
				<section id="news">
				<div class="panel panel-primary">
					<div class="panel-heading">新闻列表</div>
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>用户名</th>
									<th>时间</th>
									<th>查看</th>
								</tr>
							</thead>
							<tbody>
								<%
									if (feedbackList != null) {
										for (int i = 0; i < feedbackList.size(); i++) {
								%>
								<tr>
									<td><%=feedbackList.get(i).getUserName()%></td>
									<td><%=feedbackList.get(i).getGmtCreate()%></td>
									<td>
										<button class="btn btn-mini btn-info"
											onclick="news_click(<%=feedbackList.get(i).getId()%>)">
											编辑
											</button>
									</td>
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
			<div class="span7">
				<section id="news">
				<div class="panel panel-primary">
					<div class="panel-heading">反馈信息</div>
					<div class="panel-body">
						<table class="table">
							<tr>
								<td width="15%">用户名：</td>
								<td><label id="userName" ></label>
								<td>
							</tr>
							<tr>
								<td width="10%">邮箱：
								</td>
								<td><label id="email">
								</label>
								<td>
							</tr>
							<tr>
								<td>手机：
								</td>
								<td><label id="phone" >
									</label>
								</td>
							</tr>
							<tr>
								<td>反馈时间：
								</td>
								<td><label id="gmtCreate" ></label>
								</td>
							</tr>
							<tr>
								<td>反馈信息：
								</td>
								<td><textarea id="message" cols="80" rows="4"></textarea>
								</td>
							</tr>
						</table>
					</div>
				</div>
				</section>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
/* 新闻列表点击编辑 */
function news_click(id){
	$.ajax({
		type : "POST",
		url : "getFeedbackById",
		dataType : "json",
		data : {
			id : id,
		},
		success : function(data) {
			$("#userName").html(data.feedback.userName);
			$("#email").html(data.feedback.userEmail);
			$("#phone").html(data.feedback.userPhone);
			$("#message").html(data.feedback.message);
			$("#gmtCreate").html(data.feedback.gmtCreate);
		},
		error:function(data){
			alert(data);
		}
	}); 
	}
</script>
</html>