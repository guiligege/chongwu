<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>
<div class="container">
		<div class="left">
			<c:forEach var="product" items="${bList}" varStatus="index">
				<div style="position: relative;" class="project-summary wall">
				            <div class="row-fluid">
				        <div class="span7 ">
				            <div style="min-height: 75px;">
				                <h4 style="margin-bottom:10px; line-height:18px;padding-top:5px;">
				                	<i style="display: block; position: absolute; background: url(&quot;${pageContext.request.contextPath}/img/bankicon/tongjitupian.png&quot;) no-repeat scroll 0px 0px / 20px auto transparent; width: 20px; height: 20px;"></i>
				                    <a href="${_contextPath}/tjdetail-${product.id}.htm" target="_blank" style="display: block; text-indent: 20px;margin-left: 5px;">
				                    	<%-- ${product.productName} --%>
				                    	${fn:replace(product.title, "人民币", "")}
				                    </a>
				                </h4>
				                <p class="project-tags">
				                    <span class="tag">
				                        <!-- <i class="icon-retweet"></i> -->
				                     		银行理财
				                    </span>
									<span class="tag">
			                            <!-- <i class="icon-certificate"></i> -->
			                            	个人理财
			                        </span>
									<span class="tag">
									<!-- <i class="icon-time"></i> -->
									自助理财
									</span>
									<span class="tag">
									<!-- <i class="icon-time"></i> -->
									理财统计
									</span>
				                </p>
				            </div>
				            <div class="row-fluid">
				                <div class="span12">
				                   <%--  <div style="margin-right: 10px;margin-left:20px;" class="pull-left">
										<a href="${_contextPath}/detail-${product.id}.htm" target="_blank" class="btn btn-large btn-details">查看详情</a>                    
									</div> --%>
				                    <div class="pull-left">
				                                <div class="project-progress1">
				                                <div class="divheight"><span class="listli"></span><span class="leftspan">在售高利率Top产品:</span>
					                                <span class="rightspan">
					                                <c:forEach var="saletop" begin="0" end="2" items="${product.saletopList}" varStatus="index">
				                                		<div> ${saletop.companyName}-<a href="${_contextPath}/detail-${saletop.id}.htm" target="_blank">${saletop.productName}</a>-<span class="tongjiincome">${saletop.income}%</span>，</div>
				                                	</c:forEach>
					                                ...</span>
				                                </div>
				                                <div class="divheight"><span class="listli"></span><span class="leftspan">在售稳健Top产品:</span>
					                                <span class="rightspan">
					                                	<c:forEach var="saletop" begin="0" end="2" items="${product.saleriskList}" varStatus="index">
					                                		<div> ${saletop.companyName}-<a href="${_contextPath}/detail-${saletop.id}.htm" target="_blank">${saletop.productName}</a>-<span class="tongjiincome">${saletop.income}%</span>，</div>
					                                	</c:forEach>
					                                ...</span>
					                            </div>
					                            <div class="divheight"><span class="listli"></span><span class="leftspan">最新理财产品:</span>
				                                	<span class="rightspan">
				                                	<c:forEach var="saletop" begin="0" end="2" items="${product.newlicaiList}" varStatus="index">
				                                		<div> ${saletop.companyName}-<a href="${_contextPath}/detail-${saletop.id}.htm" target="_blank">${saletop.productName}</a>-<span class="tongjiincome">${saletop.income}%</span>，</div>
				                                	</c:forEach>
				                                	...
				                                	</span>
				                                </div>
				                                <!-- <div class="divheight"><span class="listli"></span><span class="leftspan">待发售高利率Top产品:</span><span class="rightspan">股票指数表现联动（沪深300指数期末双向连续型带触碰条款）,股票指数表现联动（沪深300指数期末双向连续型带触碰条款）,股票指数表现联动（沪深300指数期末双向连续型带触碰条款）...</span></div>
				                                <div class="divheight"><span class="listli"></span><span class="leftspan">待发售稳健Top产品:</span><span class="rightspan">股票指数表现联动（沪深300指数期末双向连续型带触碰条款）,股票指数表现联动（沪深300指数期末双向连续型带触碰条款）,股票指数表现联动（沪深300指数期末双向连续型带触碰条款）...</span></div> -->
				                                </div>
				                    </div>
				                </div>
				            </div>
				        </div>
				    </div>
				</div>
			</c:forEach>
		    <jsp:include page="/views/commons/page.jsp"></jsp:include>
		</div>
		<div class="right post-thumbnail">
			<!-- <section>
		        <a class="more" href="#">更多</a>
		        <h3>媒体报道</h3>
		        <ul>
	                <li><a target="_blank" href="http://www.gzmama.com/thread-3443921-1-1.html">十年理财经验调研各大银行理财产品利率</a></li>
	                <li><a target="_blank" href="http://www.yinhang123.net/wangdian/licaichanpin/2014/0623/25422.html">6月23日宝宝军团收益排名</a></li>
		        </ul>
		    </section> -->
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
		    </div>
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
