<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目</title>
<!-- Remove this line if you use the .htaccess -->
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
<!-- Prompt IE 7 users to install Chrome Frame -->
	<!--[if lt IE 8]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

	<div class="container">
		<header id="navtop">
			<a href="index.html"> <img src="img/logo.png"
				alt="Designa Studio"> </a>
			<nav class="fright">
				<ul>
					<li><a href="index">主页</a></li>
				</ul>
				<ul>
					<li><a href="about.html">关于</a></li>
				</ul>
				<ul>
					<li><a href="getAllProject" class="navactive">项目</a>
					</li>
				</ul>
				<ul>
					<li><a href="product_List">产品服务</a></li>
				</ul>
				<ul>
					<li><a href="contact.html">联系我们</a></li>
				</ul>
			</nav>
		</header>


		<div class="works-page main grid-wrap">

			<header class="grid col-full">
				<hr>
				<p class="fleft">项目</p>
			</header>
			<aside class="grid col-one-quarter mq2-col-full">
				<p class="mbottom">我们的项目包含智之屋云门铃系统、停车场道闸管理、智能家居、公共广播、周界防盗、以及医院健康体检系统、排队叫号系统、PACS(影像系统)、LIS(检验系统)、网站等业务...</p>
				<menu>
					<a id="work_all" class="arrow buttonactive">All</a>
					<br>
					<a id="work_1" class="arrow">Web design</a>
					<br>
					<a id="work_2" class="arrow">Web development</a>
					<br>
					<a id="work_3" class="arrow">Graphic design</a>
				</menu>
			</aside>

			<section class="grid col-three-quarters mq2-col-full">
				<div class="grid-wrap works">
					<!-- 循环加载数据 -->
					<s:if test="#request.projectList!=null">
						<s:iterator var ="project" value="#request.projectList" status="st">
							
							<figure class="grid col-one-third mq1-col-one-half mq2-col-one-third mq3-col-full work_1">
								<a href="getProjectById?id=<s:property value="#project.id"/>"> <img src='<s:property value="#project.picUrl1"/>' alt=""> <span
									class="zoom"></span> </a>
								<figcaption>
									<a href="getProjectById?id=<s:property value="#project.id"/>" class="arrow"><s:property value="#project.projectName"/></a>
								<p><s:property value="#project.projectContent"/></p>
						</figcaption>
					</figure>
						</s:iterator>
					</s:if>
					
				</div>
				<!-- grid inside 3/4-->
			</section>
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
		window.jQuery|| document.write('<script src="js/jquery-1.7.2.min.js"><\/script>');
	</script>
	<!--[if (gte IE 6)&(lte IE 8)]>
<script src="js/selectivizr.js"></script>
<![endif]-->
	<script src="js/scripts.js"></script>
</body>
</body>
</html>