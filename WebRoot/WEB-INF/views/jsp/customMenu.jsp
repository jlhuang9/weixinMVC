<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../include/core.jsp"%>
<html lang="en">
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




                        <div class="col-sm-3">
                            <a href="#" onclick="update()" class="btn btn-app btn-success">
                                <i class="ace-icon fa fa-refresh bigger-230"></i>
                                刷新标签
                            </a>
                            <a class="btn btn-app btn-success" onclick="update_to_wx()">
                                <i class="ace-icon fa fa-upload bigger-230"></i>
                                提交微信
                            </a>
                        </div>
                        <%--<div class="col-sm-3">
                            <div style="width: 100%;height: 600px ;border:1px solid #bfbfbf;float: left;position:relative">
                                <div id="btn_list" style="width: 100%;height: 10%;position:absolute;bottom: 0px;border:1px solid #bfbfbf;"></div>
                            </div>
                        </div>--%>
                            <div class="col-xs-6 col-sm-3 pricing-box">
                                <div class="widget-box widget-color-blue">
                                    <div class="widget-header">
                                        <h5 class="widget-title bigger lighter">手机屏幕</h5>
                                    </div>

                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <ul class="list-unstyled spaced2">
                                                <li>
                                                    <i class="ace-icon fa fa-check green"></i>
                                                    200 GB Disk Space
                                                </li>

                                                <li>
                                                    <i class="ace-icon fa fa-check green"></i>
                                                    Unlimited Bandwidth
                                                </li>

                                                <li>
                                                    <i class="ace-icon fa fa-check green"></i>
                                                    1000 Email Accounts
                                                </li>

                                                <li>
                                                    <i class="ace-icon fa fa-check green"></i>
                                                    200 MySQL Databases
                                                </li>

                                                <li>
                                                    <i class="ace-icon fa fa-check green"></i>
                                                    $25 Ad Credit
                                                </li>

                                                <li>
                                                    <i class="ace-icon fa fa-check green"></i>
                                                    Free Domain
                                                </li>
                                            </ul>

                                            <hr>
                                            <div class="price">
                                                $15
                                                <small>/month</small>
                                            </div>
                                        </div>

                                        <div>
                                            <div id="btn_list" class="btn-group" style = "width: 100%">
                                                <button type="button" class="btn">1</button>
                                                <button type="button" class="btn">2</button>
                                                <button type="button" class="btn">3</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>






                        <div class="col-sm-6">
                            <div id ="tabbable_list" class="tabbable">
                                <div class="btn-group dropup">

                                    <ul class="dropdown-menu" role="menu">
                                        <li class="">
                                            <a>+</a></li>
                                        <li></li><li class="">
                                        <a onclick="item_clack('0','0')">开源中国</a></li>
                                        <li></li><li class="">
                                        <a onclick="item_clack('0','1')">中国</a></li>
                                        <li>    <!-- Dropdown menu links -->
                                        </li></ul>
                                </div>



                            </div>
                        </div>
                    </div><!--row-->
                </div><!--col-->
            </div><!--page-->
        </div><!-- /.main-content -->

        <%@include file="condown.jsp"%>
    </div><!-- /.main-container -->
    <%@include file="down.jsp"%>
    <script src="${ctx}/js/customMenu.js"></script>
</body>
</html>
