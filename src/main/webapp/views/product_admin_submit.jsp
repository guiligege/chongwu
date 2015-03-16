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
	    	<jsp:include page="commons/header_content.jsp"></jsp:include>
		    <div class="section_container" style="width:980px;margin:0px auto;">
		        <section>
		            <div id="banner_section" class="content">
		                <div class="left_main">
		                <form data-action="${pageContext.request.contextPath}/product/batShare.htm" method="post" id="saveform" action="${pageContext.request.contextPath}/product/batShare.htm">
							<div class="titleBox"><h1>我要分享</h1></div>
							<div class="wantItem">
		                        <div class="titleItem">
		                            <span class="red">*</span>优惠链接：
		                        </div>
		                        <div class="perDataItem">
		                            <input type="text" class="inputBox lfloat text-empty text" value="请填写商品购买链接或活动地址" id="productUrl" name="productUrl" data-default="请填写商品购买链接或活动地址" autocomplete="off" />
		                           <!--  <input type="button" style="margin:4px 0 0 10px;" class="blueBorderBtn lfloat" value="获取信息" title="获取信息" id="get_info_btn" /> -->
		                            <div class="clear"></div>
		                            <span class="grey">支持京东商城，亚马逊中国，易迅网，天猫，苏宁易购等网站商品信息自动获取</span>
		                        </div>
		                        <div class="clear"></div>
		                        <!-- <span class="layerError" style="display: none;">请于此处填写商品购买链接或促销活动链接</span> -->
		                        <span id="productUrlError" class="layerError layerError6" style="display:none;">暂不支持自动提取该链接，请手动输入，活动价格不必填</span>
		                    </div>
		                    <!-- <div class="wantItem">
		                        <div class="titleItem">
		                            	活动名称：
		                        </div>
		                        <div class="perDataItem">
		                            <input type="text" class="inputBox lfloat text-empty text" value="请填写活动名称" id="activityName" name="activityName" data-default="请填写商品活动名称" />
		                        </div>
		                        <div class="clear"></div>
		                    </div> -->
		                    <!-- <div class="displaynone" id="infosmain">
	                    		<div class="wantItem show">
				                    <div class="titleItem"><span class="red">*</span>标题：</div>
				                    <div class="perDataItem">
				                        <input type="text" class="inputBox mB10 text-empty text" id="productName" name="productName" value="请输入商品名/活动名" />
				                        <span class="grey">请以括号说明优惠条件</span>
				                    </div>
				                    <div class="clear"></div>
				                    <span id="productNameError" class="layerError" style="display: none;">请于此处填写商品名称或活动标题</span>
				                </div>
		                        <div class="wantItem show">
				                    <div class="titleItem"><span class="red">*</span>图片链接：</div>
				                    <div class="perDataItem">
				                        <input type="text" class="inputBox mB10 text-empty text" id="goodsImage" name="goodsImage" value="产品图片链接地址" />
				                    </div>
				                    <div class="clear"></div>
				                    <span id="goodsImageError" class="layerError" style="display: none;">请于此处填写商品图片链接</span>
				                </div>
				                <div class="wantItem">
					                    <div class="titleItem"><span class="red">*</span>店铺名称：</div>
					                    <div class="perDataItem">
					                        <input type="text" class="inputBox mB10 text-empty text" id="productStore" name="productStore" value="店铺名称" />
					                    </div>
					                    <div class="clear"></div>
					                    <span id="productStoreError" class="layerError" style="display: none;">请于此处填写商品店铺名称</span>
					             </div>
					              <div class="wantItem">
					                    <div class="titleItem"><span class="red"></span>月销量：</div>
					                    <div class="perDataItem">
					                        <input type="text" class="inputBox mB10 text-empty text" id="goodsSellCount" name="goodsSellCount" value="月销量" />
					                    </div>
					                    <div class="clear"></div>
					                </div>
					                <div class="wantItem">
					                    <div class="titleItem"><span class="red"></span>总评价数：</div>
					                    <div class="perDataItem">
					                        <input type="text" class="inputBox mB10 text-empty text" id="pingjia" name="pingjia" value="总评价数" />
					                    </div>
					                    <div class="clear"></div>
					                </div>
					             <div class="wantItem">
					                    <div class="titleItem"><span class="red">*</span>价格：</div>
					                    <div class="perDataItem">
					                        <input type="text" class="inputBox mB10 text-empty text" id="price" name="price" value="价格" />
					                    </div>
					                    <div class="clear"></div>
					                    <span id="priceError" class="layerError" style="display: none;">请于此处填写商品价格</span>
					              </div>
		                    </div> -->
		                    <!-- 自动获取信息start -->
		                    <!-- <div class="manualBox displaynone" id="infos">
					            <div class="manualGreyBg">
					           		 <div class="wantItem">
					                	<div class="titleItem">活动价：</div>
					                    <div class="perDataItem">
					                        <input type="text" class="inputBox mB10 text-empty text" id="salePrice" name="salePrice" value="活动价格" />
					                    </div>
					                    <div class="clear"></div>
					                </div>
					                <div class="wantItem">
					                    <div class="titleItem">折扣率：</div>
					                    <div class="perDataItem">
					                        <input type="text" class="inputBox mB10 text-empty text" id="zhekou" name="zhekou" value="折扣率" />
					                    </div>
					                    <div class="clear"></div>
					                </div>
					                <div class="wantItem">
					                    <div class="titleItem">发货地址：</div>
					                    <div class="perDataItem">
					                        <input type="text" class="inputBox mB10 text-empty text" id="goodsAddress" name="goodsAddress" value="发货地址" />
					                    </div>
					                    <div class="clear"></div>
					                </div>
					                <div class="wantItem">
					                    <div class="titleItem">邮费信息：</div>
					                    <div class="perDataItem">
					                        <input type="text" class="inputBox mB10 text-empty text" id="goodsFee" name="goodsFee" value="邮费信息" />
					                    </div>
					                    <div class="clear"></div>
					                </div>
					                <div class="wantItem">
					                	<div class="titleItem">邮费信息：</div>
					                    <div class="perDataItem">
					                        <input type="text" class="inputBox lfloat w280 text-empty text" id="goodsFee" name="goodsFee" value="邮费信息" />
					                        <input type="text" class="inputBox lfloat w180 text-empty text" id="resourceStore" name="resourceStore" value="商城" />
					                        <div class="clear"></div>
					                        <span class="layerError" id="un-item-goods-warn" style="margin-left: 0px;"></span>
					                    </div>
					                    <div class="clear"></div>
					                </div>
					               
					            </div>
					        </div> -->
		                    <!-- 自动获取信息end -->
		                    <div class="wantItem">
		                        <div class="titleItem">
		                            <span class="red">*</span>推荐理由：
		                        </div>
		                        <div class="perDataItem">
		                            <textarea style="height:126px;" id="shareReason" name="shareReason" class="textareaBox text-empty text" autocomplete="off"></textarea>
		                            <span class="grey">推荐理由力求做到全部原创，严谨丰富，条理清晰，信息量大。</span>
		                        </div>
		                        <div class="clear"></div>
		                        <span id="shareReasonError"  class="layerError" style="display: none;">请于此处填写商品推荐理由</span>
		                    </div>
		                   <div class="wantItem show">
			                    <div class="titleItem"><span class="red">*</span>商品区块：</div>
			                    <div class="perDataItem">
			                    	<input type="text" class="inputBox mB10 text-empty text displaynone" id="type" name="type" value="1，优惠活动商品，2，打折商品，3，全网最低商品，4商家活动" />
			                        <div class="regionRadio" id="un-region">
			                        	<!-- <input type="radio" name="goodProduct.type" id="yh" value='1' /><label for="yh" class="leftSpace">优惠活动商品</label> -->
			                        	<input type="radio" name="goodProduct.type" id="pt" value='1' /><label for="pt" class="leftSpace">全网最低</label>
			                            <input type="radio" name="goodProduct.type" id="zk" value='2' /><label for="zk" class="leftSpace">打折商品</label>
			                            <input type="radio" name="goodProduct.type" id="hd" value='3' /><label for="hd" class="leftSpace">商家活动</label>
			                        </div>
			                    </div>
			                    <div class="clear"></div>
			                    <span id="typeError" class="layerError" style="display: none;">请于此处填写商品所属商品区块</span>
					        </div>
		                    <div class="wantItem">
		                        <div class="titleItem">产品分类：</div>
		                        <div class="perDataItem">
		                            <select name="categoryId" class="select">
										<option>选择分类</option>
										<option value="1">服饰鞋包</option>
										<option value="2">运动户外</option>
										<option value="3">手机数码</option>
										<option value="4">家用电器</option>
										<option value="5">护肤美妆</option>
										<option value="6">办公用品</option>
										<option value="7">母婴用品</option>
										<option value="8">日用百货</option>
										<option value="9">美食特产</option>
										<option value="10">家居家纺</option>
										<option value="11">图书音像</option>
										<option value="12">汽车用品</option>
										<option value="13">其他分类</option>
									</select>
		                        </div>
		                        <div class="clear"></div>
		                        <span id="un-more-link-warn" class="layerError"></span>
		                    </div>
		                    <!-- <div class="wantItem">
		                        <div class="titleItem">其他链接：</div>
		                        <div class="perDataItem">
		                            <input type="text" value="请填写其他凑单单品或活动、领券链接" class="inputBox lfloat text-empty text" id="otherlinks" autocomplete="off"/>
		                        </div>
		                        <div class="clear"></div>
		                        <span id="un-more-link-warn" class="layerError"></span>
		                    </div> -->
		                    <div class="wantItem">
		                        <div class="titleItem"><span class="red">*</span>邮箱地址：</div>
		                        <div class="perDataItem">
		                            <input type="text" value="请填写邮件地址便于与我们互动，建议您注册并登陆后爆料" class="inputBox lfloat text-empty text" name="email" id="email" autocomplete="off"/>
		                        </div>
		                        <div class="clear"></div>
		                        <span id="emailError" class="layerError" style="display: none;">请于此处填写您的邮箱地址</span>
		                    </div>
		                    <div style="padding-top:60px;" class="wantItem">
		                        <div class="titleItem"><span></span></div>
		                        <div style="padding-right:40px; width:503px;" class="perDataItem">
		                            <input type="button" value="提交分享" class="submitBtn2" onclick="document.getElementById('submit_confirm').style.display=none" id="submit_confirm" />
		                            <span class="red"></span>
		                        </div>
		                        <div class="clear"></div>
		                    </div>
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
		                  <!--   <div class="rightBox">
		                        <div class="titleStyle"><h2>奖励&amp;说明</h2></div>
		                        <p class="info">小编们会根据爆料及时程度、特价力度、推荐理由的丰富度的不同，<span class="red">奖励被采用成功的爆料者5~300个金币，无需小编修改的推荐理由，奖励Double</span>！您可以通过<a href="http://www.smzdm.com/youhui/420" target="_blank">用户积分计划</a>，换取优惠劵、礼品卡或其他实物礼品。</p>
		                        <p class="info noMbSpace">请注意，本站可能会对推荐产品、推荐语及推荐链接进行调整，恕不另行通知。</p>   
		                    </div> -->
		                    <div class="blPicBox">
		                        <a href="http://www.womaime.com/feedback"><img src="${domain_image}/img/blPic.png" alt="" /></a>
		                    </div>
		                </div>
		            </div>
		            
		        </section>
		    </div>
	    	<jsp:include page="commons/footer.jsp"></jsp:include>
		    </div>
	</body>
	<!--Javascript-->
		<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
		<script type="text/javascript">
		$(function() {
			//分享商品
			 $("#get_info_btn").click(function(){
				 var producturl=$(this).prev().val();
				 $(".layerError").hide();
				 if(producturl!='请填写商品购买链接或活动地址'){
					 $.ajax({
			  				url:_contextPath+"/product/share.htm",
			  				type:"get",
			  				data:{producturl:producturl},
			  				dataType:"json",
			  				success:function(data){
			  					//prevScore,productScore,repeatScore,result,isless,url,productName
			  					if(data!=null){
			  						if(data.nostore=='nostore'){
			  							$(".layerError6").show();
			  							$("#infosmain").show();
			  						}else{
			  							if(data.miaoshatime!=""){
				  							$("#miaoshatime").val(data.miaoshatime);
				  						}
			  							//goodsSellCount
				  						$("#productName").val(data.productName);
				  						$("#goodsAddress").val(data.goodsAddress);
				  						$("#goodsFee").val(data.goodsFee);
				  						$("#goodsImage").val(data.goodsImage);
				  						$("#goodsSellCount").val(data.goodsSellCount);
				  						$("#price").val(data.price);
				  						$("#salePrice").val(data.salePrice);
				  						$("#zhekou").val(data.zhekou);
				  						$("#productStore").val(data.productStore);
				  						$("#resourceStore").val(data.resourceStore);
				  						$("#productUrl").val(data.productUrl);
				  						$("#activityName").val(data.productattr);
				  						$("#type").val(data.type);
				  						$("#pingjia").val(data.pingjia);
				  						//回显商品类型
				  						/* if(data.type=='1'){
				  							$("#yh").attr("checked","checked");
				  						} */
				  						if(data.type=='1'){
											$("#pt").attr("checked","checked");
				  						}
										if(data.type=='2'){
											$("#zk").attr("checked","checked");
				  						}
										if(data.type=='3'){
											$("#hd").attr("checked","checked");
				  						}
										//显示隐藏域
										$("#infos").show();
					  					$("#infosmain").show();
			  						}
			  					}
			  				},
			  				error:function(data){
			  				}
			  		});
			 	}
			 });
			 //提交分享
			 $("#submit_confirm").click(function(){
				 /* if(validate()==false){
					 return;
				 } */
				 $("#saveform").submit();
			 });
			 //选择
			 /* $("#yh").change(function(){
				 $("#type").val(1);
			 }); */
			 $("#pt").change(function(){
				 $("#type").val(1);
			 });
			 $("#zk").change(function(){
				 $("#type").val(2);
			 });
			 $("#hd").change(function(){
				 $("#type").val(3);
			 });
			 
			 //各种验证提示
			 //链接效果
			 $("#productUrl").focus(function(){
				if($("#productUrl").val()=='请填写商品购买链接或活动地址'){
					$("#productUrl").val('');
				}
				$(".layerError6").hide();
			 });
			 $("#productUrl").blur(function(){
					if($("#productUrl").val()==''){
						$("#productUrl").val('请填写商品购买链接或活动地址');
					}
			 });
			 //活动名称验证
			 $("#activityName").focus(function(){
					if($("#activityName").val()=='请填写活动名称'){
						$("#activityName").val('');
					}
			 });
			 $("#activityName").blur(function(){
					if($("#activityName").val()==''){
						$("#activityName").val('请填写活动名称');
					}
			 });
			 //邮箱 email
			 $("#email").focus(function(){
					if($("#email").val()=='请填写邮件地址便于与我们互动，建议您注册并登陆后爆料'){
						$("#email").val('');
					}
			 });
			 $("#email").blur(function(){
					if($("#email").val()==''){
						$("#email").val('请填写邮件地址便于与我们互动，建议您注册并登陆后爆料');
					}
			 });
			//邮箱 otherlinks
			 $("#otherlinks").focus(function(){
					if($("#otherlinks").val()=='请填写其他凑单单品或活动、领券链接'){
						$("#otherlinks").val('');
					}
			 });
			 $("#otherlinks").blur(function(){
					if($("#otherlinks").val()==''){
						$("#otherlinks").val('请填写其他凑单单品或活动、领券链接');
					}
			 });
			 //goodsImage  productStore  goodsSellCount pingjia price
			 //图片
			 $("#goodsImage").focus(function(){
					if($("#goodsImage").val()=='产品图片链接地址'){
						$("#goodsImage").val('');
					}
			 });
			 $("#goodsImage").blur(function(){
					if($("#goodsImage").val()==''){
						$("#goodsImage").val('产品图片链接地址');
					}
			 });
			 //店铺名称
			 $("#productStore").focus(function(){
					if($("#productStore").val()=='店铺名称'){
						$("#productStore").val('');
					}
			 });
			 $("#productStore").blur(function(){
					if($("#productStore").val()==''){
						$("#productStore").val('店铺名称');
					}
			 });
			 //月销量
			 $("#goodsSellCount").focus(function(){
					if($("#goodsSellCount").val()=='月销量'){
						$("#goodsSellCount").val('');
					}
			 });
			 $("#goodsSellCount").blur(function(){
					if($("#goodsSellCount").val()==''){
						$("#goodsSellCount").val('月销量');
					}
			 });
			 //评价数
			 $("#pingjia").focus(function(){
					if($("#pingjia").val()=='总评价数'){
						$("#pingjia").val('');
					}
			 });
			 $("#pingjia").blur(function(){
					if($("#pingjia").val()==''){
						$("#pingjia").val('总评价数');
					}
			 });
			 //price
			 $("#price").focus(function(){
					if($("#price").val()=='价格'){
						$("#price").val('');
					}
			 });
			 $("#price").blur(function(){
					if($("#price").val()==''){
						$("#price").val('价格');
					}
			 });
			 //productName
			 $("#productName").focus(function(){
					if($("#productName").val()=='请输入商品名/活动名'){
						$("#productName").val('');
					}
			 });
			 $("#productName").blur(function(){
					if($("#productName").val()==''){
						$("#productName").val('请输入商品名/活动名');
					}
			 });
			 
	    }); 
		//验证信息
		function validate(){
			var flag=true;
			//验证评论数量和销量正则
			var regnum = new RegExp("^(0|[1-9][0-9]{0,5})$");
			var regzhe = new RegExp("^[0-9]{0,1}(.[0-9]{0,3})?$");
			var regjia = new RegExp("^[0-9]+(.[0-9]{0,3})?$");
			
			if($("#productUrl").val()=='请填写商品购买链接或活动地址' || $("#productUrl").val()==''){
				$("#productUrlError").show();
				flag=false;
			}
			if($("#productName").val()=='请输入商品名/活动名' || $("#productName").val()==''){
				$("#productNameError").show();
				flag=false;
			}
			if($("#goodsImage").val()=='产品图片链接地址' || $("#goodsImage").val()==''){
				$("#goodsImageError").show();
				flag=false;
			}
			if($("#productStore").val()=='店铺名称' || $("#productStore").val()==''){
				$("#productStoreError").show();
				flag=false;
			}
			if($("#price").val()=='价格' || $("#price").val()==''){
				$("#priceError").show();
				flag=false;
			}
			if($("#shareReason").val()==''){
				$("#shareReasonError").show();
				flag=false;
			}
			if($("#type").val()=='1，优惠活动商品，2，打折商品，3，全网最低商品，4商家活动' || $("#type").val()==''){
				$("#typeError").show();
				flag=false;
			}
			if($("#email").val()=='请填写邮件地址便于与我们互动，建议您注册并登陆后爆料' || $("#email").val()==''){
				$("#emailError").show();
				flag=false;
			}
			//设置信息
			if($("#pingjia").val()=='总评价数' || $("#productName").val()==''){
				$("#pingjia").val(0);
			}else{
				//正则验证
				if(!regnum.test($("#pingjia").val())){
					//alert("评价数格式不对");
					flag=false;
				}
			}
			if($("#zhekou").val()=='折扣率' || $("#zhekou").val()==''){
				$("#zhekou").val(10);
			}else{
				//正则验证
				if(!regzhe.test($("#zhekou").val())){
					//alert("折扣格式不对");
					flag=false;
				}
			}
			if($("#salePrice").val()=='活动价格' || $("#salePrice").val()==''){
				$("#salePrice").val($("#price").val());
			}else{
				//正则验证
				if(!regjia.test($("#salePrice").val())){
					//alert("活动价格格式不对");
					flag=false;
				}
			}
			if($("#goodsSellCount").val()=='月销量' || $("#goodsSellCount").val()==''){
				$("#goodsSellCount").val(0);
			}else{
				//正则验证
				if(!regnum.test($("#goodsSellCount").val())){
					//alert("月销量格式不对");
					flag=false;
				}
			}
			if($("#goodsFee").val()=='邮费信息' || $("#goodsFee").val()==''){
				$("#goodsFee").val("快递:无");
			}
			if($("#goodsAddress").val()=='发货地址' || $("#goodsAddress").val()==''){
				$("#goodsAddress").val("请去商家查看");
			}
			//正则验证
			if(!regjia.test($("#price").val())){
				//alert("价格格式不对");
				$("#priceError").show();
				flag=false;
			}
			return flag;
		}
	</script>
</html>