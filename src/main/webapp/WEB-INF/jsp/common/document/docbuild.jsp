<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>创建文件</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<link rel="stylesheet" href="../dist/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" href="../dist/adminlte/AdminLTE.css">
		<link rel="stylesheet" href="../dist/adminlte/skin-mcblue.css">
		<link rel="stylesheet" href="../dist/umeditor/default/css/umeditor.css">
		<link rel="stylesheet" href="../mcfish/css/guide.css">
		<link rel="stylesheet" href="../mcfish/css/mcfish.css">
		
		<link rel="stylesheet" href="../dist/adminlte/AdminLTE.css">
	</head>

	<body class="hold-transition skin-blue sidebar-mini mc_body">
		<div class="wrapper">
			<div class="content-wrapper" style="margin-left: 0;">
				<section class="content no-padding">
					<div class="box box-default">
						<div class="box-header" style="line-height: 45px;">
							<h3 class="box-title text-blue box-header-text"></h3>
							<div class="col-lg-6 no-padding pull-right">
								<div class="pull-right">
									<button type="button" class="btn btn-success bulit-btn" id="publish">发布</button>
								</div>
								<div class="pull-right" style="margin-right:60;">
								    <a href="DocumentPage.do">
								    <button type="button" class="btn btn-success bulit-btn" id="back">返回</button>
								    </a>
								    &nbsp&nbsp&nbsp&nbsp&nbsp;
								</div>
							</div>
						</div>
						<div class="container-fluid">
							<div class="new-bulit">
								<div class="new-bulit-meeting" >
								
                                   <div id="bulit-crate" class="new-bulit-item">
										<p class="bulit-small" >创建人名称</p>
										<input id="bulit-name" type="text" class="form-control">
								   </div>
								
									<div id="bulit-update" class="new-bulit-item">
										<p class="bulit-small" >修改人名称</p>
										<input id="updata-name" type="text" class="form-control">
									</div>
									
									<div class="new-bulit-item">
										<p class="bulit-small">标题</p>
										<input id="built-title" type="text" class="form-control" placeholder="文件标题">
									</div>
								<div class="form-group">
									<label class="text-color-999">类型:</label>
									
									<select id="documentStatus" class="form-control" style="display: inline-block;width:auto;margin-left:39.5px">
										<option value="">全部</option>
										<option value="0">制度</option>
										<option value="1">通知</option>
									</select>
								</div>
								</div>
							</div>
							
							<div class="new-bulit-item">
								<p class="bot-positon" style="width: 76px">内容</p>
								<div class="my-editor">
									<script id="editor" type="text/plain" style="width: 100%;"></script>
								</div>
							</div>
							
							<div class="new-bulit mar-top20 upFile hidden">
								<div class="new-bulit-item addFile">
									<p class="bulit-small">上传附件</p>
									<input type="file" onchange="mcupFileFunc(this)">
									<b style="display: none;"></b>
									<span class="tab_text_blue pointer" style="display: none;" onclick="delUpFile(this)">删除</span>
								</div>
								<span class="bulit-small tab_text_blue pointer mar-bottom10" onclick="addFileTool(this)">添加一项</span>
							</div>
							
						</div>
					</div>
				</section>
			</div>
		</div>

		
		
		<script src="../dist/jquery/jquery.min.js"></script>
		<script src="../dist/jquery/jquery.form.min.js"></script>
		<script src="../dist/adminlte/adminlte.min.js"></script>
		<script src="../dist/umeditor/umeditor.config.js"></script>
		<script src="../dist/umeditor/umeditor.min.js"></script>
		<script src="../dist/umeditor/lang/zh-cn/zh-cn.js"></script>
		<script src="../dist/jquery/ui.js"></script>
		<script src="../mcfish/js/mcfish.js"></script>
		<script src="../mcfish/js/document/docbuild.js"></script>
	</body>

</html>