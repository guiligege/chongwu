<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="products_list products_slider">
	<c:if test="${not empty pageParam.storeId}">
    	<h2 class="sub_title">${productstore}</h2>
    </c:if>
    <div class="link">
		<c:if test="${not empty pageParam.storeId && not empty pageParam.zhekou}">
		 	当前位置： <a href="${_contextPath}/index.htm">首页 </a> >><a href="${_contextPath}/s----${pageParam.categoryId}-1.htm">所有商家</a> >> <a href="${_contextPath}/s-${pageParam.storeId}---${pageParam.categoryId}-1.htm">${productstore}</a>>> ${pageParam.zhekou}折
		</c:if>
		<c:if test="${not empty pageParam.storeId && empty pageParam.zhekou}">
		 	当前位置： <a href="${_contextPath}/index.htm">首页 </a> >><a href="${_contextPath}/s----${pageParam.categoryId}-1.htm">所有商家</a> >> <a href="${_contextPath}/s-${pageParam.storeId}---${pageParam.categoryId}-1.htm">${productstore}</a>
		</c:if>
		<c:if test="${empty pageParam.storeId && not empty pageParam.zhekou}">
		 	当前位置： <a href="${_contextPath}/index.htm">首页 </a>
		</c:if>
	</div>
    <div class="wrapper-w">
    	<a class="first">折扣筛选：</a>
    	<c:if test="${empty pageParam.zhekou}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}--${pageParam.categoryId}-1.htm" class="cur">全部折扣</a>
    	</c:if>
    	<c:if test="${not empty pageParam.zhekou}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}--${pageParam.categoryId}-1.htm" >全部折扣</a>
    	</c:if>
    	<a href="#">全网最低</a>
    	<c:if test="${pageParam.zhekou ==1.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-1-${pageParam.categoryId}-1.htm" class="cur">一折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  !=1.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-1-${pageParam.categoryId}-1.htm">一折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  ==2.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-2-${pageParam.categoryId}-1.htm" class="cur">二折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  !=2.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-2-${pageParam.categoryId}-1.htm">二折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  ==3.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-3-${pageParam.categoryId}-1.htm" class="cur">三折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  !=3.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-3-${pageParam.categoryId}-1.htm">三折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  ==4.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-4-${pageParam.categoryId}-1.htm" class="cur">四折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  !=4.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-4-${pageParam.categoryId}-1.htm">四折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  ==5.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-5-${pageParam.categoryId}-1.htm" class="cur">五折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  !=5.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-5-${pageParam.categoryId}-1.htm">五折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  ==6.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-6-${pageParam.categoryId}-1.htm" class="cur">六折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  !=6.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-6-${pageParam.categoryId}-1.htm">六折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  ==7.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-7-${pageParam.categoryId}-1.htm" class="cur">七折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  !=7.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-7-${pageParam.categoryId}-1.htm">七折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  ==8.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-8-${pageParam.categoryId}-1.htm" class="cur">八折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  !=8.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-8-${pageParam.categoryId}-1.htm">八折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  ==9.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-9-${pageParam.categoryId}-1.htm" class="cur">九折</a>
    	</c:if>
    	<c:if test="${pageParam.zhekou  !=9.0}">
    		<a href="${_contextPath}/s-${pageParam.storeId}-${pageParam.activityId}-9-${pageParam.categoryId}-1.htm">九折</a>
    	</c:if>
    </div>
    <ul class="productlist">
    	<%-- <li> <a class="product_image"><img src="${domain_image}/img/pr_l_1.jpg" /></a>
            <div class="product_info">
                <h3><a href="leisure_detail.html">CN Clogs Beach/Garden Clog</a></h3>
                <small>Comfortable and fun to wear these clogs are the latest trend in fash</small> </div>
            <div class="price_info"> <a href="#">+ Add to wishlist</a>
                <button class="price_add" title="" type="button"><span class="pr_price">$76.00</span><span class="pr_add">Add to Cart</span></button>
            </div>
        </li> --%>
    	<c:forEach var="product" items="${bList}" varStatus="index">
	        <li> 
	        	<a class="product_image" href="${_contextPath}/pd-${product.id}.htm" target="_blank">
	        		<img data-original="${product.goodsImage}" alt="${product.productName}" title="${product.productName}"/>
	        	</a>
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
		                <a href="${_contextPath}/pd-${product.id}.htm" target="_blank">
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

