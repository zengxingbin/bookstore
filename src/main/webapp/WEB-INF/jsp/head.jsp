<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
window.onload = function() {
	var userCheckbox = document.getElementById("userCheckbox");
	var loginCheckbox = document.getElementById("loginCheckbox");
	if(userCheckbox != null && loginCheckbox != null) {
		var isUserCheck = "${cookie.userNameCheck.value}";
		var isAutoLoginCheck = "${cookie.autoLoginCheck.value}";
		if(isUserCheck == "checked")
			userCheckbox.checked = true;
		else
			userCheckbox.checked = false;
		if(isAutoLoginCheck == "checked")
			loginCheckbox.checked = true;
		else
			loginCheckbox.checked = false;
	}
		
	var value = "${loginStatus}";
	var loginUser = "${loginUser}";
	var registerLink = document.getElementById("registerLink");
    var loginLink = document.getElementById("loginLink");
    var font = document.getElementById("fontId");
    var userFont = document.getElementById("userFont");
    var userSpan = document.getElementById("userId");
	if(value == "true") {
		registerLink.hidden = "true";
		loginLink.hidden = "true";
		font.hidden = "true";
		userSpan.hidden = "";
		userFont.color = "green";
	}else {
		registerLink.hidden = "";
        loginLink.hidden = "";
        font.hidden = "";
        userSpan.hidden = "true";
	}
}
</script>
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td><a href="${pageContext.request.contextPath }/page/index.do"><img src="${pageContext.request.contextPath }/images/logo.png"
					width="95" height="30" border="0" /> </a></td>
			<td style="text-align:right"><img src="${pageContext.request.contextPath }/images/cart.gif"
				width="26" height="23" style="margin-bottom:-4px" />&nbsp;<a
				href="${pageContext.request.contextPath }/page/cart.do">购物车</a> | <a href="#">帮助中心</a> | <a href="${pageContext.request.contextPath }/user/userInfo.do">我的帐户</a>
				| <a id="registerLink" href="${pageContext.request.contextPath }/page/register.do">新用户注册</a><font id="fontId"> | </font><a id="loginLink" href="${pageContext.request.contextPath }/page/login.do">用户登录</a>
				<span id="userId" hidden="true"><a href=""><font id="userFont">欢迎您${loginUser.username}</font></a>，<a href="${pageContext.request.contextPath }/user/logout.do"><font color="green">注销</font></a></span>
				</td>
		</tr>
	</table>
</div>