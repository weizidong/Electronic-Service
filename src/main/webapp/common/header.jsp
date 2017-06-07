<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header">
	<c:if test="${sessionScope.user != null}">
		<div>${sessionScope.user.name},欢迎您!</div>
	</c:if>
</div>