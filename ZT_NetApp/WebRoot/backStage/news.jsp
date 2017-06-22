<%@page import="zjzt.entity.News"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻管理</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- CSS Files -->
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap-responsive.min.css">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/docs.css">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/prettify.css">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/panel.css" />
<link rel="apple-touch-icon"
	href="mindmup.s3.amazonaws.com/lib/img/apple-touch-icon.png" />
<link href="../editor/external/google-code-prettify/prettify.css"
	rel="stylesheet">
<link href="netCss/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="netCss/bootstrap-responsive.min.css" rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css"
	rel="stylesheet">
<script src="netJs/jquery.min.js"></script>
<script src="../editor/external/jquery.hotkeys.js"></script>
<script src="netJs/bootstrap.min.js"></script>
<script src="../editor/external/google-code-prettify/prettify.js"></script>
<link href="../editor/index.css" rel="stylesheet">
<script src="../editor/bootstrap-wysiwyg.js"></script>
<!--[if it IE 9]  -->
<script type="text/javascript" src="../js/html5shiv.js"></script>
<script type="text/javascript" src="../js/selectivizr.js"></script>
<style>
body {
	font-family: "ff-tisa-web-pro-1", "ff-tisa-web-pro-2", "Lucida Grande",
		"Helvetica Neue", Helvetica, Arial, "Hiragino Sans GB",
		"Hiragino Sans GB W3", "Microsoft YaHei UI", "Microsoft YaHei",
		"WenQuanYi Micro Hei", sans-serif;
}

