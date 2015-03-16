<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<c:if test="${not empty goodProduct.productStore}">
			<title>${goodProduct.productName}_${goodProduct.productStore}-我买么</title>
		</c:if>
		<c:if test="${empty goodProduct.productStore}">
			<title>${goodProduct.productName}-我买么</title>
		</c:if>
		<!--start seo -->
		<c:if test="${not empty goodProduct.productStore}">
			<meta name="keywords" content="${goodProduct.productName},${goodProduct.productName}折扣,${goodProduct.productName}活动,${goodProduct.productName}秒杀,${goodProduct.productName}价格,${goodProduct.productStore}优惠券,${goodProduct.productStore}优质商品" />
		</c:if>
		<c:if test="${empty goodProduct.productStore}">
			<meta name="keywords" content="${goodProduct.productName},${goodProduct.productName}折扣,${goodProduct.productName}活动,${goodProduct.productName}秒杀,${goodProduct.productName}价格" />
		</c:if>
		<meta name="description" content="我买么${goodProduct.productName}频道为您提供${goodProduct.productName}最新优惠商品图片,折扣,活动,优惠券,优质商品等信息,更多${goodProduct.productName}资讯内容尽在我买么"/>
		<!-- end seo -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<link rel="stylesheet" href="${domain_css}/css/styles.css?${version_css}" />
	</head>
	<body>
	<div class="wrapper">
	    <jsp:include page="/views/commons/header_content.jsp"></jsp:include>    
	    <div class="section_container">
	        <div class="section">
	          <%--  <jsp:include page="share.jsp"></jsp:include> --%>
	           <jsp:include page="/views/detail_content.jsp"></jsp:include>
	        </div>
	    </div>
	    <jsp:include page="/views/commons/footer.jsp"></jsp:include> 
	</div>
	</body>
	<!--Javascript-->
	<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
	<script type="text/javascript">
	//瀑布流
	$.Isotope.prototype._getCenteredMasonryColumns = function() {
		this.width = this.element.width();

		var parentWidth = this.element.parent().width();

					  // i.e. options.masonry && options.masonry.columnWidth
		var colW = this.options.masonry && this.options.masonry.columnWidth ||
					  // or use the size of the first item
					  this.$filteredAtoms.outerWidth(true) ||
					  // if there's no items, use size of container
					  parentWidth;

		var cols = Math.floor( parentWidth / colW );
		cols = Math.max( cols, 1 );

		// i.e. this.masonry.cols = ....
		this.masonry.cols = cols;
		// i.e. this.masonry.columnWidth = ...
		this.masonry.columnWidth = colW;
	};

	$.Isotope.prototype._masonryReset = function() {
		// layout-specific props
		this.masonry = {};
		// FIXME shouldn't have to call this again
		this._getCenteredMasonryColumns();
		var i = this.masonry.cols;
		this.masonry.colYs = [];
		while (i--) {
			this.masonry.colYs.push( 0 );
		}
	};

	$.Isotope.prototype._masonryResizeChanged = function() {
		var prevColCount = this.masonry.cols;
		// get updated colCount
		this._getCenteredMasonryColumns();
		return ( this.masonry.cols !== prevColCount );
	};

	$.Isotope.prototype._masonryGetContainerSize = function() {
		var unusedCols = 0,
			i = this.masonry.cols;
		// count unused columns
		while ( --i ) {
			if ( this.masonry.colYs[i] !== 0 ) {
				break;
			}
			unusedCols++;
		}

		return {
			height : Math.max.apply( Math, this.masonry.colYs ),
			// fit container to columns that have been used;
			width : (this.masonry.cols - unusedCols) * this.masonry.columnWidth
		};
	};
	
	$('.productlist').isotope({
		itemSelector : 'li',
		layoutMode: 'masonry'
	}); 
	
	//lazyload
	$('img[data-original]').lazyLoad({
			defaultImage: '../img/o_loading.gif'
			, parents: 'li'
			, timeout: 500
	});
	</script>
</html>