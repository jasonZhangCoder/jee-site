package com.security.baotai.service.role.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.baotai.mapper.role.RoleMapper;
import com.security.baotai.model.role.Role;
import com.security.baotai.model.role.RoleExample;
import com.security.baotai.service.role.IRoleService;
import com.thinkgem.jeesite.common.utils.StringUtils;

@Service
public class RoleServicve implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoles(String department) {
        RoleExample example = new RoleExample();
        if(StringUtils.isNotEmpty(department)){
            example.createCriteria().andOfficeIdEqualTo(department);
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public Map<String, String> getAllRoleName(String department) {
        List<Role> list = getRoles(department);

        Map<String, String> map = new HashMap<String, String>();
        for (Role role : list) {
            map.put(role.getId(), role.getName());
        }
        return map;
    }

    @Override
    public Role getRoleById(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

}
