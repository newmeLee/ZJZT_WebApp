<%@page import="zjzt.entity.News"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻详情</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width">
<link rel="shortcut icon" type="image/x-icon" href="img/logo.ico">
<link rel="shortcut icon" type="image/png" href="img/logo.png">
<link rel="stylesheet" href="css/style.css">
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
		</nav> 
	</header>
		<div class="blog-page main grid-wrap">
		<header class="grid col-full">
			<hr>
			<p class="fleft">新闻详情</p>
		</header>
		<section class="grid col-three-quarters mq2-col-two-thirds mq3-col-full">
			<article class="post">
			<%
				Map<String,Object> req=(Map<String,Object>) ActionContext.getContext().get("request");
				News news = (News) req.get("news");
				if(news!=null){
					%>
					<h3><%=news.getTitle() %></h3>
					<div class="meta">
						<p>发表于: <span class="time"><%=news.getGmtModified()%></span> 
						编辑： <a href="#" class="fn"><%=news.getCreater()%></a></p>
					</div>
					<div class="entry">
						<%=news.getContent()%>
					</div>
					<%
				}
			%>
				
			</article>
		</section>
	</div> 
		<!-- 底部栏 -->
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

	<script src="js/scripts.js"></script>
</body>
</html>