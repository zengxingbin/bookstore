<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type = "text/javascript">
	function test(id) {
		alert(id);
	}
</script>
</head>
<body>
	<input id = "inputid" type = "button" value = "点击" onclick = "test(this.id)"/>
</body>
</html>