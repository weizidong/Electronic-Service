<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/common/head.jsp"%>
<body>
	<%@include file="/common/header.jsp"%>
	<form action="${pageContext.request.contextPath}/user/login" method="post">
		<c:if test="${requestScope.msg != null}">
			<div>${requestScope.msg}</div>
		</c:if>
		<div>
			<input id="userid" name="userid" />
		</div>
		<div>
			<input id="pwd" name="pwd" />
		</div>
		<div>
			<input type="submit" value="登录">
		</div>
	</form>
	<%@include file="/common/footer.jsp"%>
</body>
<script type="text/javascript">
	setTitle('首页');
</script>
</html>
