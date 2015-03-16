<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="products_list products_slider">
    <ul class="productlist share" style="margin-top:30px;">
    	<c:forEach var="store" items="${bList}" varStatus="index">
	        <li> 
	            <div class="product_info">
	            	<h3>
	            		<a href="${_contextPath}/ex/jylb-${store.id}--1.htm" target="_blank" style="margin-bottom:10px;">
							<c:out value="${store.storeName}" />经验专区  
		                </a>
	                </h3>
	                 <a>
		                	&nbsp;&nbsp;&nbsp;&nbsp;这里是${store.storeName}分享的经验专区.包含：${store.storeName}怎么样?${store.storeName}真伪识别?${store.storeName}性价比如何?最近${store.storeName}有哪些优惠活动?
		             </a>            	
	            </div>
	        </li>
        </c:forEach> 
    </ul>
    <jsp:include page="/views/commons/page.jsp"></jsp:include>
</div>

