<%@ page import="com.domain.Order"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
<script type="text/javascript">
	function createXMLHttpRequest() {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}		
		return xmlhttp;
	}
	
	function deleteOrder(orderId, id) {
		// 创建XMLHttpRequest对象
		var xmlhttp = createXMLHttpRequest();
		// 注册状态监控回调函数
		xmlhttp.onreadystatechange = function() {
			if(xmlhttp.readyState == 4) {
				if( xmlhttp.status == 200) {
					var cart = document.getElementById(id);
					cart.parentNode.removeChild(cart);
					var orderNumber = document.getElementById("orderNumber");
					orderNumber.innerHTML = orderNumber.innerText - 1;
					return 0;				
				}else {
					alert("服务器繁忙！（状态码：" + xmlhttp.status + "）");
				}
				
			} 
		};
		// 建立与服务器的异步连接
		var url = "${pageContext.request.contextPath }/order/deleteOrder.do?orderId=" + orderId + "&time=" + new Date().getTime();
		xmlhttp.open("get", url);
		xmlhttp.send(null);	
	}
</script>
</head>

<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%"><table width="100%" border="0" cellspacing="0"
						style="margin-top:30px">
						<tr>
							<td class="listtitle">我的帐户</td>
						</tr>
						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath}/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath}/page/modifyUserInfo.do">用户信息修改</a>
							</td>
						</tr>

						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath}/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/order/findOrders.do">订单查询</a>
							</td>
						</tr>
						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath}/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/user/logout.do">用戶退出</a></td>
						</tr>
















					</table>
				</td>
				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/page/index.do">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath }/page/myAccount.do">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单查询
					</div>





					<table cellspacing="0" class="infocontent">
						<tr>
							<td style="padding:20px"><p>欢迎${loginUser.username }光临商城！</p>
								<p>
									您有<font style="color:#FF0000" id="orderNumber"><%=((List<Order>)request.getAttribute("orders")).size() %></font>个订单
								</p>
								<table width="100%" border="0" cellspacing="0" class="tableopen">
									<tr>
										<td bgcolor="#A3E6DF" class="tableopentd01">订单号</td>
										<td bgcolor="#A3D7E6" class="tableopentd01">收件人</td>
										<td bgcolor="#A3CCE6" class="tableopentd01">订单时间</td>
										<td bgcolor="#A3B6E6" class="tableopentd01">状态</td>
										<td bgcolor="#A3E2E6" class="tableopentd01">操作</td>
									</tr>


									<c:forEach var="order" items="${orders }" varStatus="vs">
										<tr id="${vs.count }">
											<td class="tableopentd02">${order.id }</td>
	
											<td class="tableopentd02">${order.receiverName }</td>
											<td class="tableopentd02">${order.ordertime }</td>
											<td class="tableopentd02">${order.paystate == 0 ? "未支付" : "已支付"}</td>
											<td class="tableopentd03"><a href="${pageContext.request.contextPath }/order/findOrderInformation.do?orderId=${order.id }">查看</a>&nbsp;&nbsp;
												<a href="javascript:void(deleteOrder('${order.id }', '${vs.count }'))">刪除</a>
											</td>
										</tr>
									</c:forEach>					
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="${pageContext.request.contextPath}/images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" />
				</td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a>
				</td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font>
				</td>
			</tr>
		</table>
	</div>


</body>
</html>
