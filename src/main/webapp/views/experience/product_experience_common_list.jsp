<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="products_list products_slider">
    <h2 class="sub_title">${productstore}-经验分享</h2>
	<div class="link">
		当前位置： <a href="${_contextPath}/index.htm">首页 </a> >><a href="${_contextPath}/ex/jybr-1.htm">所有商家经验分享</a> >> <a href="">${productstore}</a>
	</div>
	<div class="sharediv" style="margin-left:707px;"><a href="${_contextPath}/ex/shareEx.htm?storeId=${shopStore.id}">分享${shopStore.storeName}经验</a></div>
    <ul class="productlist share" style="margin-top:30px;">
    	<c:forEach var="product" items="${bList}" varStatus="index">
	        <li> 
	            <div class="product_info">
	            	<h3>
	            		<a href="${_contextPath}/ex/jyxx-${product.id}.htm" target="_blank" style="margin-bottom:10px;">
							${product.title}
		                </a>
	                </h3>
	                 <a>
		                	&nbsp;&nbsp;&nbsp;&nbsp;
		             <c:if test="${fn:length(product.content) > 100}">
							   <c:out value="${fn:substring(product.content, 0, 100)}..." />  
					 </c:if>
					 <c:if test="${fn:length(product.content) <= 100}">
					 	${product.content}
					 </c:if>	
		             </a>            	
	            </div>
	        </li>
        </c:forEach> 
    </ul>
    <jsp:include page="/views/commons/page.jsp"></jsp:include>
</div>

