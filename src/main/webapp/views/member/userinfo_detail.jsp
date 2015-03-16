<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>
   <!--start: Sub-nav -->
<div class="sub-nav" sup="Account">
    <div class="sub-nav-inner">
        <div class="container">
            <!--start: Navigation -->
            <div class="navbar navbar-inverse">
                <div class="navbar-inner">
                    <ul class="nav">
                        <li class="active"><a href="">用户信息</a></li>
                        <!-- <li ><a href="">我的讨论</a></li>
                        <li ><a href="">评论讨论</a></li> -->
                        <li ><a href="">修改密码</a></li>
                       <!--  <li ><a href="">消息</a></li> -->
                    </ul>
                </div>
            </div>
            <!--end: Navigation -->
        </div>
    </div>
</div>
<!-- 梁宏用户中心 -->
<div class="container w990">
  <%-- <h3 class="say-hello">中午好，${user.nickName==null?user.email:user.nickName} 吃完午饭小憩一会为下午补充能量！</h3> --%>
  <div class="account-info">
  </div>
    <div class="row">
    <div class="mywidget">
            <div class="usertitle">个人资料</div>
            <div class="mycontent">
				<c:if test="${user.email ne 'guest'}">          
                <table class="mytable">
                    <tbody>
                    <%-- <tr>
                        <td class="mytext-left " width="15%"><div class="trhead"><span class="listli"></span><strong>手机号码</strong></div></td>
                        <td class="userinfo" width="30%">手机号是您在“理财么”重要的身份凭证</td>
                        <td class="status  text-center"width="15%">
                            	详细
                        </td>
                        <td class="userinfo "width="30%">${user.}</td>
                        <td class=""width="10%">
                            <a href="/User/BindMobile">验证</a>
                        </td>
                    </tr> --%>
                    <tr>
                        <td class="mytext-left" width="15%"><div class="trhead"><span class="listli"></span><strong>电子邮箱</strong></div></td>
                        <td class="userinfo" width="30%">获取最新的投资讯息和账户信息变动通知</td>
                        <td class="status text-center" width="15%">详细</td>
                        <td class="userinfo" width="30%">${user.email}</td>
                        <td width="10%">已验证</td>
                    </tr>
                    <tr>
                        <td class="mytext-left"><div class="trhead"><span class="listli"></span><strong>用户昵称</strong></div></td>
                        <td class="userinfo">用户昵称是您在“理财么”的一个代号</td>
                        <td class="status text-center">详细</td>
                        <td class="userinfo">${user.nickName==null?'(未填写)':user.nickName}</td>
                        <td><a >继续</a></td>
                    </tr>
                    <tr>
                        <td class="mytext-left"><div class="trhead"><span class="listli"></span><strong>创建时间</strong></div></td>
                        <!-- <td class="text-left desc"><small class="muted">用户创建时间</small></td> -->
                        <td class="userinfo">用户创建时间</td>
                        <td class="status text-center">详细</td>
                        <td class="userinfo"><fmt:formatDate  value="${user.createTime}" type="both" pattern="yyyy.MM.dd HH:mm:ss" /></td>
                        <td>已创建</td>
                    </tr>
                    </tbody>
                </table>
                </c:if> 
                <c:if test="${user.email eq 'guest'}">
                   	您还没有登录“理财么”哟！
                </c:if>
            </div>
        </div>
        <div class="span3">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3>今日理财</h3>
                    <span><a title="查看详情" href="#"><i class="icon-list"></i></a></span>
                </div>
                <div class="widget-content">
                    <table class="table">
                        <thead>
                        <tr>
                            <th style="width:100px;">银行</th>
                            <th style="width: 235px;">产品名称</th>
                            <th style="text-align: center;width: 88px;">投资周期</th>
                            <th style="text-align: center;">收益</th>
                            <th style="text-align: center;">收益类型</th>
                            <th style="text-align: center;">风险</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="product" items="${onSaleTopList}" varStatus="index">
                         <tr>
                            <td class="tablebodytd1">${product.companyName}</td>
                            <td class="tablebodytdname"><a href="${_contextPath}/detail-${product.id}.htm">${product.productName}</a></td>
                            <td class="tablebodytd">${product.days}天</td>
                            <td class="tablebodytd">${product.income}%</td>
                            <td class="tablebodytd"><a href="${_contextPath}/detail-${product.id}.htm">${lcProduct.incomeType==null?'查看详情':lcProduct.incomeType}</a></td>
                            <td class="tablebodytd"><a href="${_contextPath}/detail-${product.id}.htm">${lcProduct.fengxian==null?'查看详情':lcProduct.fengxian}</a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<!--end: Sub-nav -->
        <div id="sink-footer"></div>