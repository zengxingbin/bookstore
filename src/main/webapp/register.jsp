<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>bookStore注册页面</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/my.js"></script>
<script type="text/javascript">
	var judge = new Boolean(true);
	var validateCodeStatus = new Boolean(true);
	function clearTip() {
        var validateCodeMsg =window.document.getElementById("validateCodeMsg");
        validateCodeMsg.innerHTML = "";
    }
	function changeImage() {
	    document.getElementById("validateId").value="";
	    clearTip();
		document.getElementById("img").src = "${pageContext.request.contextPath}/kaptcha/imageCode.do?time="
				+ new Date().getTime();
	}
	function check(msg) {
		if(msg != "")
			alert(msg);
	}
	function prompt(fontid) {
		var font = document.getElementById(fontid);
		
		if("fontid1"== fontid)
			font.innerHTML = "请输入有效的邮箱地址";
		else if("fontid2"== fontid)
			font.innerHTML = "用户名设置至少6位";
		else if("fontid3"== fontid)
			font.innerHTML = "密码设置至少6位";
		else
			font.innerHTML = "";
		font.color = "black";
	}
	function checkEmail(submit) {
		//获取input结点
		var input = document.getElementById("inputid1");
		//获取font结点
		var font = document.getElementById("fontid1");
		//创建正则表达式对象
		var reg = /^[A-z0-9_-]+\@[A-z0-9]+(\.[A-z]+)+$/;
		if("" == input.value) {
			if(submit == "submit") {
				font.innerHTML = "邮箱不能为空！";
				font.color = "red";
			}
			judge = false;
			return;
		}
		if(reg.test(input.value)) {
			//创建XMLHttpResquest对象
			var xhr = getXMLHttpRequest();
			
			//处理响应结果
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) 
					if(xhr.status == 200) {
						if(xhr.responseText == "false") {
							font.innerHTML = "邮箱已经被注册！";
							font.color = "orange";
							judge = false;
						}
						else {
							font.innerHTML = "邮箱格式正确！";
							font.color = "green";
							judge = true;
						}
					}
			}
			//创建连接
			xhr.open("get","${pageContext.request.contextPath}/user/checkEmail.do?email=" + input.value);
			//发送请求
			xhr.send(null);
		}
		else {
			font.innerHTML = "邮箱格式错误!";
			font.color = "red";
			judge = false;
		}
	}
	function checkUserName(submit) {
		//获取结点
		var input = document.getElementById("inputid2");
		var font = document.getElementById("fontid2");
		if(input.value == "") {
			if(submit == "submit") {
				font.innerHTML = "用户名不能为空！";
				font.color = "red";
			}
			judge = false;
			return;
		}
		var value = input.value;
		if(value.length < 6) {
			font.innerHTML = "用户名格式错误！";
			font.color = "red";
			judge = false;
		}else {
			//创建XMLHttpResquest对象
			var xhr = getXMLHttpRequest();
			
			//处理响应结果
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) 
					if(xhr.status == 200) {
						if(xhr.responseText == "false") {
							font.innerHTML = "用户名已经被注册！";
							font.color = "orange";
							judge = false;
						}
						else {
							font.innerHTML = "用户名格式正确！";
							font.color = "green";
							judge = true;
						}
					}
			}
			//创建连接
			xhr.open("get","${pageContext.request.contextPath}/user/checkUsername.do?username=" + input.value);
			//发送请求
			xhr.send(null);
		}
	}
	
	function checkPassword(submit) {
		var input = document.getElementById("inputid3");
		var font = document.getElementById("fontid3");
		
		if(input.value == "")
		{
			if(submit == "submit") {
				font.innerHTML = "密码不能为空！";
				font.color = "red";
			}
			return false;
		}
		if(input.value.length < 6) {
			font.innerHTML = "密码格式错误！";
			font.color = "red";
			return false;
		}else {
			font.innerHTML = "密码格式正确！";
			font.color = "green";
			return true;
		}
	}
	function checkRepassword(submit) {
		var input = document.getElementById("inputid3");
		var input2 = document.getElementById("inputid4");
		var font = document.getElementById("fontid4");
		
		if("" == input2.value) {

			if(submit == "submit") {
				font.innerHTML = "重复密码不能为空！";
				font.color = "red";
			}
			font.innerHTML = "";
			return false;
		}
		if(input.value.length < 6) {
			font.innerHTML = "密码格式错误！";
			font.color = "red";
			return false;
		} 
		if(input.value != input2.value) {
			font.innerHTML = "前后密码不一致！";
			font.color = "red";
			return false;
		}else {
			font.innerHTML = "重复密码正确！";
			font.color = "green";
			return true;
		}
			
	}
	function checkvalidateCode(obj,submit) {
	    var validateCodeMsg =window.document.getElementById("validateCodeMsg");
	    var obj = document.getElementById("validateId");
	    if("" == obj.value) {
            if(submit == "submit") {
            	validateCodeMsg.innerHTML = "<font color='red'>请填写验证码!</font>";
            }
            validateCodeStatus = false;
            return;
        }
	    if(obj.value != "") {
	        var xmlhttp = getXMLHttpRequest();
	        xmlhttp.onreadystatechange = function() {
	            if(xmlhttp.readyState == 4) {
	                if(xmlhttp.status == 200) {
	                    if(xmlhttp.responseText == "true") {
	                        validateCodeMsg.innerHTML = "<font color='green'>验证码正确</font>";
	                        validateCodeStatus = true;
	                    } else {
	                        validateCodeMsg.innerHTML = "<font color='red'>验证码错误</font>";
	                        validateCodeStatus = false;
	                    }
	                } else {
	                    /* alert("服务器繁忙，请稍后注册！（状态码：" + xmlhttp.status + "）"); */
	                }               
	            }
	        };
	        // 建立与服务器的异步连接
	        var url = "${pageContext.request.contextPath}/kaptcha/checkvalidatecode.do?userInputValidateCode=" + obj.value;
	        
	        xmlhttp.open("get", url);
	        xmlhttp.send(null);     
	    }
	}
	
	function checkAll(submit) {
		
		checkEmail(submit);
		if(judge == true)
			checkUserName(submit);
		else {
			checkUserName(submit);
			judge = false;
		}
		checkvalidateCode(null,submit);
		if(judge & checkPassword(submit) & checkRepassword(submit) & validateCodeStatus) {
		
			return true; 
		}
		return false;
		
	}