.warp {
	width: 100px;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow:hidden;
}
</style>
</head>
<body style="padding: 20px;font-size: 12px">
	<div class="container-fluid">
		<div class="row">
			<div class="navbar navbar-fixed-top">
				<div class="navbar-inner">
					<ul class="nav">
						<li><a href="getAllProduct">产品服务管理</a>
						</li>
						<li><a href="project">项目管理</a>
						</li>
						<li class="active"><a href="news">新闻管理</a>
						</li>
						<li><a href="feedback">反馈信息</a></li>
					</ul>
				</div>
			</div>

			<div class="span4">
				<%
					Map<String,Object> req=(Map<String,Object>)ActionContext.getContext().get("request");
					List<News> newsList=(List<News>)req.get("newsList");
				%>
				<section id="news">
				<div class="panel panel-primary">
					<div class="panel-heading">新闻列表</div>
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>标题</th>
									<th>编辑</th>
									<th>删除</th>
								</tr>
							</thead>
							<tbody>
							<%
								if(newsList!=null){
									for(int i=0;i<newsList.size();i++){
									%>
									<tr>
									<td><%=newsList.get(i).getTitle() %></td>
									<td>
										<button class="btn btn-mini btn-info"
											onclick="news_click(<%=newsList.get(i).getId()%>)">编辑
											</button></td>
									<td>
										<button class="btn btn-mini btn-danger"
											onclick="news_delete()">删除</button></td>
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
					<div class="panel-heading">添加新闻</div>
					<div class="panel-body">
						<table class="table">
							<tr style="display: none;">
								<td >新闻id</td>
								<td><textarea rows="1" id="newsID"
										name="id"></textarea>
								<td>
							</tr>
							<tr>
								<td width="10%">标题<td>
								<td><textarea rows="1" id="newsTitle" >
								</textarea>
								<td>
							</tr>
							<tr>
								<td>关键字<td>
								<td><textarea id="keywords" rows="1" >
									</textarea>
								<td>
							</tr>
							<tr>
								<td>内容
								<td>
								<td>
									<div class="btn-toolbar" data-role="editor-toolbar"
										data-target="#editor">
										<div class="btn-group">
											<a class="btn dropdown-toggle" data-toggle="dropdown"
												title="Font"><i class="icon-font"></i><b class="caret"></b>
											</a>
											<ul class="dropdown-menu">
											</ul>
										</div>
										<div class="btn-group">
											<a class="btn dropdown-toggle" data-toggle="dropdown"
												title="Font Size"><i class="icon-text-height"></i>&nbsp;<b
												class="caret"></b> </a>
											<ul class="dropdown-menu">
												<li><a data-edit="fontSize 5"><font size="5">Huge</font>
												</a>
												</li>
												<li><a data-edit="fontSize 3"><font size="3">Normal</font>
												</a>
												</li>
												<li><a data-edit="fontSize 1"><font size="1">Small</font>
												</a>
												</li>
											</ul>
										</div>
										<div class="btn-group">
											<a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i
												class="icon-bold"></i> </a> <a class="btn" data-edit="italic"
												title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i>
											</a> <a class="btn" data-edit="strikethrough"
												title="Strikethrough"><i class="icon-strikethrough"></i>
											</a> <a class="btn" data-edit="underline"
												title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i>
											</a>
										</div>
										<div class="btn-group">
											<a class="btn" data-edit="insertunorderedlist"
												title="Bullet list"><i class="icon-list-ul"></i> </a> <a
												class="btn" data-edit="insertorderedlist"
												title="Number list"><i class="icon-list-ol"></i> </a> <a
												class="btn" data-edit="outdent"
												title="Reduce indent (Shift+Tab)"><i
												class="icon-indent-left"></i> </a> <a class="btn"
												data-edit="indent" title="Indent (Tab)"><i
												class="icon-indent-right"></i> </a>
										</div>
										<div class="btn-group">
											<a class="btn" data-edit="justifyleft"
												title="Align Left (Ctrl/Cmd+L)"><i
												class="icon-align-left"></i> </a> <a class="btn"
												data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i
												class="icon-align-center"></i> </a> <a class="btn"
												data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i
												class="icon-align-right"></i> </a> <a class="btn"
												data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i
												class="icon-align-justify"></i> </a>
										</div>
										<div class="btn-group">
											<a class="btn dropdown-toggle" data-toggle="dropdown"
												title="Hyperlink"><i class="icon-link"></i> </a>
											<div class="dropdown-menu input-append">
												<input class="span2" placeholder="URL" type="text"
													data-edit="createLink" />
												<button class="btn" type="button">Add</button>
											</div>
											<a class="btn" data-edit="unlink" title="Remove Hyperlink"><i
												class="icon-cut"></i> </a>

										</div>

										<div class="btn-group">
											<a class="btn" title="Insert picture (or just drag & drop)"
												id="pictureBtn"><i class="icon-picture"></i> </a> <input
												type="file" data-role="magic-overlay"
												data-target="#pictureBtn" data-edit="insertImage" />
										</div>
										<div class="btn-group">
											<a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i
												class="icon-undo"></i> </a> <a class="btn" data-edit="redo"
												title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i> </a>
										</div>
										<input type="text" data-edit="inserttext" id="voiceBtn"
											x-webkit-speech="">
									</div>
									<div id="editor"></div>
								<td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3">
									<button class="btn btn-info" id="btnCommit">提交新闻</button>
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
/* 新增新闻信息 */
$("#btnCommit").click(function() {
	var newsID=$("#newsID").val();
	if($.trim(newsID)==''){
		newsId='-1';
	}
	var newsTitle = $("#newsTitle").val();
	var keywords = $("#keywords").val();
	var newsContent = $("#editor").html();
	if($.trim(newsTitle)==''){
		alert('新闻标题不能为空！');
		return;
	}else if($.trim(newsContent)==''){
		alert('新闻内容不能为空！');
		return;
	}
	$.ajax({
		type : "POST",
		url : "saveOrUpdateNews",
		dataType : "json",
		data : {
			id : newsID,
			title : newsTitle,
			keyword : keywords,
			content : newsContent,
		},
		success : function(result) {
			//alert(result);
		},
		error:function(result){
			//alert(result.responseText);
			window.location.href="news";
		}
	});
});
/* 新闻列表点击编辑 */
function news_click(id){
	$("#newsID").val(id);
	$.ajax({
		type : "POST",
		url : "getJsonNewsById",
		dataType : "json",
		data : {
			id : id,
		},
		success : function(data) {
			$("#newsID").val(data.result.id);
			$("#newsTitle").val(data.result.title);
			$("#keywords").val(data.result.keyword);
			$("#editor").html(data.result.content);
		},
		error:function(data){
			alert(data);
		}
	}); 
}

function news_delete(id){
	if(window.confirm("你确定要删除这条新闻吗！")){
		location="deleteNewsByID?newsID="+id+"";
	}
	else{
		 return false;
	}
}
</script>
<script>
	$(function() {
		function initToolbarBootstrapBindings() {
			var fonts = [ 'Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
					'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact',
					'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
					'Times New Roman', 'Verdana' ], fontTarget = $(
					'[title=Font]').siblings('.dropdown-menu');
			$.each(fonts,function(idx, fontName) {
						fontTarget.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'
												+ fontName + '</a></li>'));
							});
			$('a[title]').tooltip({
				container : 'body'
			});
			$('.dropdown-menu input').click(function() {
				return false;
			}).change(
					function() {
						$(this).parent('.dropdown-menu').siblings(
								'.dropdown-toggle').dropdown('toggle');
					}).keydown('esc', function() {
				this.value = '';
				$(this).change();
			});

			$('[data-role=magic-overlay]').each(
					function() {
						var overlay = $(this), target = $(overlay
								.data('target'));
						overlay.css('opacity', 0).css('position', 'absolute')
								.offset(target.offset()).width(
										target.outerWidth()).height(
										target.outerHeight());
					});
			if ("onwebkitspeechchange" in document.createElement("input")) {
				var editorOffset = $('#editor').offset();
				$('#voiceBtn').css('position', 'absolute').offset({
					top : editorOffset.top,
					left : editorOffset.left + $('#editor').innerWidth() - 35
				});
			} else {
				$('#voiceBtn').hide();
			};
		}
		;
		function showErrorAlert(reason, detail) {
			var msg = '';
			if (reason === 'unsupported-file-type') {
				msg = "Unsupported format " + detail;
			} else {
				console.log("error uploading file", reason, detail);
			}
			$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'
							+ '<strong>File upload error</strong> '
							+ msg
							+ ' </div>').prependTo('#alerts');
		}
		;
		initToolbarBootstrapBindings();
		$('#editor').wysiwyg({
			fileUploadError : showErrorAlert
		});
		window.prettyPrint && prettyPrint();
	});
</script>
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments);
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m);
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');
	ga('create', 'UA-37452180-6', 'github.io');
	ga('send', 'pageview');
</script>
<script>
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "netJs/all.js#xfbml=1";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>
<script>
	!function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (!d.getElementById(id)) {
			js = d.createElement(s);
			js.id = id;
			js.src = "netJs/widgets.js";
			fjs.parentNode.insertBefore(js, fjs);
		};
	}(document, "script", "twitter-wjs");
</script>
</html>