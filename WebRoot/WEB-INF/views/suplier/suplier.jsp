<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../include/core.jsp"%>




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
                                    <a class="btn btn-info" onclick="addgys()">添加</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div><!--row-->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="hidden-sm hidden-xs btn-group">
                            <button class="btn btn-xs btn-success"  id="adddata">
                                <i class="ace-icon fa fa-cloud-upload bigger-120"></i>
                                添加
                            </button>

                            <button class="btn btn-xs btn-info" id="updata">
                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                修改
                            </button>

                            <button class="btn btn-xs btn-danger" id="dedata">
                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                删除
                            </button>

                            <button class="btn btn-xs btn-warning" onclick="serch()">
                                <i class="ace-icon fa fa-undo bigger-120"></i>
                                刷新
                            </button>
                        </div>
                        <table id="grid-table"></table>
                        <div id="grid-pager"></div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="condown.jsp"%>
    </div><!-- /.main-container -->
    <%@include file="down.jsp"%>
    <script type="text/javascript" src="${ctx}/js/suplier/suplier.js"></script>
</body>
</html>
