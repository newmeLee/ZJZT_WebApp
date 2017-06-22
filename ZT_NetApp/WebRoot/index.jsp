<%@page import="zjzt.entity.News"%>
<%@page import="zjzt.entity.Project"%>
<%@page import="zjzt.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页-浙江智泰网络科技</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width">
<link rel="shortcut icon" type="image/x-icon" href="img/logo.ico">
<link rel="shortcut icon" type="image/png" href="img/logo.png">
<link rel="stylesheet" href="css/style.css">
<!--[if lt IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>
<body>
	<!-- Prompt IE 7 users to install Chrome Frame -->
	<!--[if lt IE 8]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->
	<div class="container">
		<header id="navtop"> <a href="index.html"> <img
			src="img/logo.png" alt="Designa Studio"> </a> <nav class="fright">
		<ul>
			<li><a href="index" class="navactive">主页</a>
			</li>
		</ul>
		<ul>
			<li><a href="about.html">关于</a>
			</li>
		</ul>
		<ul>
			<li><a href="getAllProject">项目</a>
			</li>
		</ul>
		<ul>
			<li><a href="product_List">产品服务</a>
			</li>
		</ul>
		<ul>
			<li><a href="contact.html">联系我们</a>
			</li>
		</ul>
		</nav> </header>


		<div class="home-page main">
			<section class="grid-wrap"> <header class="grid col-full">
			<hr>
			<p class="fleft">主页</p>
			<a href="about.html" class="arrow fright">获取更多信息</a> </header>

			<div class="grid col-one-half mq2-col-full">
				<h3 style="font-family: 微软雅黑">智泰科技-开启云门铃时代</h3>
				<p style="font-family: 微软雅黑">我们致力于提供先进的云楼宇门禁对讲、停车场道闸管理、智能家居、公共广播、周界防盗、监控摄像、电梯管控、照明节能、移动社区开发与应用等，涵盖各个细分领域如客服服务终端、传媒系统、多网合一维护及反馈系统等。
				</p>
				<p style="font-family: 微软雅黑">
					医院管理系统HIS、LIS、PACS、体检系统、电子病历、分诊排队叫号、健康管理系统、客户管理系统CRM、移动健康服务应用。
					个人与团队的健康体检、就医绿色通道、慢病管理、旅游疗养、居家养老、家庭医生、涉外医疗等多项健康服务。</p>
				<hr>
					<!-- 新闻列表 -->
					<h4>公司动态</h4>
					<ol style="font-size: 12px">
					<%
						Map<String,Object> req=(Map<String,Object>) ActionContext.getContext().get("request");
						List<News> newsList=(List<News>) req.get("newsList");
						if(newsList!=null){
							int listSize= newsList.size()>5?5:newsList.size();
							for(int i=0;i<listSize;i++){
							%>
								<li><a href="getNewsById?id=<%=newsList.get(i).getId() %>" title="">
									<%=newsList.get(i).getTitle() %></a>
						</li>
						<% 
							}
						}
					 %>
					</ol>
					<a style="font-size: 12px;" href="newsList">更多>></a>
			</div>

			<div class="slider grid col-one-half mq2-col-full">
				<div class="flexslider">
					<div class="slides">
						<div class="slide">
							<figure>
							<h5>健康体检系统</h5>
							<img src="img/tijian.jpg" alt=""> </figure>
						</div>

						<div class="slide">
							<figure>
							<h5>智之屋门禁系统</h5>
							<img src="img/menling.jpg" alt=""> </figure>
						</div>
						<div class="slide">
							<figure>
							<h5>医院排队叫号系统</h5>
							<img src="img/paidui.jpg" alt=""> </figure>
						</div>
					</div>
				</div>
			</div>

			</section>
			<div class="copyrights">
				Collect from <a href="http://www.cssmoban.com/">更多产品</a>
			</div>
			<section class="services grid-wrap"> <header
				class="grid col-full">
			<hr>
			<p class="fleft">产品与服务</p>
			<a href="product_List" class="arrow fright">更多产品</a> </header> <!-- 加载产品服务列表 -->
			<%
						 	List<Product> productList=(List<Product>) req.get("productList");
						 	if(productList!=null){
						 		int index=productList.size()>4?4:productList.size();
						 		for(int i=0;i<index;i++){
			%> <figure class="grid col-one-quarter mq2-col-one-half"> <a
				href="getProductById?id=<%=productList.get(i).getId()%>"> <img
				src="<%=productList.get(i).getPicUrl()%>" alt=""> <span
				class="zoom"></span> </a> <figcaption> <a
				href="getProductById?id=<%=productList.get(i).getId()%>">
				<h6><%=productList.get(i).getTitle()%></h6>
			</a>
			<p><%=productList.get(i).getContent()%></p>
			</figcaption> </figure> <%
 	}
  		 	}
 %> </section>

			<section class="works grid-wrap"> <header
				class="grid col-full">
			<hr>
			<p class="fleft">项目</p>
			<a href="getAllProject" class="arrow fright">更多项目</a> </header> <%
 	List<Project> projectList=(List<Project>) req.get("projectList");
 			 	if(projectList!=null){
 			 		int index=projectList.size()>4?4:projectList.size();
 			 		for(int i=0;i<index;i++){
 %> <figure class="grid col-one-quarter mq2-col-one-half"> <a
				href="getProjectById?id=<%=projectList.get(i).getId()%>"> <img
				src="<%=projectList.get(i).getPicUrl1()%>" alt=""> <span
				class="zoom"></span> </a> <figcaption> <a
				href="getProjectById?id=<%=projectList.get(i).getId()%>"
				class="arrow"> <%=projectList.get(i).getProjectName()%></a>
			<p><%=projectList.get(i).getProjectContent()%></p>
			</figcaption> </figure> <%
 	}
 		}
 %> </section>
		</div>
		<!--main-->

		<div class="divide-top">
			<footer class="grid-wrap">
			<div class="up grid col-one-third ">
				<small>© 浙江智泰网络科技有限公司 浙ICP备16042947号-1</small>
			</div>
			<div class="up grid col-one-third ">
				<a href="#navtop" title="Go back up">&uarr;</a>
			</div>
			<nav class="grid col-one-third ">
			<ul>
				<li><a href="index.html">主页</a>
				</li>
				<li><a href="about.html">关于</a>
				</li>
				<li><a href="works.html">产品</a>
				</li>
				<li><a href="services.html">项目</a>
				</li>
				<li><a href="contact.html">联系我们</a>
				</li>
			</ul>
			</nav>
			<div class="up col-one"></div>
			</footer>
		</div>
	</div>
	<!-- Javascript - jQuery -->
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-1.7.2.min.js"><\/script>');
	</script>
	<!--[if (gte IE 6)&(lte IE 8)]>
<script src="js/selectivizr.js"></script>
<![endif]-->
	<script src="js/jquery.flexslider-min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>