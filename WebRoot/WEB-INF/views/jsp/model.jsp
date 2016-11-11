<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../include/core.jsp"%>
<html>
<head>
    <%@include file="../include/meta.jsp"%>
    <title>小新网络</title>
    <script type="text/javascript" src="${ctx}/js/web/index.js"></script>
</head>
<body class="no-skin">
<%@include file="top.jsp"%>
<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>

    <%@include file="left.jsp"%>

    <div class="main-content">
        <div class="main-content-inner">
            <%@include file="contop.jsp"%>
            <div class="page-content">
                <%@include file="pagetop.jsp"%>
                <div class="row">
                    <div class="col-xs-12">









                    </div><!--row-->
                </div><!--col-->
            </div><!--page-->
        </div><!-- /.main-content -->

        <%@include file="condown.jsp"%>
    </div><!-- /.main-container -->
    <%@include file="down.jsp"%>
</body>
</html>
