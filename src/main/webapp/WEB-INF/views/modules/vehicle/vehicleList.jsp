<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<body>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>车牌号</th>
				<th>部门</th>
				<th>司机</th>
				<th>里程</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${vehicleList}" var="vehicle">
			<tr>
				<td>${vehicle.licenseNum }</td>
				<td>
					${departmentNameMap[vehicle.department] }
				</td>
				<td>
					${vehicle.driver }
				</td>
				<td>
					${vehicle.mileage }
				</td>
				<td>
					<a href="${ctx}/vehicle/update?id=${vehicle.id }">修改</a> &nbsp;&nbsp;<a href="${ctx}/vehicle/delete?id=${vehicle.id }" onclick="return confirmx('确认要删除吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>