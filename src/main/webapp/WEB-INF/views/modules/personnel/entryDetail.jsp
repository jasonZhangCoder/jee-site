<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>入职申请</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/personnel/entry">入职申请列表</a></li>
		<li class="active"><a href="${ctx}/personnel/entryAdd">入职申请</a></li>
	</ul><br/>
		<div class="control-group">
			<label class="control-label">真实姓名：</label>
			<div class="controls">
				<input id="name" name="name" maxlength="200" class="input-xlarge required" readonly="readonly" value="${name }"/>
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">归属部门:</label>
			<div class="controls">
                <input type="text" value="${name }"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机号：</label>
			<div class="controls">
				<input id="phone" name="phone" maxlength="200" class="input-xlarge required" readonly="readonly" value="${phone }"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份证号：</label>
			<div class="controls">
				<input id="idNum" name="idNum" maxlength="200" class="input-xlarge required" readonly="readonly" value="${idNum }"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否当过兵：</label>
			<div class="controls">
				<input name="isSoldier" type="radio" value="0"  ${idNum==0?"checked":"" }/>是 <input name="isSoldier" type="radio" value="1" ${idNum==1?"checked":"" }/>否
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">照片：</label>
			<div class="controls">
				<img src="${photo }">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份照片正面：</label>
			<div class="controls">
				<img src="${idPhotoAbove }">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份照片反面：</label>
			<div class="controls">
				<img src="${idPhotoBack }">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">政审表照片：</label>
			<div class="controls">
				<img src="${politicalExamination }">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">入职时间：</label>
			<div class="controls">
				${entryDate }
			</div>
		</div>
</body>
</html>