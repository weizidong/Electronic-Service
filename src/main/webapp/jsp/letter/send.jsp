<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/common/head.jsp"%>
<body>
	<%@include file="/common/header.jsp"%>
	<form action="/letter/send" method="post">
		<c:if test="${requestScope.msg != null}">
			<div>${requestScope.msg}</div>
		</c:if>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<h2>发送电子函</h2>
			</div>
		</div>
		<div class="form-group">
			<label for="userid" class="col-sm-2 control-label">账号：</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="userid" name="userid" placeholder="请输入账号...">
			</div>
		</div>
		<div class="form-group">
			<label for="pwd" class="col-sm-2 control-label">密码：</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入密码...">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">登录</button>
			</div>
		</div>
	</form>	
	<%@include file="/common/footer.jsp"%>
</body>
<script type="text/javascript">
	setTitle('显示用户');
</script>
</html>
