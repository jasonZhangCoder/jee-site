<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<body>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>部门</th>
				<th>角色</th>
				<th>身份证号</th>
				<th>手机号</th>
				<th>入职日期</th>
				<th>出生日期</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${staffList}" var="entry">
			<tr>
				<td>${entry.name }</td>
				<td>
					${departmentNameMap[entry.department] }
				</td>
				<td>
					${roleNameMap[entry.role] }
				</td>
				<td>
					${entry.idNum }
				</td>
				<td>
					${entry.phone }
				</td>
				<td>
					<fmt:formatDate value="${entry.entryDate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<fmt:formatDate value="${entry.birthday }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${statusMap[entry.status] }
				</td>
				<td>
					<a href="${ctx}/personnel/entryDetail?id=${entry.id }">查看</a> &nbsp;&nbsp;<a href="${ctx}/personnel/entryDetail?id=${entry.id }" onclick="return confirmx('确认要删除吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>