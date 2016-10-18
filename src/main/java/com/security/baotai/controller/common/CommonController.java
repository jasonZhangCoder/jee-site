package com.security.baotai.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.security.baotai.model.role.Role;
import com.security.baotai.service.role.IRoleService;
import com.thinkgem.jeesite.common.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/common")
public class CommonController extends BaseController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/entry", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> entry(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(value = "department", required = false) String department) {
        List<Role> roleList = roleService.getRoles(department);
        return roleList;
    }
}
