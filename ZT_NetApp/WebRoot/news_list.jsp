<%@page import="zjzt.entity.News"%>
<%@page import="java.util.List"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻列表</title>
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
			<p class="fleft">新闻列表</p>
		</header>
		<section class="grid col-three-quarters mq2-col-two-thirds mq3-col-full">
			<article class="post">
			<table id="table_news" onmouseover="changeCursor()" style="font-size: 12px">
						<%
							Map<String,Object> req=(Map<String,Object>) ActionContext.getContext().get("request");
							List<News> newsList = (List<News>) req.get("newsList");
							;
							if (newsList != null) {
								if (newsList.size() > 0) {
									for (int i = 0; i < newsList.size(); i++) {
						%>
						<tr onclick="news_click(<%=newsList.get(i).getId()%>)">
							<td width="2%"><%=i+1%>.</td>
							<td><%=newsList.get(i).getTitle() %></td>
							<td><%=newsList.get(i).getGmtCreate()%></td>
						</tr>
						<%
							}
								}
							}
						%>
					</table>
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
<script type="text/javascript">
	/* 跳转到新闻详情页 */
	function news_click(newsId){
		window.location.href="getNewsById?id="+newsId+"";
	}
	/* 改变列表的 */
	function changeCursor(){
		$("#table_news").css("cursor","pointer");
	}
</script>
	<script src="js/scripts.js"></script>
</body>
</html>