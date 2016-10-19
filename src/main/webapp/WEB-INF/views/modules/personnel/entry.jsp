<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
<html>
<head>
	<title>入职管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	$(document).ready(function() {
		initSearch();
	});
	
	function initSearch(){
		$("#listDiv").load("<%=request.getContextPath() %>/a/personnel/entryList");
	}
	
	function search(){
		var entryDateStart = $("#startTime").val();
		var entryDateEnd = $("#endTime").val();
		var name = $("#name").val();
		$("#listDiv").load("<%=request.getContextPath() %>/a/personnel/entryList?entryDateStart="+entryDateStart+"&entryDateEnd="+entryDateEnd+"&name="+name);
	}
	
	function page(n,s){
		var licenseNum = $("#licenseNum").val();
		var department = $("#departmentId").val();
		$("#listDiv").load("<%=request.getContextPath() %>/a/personnel/entryList?licenseNum="+licenseNum+"&department="+department+"&pageNo="+n+"&pageSize="+s);
    	return false;
    }
	</script>
</head>
<body onload="search()">
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">入职申请列表</a></li>
		<li><a href="${ctx}/personnel/entryAdd">入职申请</a></li>
	</ul>
	<form id="searchForm" class="breadcrumb form-search">
	<sys:message content="${message}"/>
	<ul class="ul-form">
			<%-- <li><label>归属部门：</label>
			<sys:treeselect id="department" name="department" labelName="departmentName"  value="${user.office.id}" labelValue="" 
				title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li> --%>
			
			
			<ul class="ul-form">
				<li><label class="control-label">开始时间：</label>
						<input id="startTime" name="startTime" type="text" readonly="readonly" maxlength="20" class="Wdate required"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				</li>
				
				<li>
					<label class="control-label">结束时间：</label>
						<input id="endTime" name="endTime" type="text" readonly="readonly" maxlength="20" class="Wdate required"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				</li>
				
				<li>
					<label class="control-label">名字：</label>
						<input id="name" name="name" type="text" />
				</li>
				
				<li class="btns"><input class="btn btn-primary" type="button" value="查询" onclick="search();"/></li>
				<li class="clearfix"></li>
			</ul>
		
			
		</ul>
	</form>	
	<div id="listDiv">
	</div>
</body>
</html>