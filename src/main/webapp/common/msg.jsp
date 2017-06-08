<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${requestScope.msg != null}">
	<div class="alert ${requestScope.msg.code == 200 ?'alert-success':'alert-danger'} alert-dismissible fade in" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  ${requestScope.msg.msg}
	</div>
	<script type="text/javascript">
		setTimeout(function () {
			$('.alert').alert('close');
		}, 2000);
	</script>
</c:if>