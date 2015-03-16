<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>
<div class="container">
		<div class="left">
			<div class="well">
				<ul class="nav nav-pills">
                    <li class="disabled">
                       <a href="${_contextPath}/lc.htm">所有理财产品</a>
                    </li>
                </ul>
				<ul class="nav nav-pills" style="margin-left: 80px; position: relative;">
                    <li class="disabled" style="position: absolute; left: -80px;">
                        <a href="#">发行银行</a>
                    </li>
                    <li class="${empty pageParam.yinhang ?'active':''}"><a href="${_contextPath}/lc--${pageParam.income}-${pageParam.saleTypeId}-${pageParam.days}-${pageParam.orderType}-1.htm">全部</a></li>
                    <%-- <li class="${pageParam.yinhang eq '中信银行'?'active':''}"><a href="${_contextPath}/lc-${shopencode:filterUrlTag('中信银行')}-${pageParam.income}-${pageParam.saleTypeId}-${pageParam.days}-${pageParam.orderType}-1.htm">中信银行</a></li> --%>
                    <c:forEach items="${lcProductYinHangList }" var="lcProductYinHang">
                    	<li class="${pageParam.yinhang eq lcProductYinHang.id ?'active':''}"><a href="${_contextPath}/lc-${lcProductYinHang.id}-${pageParam.income}-${pageParam.saleTypeId}-${pageParam.days}-${pageParam.orderType}-1.htm">${lcProductYinHang.name}</a></li>
                    </c:forEach>
                    <%-- <li class="${pageParam.yinhang eq '重庆银行'?'active':''}"><a href="${_contextPath}/lc-${shopencode:filterUrlTag('重庆银行')}-${pageParam.income}-${pageParam.saleTypeId}-${pageParam.days}-${pageParam.orderType}-1.htm">重庆银行</a></li> --%>
                </ul>
                <ul class="nav nav-pills">
                    <li class="disabled">
                       <a href="#">预期收益</a>
                    </li>
                    <li class="${empty pageParam.income ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}--${pageParam.saleTypeId}-${pageParam.days}-${pageParam.orderType}-1.htm">全部</a></li>
                    <li class="${pageParam.income==2.0 ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-2.0-${pageParam.saleTypeId}-${pageParam.days}-${pageParam.orderType}-1.htm">0-3%</a></li>
                    <li class="${pageParam.income==4.0 ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-4.0-${pageParam.saleTypeId}-${pageParam.days}-${pageParam.orderType}-1.htm">3-6%</a></li>
                    <li class="${pageParam.income==7.0 ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-7.0-${pageParam.saleTypeId}-${pageParam.days}-${pageParam.orderType}-1.htm">大于6%</a></li>
                    <li class="${pageParam.income==9.0 ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-9.0-${pageParam.saleTypeId}-${pageParam.days}-${pageParam.orderType}-1.htm">大于8%</a></li>
                </ul>
                <ul class="nav nav-pills">
                    <li class="disabled">
                        <a href="#">理财期限</a>
                    </li>
                    <li class="${empty pageParam.days ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleTypeId}--${pageParam.orderType}-1.htm">全部</a></li>
                    <li class="${pageParam.days==90 ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleTypeId}-90-${pageParam.orderType}-1.htm">3 个月以下</a></li>
                    <li class="${pageParam.days==120 ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleTypeId}-120-${pageParam.orderType}-1.htm">3-6 个月</a></li>
                    <li class="${pageParam.days==200 ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleTypeId}-200-${pageParam.orderType}-1.htm">6-9 个月</a></li>
                    <li class="${pageParam.days==300 ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleTypeId}-300-${pageParam.orderType}-1.htm">9-12 个月</a></li>
                    <li class="${pageParam.days==365 ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleTypeId}-365-${pageParam.orderType}-1.htm">12 个月以上</a></li>
                </ul>
                <ul class="nav nav-pills">
                    <li class="disabled">
                        <a href="#">发售状态</a>
                    </li>
                    <li class="${empty pageParam.saleTypeId ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}--${pageParam.days}-${pageParam.orderType}-1.htm">全部</a></li>
                    <li class="${pageParam.saleTypeId eq '0' ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-0-${pageParam.days}-${pageParam.orderType}-1.htm">在售</a></li>
                    <li class="${pageParam.saleTypeId eq '1' ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-1-${pageParam.days}-${pageParam.orderType}-1.htm">待售</a></li>
                    <li class="${pageParam.saleTypeId eq '2' ?'active':''}"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-2-${pageParam.days}-${pageParam.orderType}-1.htm">已完结</a></li>
                </ul>
            </div>
            <div  class="well" style="padding-left: 0px; margin-bottom: 5px; border: medium none; background-color: transparent; padding-bottom: 0px;">
                <!-- 产品排序 -->
                <ul class="nav nav-pills">
                    <li class="disabled">
                        <a href="javascript:void(0);">产品排序</a>
                    </li>
                    <c:if test="${pageParam.orderType eq '1'}">
                    	<li class="active"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleType}-${pageParam.days}-1-1.htm">预期收益</a></li>
                    </c:if>
                    <c:if test="${pageParam.orderType ne '1'}">
                    	<li ><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleType}-${pageParam.days}-1-1.htm">预期收益</a></li>
                    </c:if>
                    <c:if test="${pageParam.orderType eq '0'}">
                    	<li class="active"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleType}-${pageParam.days}-0-1.htm">理财银行</a></li>
                    </c:if>
                    <c:if test="${pageParam.orderType ne '0'}">
                    	<li ><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleType}-${pageParam.days}-0-1.htm">理财银行</a></li>
                    </c:if>
                    <c:if test="${pageParam.orderType eq '2'}">
                    	<li class="active"><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleType}-${pageParam.days}-2-1.htm">投资期限</a></li>
                    </c:if>
                    <c:if test="${pageParam.orderType ne '2'}">
                    	<li ><a href="${_contextPath}/lc-${pageParam.yinhang}-${pageParam.income}-${pageParam.saleType}-${pageParam.days}-2-1.htm">投资期限</a></li>
                    </c:if>
                </ul>
            </div>
			<c:forEach var="product" items="${bList}" varStatus="index">
				<div style="position: relative;" class="project-summary wall">
				            <div class="row-fluid">
				        <div class="span8 ">
				            <div style="min-height: 75px;">
				                <h4 style="margin-bottom:10px; line-height:18px;padding-top:5px;">
				                <i style="display: block; position: absolute; background: url(&quot;${pageContext.request.contextPath}/img/bankicon/${product.englishName}.png&quot;) no-repeat scroll 0px 0px / 20px auto transparent; width: 20px; height: 20px;"></i>
				                    <a href="${_contextPath}/detail-${product.id}.htm" style="display: block; text-indent: 20px;margin-left: 5px;">
				                    	<%-- ${product.productName} --%>
				                    	${fn:replace(product.productName, "人民币", "")}
				                    </a>
				                </h4>
				                <p class="project-tags">
				                		 <span class="label label-success">
					                		 <c:if test="${product.saleType eq '已售完'}">
					                		 	已完结
					                		 </c:if>
					                		 <c:if test="${product.saleType ne '已售完'}">
					                		 	${product.saleType}
					                		 </c:if>
				                		 </span>
				                	<%-- </c:if> --%>
				                    <span class="tag">
				                        <i class="icon-retweet"></i>
				                      ${product.companyName}
				                    </span>
									<span class="tag">
			                            <i class="icon-certificate"></i>
			                            	银行理财
			                        </span>
									<span class="tag"><i class="icon-time"></i>定时标</span>
				                </p>
				            </div>
				            <div class="row-fluid">
				                <div class="span12">
				                    <div style="margin-right: 10px;margin-left:20px;" class="pull-left">
										<a href="${_contextPath}/detail-${product.id}.htm" target="_blank" class="btn btn-large btn-details">查看详情</a>                    
									</div>
				                    <div class="pull-left">
				                            <div class="project-progress">
				                                    <div class="progress progress-striped active">
				                                        <div style="width: ${product.timePercent}%;" class="bar"></div>
				                                    </div>
				                            </div>
				                                <p class="project-progress-desc">开始时间：<fmt:formatDate value="${product.startTime}" type="both" pattern="yyyy-MM-dd"/><span class="important">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间：</span> <fmt:formatDate value="${product.endTime}" type="both" pattern="yyyy-MM-dd"/></p>
				                    </div>
				                </div>
				            </div>
				        </div>
				        <div class="span4">
				            <ul class="project-summary-items">
				            	<%-- <c:if test="${product.costMoney >0}"> --%>
					                <li><span class="title">起购金额</span>
					                 <c:if test="${product.costMoney==0}">
					                 	<span  class="important">
					                     <a href="${_contextPath}/detail-${product.id}.htm" >
					                    	点击查看
					                     </a>
					                    </span>
					                 </c:if>
					                 <c:if test="${product.costMoney!=0}">
						               <c:if test="${product.costMoney<1000}">
						               ${product.costMoney*10000}
						               </c:if>
						               <c:if test="${product.costMoney>1000}">
						               ${product.costMoney}
						               </c:if>
						               	元
						             </c:if>
					               	</li>
				               	<%-- </c:if> --%>
				                <li>
				                    <span class="title">年化收益</span>
				                    <c:if test="${product.income==0}">
				                    <span class="important">
				                     <a href="${_contextPath}/detail-${product.id}.htm" >
				                    	点击查看
				                     </a>
				                    </span>
				                    </c:if>
				                    <c:if test="${product.income!=0}">
				                    <span class="important data-tips">
				                    	${product.income}%
				                            <i class="icon-info-sign icon-gray"></i>
				                    </span>
				                    </c:if>
				                </li>
				                <li>
				                    <span class="title">投资期限</span>
				                    <span class="data-tips">
				                        ${product.days}
				                        <i class="icon-info-sign icon-gray"></i>
				                    </span>
				                </li>
				                <li><span class="title">剩余时间</span>${product.endTime==null?'':product.remainTime}</li>
				            </ul>
				        </div>
				    </div>
				</div>
			</c:forEach>
		    <jsp:include page="/views/commons/page.jsp"></jsp:include>
		</div>
		<div class="right post-thumbnail">
			<section>
		        <a class="more" href="#">更多</a>
		        <h3>媒体报道</h3>
		        <ul>
	                <li><a target="_blank" href="http://www.gzmama.com/thread-3443921-1-1.html">十年理财经验调研各大银行理财产品利率</a></li>
	                <li><a target="_blank" href="http://www.yinhang123.net/wangdian/licaichanpin/2014/0623/25422.html">6月23日宝宝军团收益排名</a></li>
		        </ul>
		    </section>
		    <hr>
		    <div>
		    <!-- 百度广告 -->
		    <script type="text/javascript">
			    /*300*250 创建于 2014-07-29*/
			    var cpro_id = "u1636420";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div>
		    
		    <div>
		    <!-- tanx广告 -->
		    <script type="text/javascript">
			     document.write('<a style="display:none!important" id="tanx-a-mm_48124372_7062997_23960588"></a>');
			     tanx_s = document.createElement("script");
			     tanx_s.type = "text/javascript";
			     tanx_s.charset = "gbk";
			     tanx_s.id = "tanx-s-mm_48124372_7062997_23960588";
			     tanx_s.async = true;
			     tanx_s.src = "http://p.tanx.com/ex?i=mm_48124372_7062997_23960588";
			     tanx_h = document.getElementsByTagName("head")[0];
			     if(tanx_h)tanx_h.insertBefore(tanx_s,tanx_h.firstChild);
			</script> 
			<!-- sogou -->
		    </div>
		    <!-- 淘宝组件 -->
		    <div>
		    <!-- 百度广告 -->
		    <script type="text/javascript">
			    /*300*250 创建于 2014-07-29*/
			    var cpro_id = "u1636443";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div>
		</div>
	</div>
<!-- 加入百度分享 -->
	<script>window._bd_share_config={"common":{"bdSnsKey":{"tsina":"4149632123","tqq":"801527859"},"bdText":"","bdMini":"1","bdMiniList":["qzone","tsina","weixin","tqq","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"24"},"slide":{"type":"slide","bdImg":"6","bdPos":"right","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>