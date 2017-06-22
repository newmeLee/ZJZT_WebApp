<%@page import="zjzt.entity.Product"%>
<%@page import="java.util.Map"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>产品服务详细</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width">
<meta name="description"
	content="Designa Studio, a HTML5 / CSS3 template.">
<meta name="author"
	content="Sylvain Lafitte, Web Designer, sylvainlafitte.com">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
<link rel="shortcut icon" type="image/png" href="favicon.png">
<link rel="stylesheet" href="css/style.css">
<!--[if lt IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>
<body>
	<div class="container">
		<header id="navtop"> <a href="index.html"> <img
			src="img/logo.png" alt="Designa Studio"> </a> <nav class="fright">
		<ul>
			<li><a href="index">主页</a></li>
		</ul>
		<ul>
			<li><a href="about.html">关于</a></li>
		</ul>
		<ul>
			<li><a href="getAllProject">项目</a>
			</li>
		</ul>
		<ul>
			<li><a href="product_List" class="navactive">产品服务</a></li>
		</ul>
		<ul>
			<li><a href="contact.html">联系我们</a></li>
		</ul>
		</nav> </header>
		<div class="work-page main grid-wrap">
			<header class="grid col-full">
			<hr>
			<p class="fleft">项目详细</p>
			</header>
			<!-- 加载数据 -->
			<%
				Map<String,Object> req=(Map<String,Object>)ActionContext.getContext().get("request");
				Product product=(Product)req.get("product");
				if(product!=null){
			%>
			<aside class="grid col-one-half mq2-col-full">

			<h6>产品名称</h6>
			<p class="halfmbottom"><%=product.getTitle()%></p>
			<!-- 关键字 -->
			<p class="halfmbottom"><%=product.getKeyword()!=null?product.getKeyword():""%></p>
			
			<h6>产品详细</h6>
			<%=product.getContent()%> 
			<!-- 其他相关描述 -->
			<p><%=product.getDescribe1()!=null?product.getDescribe1():""%></p>
			<p><%=product.getDescribe2()!=null?product.getDescribe2():""%></p>
			<p><%=product.getDescribe3()!=null?product.getDescribe3():""%></p>
			<p><%=product.getDescribe4()!=null?product.getDescribe4():""%></p>
			<p><%=product.getDescribe5()!=null?product.getDescribe5():""%></p>
			</aside>

			<section class="slider grid col-one-half mq2-col-full"> <figure
				class="">  
				<img src="<%=product.getPicUrl()%>" alt="">
				
				<figcaption>
			<p><%=product.getTitle()%></p>
			<img src="<%=product.getPicUrl1()%>" alt=""><br>
			<img src="<%=product.getPicUrl2()%>" alt=""><br>
			<img src="<%=product.getPicUrl3()%>" alt=""><br>
			</figcaption> </figure> </section>
			<%
				}
			%>
			<!-- 加载数据完成 -->
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
				<li><a href="index.html">主页</a></li>
				<li><a href="about.html">关于</a></li>
				<li><a href="works.html">产品</a></li>
				<li><a href="services.html">项目</a></li>
				<li><a href="contact.html">联系我们</a></li>
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
						.write('<script src="js/jquery-1.7.2.min.js"><\/script>')
	</script>

	<!--[if (gte IE 6)&(lte IE 8)]>
<script src="js/selectivizr.js"></script>
<![endif]-->

	<script src="js/scripts.js"></script>
</body>
</html>