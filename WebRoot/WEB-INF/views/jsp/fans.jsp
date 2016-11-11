<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../include/core.jsp"%>

<link rel="stylesheet" href="${ctx}/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<html>
<head>
    <%@include file="../include/meta.jsp"%>
    <title>小新网络</title>
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




                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 供应商名称</label>

                                <div class="col-sm-3">
                                    <input type="text" id="form-field-1" placeholder="搜索的名称" class="col-xs-12 col-sm-8">
                                </div>
                                <div class="col-sm-3">
                                    <a class="btn btn-info" onclick="serch()">搜索</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div><!--row-->
                <div class="row">
                    <div class="col-xs-12">
                        <table id="grid-table"></table>
                        <div id="grid-pager"></div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="condown.jsp"%>
    </div><!-- /.main-container -->
    <%@include file="down.jsp"%>
    <script type="text/javascript" src="${ctx}/js/web/fans.js"></script>
</body>
</html>
