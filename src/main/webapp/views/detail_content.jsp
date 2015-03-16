<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 
 <!-- product detail content -->
 <div class="section_container"> 
    <c:if test="${not empty goodProduct.storeId}">
    	<h2 class="sub_title">${goodProduct.productStore}</h2>
    </c:if>
    <div class="link">
		<c:if test="${not empty goodProduct.storeId}">
		 	当前位置： <a href="${_contextPath}/index.htm">首页 </a> >><a href="${_contextPath}/s----${pageParam.categoryId}-1.htm">所有商家</a> >> <a href="${_contextPath}/s-${goodProduct.storeId}---${goodProduct.categoryId}-1.htm">${goodProduct.productStore}</a>>>商品详情
		</c:if>
	</div>
    <div class="section">
    <!--PRODUCT DETAIL STARTS-->
    <div id="product_detail"> 
      <!--Product Left Starts-->
      <div class="product_leftcol"> 
      <a href="${_contextPath}/spd-${goodProduct.shortUrl}.htm" target="_blank">
      <img src="${goodProduct.goodsImage}" alt="${goodProduct.productName}" title="${goodProduct.productName}"/> 
      <!-- <span class="pr_info">ROLL OVER IMAGE TO ZOOM</span> -->
       <%--  <ul class="pr_gallery">
          <li><a href="#"><img src="${domain_image}/img/pr_gal1.jpg" /></a></li>
          <li><a href="#"><img src="${domain_image}/img/pr_gal2.jpg" /></a></li>
          <li><a href="#"><img src="${domain_image}/img/pr_gal3.jpg" /></a></li>
        </ul> --%>
        </a>
      </div>
      <!--Product Left Ends--> 
      <!--Product Right Starts-->
      <div class="product_rightcol"> 
      	<!-- <small class="pr_type">Formal Dress</small> -->
        <h1>${goodProduct.productName}</h1>
       <!--  <p class="short_dc" /> Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. -->
        <c:if test="${goodProduct.salePrice==goodProduct.price}">
        	<div class="pr_price"> <big> ￥${goodProduct.salePrice}</big></div>
        </c:if>
        <c:if test="${goodProduct.salePrice!=goodProduct.price}">
        	<div class="pr_price"> <big> ￥${goodProduct.salePrice}</big> <small>￥${goodProduct.price}</small> </div>
        </c:if>
        <div class="size_info">
          <div class="size_sel">
            <label>月销量 :</label>
            <c:if test="${goodProduct.goodsSellCount==0}">
            	<span>请直接到商家查看</span>
            </c:if>
            <c:if test="${goodProduct.goodsSellCount>0}">
            	<span>${goodProduct.goodsSellCount}</span>
            </c:if>
          </div>
          <div class="color_sel">
            <label>累计评价 :</label>
            <c:if test="${goodProduct.pingjia==0}">
            	<span>请直接到商家查看</span>
            </c:if>
            <c:if test="${goodProduct.pingjia>0}">
            	<span>${goodProduct.pingjia}</span>
            </c:if>
          </div>
        </div>
        <div class="qty_info">
          <div class="quantity">
            <label>分享理由 :</label>
             <span>${goodProduct.shareReason}</span>
          </div>
        </div>
        <div class="add_to_buttons">
          <button onclick="window.open('${_contextPath}/spd-${goodProduct.shortUrl}.htm')" class="add_cart">想去看看</button>
          <!-- <a href="#" class="add_cart">想去看看</a> -->
          <!-- <span>or</span>
          <ul>
            <li><a href="#">Add to Wishlist</a></li>
          </ul> -->
        </div>
        <div class="product_overview">
          <ul>
            <li>“我买么”是一个商家活动，折扣汇集的地方。我们不卖东西，我们只告诉你哪里有好东西，欢迎您有空多来看看，也许某一瞬间您就能找到自己喜欢的东西,我们每天为您提供经过甄选的国内购物活动信息和折扣商品信息，涵盖国内优质B2C平台和商家,以及品牌官方网站，如果您发现了优质的商家优惠信息和好的折扣商品，不妨<a href="#">点击此处</a>来分享给大家吧。</li>
            <!-- <li>Front button placket.</li>
            <li>Hem is longer in back.</li> -->
          </ul>
        </div>
      </div>
    <!--Product Right Ends--> 
  </div>
  <!--PRODUCT DETAIL ENDS--> 
  <!--Product List Starts-->
  <div class="products_list products_slider">
    <h2 class="sub_title">你可能会喜欢</h2>
    <ul class="productlist">
    	<c:forEach var="product" items="${goodsRelatedProductList}" varStatus="index">
	        <li> 
	        	<a class="product_image" href="${_contextPath}/pd-${product.id}.htm" target="_blank">
	        		<img src="${product.goodsImage}" alt="${product.productName}" title="${product.productName}"/>
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
  </div>
 </div>
</div>
