<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>入职申请</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function checkValues(){
			var name = $("#name").val();
			if(name==null || name==''){
				alert("姓名不能为空!");
				return false
			}
			var department = $("#departmentId").val();
			if(department==null || department==''){
				alert("部门不能为空!");
				return false
			}
			var phone = $("#phone").val();
			if(phone==null || phone==''){
				alert("手机不能为空!");
				return false
			}
			var idNum = $("#idNum").val();
			if(idNum==null || idNum==''){
				alert("身份证号不能为空!");
				return false
			}
			var photo = $("#photo").val();
			if(photo==null || photo==''){
				alert("请上传照片!");
				return false
			}
			var idPhotoAbove = $("#idPhotoAbove").val();
			
			var idPhotoBack = $("#idPhotoBack").val();
			var politicalExamination = $("#politicalExamination").val();
			var idPhotoAbove = $("#idPhotoAbove").val();
			var entryDate = $("#entryDate").val();
			if(entryDate==null || entryDate==''){
				alert("入职日期不能为空!");
				return false
			}
			return true;
		}
		
		function queryRoles(){
			alert();
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/personnel/entry">入职申请列表</a></li>
		<li class="active"><a href="#">入职申请</a></li>
	</ul><br/>
	<form id="inputForm" action="${ctx}/personnel/entrySave" method="post" enctype="multipart/form-data" onsubmit="return checkValues();" class="form-horizontal">
		<div class="control-group">
			<label class="control-label">真实姓名：</label>
			<div class="controls">
				<input id="name" name="name" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">归属部门:</label>
			<div class="controls">
                <sys:treeselect id="department" name="department" value="" labelName="officeName" labelValue=""
					title="部门" url="/sys/office/treeData?type=2" cssClass="required" notAllowSelectParent="true"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">角色:</label>
			<div class="controls">
                <select id="role" name="role" onclick="queryRoles();">
                	<option value="">--选择--</option>
                </select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机号：</label>
			<div class="controls">
				<input id="phone" name="phone" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份证号：</label>
			<div class="controls">
				<input id="idNum" name="idNum" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否当过兵：</label>
			<div class="controls">
				<input name="isSoldier" type="radio" value="0"/>是 <input name="isSoldier" type="radio" value="1" checked="checked"/>否
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">照片：</label>
			<div class="controls">
				<input id="photo" name="photo" type="file"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份照片正面：</label>
			<div class="controls">
				<input id="idPhotoAbove" name="idPhotoAbove" type="file"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份照片反面：</label>
			<div class="controls">
				<input id="idPhotoBack" name="idPhotoBack" type="file"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">政审表照片：</label>
			<div class="controls">
				<input id="politicalExamination" name="politicalExamination" type="file"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">入职时间：</label>
			<div class="controls">
				<input id="entryDate" name="entryDate" type="text" readonly="readonly" maxlength="20" class="Wdate required"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		
		<div class="form-actions">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
				<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>