</script>
</head>


<body class="main">
	<%@include file="head.jsp"%>
	<%--导入头 --%>
	<%@include file="menu_search.jsp"%><%--导入导航条与搜索 --%>

	<div id="divcontent">
		<form action="${pageContext.request.contextPath}/user/register.do"
			method="post" onsubmit = "return checkAll('submit')">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px">
						<h1>新会员注册</h1>
						
						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">会员邮箱：</td>
								<td style="width:40%">
								<input id = "inputid1" type="text" class="textinput"
									name="email" onfocus = "prompt('fontid1')" onblur = "checkEmail('no')"/></td>
								<td><font id = "fontid1" color="#999999">请输入有效的邮箱地址</font></td>
							</tr>
							<tr>
								<td style="text-align:right">会员名：</td>
								<td>
									<input id = "inputid2" type="text" class="textinput" name="username" onfocus = "prompt('fontid2')" onblur = "checkUserName('no')"/>
								</td>
								<td><font id = "fontid2"color="#999999">用户名设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">密码：</td>
								<td><input id = "inputid3" type="password" class="textinput"
									name="password" onfocus = "prompt('fontid3')" onblur = "checkPassword('no')"/></td>
								<td><font id = "fontid3" color="#999999">密码设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">重复密码：</td>
								<td><input id = "inputid4" type="password" class="textinput"
									name="repassword" onfocus = "prompt('fontid4')" onblur = "checkRepassword('no')"/></td>
								<td><font id = "fontid4"></font></td>
							</tr>
							<tr>
								<td style="text-align:right">性别：</td>
								<td colspan="2">&nbsp;&nbsp;<input type="radio"
									name="gender" value="男" checked="checked" /> 男
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
									name="gender" value="女" /> 女</td>
							</tr>
							<tr>
								<td style="text-align:right">联系电话：</td>
								<td colspan="2"><input type="text" class="textinput"
									style="width:350px" name="telephone" /></td>
							</tr>
							<tr>
								<td style="text-align:right">个人介绍：</td>
								<td colspan="2"><textarea class="textarea" name="introduce"></textarea>
								</td>
							</tr>

						</table>



						<h1>注册校验</h1>
						<table width="80%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">输入校验码：</td>
								<td style="width:50%"><input id = "validateId" type="text" name = "imagecode" class="textinput" onblur="checkvalidateCode(this,'no')" onfocus="clearTip()"/>
								<span id="validateCodeMsg"></font></span>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align:right;width:20%;">&nbsp;</td>
								<td colspan="2" style="width:50%"><img
									src="${pageContext.request.contextPath}/kaptcha/imageCode.do" width="180"
									height="30" class="textinput" style="height:30px;" id="img" />&nbsp;&nbsp;
									<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
								</td>
							</tr>
						</table>



						<table width="70%" border="0" cellspacing="0">
							<tr>
								<td style="padding-top:20px; text-align:center"><input 
									type="image" src="images/signup.gif" name="submit" border="0">
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" /></td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a></td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font></td>
			</tr>
		</table>
	</div>


</body>
</html>
