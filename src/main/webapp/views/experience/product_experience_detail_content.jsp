<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 
 <!-- product detail content -->
 <div class="section_container"> 
    	<h2 class="sub_title">${shoppingExperience.productStore}-经验分享</h2>
    <div class="link">
		<c:if test="${not empty goodProduct.storeId}">
		 	当前位置： <a href="${_contextPath}/index.htm">首页 </a> >><a href="${_contextPath}/s----${pageParam.categoryId}-1.htm">所有商家</a> >> <a href="${_contextPath}/s-${goodProduct.storeId}---${goodProduct.categoryId}-1.htm">${goodProduct.productStore}</a>>>商品详情
		</c:if>
	</div>
    <div class="section">
    <!--PRODUCT DETAIL STARTS-->
    <div id="product_detail"> 
      <div class="product_rightcol" style="margin: 0 200px;width: 590px;"> 
        <h1>${shoppingExperience.title}</h1>
        <div class="product_overview">
        	
          <a>
        		&nbsp;&nbsp;&nbsp;&nbsp;${shoppingExperience.content}
          </a>
          <ul class="experienceUl">
            <li>“我买么”是一个商家活动，折扣汇集的地方。我们不卖东西，我们只告诉你哪里有好东西，欢迎您有空多来看看，也许某一瞬间您就能找到自己喜欢的东西,我们每天为您提供经过甄选的国内购物活动信息和折扣商品信息，涵盖国内优质B2C平台和商家,以及品牌官方网站，如果您发现了优质的商家优惠信息和好的折扣商品，不妨<a href="${_contextPath}/ex/shareEx.htm?storeId=${shoppingExperience.storeId}">点击此处</a>来分享经验给大家吧。</li>
          </ul>
        </div>
      </div>
  </div>
  <div class="products_list products_slider">
    <h2 class="sub_title">相关分享经验</h2>
    <ul class="productlist share" style="margin-top:15px;">
    	<c:forEach var="experience" items="${experienceList}" varStatus="index">
	        <li> 
	            <div class="product_info">
	            	<h3>
	            		<a href="${_contextPath}//ex/jyxx-${experience.id}" target="_blank" style="margin-bottom:10px;">
							${experience.title}
		                </a>
	                </h3>
	                 <a>
		             &nbsp;&nbsp;&nbsp;&nbsp;
		             <c:if test="${fn:length(experience.content) > 130}">
							   <c:out value="${fn:substring(experience.content, 0, 130)}..." />  
					 </c:if>
					 <c:if test="${fn:length(experience.content) <= 130}">
					 	${experience.content}
					 </c:if>	
		             </a>             	
	            </div>
	        </li>
	     </c:forEach>
    </ul>
  </div>
 </div>
</div>
