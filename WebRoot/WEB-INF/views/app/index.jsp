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
    p {
        text-indent: 22px;
    }
    span.mui-icon {
        font-size: 14px;
        color: #007aff;
        margin-left: -15px;
        padding-right: 10px;
    }
    #info {
        padding: 20px 10px;
    }
    .des {
        margin: .5em 0;
    }
    .des>li {
        font-size: 14px;
        color: #8f8f94;
    }
    html,
    body {
        background-color: #efeff4;
    }
    .mui-bar~.mui-content .mui-fullscreen {
        top: 44px;
        height: auto;
    }
    .mui-pull-top-tips {
        position: absolute;
        top: -20px;
        left: 50%;
        margin-left: -25px;
        width: 40px;
        height: 40px;
        border-radius: 100%;
        z-index: 1;
    }
    .mui-bar~.mui-pull-top-tips {
        top: 24px;
    }
    .mui-pull-top-wrapper {
        width: 42px;
        height: 42px;
        display: block;
        text-align: center;
        background-color: #efeff4;
        border: 1px solid #ddd;
        border-radius: 25px;
        background-clip: padding-box;
        box-shadow: 0 4px 10px #bbb;
        overflow: hidden;
    }
    .mui-pull-top-tips.mui-transitioning {
        -webkit-transition-duration: 200ms;
        transition-duration: 200ms;
    }
    .mui-pull-top-tips .mui-pull-loading {
        /*-webkit-backface-visibility: hidden;
        -webkit-transition-duration: 400ms;
        transition-duration: 400ms;*/

        margin: 0;
    }
    .mui-pull-top-wrapper .mui-icon,
    .mui-pull-top-wrapper .mui-spinner {
        margin-top: 7px;
    }
    .mui-pull-top-wrapper .mui-icon.mui-reverse {
        /*-webkit-transform: rotate(180deg) translateZ(0);*/
    }
    .mui-pull-bottom-tips {
        text-align: center;
        background-color: #efeff4;
        font-size: 15px;
        line-height: 40px;
        color: #777;
    }
    .mui-pull-top-canvas {
        overflow: hidden;
        background-color: #fafafa;
        border-radius: 40px;
        box-shadow: 0 4px 10px #bbb;
        width: 40px;
        height: 40px;
        margin: 0 auto;
    }
    .mui-pull-top-canvas canvas {
        width: 40px;
    }
    .mui-slider-indicator.mui-segmented-control {
        background-color: #efeff4;
    }
</style>
</head>

<body>
<!--
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" ></a>
			<h1 class="mui-title">H5模式actionsheet</h1>
		</header>-->

<nav class="mui-bar mui-bar-tab">
    <a id="index" class="mui-tab-item " href="#item1mobile" >
        <span class="icon iconfont icon-zhuye-copy"></span>
        <span class="mui-tab-label">主页</span>
    </a>
    <a id="car" class="mui-tab-item" href="#item3mobile">
        <span class="icon iconfont icon-gouwuche1"></span>
        <span class="mui-tab-label">购物车</span>
    </a>
    <a id="order" class="mui-tab-item" href="#item2mobile" onclick="javascript:{alert(openid)}">
        <span class="icon iconfont icon-dingdan"></span>
        <span class="mui-tab-label">订单</span>
    </a>
    <a id="myself"  class="mui-tab-item" href="#item4mobile">
        <span class="icon iconfont icon-wode"></span>
        <span class="mui-tab-label">我的</span>
    </a>
</nav>
<div class="mui-content">
                <div id="slider1" class="mui-slider" >
                    <div class="mui-slider-group mui-slider-loop">
                        <!-- 额外增加的一个节点(循环轮播：第一个节点是最后一张轮播) -->
                        <div class="mui-slider-item mui-slider-item-duplicate">
                            <a href="#" >
                                <img src="<%=basePath%>images/yuantiao.jpg">
                            </a>
                        </div>
                        <!-- 第一张 -->
                        <div class="mui-slider-item" >
                            <a href="#" >
                                <img src="<%=basePath%>images/shuijiao.jpg">
                            </a>
                        </div>
                        <!-- 第二张 -->
                        <div class="mui-slider-item">
                            <a href="#" >
                                <img src="<%=basePath%>images/muwu.jpg">
                            </a>
                        </div>
                        <!-- 第三张 -->
                        <div class="mui-slider-item">
                            <a href="#" >
                                <img src="<%=basePath%>images/cbd.jpg">
                            </a>
                        </div>
                        <!-- 第四张 -->
                        <div class="mui-slider-item">
                            <a href="#" >
                                <img src="<%=basePath%>images/yuantiao.jpg">
                            </a>
                        </div>
                        <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一张轮播) -->
                        <div class="mui-slider-item mui-slider-item-duplicate">
                            <a href="#" >
                                <img src="<%=basePath%>images/shuijiao.jpg">
                            </a>
                        </div>
                    </div>
                    <div class="mui-slider-indicator">
                        <div class="mui-indicator mui-active"></div>
                        <div class="mui-indicator"></div>
                        <div class="mui-indicator"></div>
                        <div class="mui-indicator"></div>
                    </div>
                </div>
    <div id="text">
        <ul class="mui-table-view mui-grid-view mui-grid-12">
            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="<%=basePath%>/app/shop?shop=1">
                <i class="mui-icon mui-icon-home"></i>
                <div class="mui-media-body">日用</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
                <i class="mui-icon mui-icon-email"></i>
                <div class="mui-media-body">居家</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
                <i class="mui-icon mui-icon-chatbubble"></i>
                <div class="mui-media-body">百货</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
                <i class="mui-icon mui-icon-location"></i>
                <div class="mui-media-body">美工</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
                <i class="mui-icon mui-icon-search"></i>
                <div class="mui-media-body">Search</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
                <i class="mui-icon mui-icon-phone"></i>
                <div class="mui-media-body">Phone</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
                <i class="mui-icon mui-icon-gear"></i>
                <div class="mui-media-body">Setting</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
                <i class="mui-icon mui-icon-info"></i>
                <div class="mui-media-body">about</div></a></li>
        </ul>
        <ul class="mui-table-view">
            <li class="mui-table-view-cell mui-media">
                <a href="javascript:;">
                    <img class="mui-media-object mui-pull-left" src="<%=basePath%>images/shuijiao.jpg">
                    <div class="mui-media-body">
                        幸福
                        <p class='mui-ellipsis'>能和心爱的人一起睡觉，是件幸福的事情；可是，打呼噜怎么办？</p>
                    </div>
                </a>
            </li>
            <li class="mui-table-view-cell mui-media">
                <a href="javascript:;">
                    <img class="mui-media-object mui-pull-left" src="<%=basePath%>images/muwu.jpg" onclick="javascript:{alert(base_path)}">
                    <div class="mui-media-body">
                        木屋
                        <p class='mui-ellipsis'>想要这样一间小木屋，夏天挫冰吃瓜，冬天围炉取暖.</p>
                    </div>
                </a>
            </li>
            <li class="mui-table-view-cell mui-media">
                <a href="javascript:;">
                    <img class="mui-media-object mui-pull-left" src="images/cbd.jpg">
                    <div class="mui-media-body">
                        CBD
                        <p class='mui-ellipsis'>烤炉模式的城，到黄昏，如同打翻的调色盘一般.</p>
                    </div>
                </a>
            </li>
        </ul>
    </div>

</div>


</body>
<%@include file="include/bottom.jsp"%>
<script src="<%=basePath%>/js/app/web/index.js"></script>

</html>