<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	function search(){
		var licenseNum = $("#licenseNum").val();
		$("#listDiv").load("/vehicle/list");
	}
	</script>
</head>
<body onload="search();">

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<tr>
			<td>
				<li><label>车牌：</label>
				<input type="text" id="licenseNum" size="20"/>
				</li>
			</td>
			<td align="right">
				<input class="btn btn-primary"  type="button" value="搜索" onclick="search();">
				<input class="btn btn-primary"  type="button" value="添加" onclick="toAdd();">
			</td>
		</tr>
	</table>
	<div id="listDiv">
	</div>
</body>
</html>