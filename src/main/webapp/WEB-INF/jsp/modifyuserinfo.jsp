<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
</head>
<script type="text/javascript">
var pwdValidate = false;
var rePwdValidate = false;
function clearTip(fontid) {
	var font = document.getElementById(fontid);
	if(fontid == "pwdFontId") {
		font.color = "#999999";
		font.innerHTML = "密码设置至少6位，请区分大小写";
	}
	else {
		font.innderHTML = "";
	}
} 
//检查各输入是否为空
function isEmpty(input,fontid) {
    var font = document.getElementById(fontid);
    if("" == input.value) {
        if("pwdFontId"== fontid)
            font.innerHTML = "密码不能为空！";
        else if("rePwdFontId" == fontid)
            font.innerHTML = "请确认密码密码！";
        font.color = "red";
        return true;
    }
    return false;
}
function checkPassword() {
    var input = document.getElementById("pwdId");
    var font = document.getElementById("pwdFontId");
    
    if(input.value == "")
    {
        /* if(submit == "submit") {
            font.innerHTML = "密码不能为空！";
            font.color = "red";
        } */
        pwdValidate = false;
        return;
    }
    var regExpStr = "^[\\w\\d]{6,}$";
    var regExp = new RegExp(regExpStr);
    if(!regExp.test(input.value)) {
        font.innerHTML = "密码格式错误！";
        font.color = "red";
        pwdValidate = false;
    }else {
        font.innerHTML = "密码格式正确！";
        font.color = "green";
        pwdValidate = true;
    }
}
function checkRepassword() {
    var input = document.getElementById("pwdId");
    var input2 = document.getElementById("rePwdId");
    var font = document.getElementById("rePwdFontId");
    
    if("" == input2.value) {

        /* if(submit == "submit") {
            font.innerHTML = "重复密码不能为空！";
            font.color = "red";
        } */
        font.innerHTML = "";
        rePwdValidate = false;
        return;
    }
    /* if(input.value.length < 6) {
        font.innerHTML = "密码格式错误！";
        font.color = "red";
        return false;
    }  */
    if(input.value != input2.value) {
        font.innerHTML = "前后密码不一致！";
        font.color = "red";
        rePwdValidate = false;
    }else {
        font.innerHTML = "重复密码正确！";
        font.color = "green";
        rePwdValidate = true;
    }
        
}
function checkForm() {
    var pwdInput = document.getElementById("pwdId");
    var rePwdInput = document.getElementById("rePwdId");
    
    if(isEmpty(pwdInput,"pwdFontId"))
        return false;
    if(isEmpty(rePwdInput,"rePwdFontId"))
    	return false;
    return  pwdValidate && rePwdValidate;
    
}
</script>
<body class="main">
	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%">
					<table width="100%" border="0" cellspacing="0"
						style="margin-top:30px">
						<tr>
							<td class="listtitle">我的帐户</td>
						</tr>
						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath }/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath }/page/modifyUserInfo.do">用户信息修改</a></td>
						</tr>

						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath }/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/order?method=findOrdersByUserid">订单查询</a>
							</td>
						</tr>

						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath }/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/user/logout.do">用戶退出</a>
							</td>
						</tr>
					</table></td>
				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/page/index.do">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath }/page/myAccount.do">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;用户信息修改
					</div>





					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
								<form action="${pageContext.request.contextPath }/user/modifyUserInfo.do" method="post" onsubmit="return checkForm()">
									<input type="hidden" name="id" value="${loginUser.id}">
									<table width="100%" border="0" cellspacing="2" class="upline">
										<tr>
											<td style="text-align:right; width:20%">会员邮箱：</td>
											<td style="width:40%; padding-left:20px">${loginUser.email }</td>
											<td>&nbsp;</td>


										</tr>
										<tr>
											<td style="text-align:right">会员名：</td>
											<td style="padding-left:20px">${loginUser.username }</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td style="text-align:right">修改密码：</td>
											<td><input type="password" name="password" id="pwdId"
												class="textinput" onblur="checkPassword()" onfocus="clearTip('pwdFontId')"/>
											</td>
											<td><font color="#999999" id="pwdFontId">密码设置至少6位，请区分大小写</font>
											</td>
										</tr>
										<tr>
											<td style="text-align:right">重复密码：</td>
											<td><input type="password" class="textinput" id="rePwdId" onblur="checkRepassword()" onfocus="clearTip('rePwdFontId')" />
											</td>
											<td><font color="" id="rePwdFontId"></font></td>
										</tr>
										<tr>
											<td style="text-align:right">性别：</td>
											<td colspan="2">&nbsp;&nbsp;<input type="radio"
												name="gender" value="男" ${loginUser.gender == "男" ? "checked='checked'":""}/> 男
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
												type="radio" name="gender" value="女" ${loginUser.gender == "女" ? "checked='checked'":""}}/> 女</td>
										</tr>
										<tr>
											<td style="text-align:right">联系方式：</td>
											<td colspan="2"><input name="telephone" type="text"
												value="${loginUser.telephone }" class="textinput" />
											</td>
										</tr>

										<tr>
											<td style="text-align:right">&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table>





									<p style="text-align:center">

										<input type="image" src="${pageContext.request.contextPath }/images/botton_gif_025.gif" border="0">

									</p>
									<p style="text-align:center">&nbsp;</p>
								</form></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
