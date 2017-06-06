<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@include file="/common/page.jsp"%>
<html lang="zh-CN">
<%@include file="/common/head.jsp"%>
<body>
	<%@include file="/common/header.jsp"%>
	<form action="${pageContext.request.contextPath}/user/login"
		method="post">
		<div>
			<input id="userid" name="userid" />
		</div>
		<div>
			<input id="pwd" name="pwd" />
		</div>
	</form>
	<%@include file="/common/footer.jsp"%>
</body>
<script type="text/javascript">
	setTitle('首页');
</script>
</html>
