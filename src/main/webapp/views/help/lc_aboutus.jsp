<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="shortcut icon">
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<link rel="stylesheet" href="${domain_css}/css/licai/style.css?${version_css}" />
	</head>
	<body>
		<jsp:include page="/views/commons/licai_header_content_new.jsp"></jsp:include> 
		<div style="width: 1100px; margin: 50px auto 0px;">
		        <div class="section">
		        <p class="helpp1" style=" font-size: 15px;font-weight: bold;">关于理财么网（licaime.com）</p>
		        <br></br>
				<p  class="helpp1"> 理财么网（licaime.com）是一个自助理财平台，是一个中立的，致力于帮助广大网友买到更有性价比理财产品的理财平台（<a href="http://www.licaime.com" target="_blank">www.licaime.com</a>）,</p>
				<p  class="helpp1">“理财么”是一个自助理财平台，其致力于帮助广大网友买到更有性价比的理财产品。</p>
				<p  class="helpp1">网站每天通过抓取各大银行和金融机构的理财产品为广大网友提供最新最全的理财产品。</p>
				<p  class="helpp1">目前收录的主要理财产品包括：</p>
				<p  class="helpp">中国工商银行</p>
				<p  class="helpp">中国农业银行</p>
				<p  class="helpp">中国建设银行</p>
				<p  class="helpp">中国银行</p>
				<p  class="helpp">交通银行</p>
				<p  class="helpp">招商银行</p>
				<p  class="helpp">中国民生银行</p>
				<p  class="helpp">浦发银行</p>
				<p  class="helpp">中国光大银行</p>
				<p  class="helpp">平安银行</p>
				<p  class="helpp">兴业银行</p>
				<p  class="helpp">中信银行</p>
				<p  class="helpp">重庆银行</p>
				<p  class="helpp1">理财么希望每个人都买到收益最高，理财风险最低，最稳定的理财产品，同时理财么希望通过我们的努力能减少您选择理财产品过程中花费的时间和精力，和更理性的选择理财产品。</p>
				<p class="helpp1">同时理财么提醒理财者们：理财有风险，投资需谨慎!</p>
				<!-- <p  class="helpp1">欢迎对本网站提意见和建议！</p> -->
		        </div>
		</div>
		<jsp:include page="/views/commons/licai_footer.jsp"></jsp:include>
	</body>
	<!--Javascript-->
	<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
</html>