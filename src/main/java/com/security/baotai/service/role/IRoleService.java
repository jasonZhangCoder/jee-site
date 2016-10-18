package com.security.baotai.service.role;

import java.util.List;
import java.util.Map;

import com.security.baotai.model.role.Role;

public interface IRoleService {

    List<Role> getRoles(String department);

    Map<String, String> getAllRoleName(String department);

    Role getRoleById(String id);
}
