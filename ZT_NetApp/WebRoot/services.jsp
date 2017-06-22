<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我们的服务</title>
<!-- Remove this line if you use the .htaccess -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width">
<meta name="author" content="liyumin">
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
					<li><a href="getAllProject">项目</a></li>
				</ul>
				<ul>
					<li><a href="product_List" class="navactive">产品服务</a></li>
				</ul>
				<ul>
					<li><a href="contact.html">联系我们</a></li>
				</ul>
			</nav>
		</header>

		<div class="services-page main grid-wrap">
			<header class="grid col-full">
				<hr>
				<p class="fleft">产品服务</p>
			</header>
			<aside class="grid col-one-quarter mq2-col-full">
				<p>我们致力于提供先进的云楼宇门禁对讲、停车场道闸管理、智能家居、公共广播、周界防盗、监控摄像、电梯管控、
					照明节能、移动社区开发与应用等，涵盖各个细分领域如客服服务终端、传媒系统、多网合一维护及反馈系统等。</p>
				<p>
					医院管理系统HIS、LIS、PACS、体检系统、电子病历、分诊排队叫号、健康管理系统、客户管理系统CRM、移动健康服务应用。 
					个人与团队的健康体检、就医绿色通道、慢病管理、旅游疗养、居家养老、家庭医生、涉外医疗等多项健康服务。</p>
				<menu>
					<ul>
						<li><a href="#navbutton" class="arrow">Buttons</a>
						</li>
						<li><a href="#navtogg" class="arrow">Toggles</a>
						</li>
						<li><a href="#navtabs" class="arrow">Tabs</a>
						</li>
					</ul>
				</menu>
			</aside>

			<section class="grid col-three-quarters mq2-col-full">
				<div class="grid-wrap">
					<article id="navbutton" class="grid col-full">
						<section class="grid col-three-quarters mq2-col-full">
							<div class="grid-wrap works">
							<!-- 加载数据 -->
							<s:if test="#request.productList!=null">
								<s:iterator var="product" value="#request.productList" status="st">
									<figure class="grid col-one-third mq1-col-one-half mq2-col-one-third mq3-col-full work_1">
										<a href="getProductById?id=<s:property value="#product.id"/>"> 
											<img src="<s:property value="#product.picUrl"/>" alt="">
											<span class="zoom"></span>
										</a>
										<figcaption>
											<a href="getProductById?id=<s:property value="#product.id"/>" class="arrow"><s:property value="#product.title"/></a>
										</figcaption>
									</figure>
								</s:iterator>
							</s:if>
							</div>
						</section>
					</article>
				</div>
				<!-- 100%articles-->

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
		window.jQuery|| document.write('<script src="js/jquery-1.7.2.min.js"><\/script>')
	</script>

	<!--[if (gte IE 6)&(lte IE 8)]>
<script src="js/selectivizr.js"></script>
<![endif]-->
	<script src="js/scripts.js"></script>
</body>
</html>