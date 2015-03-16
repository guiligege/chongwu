<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="shortcut icon">
		<title>理财么-自助理财平台，发现，分享好的理财产品，分享理财经验，让财富增长从理财开始。</title>
		<meta name="keywords" content="理财么,理财,自助理财,理财产品,银行理财,银行理财产品,互联网理财,互联网理财产品,理财知识,理财经验,互联网理财产品排行榜" />
		<meta name="description" content="理财么是自助理财平台，我们的提供互联网上能查到的各种银行的理财产品供大家选择适合自己的理财产品，" />
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<%@include file="/views/commons/cssandscript.jsp" %>
		<link rel="stylesheet" href="${domain_css}/css/licai/style.css?${version_css}" />
		<script type="text/javascript">
			//验证
			function validate(){
				$("#emailinfo1").removeClass("error");
				$("#emailinfo").removeClass("error");
				$("#passwordAgaininfo").removeClass("error");
				$("#passwordinfo").removeClass("error");
				$("#validateNuminfo").removeClass("error");
				
				var email=$("#oldpassword").val();
				//var nickName=$("#nickName").val();
				var password=$("#password").val();
				var passwordAgain=$("#passwordAgain").val();
				var validateNum=$("#validateNum").val();
				//是邮箱
				if(email=='')){
					$("#emailinfo").addClass("error");
					return false;
				}
				//密码相同
				if(password != passwordAgain){
					$("#passwordAgaininfo").addClass("error");
					return false;
				}
				//验证码
				if(validateNum==''){
					$("#validateNuminfo").addClass("error");
					return false;
				}
				return true;
			}
			//邮箱验证
			function checkEmail(str) {
				 var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/
				 return re.test(str);
			}
			//注册
			function update(){
				//验证各种信息
				//alert(validate());
				if(!validate()){
					return;
				}
				$("#login-form").submit()
			}
			//文档加载
		</script>
	</head>
	<body>
		<%@include file="/views/commons/licai_header_content.jsp" %>
		<div style="padding-bottom: 10px;"></div>
		<jsp:include page="update_detail.jsp"></jsp:include>
		<%-- <%@include file="licai_register.jsp" %> --%>
		<jsp:include page="/views/commons/licai_footer.jsp"></jsp:include>
		<div class="none">
			<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F19d3582fea421029f25811115d6cdf0e' type='text/javascript'%3E%3C/script%3E"));
			</script>
		</div>
	</body>
</html>