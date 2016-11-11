<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    Object  user = session.getAttribute("user");
%>
<script type="text/javascript">
    //项目基础路径
    var base_path = "<%=basePath%>";
    var user = <%=user%>;
</script>
<c:set var="stx" value="${pageContext.request.contextPath }"></c:set>
<link rel="stylesheet" type="text/css" href="${ctx}/css/web.css">
<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet" href="${ctx}/assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ui.jqgrid.min.css" />

<!-- text fonts -->
<link rel="stylesheet" href="${ctx}/assets/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
<link rel="stylesheet" href="${ctx}/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
<![endif]-->
<link rel="stylesheet" href="${ctx}/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace-rtl.min.css" />
<script src="${ctx}/js/com/mycooke.js" /></script>