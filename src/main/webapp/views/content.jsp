<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 
<div class="products_list products_slider">
    <h2 class="sub_title">商家折扣</h2>
    <%-- <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
        <li> <a class="product_image"><img src="${domain_image}/img/pr_l_1.jpg" /></a>
            <div class="product_info">
                <h3><a href="leisure_detail.html">CN Clogs Beach/Garden Clog</a></h3>
                <small>Comfortable and fun to wear these clogs are the latest trend in fash</small> </div>
            <div class="price_info"> <a href="#">+ Add to wishlist</a>
                <button class="price_add" title="" type="button"><span class="pr_price">$76.00</span><span class="pr_add">Add to Cart</span></button>
            </div>
        </li>
    </ul> --%>
    <ul class="productlist">
    	<c:forEach var="product" items="${storeProductList}" varStatus="index">
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
		                <a href="${_contextPath}/s-${product.storeId}----1.htm" class="pc-name" target="_blank">${product.productStore}</a>
	                </h3>	            	
	            	<p>
	            		<span>月成交&nbsp;<em>大于${product.goodsSellCount}笔</em></span>
	            		<span>评价&nbsp;<em>${product.pingjia}</em></span>
	            	</p>
	            </div>
	        </li>
        </c:forEach> 
    </ul>
</div>

<!--Product List Starts-->
<div class="products_list products_slider">
    <h2 class="sub_title">商家活动</h2>
    <%-- <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
        <li> <a class="product_image"><img src="${domain_image}/img/pr_l_1.jpg" /></a>
            <div class="product_info">
                <h3><a href="leisure_detail.html">CN Clogs Beach/Garden Clog</a></h3>
                <small>Comfortable and fun to wear these clogs are the latest trend in fash</small> </div>
            <div class="price_info"> <a href="#">+ Add to wishlist</a>
                <button class="price_add" title="" type="button"><span class="pr_price">$76.00</span><span class="pr_add">Add to Cart</span></button>
            </div>
        </li>
    </ul> --%>
    
    <ul class="productlist">
    	<c:forEach var="product" items="${activityProductList}" varStatus="index">
	        <li> <a class="product_image" href="${_contextPath}/s--${product.storeActivityId}---1.htm" target="_blank"><img data-original="${product.goodsImage}" alt="${product.productName}" title="${product.productName}"/></a>
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
		                <a href="${_contextPath}/s-${product.storeId}----1.htm" class="pc-name" target="_blank">${product.productStore}</a>
	                </h3>	            	
	            	<p>
	            		<span>月成交&nbsp;<em>大于${product.goodsSellCount}笔</em></span>
	            		<span>评价&nbsp;<em>${product.pingjia}</em></span>
	            	</p>
	            </div>
	        </li>
        </c:forEach> 
    </ul>
</div>
<!--Product List Ends-->