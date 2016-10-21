<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>审核</title>
	<meta name="decorator" content="default"/>
	
	<script type="text/javascript">
	function audit(status){
		$("#status").val(status);
		alert(1);
		$("#auditForm").submit();
		alert(2);
	}
	</script>
</head>
<body>
	<form class="form-horizontal">
		<div class="control-group">
			<label class="control-label">真实姓名：</label>
			<div class="controls">
				${staff.name }
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">归属部门：</label>
			<div class="controls">
                ${staff.department }
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">角色：</label>
			<div class="controls">
                ${staff.role }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机号：</label>
			<div class="controls">
				${staff.phone }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份证号：</label>
			<div class="controls">
				${staff.idNum }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否当过兵：</label>
			<div class="controls">
				${staff.isSoldier?"是":"否" }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">入职日期：</label>
			<div class="controls">
				<fmt:formatDate value="${staff.entryDate }" pattern="yyyy-MM-dd"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">出生日期：</label>
			<div class="controls">
				<fmt:formatDate value="${staff.birthday }" pattern="yyyy-MM-dd"/>
			</div>		
		</div>
		
		<div class="control-group">
			<table>
				<tr>
					<td>
						<label class="control-label">照片：</label>
						<div class="controls">
							<img src="<%=request.getContextPath() %>${staff.photo }" width="150" height="150">
						</div>
					</td>
					<td>
						<label class="control-label">身份照片正面：</label>
						<div class="controls">
							<img src="<%=request.getContextPath() %>${staff.idPhotoAbove }" width="150" height="150">
						</div>
					</td>
					<td>
						<label class="control-label">身份照片反面：</label>
						<div class="controls">
							<img src="<%=request.getContextPath() %>${staff.idPhotoBack }" width="150" height="150">
						</div>
					</td>
					<td>
						<label class="control-label">政审表照片：</label>
						<div class="controls">
							<img src="<%=request.getContextPath() %>${staff.politicalExamination }" width="150" height="150">
						</div>
					</td>
				</tr>
			</table>
		</div>
		
		<br/>
		<div class="control-group">
			<form id="auditForm" action="${ctx}/personnel/completeTask" method="post" class="form-horizontal">
			<input type="text" name="taskId" value="${taskId }"/>
			<input type="text" name="status" id="status"/>
			<table>
				<tr>
					<td>
						<label class="control-label">意见：</label>
						<textarea rows="5" cols="20" name="reason"></textarea>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input id="btnSubmit" class="btn btn-primary" type="button" value="同意" onclick="audit('1');"/>&nbsp;
						<input id="btnCancel" class="btn" type="button" value="拒绝" onclick="audit('2');"/>
					</td>
				</tr>
			</table>	
			</form>	
		</div>
		</form>
</body>
</html>