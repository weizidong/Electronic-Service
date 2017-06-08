<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/common/head.jsp"%>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="page container-fluid">
		<%@include file="/common/msg.jsp"%>
		<c:if test="${requestScope.letter == null }">
		
		</c:if>
		<c:if test="${requestScope.letter != null }">
			
		</c:if>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
<script type="text/javascript">
	setTitle('接收电子函');
</script>
</html>
