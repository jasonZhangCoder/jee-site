<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
<html>
<head>
	<title>车辆管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	$(document).ready(function() {
		initSearch();
	});
	
	function initSearch(){
		$("#listDiv").load("<%=request.getContextPath() %>/a/vehicle/list");
	}
	
	function search(){
		
		var licenseNum = $("#licenseNum").val();
		var department = $("#departmentId").val();
		$("#listDiv").load("<%=request.getContextPath() %>/a/vehicle/list?licenseNum="+licenseNum+"&department="+department);
	}
	
	function page(n,s){
		var licenseNum = $("#licenseNum").val();
		var department = $("#departmentId").val();
		$("#listDiv").load("<%=request.getContextPath() %>/a/vehicle/list?licenseNum="+licenseNum+"&department="+department+"&pageNo="+n+"&pageSize="+s);
    	return false;
    }
	</script>
</head>
<body onload="search()">
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">车辆列表</a></li>
		<li><a href="${ctx}/vehicle/add">车辆添加</a></li>
	</ul>
	<form id="searchForm" class="breadcrumb form-search">
	<sys:message content="${message}"/>
	<ul class="ul-form">
			<li><label>车牌号：</label>
				<input type="text" id="licenseNum" name="licenseNum" size="20"/>
			</li>
			
			<li><label>归属部门：</label>
			<sys:treeselect id="department" name="department" labelName="departmentName"  value="${user.office.id}" labelValue="" 
				title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li class="btns"><input class="btn btn-primary" type="button" value="查询" onclick="search();"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>	
	<div id="listDiv">
	</div>
</body>
</html>