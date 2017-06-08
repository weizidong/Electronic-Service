<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/common/head.jsp"%>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="page container-fluid">
		<%@include file="/common/msg.jsp"%>
		<div>
			<h1>用户列表</h1>
			<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#register">注册新用户</button>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>账户类型</th>
					<th>账号</th>
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
						<td>
							<div class="btn-group" role="group">
								<a class="btn btn-info" href="#" role="button">修改</a> 
								<a class="btn btn-warning" href="#" role="button">重置密码</a>
								<a class="btn btn-danger" href="#" role="button">删除</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@include file="/common/page.jsp"%>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">注册新用户</h4>
	      </div>
	      <div class="modal-body">
	        <form action="${pageContext.request.contextPath}/user/register" method="post">
	        	<input name="type" style="visibility: hidden;" value="0">
	        	<div class="form-group">
					<label for="exampleInputEmail1">姓名：</label>
					<input type="text" name="name" class="form-control" id="name" placeholder="请输入姓名...">
				</div>
	        	<div class="form-group">
					<label for="exampleInputEmail1">账号：</label>
					<input type="text" name="userid" class="form-control" id="userid" placeholder="请输入账号...">
				</div>
	        	<div class="form-group">
					<label for="exampleInputEmail1">密码：</label>
					<input type="password" name="pwd" class="form-control" id="pwd" placeholder="请输入密码...">
				</div>
				<div class="modal-footer">
				    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				    <button type="submit" class="btn btn-primary">确定</button>
			    </div>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
<script type="text/javascript">
	setTitle('用户列表');
</script>
</html>
