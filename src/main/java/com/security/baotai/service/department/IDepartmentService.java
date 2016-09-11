package com.security.baotai.service.department;

import java.util.List;
import java.util.Map;

import com.security.baotai.model.department.Department;

public interface IDepartmentService {
    Department getDepartment(String id);

    List<Department> getDepartmentByIds(List<String> ids);

    Map<String, String> getDepartmentNameMap(List<String> ids);
}
