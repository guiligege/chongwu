<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		    <div class="section_container" style="width:980px;margin:0px auto;">
		        <section>
		            <div id="banner_section" class="content">
		                <div class="left_main">
		                <form  id="saveExform" action="${pageContext.request.contextPath}/ex/saveEx.htm"  method="post">
							<div class="titleBox"><h1>我要分享</h1></div>
		                    <div class="wantItem">
		                        <div class="titleItem">
		                            	标题：
		                        </div>
		                        <div class="perDataItem">
		                            <input type="text" class="inputBox lfloat text-empty text" value="请填写购物经验标题" id="title" name="title" autocomplete="off"/>
		                        </div>
		                        <div class="clear"></div>
		                        <span id="titleError"  class="layerError" style="display: none;">请填写小于300字购物经验标题</span>
		                    </div>
		                    <div class="wantItem">
		                        <div class="titleItem">
		                            <span class="red">*</span>购物经验：
		                        </div>
		                        <div class="perDataItem">
		                            <textarea style="height:126px;" id="content" name="content" class="textareaBox text-empty text" autocomplete="off"></textarea>
		                            <span class="grey">购物经验力求做到全部原创，严谨丰富，条理清晰，信息量大。</span>
		                        </div>
		                        <div class="clear"></div>
		                        <span id="contentError"  class="layerError" style="display: none;">请于此处填写小于1000字购物经验</span>
		                    </div>
		                    <div style="padding-top:60px;" class="wantItem">
		                        <div class="titleItem"><span></span></div>
		                        <div style="padding-right:40px; width:503px;" class="perDataItem">
		                            <input type="button" value="提交分享" class="submitBtn2" onclick="document.getElementById('submit_confirm').style.display=none" id="submit_confirm" />
		                            <span class="red"></span>
		                        </div>
		                        <div class="clear"></div>
		                    </div>
		                    <c:if test="${storeId==0}">
			                    <input type="hidden" value="通用购物经验" id="productStore" name="productStore" />
								<input type="hidden" value="0" id="storeId" name="storeId"/>
							</c:if>
							<c:if test="${storeId!=0}">
			                    <input type="hidden" value="${productStore}" id="productStore" name="productStore" />
								<input type="hidden" value="${storeId}" id="storeId" name="storeId"/>
							</c:if>
		                    </form>
		                </div>
		                <div class="right">
		                    <div class="rightBox">
		                        <div class="titleStyle"><h2>欢迎！</h2></div>
		                        <p class="info">我买么是一个商家活动、折扣汇集的<span class="red">购物产品分享平台。</span></p>
		                        <p class="info noMbSpace">如果您发现了优质的商家折扣或者优质的商家活动，可以通过本页面向我们分享。</p>   
		                    </div>
		                    <div class="rightBox">
		                        <div class="titleStyle"><h2>什么是优质分享？</h2></div>
		                        <ol class="olInfo">
		                            <li>1、优秀品牌，打折促销品牌，正品全网最低价；</li>
		                            <li>2、推荐理由丰满，内容丰富，吸引人；</li>
		                            <li class="noMbSpace">3、可以接受商家推荐商品，但是必须是特价商品或者活动商品，那种先升价再打折的商品我们一律拒绝通过审核。</li>
		                        </ol>
		                    </div>
		                    <div class="blPicBox">
		                        <a href="http://www.womaime.com/feedback"><img src="${domain_image}/img/blPic.png" alt="" /></a>
		                    </div>
		                </div>
		            </div>
		        </section>
		    </div>
	    	<jsp:include page="/views/commons/footer.jsp"></jsp:include>
		    </div>
	</body>
	<!--Javascript-->
		<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
		<script type="text/javascript">
		$(function() {
			 //提交分享
			 $("#submit_confirm").click(function(){
				 if(validate()==false){
					 return;
				 }
				 $("#saveExform").submit();
			 });
			 
			 $("#title").focus(function(){
					if($("#title").val()=='请填写购物经验标题'){
						$("#title").val('');
					}
			 });
			 $("#title").blur(function(){
					if($("#title").val()==''){
						$("#title").val('请填写购物经验标题');
					}
			 });
	    }); 
		//验证信息
		function validate(){
			var flag=true;
			//验证评论数量和销量正则
			if($("#title").val()=='请填写购物经验标题' || $("#title").val()=='' ||$("#title").val().trim()=='' ||$("#title").val().length>300){
				$("#titleError").show();
				flag=false;
			}
			if($("#content").val()=='' || $("#content").val().trim()=='' ||$("#content").val().length>1000){
				$("#contentError").show();
				flag=false;
			}
			return flag;
		}
	</script>
</html>