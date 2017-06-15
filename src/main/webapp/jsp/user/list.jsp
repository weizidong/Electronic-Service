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
			<button type="button" class="btn btn-primary pull-right" id="register">注册新用户</button>
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
								<button class="btn btn-info" id="update" data-id="${user.id}">修改</button> 
								<button class="btn btn-warning" id="reset" data-id="${user.id}">重置密码</button>
								<button class="btn btn-danger" id="delete" data-id="${user.id}">删除</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@include file="/common/page.jsp"%>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">注册新用户</h4>
	      </div>
	      <div class="modal-body">
	        <form action="/user/register" method="post">
	        	<input name="type" id="type" style="visibility: hidden;" value="0">
	        	<input name="id" id="id" style="visibility: hidden;">
	        	<div class="form-group" id="userid">
					<label for="exampleInputEmail1">账号：</label>
					<input type="text" name="userid" class="form-control" placeholder="请输入账号...">
				</div>
	        	<div class="form-group" id="name">
					<label for="exampleInputEmail1">姓名：</label>
					<input type="text" name="name" class="form-control" placeholder="请输入姓名...">
				</div>
	        	<div class="form-group" id="pwd">
					<label for="exampleInputEmail1">密码：</label>
					<input type="password" name="pwd" class="form-control" placeholder="请输入密码...">
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
	// 显示弹出层
	function showModel(user){
		$('#userid input').val(user?user.userid:'');
		$('#type').val(user?user.type:0);
		$('#id').val(user?user.id:'');
		$('#name input').val(user?user.name:'');
		$('#registerModal form').attr('action','/user/'+(user?'update':'register'));
		$('#registerModal .modal-title').text(user?'修改用户':'注册新用户');
		user ? $('#userid input').attr('readonly','readonly') : $('#userid input').removeAttr('readonly','readonly');
		$('#registerModal').modal('show');
	}
	// 修改
	$('#update').click(function(){
		var id = $(this).attr('data-id');
		$.get('/user/get/'+id,function(user){
			showModel(user);
		});
	});
	// 重置密码
	$('#reset').click(function(){
		var id = $(this).attr('data-id');
		$.get('/user/reset/'+id,function(data){
			console.log(data);
		});
	});
	// 删除
	$('#delete').click(function(){
		var id = $(this).attr('data-id');
		$.get('/user/delete/'+id,function(data){
			console.log(data);
		});
	});
	// 注册
	$('#register').click(function(){
		showModel();
	});
</script>
</html>
