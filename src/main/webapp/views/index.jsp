<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>我买么 - 一个商家活动汇集的地方 - A place where business activities are concentrated in China</title>
		<!--start seo -->
		<meta name="description" content="我买么是一个商家活动，折扣汇集的地方。我们不卖东西，我们只告诉你哪里有好东西，欢迎您有空多来看看，也许某一瞬间您就能找到自己喜欢的东西,我们每天为您提供经过甄选的国内购物活动信息和折扣商品信息，涵盖国内优质B2C平台和商家,以及品牌官方网站，如果您发现了优质的商家优惠信息和好的折扣商品，不妨来分享给大家吧。"/>
		<meta name="keywords" content="我买么,买么,折扣,活动,打折信息,打折,折扣信息,优惠信息,优惠券,促销打折,优质折扣,官网购物,官方商城购物,天猫折扣,京东折扣,官方商城折扣,京东活动,天猫活动,官方商城活动,推荐商品"/>
		<!-- end seo -->
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<link rel="stylesheet" href="${domain_css}/css/styles.css?${version_css}" />
	</head>
	<body>
	<div class="wrapper">
	    <jsp:include page="/views/commons/header_content.jsp"></jsp:include>    
	    <div class="section_container">
	        <div class="section">
	           <jsp:include page="/views/banners.jsp"></jsp:include>
	           <jsp:include page="/views/content.jsp"></jsp:include>
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
		
		//lazyload
		$('img[data-original]').lazyLoad({
				defaultImage: '../img/o_loading.gif'
				, parents: 'li'
				, timeout: 500
		});
	</script>
</html>