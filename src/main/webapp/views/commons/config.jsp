<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--去除el表达式带来的源代码中的空行 --%>
<%@ page trimDirectiveWhitespaces="true"%>
<c:set var="version_css" value="20130909.00001" scope="application"></c:set>
<c:set var="version_js" value="20130909.00001" scope="application"></c:set>
<script type="text/javascript">
	var domain_css = "${domain_css}";
	var domain_js = "${domain_js}";
	var domain_image = "${domain_image}";
	var _contextPath = "${_contextPath}";
</script>