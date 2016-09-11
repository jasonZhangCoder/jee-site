<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/vehicle/info/">车辆列表</a></li>
		<li class="active"><a href="#">修改车辆</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="oaNotify" action="${ctx}/vehicle/save" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${vehicleInformation.id }">
		<div class="control-group">
			<label class="control-label">车牌号：</label>
			<div class="controls">
				<input name="licenseNum" maxlength="200" class="input-xlarge required" value="${vehicleInformation.licenseNum }"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">归属部门:</label>
			<div class="controls">
                <sys:treeselect id="office" name="department" value="${vehicleInformation.department }" labelName="officeName" labelValue="${departmentName }"
					title="部门" url="/sys/office/treeData?type=2" cssClass="required" notAllowSelectParent="true"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">司机：</label>
			<div class="controls">
				<input name="driver" maxlength="200" value="${vehicleInformation.driver }" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">里程：</label>
			<div class="controls">
				<input name="mileage" value="${vehicleInformation.mileage }" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		<div class="form-actions">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
				<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>