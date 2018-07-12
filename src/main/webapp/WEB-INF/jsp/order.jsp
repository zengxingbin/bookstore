<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />



</head>


<body class="main">
	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/page/index.do">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath }/page/cart.do">&nbsp;购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单
					</div>

					<form id="orderForm" action="${pageContext.request.contextPath }/order/createOrder.do" method="post">
						<table cellspacing="0" class="infocontent">
							<tr>
								<td><table width="100%" border="0" cellspacing="0">
										<tr>
											<td><img src="${pageContext.request.contextPath }/images/buy2.gif" width="635" height="38" />
												<p>您好：${user.userName }先生！欢迎您来到商城结算中心</p></td>
										</tr>
										<tr>
											<td><table cellspacing="1" class="carttable">
													<tr>
														<td width="10%">序号</td>
														<td width="40%">商品名称</td>
														<td width="10%">价格</td>
														<td width="10%">类别</td>
														<td width="10%">数量</td>
														<td width="10%">小计</td>

													</tr>
												</table>
											<c:set var = "count" value = "0"></c:set>
											<table width="100%" border="0" cellspacing="0">
											<c:forEach items = "${cart}" var = "entry" varStatus = "vs">
												
													<tr>
														<td width="10%">${vs.count }</td>
														<td width="40%">${entry.key.name }</td>
														<td width="10%">${entry.key.price }</td>
														<td width="10%">${entry.key.category }</td>
														<td width="10%"><input name="text" type="text"
															value="${entry.value}" style="width:20px" readonly="readonly" /></td>
														<td width="10%">${entry.value * entry.key.price}</td>
														<c:set var = "count" value = "${count + entry.value * entry.key.price}"></c:set>
													</tr>
												<c:set var="total" value="${total+entry.key.price*entry.value  }"></c:set>
											</c:forEach>
                                            </table>
												<table cellspacing="1" class="carttable">
													<tr>
														<td style="text-align:right; padding-right:40px;"><font
															style="color:#FF0000">合计：&nbsp;&nbsp;${total }元</font></td>
														
													</tr>
												</table>

												<p>
													收货地址：<input name="receiverAddress" type="text" value=""
														style="width:350px" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"></a>
													<br /> 收货人：&nbsp;&nbsp;&nbsp;&nbsp;<input
														name="receiverName" type="text" value=""
														style="width:150px" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"></a>
													<br /> 联系方式：<input type="text" name="receiverPhone"
														value="" style="width:150px" />&nbsp;&nbsp;&nbsp;&nbsp;
														<input type = "hidden" name = "money" value = "${count }"/>
												</p>
												<hr />
												<p style="text-align:right">
													<a href = "javascript:void(0);" onclick = "submitOrder()">
														<img src="${pageContext.request.contextPath }/images/gwc_buy.gif" width="204" height="51"
															border="0" />
													</a>
												</p></td>
										</tr>
									</table></td>
							</tr>
						</table>
						<script type = "text/javascript">
							function submitOrder() {
								//获取form结点
								var form = document.getElementById("orderForm");
								form.submit();
							}
						</script>
					</form></td>
			</tr>
		</table>
	</div>


	<jsp:include page="foot.jsp" />


</body>
</html>
