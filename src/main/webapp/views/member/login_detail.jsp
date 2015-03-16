<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>

  <div class="lr-tips">
      <div>欢迎登录理财么</div>
  </div>
  <div style="float: left;margin: 50px 52px 100px;">
  	<img src="/img/licai/licaime1.png">
  </div>
  <div class="lr-content">
      <div>
          <div class="lr-header">
            <h4>登录</h4>
            <span>还没有账号？ <a href="${_contextPath}/member/toRegister.htm">注册</a></span>
          </div>
          <form id="login-form" action="/member/login.htm" method="post" autocomplete="off">
	          <div class="lr-fluid">
	          	  <c:if test="${validateresult=='error'}">
		              <div class="control-group error" id="emailinfo1">
		                <span class="help-block" >用户名或密码输入有误！</span>
		              </div>
	              </c:if>
	          	  <!-- <div class="control-group error" id="emailinfo"> -->
	              <div class="control-group" id="emailinfo">
	                <label class="control-label">邮箱</label>
	                <div class="controls">
	                  <input type="text" value="example@example.com" maxlength="50" tabindex="1" name="email" id="email" class="span12">
	                </div>
	                <span class="help-block" id="errorinfo">邮箱格式错误！</span>
	              </div>
	              <div class="control-group" id="passwordinfo">
	                <label class="control-label">输入密码</label>
	                <div class="controls">
	                  <input type="password" value="" maxlength="12"  tabindex="1" name="password" id="password" class="span12">
	                </div>
	                <span class="help-block">请输入小于8位密码</span>
	              </div>
	              <div class="control-group none" id="validateNuminfo">
	                <label class="control-label">验证码</label>
	                <div class="controls yzm">
	                  <input type="text" value="123" maxlength="4" tabindex="1" name="validateNum" id="validateNum" class="span12"> <img src="" />
	                </div>
	                <span class="help-block">请输入正确的验证码！</span>
	              </div>
	          </div>
	          <button tabindex="4" type="button" onclick="login();">登录</button>
          </form>
      </div>
  </div>