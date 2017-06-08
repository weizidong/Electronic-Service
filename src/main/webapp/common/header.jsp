<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header">
<!-- 	<h1 class="title">电子推送系统</h1>
 -->	<c:if test="${sessionScope.user != null}">
		<div class="pull-right">${sessionScope.user.name},欢迎您!</div>
	</c:if>
</div>