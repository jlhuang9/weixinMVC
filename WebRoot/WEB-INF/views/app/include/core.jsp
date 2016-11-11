<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    Object  user = session.getAttribute("user");
    Object  list = request.getAttribute("list");
    Object  listnow = request.getAttribute("listnow");
%>
<script type="text/javascript">
    //项目基础路径
    var base_path = "<%=basePath%>";
    var user = <%=user%>;
    var list = <%=list%>;
    var listnow = <%=listnow%>;
</script>
<!--标准mui.css-->
<link rel="stylesheet" href="<%=basePath%>/css/mui.min.css">
<!--App自定义的css-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/app.css"/>
<link rel = "stylesheet" type ="text/css" href ="<%=basePath%>/css/iconfont.css">
<link rel = "stylesheet" type ="text/css" href ="<%=basePath%>/css/animate.min.css">
