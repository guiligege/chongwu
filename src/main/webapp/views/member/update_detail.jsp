<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>

  <div class="lr-tips">
      <div>欢迎注册理财么</div>
  </div>
  <div style="float: left;margin: 50px 52px 100px;">
  	<img src="/img/licai/licaime1.png">
  </div>
  <div class="lr-content">
      <div>
          <div class="lr-header">
            <h4>注册</h4>
            <span>已经注册？ <a href="${_contextPath}/member/toLogin.htm">登录</a></span>
          </div>
          <form id="login-form" action="/member/update.htm" method="post" autocomplete="off">
	          <div class="lr-fluid">
	              <div class="control-group" id="emailinfo">
	                <label class="control-label">原密码</label>
	                <div class="controls">
	                  <input type="text" value="" maxlength="50" tabindex="1" name="oldpassword" id="oldpassword" class="span12">
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
	              <div class="control-group" id="passwordAgaininfo">
	                <label class="control-label">重复密码</label>
	                <div class="controls">
	                  <input type="password" value="" maxlength="12" tabindex="1"  name="passwordAgain" id="passwordAgain" class="span12">
	                </div>
	                <span class="help-block">请输入相同密码！</span>
	              </div>
	          </div>
	          <button tabindex="4" type="button" onclick="update();">更新密码</button>
          </form>
      </div>
  </div>