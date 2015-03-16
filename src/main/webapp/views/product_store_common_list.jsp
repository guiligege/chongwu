<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 
<div class="products_list products_slider">
    <h2 class="sub_title">相关店铺</h2>
    <div style="position:absolute;right:0;top:27px;">
    	<a style=" font-size: 15px; color:#f38256; font-weight:bold;" href="${_contextPath}/sps----1.htm"  target="_blank">所有店铺查询</a> 
    </div>
    <ul class="productlist">
    	<c:forEach var="product" items="${bList}" varStatus="index">
	        <li> <a class="product_image" href="${_contextPath}/s-${product.storeId}----1.htm" target="_blank"><img data-original="${product.goodsImage}" alt="${product.productName}" title="${product.productName}"/></a>
	            <div class="product_info">
	            	<c:if test="${product.salePrice==product.price}">
		            	<small>
							  ￥<c:out value="${product.salePrice}" />  
		            	</small> 
	            	</c:if>
	            	<c:if test="${product.salePrice!=product.price}">
		            	<small>
							  ￥<c:out value="${product.salePrice}" />  
							  &nbsp;&nbsp;<em>${product.price}</em>
		            	</small> 
	            	</c:if>
	            	<h3>
		                <a href="${_contextPath}/s-${product.storeId}----1.htm" target="_blank">
		                	<c:choose>  
							    <c:when test="${fn:length(product.productName) > 40}">  
							        <c:out value="${fn:substring(product.productName, 0, 40)}..." />  
							    </c:when>
							    <c:when test="${fn:length(product.productName) <=23}">  
							       <c:out value="${product.productName}" />
							       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							   	</c:when>  
							    <c:otherwise>
							      	<c:out value="${product.productName}" />  
							    </c:otherwise>  
							</c:choose>
		                </a>
		                <c:if test="${product.productStore !=null}">
		                	<a href="${_contextPath}/s-${product.storeId}----1.htm" class="pc-name" target="_blank">${product.productStore}</a>
		                </c:if>
	                </h3>	            	
	            	<p>
	            		<span>月成交&nbsp;<em>大于${product.goodsSellCount}笔</em></span>
	            		<span>评价&nbsp;<em>${product.pingjia}</em></span>
	            	</p>
	            </div>
	        </li>
        </c:forEach> 
    </ul>
    <jsp:include page="/views/commons/page.jsp"></jsp:include>
</div>

