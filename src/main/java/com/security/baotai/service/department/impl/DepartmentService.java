package com.security.baotai.service.department.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.baotai.mapper.department.DepartmentMapper;
import com.security.baotai.model.department.Department;
import com.security.baotai.model.department.DepartmentExample;
import com.security.baotai.service.department.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepartment(String id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Department> getDepartmentByIds(List<String> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            DepartmentExample example = new DepartmentExample();
            example.createCriteria().andIdIn(ids);
            return departmentMapper.selectByExample(example);
        }
        return Collections.emptyList();
    }

    @Override
    public Map<String, String> getDepartmentNameMap(List<String> ids) {
        List<Department> list = getDepartmentByIds(ids);
        if (CollectionUtils.isNotEmpty(list)) {
            Map<String, String> map = new HashMap<String, String>();
            for (Department department : list) {
                map.put(department.getId(), department.getName());
            }
            return map;
        }
        return Collections.emptyMap();
    }

}
