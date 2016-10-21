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
				<th>出生日期</th>
				<th>入职日期</th>
				<th>申请人</th>
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
					<fmt:formatDate value="${entry.birthday }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<fmt:formatDate value="${entry.entryDate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${entry.applyUser }
				</td>
				<td>
					<a href="${ctx}/personnel/auditPage?taskId=${entry.taskId }&staffId=${entry.id }">审核</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<a href="${ctx}/personnel/entryDetail?id=${entry.id }">查看</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<a target="_blank" href="${pageContext.request.contextPath}/act/diagram-viewer?processDefinitionId=${entry.processDefinitionId}&processInstanceId=${entry.processInstanceId}">跟踪</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>