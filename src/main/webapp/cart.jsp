<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type = "text/javascript" src = "js/my.js"></script>
</head>

<body class="main">

	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />


	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;购物车
					</div>

					<table cellspacing="0" class="infocontent">
						<tr>
							<td><img src="ad/page_ad.jpg" width="666" height="89" />
								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td><img src="images/buy1.gif" width="635" height="38" />
										</td>
									</tr>
									<tr>
										<td>
										<table cellspacing="1" class="carttable">
												<tr>
													<td width="4%">序号</td>
													<td width = "%6">全选<input id = "checkboxid" type = "checkbox" checked = "checked" onclick = "chooseAll(this.checked)" /></td>
													<td width="30%">商品名称</td>
													<td width="10%">价格</td>
													<td width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量</td>
													<td width="10%">库存</td>
													<td width="10%">小计</td>
													<td width="10%">取消</td>
												</tr>
											</table> 
										
											<c:forEach items = "${user.cart}" var = "entry" varStatus = "vs">
												<table id = "tableid${vs.count}" width="100%" border="0" cellspacing="0">
													<tr>
														<td width="4%">${vs.count}</td>
														<td width = "6%"><input id = "${entry.key.id }" name = "boxes" type = "checkbox" checked = "checked" onclick = "choose()" ${entry.key.pnum == 0?"disabled = 'disabled'":"" }/></td>
														<td width="30%">${entry.key.name }</td>

														<td width="10%">${entry.key.price }</td>
														<td width="20%">
														<input id = "inputid1${vs.count }"type="button" value='-' onclick = "changeProductNum2('${entry.key.id }',this.id,'${vs.count }')"
															style="width:20px">

															<input id = "inputid2${vs.count }" name="text" type="text"  onblur = "changeProductNum3('${entry.key.id }','${vs.count }')" value="${entry.value}"
															style="width:40px;text-align:center" /> <input id = "inputid3${vs.count }"
															type="button" value='+' onclick = "changeProductNum2('${entry.key.id }',this.id,'${vs.count }')" style="width:20px">

														</td>
														<td width="10%">${entry.key.pnum }</td>
														<td id = "tdid${vs.count}" width="10%">${entry.value * entry.key.price}</td>

														<td width="10%"><a href="javascript:void(0);" onclick = "deleteProduct('${entry.key.id}','tableid${vs.count}')"
															style="color:#FF0000; font-weight:bold">X</a></td>
													</tr>
												</table>
											</c:forEach>
											

											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align:right; padding-right:40px;"><font id = "fontid"
														style="color:#FF6600; font-weight:bold">合计：&nbsp;&nbsp;${total}元</font>
													</td>
												</tr>
											</table>
											 
												
											<div style="text-align:right; margin-top:10px">
												<a
													href="${pageContext.request.contextPath }/product?method=page"><img
													src="images/gwc_jx.gif" border="0" /> </a>

												&nbsp;&nbsp;&nbsp;&nbsp;<a
													href="javascript:void(0);" onclick = "checkout()"><img
													src="images/gwc_buy.gif" border="0" /> </a>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
