<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>文件上传</h1>
    <form action="doUpload" method="post" enctype="multipart/form-data">
    	<p>姓名：<input type="text" name="userName"></p>
    	<p>图片1：<input type="file" name="pic"></p>
    	<p>图片2：<input type="file" name="pic"></p>
    	<p>图片3：<input type="file" name="pic"></p>
    	<p><input type="submit" value="上传"></p>
    
    </form>
  </body>
</html>
