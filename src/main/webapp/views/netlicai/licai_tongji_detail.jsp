<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<meta http-equiv="content-type" content="text/html; charset=utf-8">
  	<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="shortcut icon">
  	<!-- 公共setting配置 -->
  	<c:if test="${from eq 'detail'}">
	<title>${fn:replace(lcProduct.productName, "人民币", "")}-${lcProduct.companyName}-理财么</title>
	<meta name="keywords" content="理财么,自助理财,${lcProduct.companyName}理财产品,银行理财,理财产品" />
	<meta name="description" content="理财么-${lcProduct.companyName}-${fn:replace(lcProduct.productName, "人民币", "")}" />
	</c:if>
	<%@include file="/views/commons/config.jsp" %>
	<%@include file="/views/commons/cssandscript.jsp" %>
  	<link rel="stylesheet" type="text/css" href="${domain_css}/css/licai/detail/detail.css?${version_css}">
  	<script type="text/javascript" src="${domain_js}/js/licai/highcharts.js?${version_js}"></script>
  	<script type="text/javascript" src="${domain_js}/js/licai/modules/exporting.js?${version_js}"></script>
  </head>
  <body>
  <jsp:include page="/views/commons/licai_header_content.jsp"></jsp:include> 
		<div style="padding-bottom: 65px;"></div>
        <div class="center">
          <div class="row-fluid">
            <div class="center-left" style="margin-top: 10px;">
              <div class="left-one">
              	<div id="bdshare" style="float: right;margin-top: 5px;" class="bdshare_t bds_tools get-codes-bdshare" data="{'text':'理财么-自助理财平台-${fn:replace(lcProductTongji.title, "人民币", "")}','url':'http://www.licaime.com/tjdetail-${lcProductTongji.id}.htm','pic':'http://www.licaime.com/img/licai/licaime1.png'}">
			        <a class="bds_qzone"></a>
			        <a class="bds_tsina"></a>
			        <a class="bds_tqq"></a>
			        <!--<a class="bds_renren"></a> -->  
			        <span class="bds_more"></span>
			    </div>
                <div class="left-one-huang" style=" float: left; height: 30px; line-height: 30px; position: relative; text-indent: 10px; width: 87px; width:auto; padding-right: 12px;">
                  <%-- <i style="background: url(&quot;${_contextPath}/img/bankicon/${lcProduct.englishName}.png&quot;) no-repeat scroll 0px 0px / 20px auto transparent; width: 20px; height: 20px; position: absolute; top: 50%; display: block; clear: both; margin-top: -9px;"></i> --%>
                  	理财么-自助理财平台
                </div>
                <div class="left-one-title">
                  <h2>${fn:replace(lcProductTongji.title, "人民币", "")}</h2>
                </div>
              </div>
              <div class="left-five" style="padding-bottom:20px;">
              <div class="left-five-info2" style="clear: both;">
                  <!--在售利率最高产品前3-->
                  <c:if test="${lcProductTongji.saletopList!=null}">
                  <hr class="dashed"></hr>
                  <div class="partname"><span class="listli"></span><span>在售高利率银行理财产品top5</span></div>
                  <div >
	              <div class="investmentedList">
	                <div class="investments_area">
	                  <table>
	                    <thead>
	                      <tr>
	                        <th>银行</th>
	                        <th>产品名称</th>
	                        <th>销售状态</th>
	                        <th>投资周期</th>
	                        <th>收益</th>
	                        <th>收益类型</th>
	                      </tr>
	                    </thead>
	                    <tbody>
	                   <c:forEach var="product" items="${lcProductTongji.saletopList}">
		                     <tr>
		                        <td>${product.companyName}</td>
		                        <td><a href="${_contextPath}/detail-${product.id}.htm" target="_blank">${fn:replace(product.productName, "人民币", "")}</a></td>
		                        <td>
			                         <c:if test="${product.saleType eq '已售完'}">
			                		 	已完结
			                		 </c:if>
			                		 <c:if test="${product.saleType ne '已售完'}">
			                		 	${product.saleType}
			                		 </c:if>
		                        </td>
		                        <td>${product.days}天</td>
		                        <td><span class="tongjidetailincome">${product.income}%</span></td>
		                        <td>
		                            <c:if test="${product.incomeType eq 'null'}">
		                             <a href="${_contextPath}/detail-${product.id}.htm"  target="_blank">查看详细</a>
		                            </c:if>
		                            <c:if test="${product.incomeType ne 'null'}">
		                            	${product.incomeType}
		                            </c:if>
		                        </td>
		                     </tr>
	                    </c:forEach>
	                    </tbody>
	                  </table>
	                </div>
	              </div>
	            </div>
	            </c:if>
	            <c:if test="${lcProductTongji.saleriskList!=null}">
                <hr class="dashed"></hr>
                <div class="partname"><span class="listli"></span><span>在售低风险高利率银行理财产品top5</span></div>
	              <div>
	              <div class="investmentedList">
	                <div class="investments_area">
	                  <table>
	                    <thead>
	                      <tr>
	                        <th>银行</th>
	                        <th>产品名称</th>
	                        <th>销售状态</th>
	                        <th>投资周期</th>
	                        <th>收益</th>
	                        <th>收益类型</th>
	                      </tr>
	                    </thead>
	                    <tbody>
	                   <c:forEach var="product" items="${lcProductTongji.saleriskList}">
		                     <tr>
		                        <td>${product.companyName}</td>
		                        <td><a href="${_contextPath}/detail-${product.id}.htm" target="_blank">${fn:replace(product.productName, "人民币", "")}</a></td>
		                        <td>
			                         <c:if test="${product.saleType eq '已售完'}">
			                		 	已完结
			                		 </c:if>
			                		 <c:if test="${product.saleType ne '已售完'}">
			                		 	${product.saleType}
			                		 </c:if>
		                        </td>
		                        <td>${product.days}天</td>
		                        <td><span class="tongjidetailincome">${product.income}%</span></td>
		                        <td>
		                            <c:if test="${product.incomeType eq 'null'}">
		                             <a href="${_contextPath}/detail-${product.id}.htm"  target="_blank">查看详细</a>
		                            </c:if>
		                            <c:if test="${product.incomeType ne 'null'}">
		                            	${product.incomeType}
		                            </c:if>
		                        </td>
		                     </tr>
	                    </c:forEach>
	                    </tbody>
	                  </table>
	                </div>
	              </div>
	            </div>
	            </c:if>
	            <div class="left-five-info2" style="clear: both;">
                     <hr class="dashed">
                    	“理财么”是一个自助理财平台，是一个中立的，致力于帮助广大网友买到更适合自己的理财产品，每天为网友们提供各大银行和金融机构的理财产品,并附上相应机构理财产品说明书，保证数据的真实有效性。理财么网站理财资讯信息绝大部分来自银行和金融结构，经过金融数据搜索并整理展现给大家，这是也是一个大家帮助大家的社区，大家分享理财经验让大家更好的理财，更安全的理财，获得更多的收益。
                </div>
                <c:if test="${lcProductTongji.presaletopList!=null}">
	            <hr class="dashed"></hr>
                <div class="partname"><span class="listli"></span><span>待售高利率银行理财产品top5</span></div>
	              <div>
	              <div class="investmentedList">
	                <div class="investments_area">
	                  <table>
	                    <thead>
	                      <tr>
	                        <th>银行</th>
	                        <th>产品名称</th>
	                        <th>销售状态</th>
	                        <th>投资周期</th>
	                        <th>收益</th>
	                        <th>收益类型</th>
	                      </tr>
	                    </thead>
	                    <tbody>
	                   <c:forEach var="product" items="${lcProductTongji.presaletopList}">
		                     <tr>
		                        <td>${product.companyName}</td>
		                        <td><a href="${_contextPath}/detail-${product.id}.htm" target="_blank">${fn:replace(product.productName, "人民币", "")}</a></td>
		                        <td>
			                         <c:if test="${product.saleType eq '已售完'}">
			                		 	已完结
			                		 </c:if>
			                		 <c:if test="${product.saleType ne '已售完'}">
			                		 	${product.saleType}
			                		 </c:if>
		                        </td>
		                        <td>${product.days}天</td>
		                        <td><span class="tongjidetailincome">${product.income}%</span></td>
		                        <td>
		                            <c:if test="${product.incomeType eq 'null'}">
		                             <a href="${_contextPath}/detail-${product.id}.htm" target="_blank" >查看详细</a>
		                            </c:if>
		                            <c:if test="${product.incomeType ne 'null'}">
		                            	${product.incomeType}
		                            </c:if>
		                        </td>
		                     </tr>
	                    </c:forEach>
	                    </tbody>
	                  </table>
	                </div>
	              </div>
	            </div>
	            </c:if>
	            <c:if test="${lcProductTongji.presaleriskList!=null}">
	            <hr class="dashed">
                <div class="partname"><span class="listli"></span><span>待售低风险高利率银行理财产品top5</span></div>
	              <div>
	              <div class="investmentedList">
	                <div class="investments_area">
	                  <table>
	                    <thead>
	                      <tr>
	                        <th>银行</th>
	                        <th>产品名称</th>
	                        <th>销售状态</th>
	                        <th>投资周期</th>
	                        <th>收益</th>
	                        <th>收益类型</th>
	                      </tr>
	                    </thead>
	                    <tbody>
	                   <c:forEach var="product" items="${lcProductTongji.presaleriskList}">
		                     <tr>
		                        <td>${product.companyName}</td>
		                        <td><a href="${_contextPath}/detail-${product.id}.htm" target="_blank">${fn:replace(product.productName, "人民币", "")}</a></td>
		                        <td>
			                         <c:if test="${product.saleType eq '已售完'}">
			                		 	已完结
			                		 </c:if>
			                		 <c:if test="${product.saleType ne '已售完'}">
			                		 	${product.saleType}
			                		 </c:if>
		                        </td>
		                        <td>${product.days}天</td>
		                       <td><span class="tongjidetailincome">${product.income}%</span></td>
		                        <td>
		                           <c:if test="${product.incomeType eq 'null'}">
		                             <a href="${_contextPath}/detail-${product.id}.htm" target="_blank" >查看详细</a>
		                            </c:if>
		                            <c:if test="${product.incomeType ne 'null'}">
		                            	${product.incomeType}
		                            </c:if>
		                        </td>
		                     </tr>
	                    </c:forEach>
	                    </tbody>
	                  </table>
	                </div>
	              </div>
	            </div>
	            </c:if>
	            <c:if test="${lcProductTongji.newlicaiList!=null}">
	            <hr class="dashed"></hr>
                <div class="partname"><span class="listli"></span><span>在售主流银行理财产品高利率top1</span></div>
	              <div>
	              <div class="investmentedList">
	                <div class="investments_area">
	                  <table>
	                    <thead>
	                      <tr>
	                        <th>银行</th>
	                        <th>产品名称</th>
	                        <th>销售状态</th>
	                        <th>投资周期</th>
	                        <th>收益</th>
	                        <th>收益类型</th>
	                      </tr>
	                    </thead>
	                    <tbody>
	                   <c:forEach var="product" items="${lcProductTongji.newlicaiList}">
		                     <tr>
		                        <td>${product.companyName}</td>
		                        <td><a href="${_contextPath}/detail-${product.id}.htm"  target="_blank">${fn:replace(product.productName, "人民币", "")}</a></td>
		                        <td>
			                         <c:if test="${product.saleType eq '已售完'}">
			                		 	已完结
			                		 </c:if>
			                		 <c:if test="${product.saleType ne '已售完'}">
			                		 	${product.saleType}
			                		 </c:if>
		                        </td>
		                        <td>${product.days}天</td>
		                        <td><span class="tongjidetailincome">${product.income}%</span></td>
		                        <td>
		                            <c:if test="${product.incomeType eq 'null'}">
		                             <a href="${_contextPath}/detail-${product.id}.htm" target="_blank" >查看详细</a>
		                            </c:if>
		                            <c:if test="${product.incomeType ne 'null'}">
		                            	${product.incomeType}
		                            </c:if>
		                        </td>
		                     </tr>
	                    </c:forEach>
	                    </tbody>
	                  </table>
	                  <div class="more" style="text-align: right;">
	                    <a href="">显示更多</a>
	                  </div>
	                </div>
	              </div>
	            </div>
	            </c:if>
               </div>
               </div>
            </div>
            <!-- 右侧-->
            <div class="center-right">
	            <div>
			    <!-- 百度广告 -->
			    <script type="text/javascript">
				    /*300*250 创建于 2014-07-29*/
				    var cpro_id = "u1636420";
				</script>
				<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
			    </div>
		    	<!-- tanx广告 -->
			    <div>
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
        </div>
        <!-- 百度统计 -->
        <div class="none">
			<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F19d3582fea421029f25811115d6cdf0e' type='text/javascript'%3E%3C/script%3E"));
			</script>
		</div>
		<!-- 百度广告开始 -->
		<jsp:include page="/views/commons/licai_footer.jsp"></jsp:include>
		<script type="text/javascript">
		    /*250*200 创建于 2014-07-29*/
		var cpro_id = "u1636408";
		</script>
		<script src="http://cpro.baidustatic.com/cpro/ui/f.js" type="text/javascript"></script>
		<!-- 百度广告开始 结束>
  </body>
</html>