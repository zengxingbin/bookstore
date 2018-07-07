<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>bookStore列表</title>
<%--导入css --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
					</div>

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>商品目录</h1>
								<hr />
								<h1>计算机</h1>&nbsp;&nbsp;&nbsp;&nbsp;共${pb.count }种商品
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img
										src="${pageContext.request.contextPath }/images/productlist.gif"
										width="100%" height="38" />
								</div>
							<c:forEach items="${list}" var="a">
								<table cellspacing="0" class="booklist">
									<tr>
										<c:forEach items="${a }" var="b">
											<td>

												<div class="divbookpic">
													<p>
														<a href="${pageContext.request.contextPath }/product?method=findBookInfo&id=${b.id}"><img
															src="${pageContext.request.contextPath }/bookcover/${b.imgurl}"
															width="115" height="129" border="0" /> </a>
													</p>
												</div>

												<div class="divlisttitle">
													<a
														href="${pageContext.request.contextPath }/product?method=findBookInfo&id=${b.id}">书名:${b.name
														}<br />售价:${b.price } </a>
												</div>
											</td>
										</c:forEach>
									</tr>
								</table>
							</c:forEach>
















								<div class="pagination">
									<ul>


										<li class="disablepage"><a
											href="${pageContext.request.contextPath  }/product?method=page&currentPage=${pb.currentPage==1?1:pb.currentPage-1}&category=${pb.category}">&lt;&lt;上一页</a>
										</li>
										<c:if test="${pb.totalPage <=4}">
											<c:forEach var = "i" begin = "1" end = "${pb.totalPage }" step = "1">
										<li><a href="${pageContext.request.contextPath}/product?method=page&currentPage=${i}">${i}</a>
										</li>
										</c:forEach>
										</c:if>
										<c:if test="${pb.totalPage >4}">
											<c:forEach var = "i" begin = "${pb.currentPage + 3 <= pb.totalPage ? pb.currentPage :pb.currentPage - (4-(pb.totalPage - pb.currentPage)) + 1}" end = "${pb.currentPage + 3< pb.totalPage?pb.currentPage + 3 :pb.totalPage }" step = "1">
												<li><a href="${pageContext.request.contextPath}/product?method=page&currentPage=${i}">${i}</a>
												</li>
											</c:forEach>
										</c:if>
										
										

										<li class="nextPage"><a
											href="${pageContext.request.contextPath  }/product?method=page&currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}&category=${pb.category}">下一页&gt;&gt;</a>
										</li>
										<li>第${pb.currentPage }页/共${pb.totalPage }页</li>			

									</ul>
								</div></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
