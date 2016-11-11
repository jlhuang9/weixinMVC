<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="include/core.jsp"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>小新网络</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <style>
        .mui-plus header.mui-bar {
            display: none!important;
        }
        .mui-plus .mui-bar-nav~.mui-content {
            padding: 0!important;
        }

        .mui-plus .plus{
            display: inline;
        }

        .plus{
            display: none;
        }

        #topPopover {
            position: fixed;
            top: 16px;
            right: 6px;
        }
        #topPopover .mui-popover-arrow {
            left: auto;
            right: 6px;
        }
        p {
            text-indent: 22px;
        }
        span.mui-icon {
            font-size: 14px;
            color: #007aff;
            margin-left: -15px;
            padding-right: 10px;
        }
        .mui-popover {
            height: 300px;
        }
        .mui-content {
            padding: 10px;
        }
        #foot {
            width: 100%;
            height: 57px;
            position: fixed;
            bottom: 0;
            z-index: 101;
        }
        #foot1 {
            width: 100%;
            height: 57px;
            position: fixed;
            bottom: 0;
            z-index: 1001;
            background-color: rgba(0,0,0,0.8);
            color :#fff;
            padding-left: 20px;
            line-height: 50px;
        }
        #foot .footLeft {
            position: absolute;
            width: 100%;
            height: 57px;
            color :#fff;
            background-color: rgba(0,0,0,0.8);
            padding-left: 20px;
            line-height: 50px;
        }
        #foot .footRight {
            width: 100px;
            height: 57px;
            padding: 0 8px;
            background-color: #f15353;
            position: absolute;
            right: 0;
            color: #fff;
            font-size: 18px;
            text-align: center;
            line-height: 57px;
            z-index: 50;
        }
    </style>
</head>
<body>
<!--
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" ></a>
			<h1 class="mui-title">H5模式actionsheet</h1>
		</header>-->

    <div class="mui-content">
        <div id="popover" class="mui-popover mui-table-view" >
            <div class="mui-popover-arrow"></div>
            <div class="mui-scroll-wrapper">
                <div class="mui-scroll">
                    <span>购物车</span>
                <ul class="mui-table-view mui-table-view-inverted" style="background-color: #732c2c;">
                    <li class="mui-table-view-cell">
                        <a href="javascript:;">Item 1</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a href="javascript:;">Item 2</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a href="javascript:;">Item 3</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a href="javascript:;">Item 4</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a href="javascript:;">Item 5</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a href="javascript:;">Item 6</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a href="javascript:;">Item 7</a>
                    </li>
                </ul>
                    </div>
            </div>
        </div>

        <nav class="mui-bar mui-bar-tab" >
            <footer id="foot" hidden="hidden">
                <a id="testbox" href="#popover">
                    <div class="footLeft">

                        <div class="foot-info">
                            <span class="icon iconfont icon-zhuye-copy" style="color:#dd524d;font-size: 25px;"><span id="titlenum" class="mui-badge mui-badge-danger" style="position: absolute;"></span></span>
                            <span class="icon iconfont icon-gouwuche"></span>
                            合计:￥<span id = "pricetitle"></span>
                        </div>
                    </div>
                </a>
                <div class="footRight" ng-click="func_goHome()">
                    去结算（0）
                </div>
            </footer>
            <footer id="foot1">
                 <span class="icon iconfont icon-zhuye-copy" style="color:#fff;font-size: 25px;"></span>
                    购物车是空的
            </footer>
        </nav>
        <div class="mui-row">
            <div class="mui-col-xs-12" style="height: 20%;border: 1px solid red">


            </div>
        </div>
        <div class="mui-row" style="height: 70%">
            <div id="content_left" class="mui-col-xs-3" style="border: 1px solid blue;height: 100%">
                <ul id="ite_menu" class="mui-table-view">

                </ul>
            </div>
            <div id="content_right" class="mui-col-xs-9" style="border: 1px solid brown;height: 100%">
                <ul id="ite_list" class="mui-table-view" style="overflow: auto;height: 400px">


                </ul>
            </div>
        </div>
    </div>
</body>
<%@include file="include/bottom.jsp"%>
<script src="<%=basePath%>/js/app/web/shop.js"></script>

</html>