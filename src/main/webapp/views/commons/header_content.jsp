<%-- 剥离出来的头部 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header_container">
    <!--Header Starts-->
    <!-- <header> -->
    <div class="header">
        <h1 class="logo"> <a href="${_contextPath}/index.htm"><img src="${domain_image}/img/logo.png" /></a> </h1>
        <!-- 暂时注释搜索功能 -->
        <!-- <form class="header_search">
            <div class="form-search">
                <input id="search" type="text" name="q" value="" class="input-text" autocomplete="off" placeholder="Search" />
                <button type="submit" title="Search"></button>
            </div>
        </form> -->
    </div>
    <!-- </header> -->
</div>
<!-- 导航栏 -->
<div class="navigation_container">
    <!-- <nav> -->
    <div class="nav">
        <ul class="primary_nav">
        	<%-- <c:if test="${daohang}">
        	</c:if> --%>
        	<li class="active">
            	<a href="${_contextPath}/sps----1.htm" >分类</a>
                <ul class="sub_menu">
                    <li> 
                        <ul>
                            <li><a href="${_contextPath}/sps---1-1.htm" >服饰鞋包</a></li>
                            <li><a href="${_contextPath}/sps---2-1.htm" >运动户外</a></li>
                            <li><a href="${_contextPath}/sps---3-1.htm" >手机数码</a></li>
                            <li><a href="${_contextPath}/sps---4-1.htm" >家用电器</a></li>
                            <li><a href="${_contextPath}/sps---5-1.htm" >护肤美妆</a></li>
                            <li><a href="${_contextPath}/sps---6-1.htm" >办公用品</a></li>
                            <li><a href="${_contextPath}/sps---7-1.htm" >母婴用品</a></li>
                        </ul>
                    </li>
                    <li> 
                        <ul>
                            <li><a href="${_contextPath}/sps---8-1.htm">日用百货</a></li>
                            <li><a href="${_contextPath}/sps---9-1.htm">美食特产</a></li>
                            <li><a href="${_contextPath}/sps---10-1.htm">家居家纺</a></li>
                            <li><a href="${_contextPath}/sps---11-1.htm">图书音像</a></li>
                            <li><a href="${_contextPath}/sps---12-1.htm">汽车用品</a></li>
                            <li><a href="${_contextPath}/sps---13-1.htm">其他分类</a></li>
                            <li><a href="${_contextPath}/sps----1.htm" >所有分类</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        	<%-- <li>
            	<a href="${_contextPath}/sps----1.htm" >折扣</a>
                <ul class="sub_menu">
                    <li> 
                        <ul>
                            <!-- <li><a href="#">全网最低</a></li> -->
                            <li><a href="${_contextPath}/s---1--1.htm">一折</a></li>
                            <li><a href="${_contextPath}/s---2--1.htm">二折</a></li>
                            <li><a href="${_contextPath}/s---3--1.htm">三折</a></li>
                            <li><a href="${_contextPath}/s---4--1.htm">四折</a></li>
                            <li><a href="${_contextPath}/s---5--1.htm">五折</a></li>
                        </ul>
                    </li>
                    <li> 
                        <ul>
                            <li><a href="${_contextPath}/s---6--1.htm">六折</a></li>
                            <li><a href="${_contextPath}/s---7--1.htm">七折</a></li>
                            <li><a href="${_contextPath}/s---8--1.htm">八折</a></li>
                            <li><a href="${_contextPath}/s---9--1.htm">九折</a></li>
                        </ul>
                    </li>
                </ul>
            </li> --%>
        	<li>
            	<a href="${_contextPath}/sps----1.htm">品牌商家</a>
            </li>
            <li><a href="${_contextPath}/ex/jybr-1.htm">经验</a></li>
            <li><a href="${_contextPath}/product/gotoShare.htm">商品分享</a></li>
            <li><a href="${_contextPath}/error/weihu.htm">帮助中心</a></li>
        </ul>
   </div>
   <!-- </nav> -->
</div>