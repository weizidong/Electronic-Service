<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/common/head.jsp"%>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="page container-fluid">
		<form action="${pageContext.request.contextPath}/letter/send" method="post" class="form-horizontal">
			<c:if test="${requestScope.msg != null}">
				<div>${requestScope.msg}</div>
			</c:if>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<h2>发送电子函</h2>
				</div>
			</div>
			<div class="form-group">
				<label for="userid" class="col-sm-2 control-label">案件号：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title" placeholder="请输入案件号...">
				</div>
			</div>
			<div class="form-group">
				<label for="userid" class="col-sm-2 control-label">发送对象：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="target" name="target" placeholder="请输入发送对象...">
				</div>
			</div>
			<div class="form-group">
				<label for="userid" class="col-sm-2 control-label">身份证：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="idCard" name="idCard" placeholder="请输入身份证号码...">
				</div>
			</div>
			<div class="form-group">
				<label for="userid" class="col-sm-2 control-label">手机号码：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号码...">
				</div>
			</div>
			<div class="form-group">
				<label for="userid" class="col-sm-2 control-label">手机号码：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号码...">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">发送</button>
				</div>
			</div>
		</form>	
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
<script type="text/javascript">
	setTitle('发送电子函');
</script>
</html>
