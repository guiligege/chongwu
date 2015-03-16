<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>我买么 - 一个商家活动汇集的地方 - A place where business activities are concentrated in China</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!--start seo -->
		<meta name="description" content="我买么是一个中立的、致力于帮助广大网友买到更多更好商家活动的最热门推荐网站，值得您每天都来看看。我们每天为您提供经过甄选的、优质的、超值的国内、海外购物优惠信息，涵盖数码、个护、食品、家居、图书、服饰、母婴、首饰、运动等类别，数十万网友踊跃参与产品点评。如果您发现了好的优惠打折信息，也可通过我们与更多网友分享。"/>
		<meta name="keywords" content="我买么,活动,淘宝活动,天猫活动,网购活动,特价活动,活动,商家促销活动,商家优惠券,活动点评,网友活动点评"/>
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
		        <p class="pclass" style=" font-size: 14px;font-weight: bold;">我买么是一个商家活动，折扣汇集的地方。</p>
				<p style="" class="pclass"> 通过提供内容丰富、人性化的网站（<a href="http://www.womaime.com" target="_blank">www.womaime.com</a>）,</p>
				<p style="" class="pclass">我买么以最有竞争力的价格，提供具有丰富品类及卓越品质的商品。</p>
				<p style="" class="pclass">我买么提供12个大类的丰富商品，品类包括:</p>
				<p style="" class="pclass">&nbsp;&nbsp;&nbsp;&nbsp;服饰鞋包，运动户外，手机数码，家用电器，护肤美妆，办公用品，母婴用品，日用百货，美食特产，家居家纺，图书音像，汽车用品。</p>
				<p style="" class="pclass">我们的信息大部分来自于网友爆料，经过编辑审核后的内容也会得到大量网友的评价，这是一个大家帮助大家的互动社区。</p>
				<p style="" class="pclass">我买么希望每个人都买到最优质廉价的商品，我希望通过我们的努力能减少您网购过程中花费的时间和精力，和更理性的消费。</p>
				<p style="" class="pclass">我们的不足请您多多提意见。！</p>
		        </div>
		    </div>
		    <jsp:include page="/views/commons/footer.jsp"></jsp:include> 
		</div>
	</body>
</html>