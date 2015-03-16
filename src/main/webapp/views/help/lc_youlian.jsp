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
		<div style="width: 1100px; margin: 50px auto 0px;padding-bottom: 50px;">
		        <div class="section">
		        <p class="helpp1" style=" font-size: 15px;font-weight: bold;">友情链接-理财么网（<a href="licaime.com">licaime.com</a>）</p>
		        <br></br>
		        <p  class="helpp1"> 若有任何问题，请通过以下途径联系我们：（<a href="http://www.licaime.com" target="_blank">www.licaime.com</a>）,</p>
				<p  class="helpp"><a href="http://www.converse.com.cn">converse官方商城</a></p>
				<p  class="helpp"><a href="http://www.yqkxh.com">一起看笑话</a></p>
				<p  class="helpp">期待您的友链....</p>
				<p class="helpp1">同时理财么提醒理财者们：理财有风险，投资需谨慎!</p>
		        </div>
		</div>
		<jsp:include page="/views/commons/licai_footer.jsp"></jsp:include>
	</body>
	<!--Javascript-->
	<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
</html>