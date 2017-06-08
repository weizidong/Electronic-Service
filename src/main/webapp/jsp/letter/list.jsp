<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/common/head.jsp"%>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="page container-fluid">
		<%@include file="/common/msg.jsp"%>
		<div>
			<h1>电子函列表</h1>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>案件号</th>
					<th>通知对象</th>
					<th>证件号</th>
					<th>送达回执</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.data.list}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.type == 1?'管理员':'普通用户'}</td>
						<td>${user.userid}</td>
						<td>${user.userid}</td>
						<td>
							<div class="btn-group" role="group">
								<a class="btn btn-info" href="#" role="button">重发</a> 
								<a class="btn btn-warning" href="#" role="button">查看回执</a>
								<a class="btn btn-danger" href="#" role="button">删除</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@include file="/common/page.jsp"%>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
<script type="text/javascript">
	setTitle('电子函列表');
</script>
</html>
