package com.security.baotai.controller.personnel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.security.baotai.bean.ProcessDefinitionKeyEnum;
import com.security.baotai.bean.StaffSearch;
import com.security.baotai.bean.StaffStatus;
import com.security.baotai.bean.StaffVo;
import com.security.baotai.core.util.Page;
import com.security.baotai.model.department.Department;
import com.security.baotai.model.personnel.Staff;
import com.security.baotai.model.role.Role;
import com.security.baotai.service.activiti.IActivitiService;
import com.security.baotai.service.department.IDepartmentService;
import com.security.baotai.service.personnel.IPersonnelService;
import com.security.baotai.service.role.IRoleService;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller
@RequestMapping(value = "${adminPath}/personnel")
public class PersonnelController extends BaseController {

    @Autowired
    private IPersonnelService personnelService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IActivitiService activitiService;

    private static final String imgPath = "/upload/";

    @RequestMapping(value = "/entry", method = RequestMethod.GET)
    public String entry(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "modules/personnel/entry";
    }

    @RequestMapping(value = "/entryList", method = RequestMethod.GET)
    public String entryList(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(value = "entryDateStart", required = false) Date entryDateStart,
            @RequestParam(value = "entryDateEnd", required = false) Date entryDateEnd,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        StaffSearch search = new StaffSearch();
        search.setStart((pageNo - 1) * pageSize);
        search.setMaxRows(pageSize);
        search.setEntryDateStart(entryDateStart);
        search.setEntryDateEnd(entryDateEnd);
        search.setName(name);
        int count = personnelService.countStaff(search);
        Page page = new Page(pageNo, pageSize, count);
        List<Staff> staffList = personnelService.getStaffList(search);
        List<String> ids = new ArrayList<String>();
        if (CollectionUtils.isNotEmpty(staffList)) {
            for (Staff staff : staffList) {
                ids.add(staff.getDepartment());
            }
        }
        Map<String, String> departmentNameMap = departmentService.getDepartmentNameMap(ids);
        Map<String, String> roleNameMap = roleService.getAllRoleName(null);
        Map<Integer, String> statusMap = StaffStatus.getStatusMap();
        model.addAttribute("staffList", staffList);
        model.addAttribute("departmentNameMap", departmentNameMap);
        model.addAttribute("roleNameMap", roleNameMap);
        model.addAttribute("statusMap", statusMap);
        model.addAttribute("page", page);

        return "modules/personnel/entryList";
    }

    @RequestMapping(value = "/entryAdd", method = RequestMethod.GET)
    public String entryAdd(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Role> roleList = roleService.getRoles(null);
        model.addAttribute("roleList", roleList);
        return "modules/personnel/entryAdd";
    }

    @RequestMapping(value = "/entryDetail", method = RequestMethod.GET)
    public String entryDetail(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "id", required = true) Long id) {
        Staff staff = personnelService.getStaff(id);

        Department department = departmentService.getDepartment(staff.getDepartment());
        Role role = roleService.getRoleById(staff.getRole());
        staff.setDepartment(department.getName());
        staff.setRole(role.getName());

        model.addAttribute("staff", staff);

        return "modules/personnel/entryDetail";
    }

    @RequestMapping(value = "/entrySave", method = RequestMethod.POST)
    public String entrySave(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(value = "name", required = true) String name, @RequestParam(value = "department", required = true) String department,
            @RequestParam(value = "role", required = true) String role, @RequestParam(value = "phone", required = true) String phone,
            @RequestParam(value = "idNum", required = true) String idNum,
            @RequestParam(value = "isSoldier", required = true) String isSoldier, @RequestParam(value = "entryDate", required = true) Date entryDate,
            @RequestParam(value = "birthday", required = true) Date birthday,
            @RequestParam(value = "photo", required = true) CommonsMultipartFile photo,
            @RequestParam(value = "idPhotoAbove", required = true) CommonsMultipartFile idPhotoAbove,
            @RequestParam(value = "idPhotoBack", required = true) CommonsMultipartFile idPhotoBack,
            @RequestParam(value = "politicalExamination", required = true) CommonsMultipartFile politicalExamination) throws Exception {
        
        String userId = UserUtils.getUser().getId();
        
        Staff staff = new Staff();
        staff.setName(name);
        staff.setDepartment(department);
        staff.setRole(role);
        staff.setPhone(phone);
        staff.setIdNum(idNum);
        staff.setIsSoldier("0".equals(isSoldier.trim()) ? true : false);
        staff.setEntryDate(entryDate);
        staff.setBirthday(birthday);
        if(photo != null){
            staff.setPhoto(uploadImg(request, photo));
        }
        if (idPhotoAbove != null) {
            staff.setIdPhotoAbove(uploadImg(request, idPhotoAbove));
        }
        if (idPhotoBack != null) {
            staff.setIdPhotoBack(uploadImg(request, idPhotoBack));
        }
        if (politicalExamination != null) {
            staff.setPoliticalExamination(uploadImg(request, politicalExamination));
        }
        long staffId = personnelService.addStaff(staff, userId);
        model.addAttribute("message", "操作成功");

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("managers", "yayunjingli");
        activitiService.startProcess(ProcessDefinitionKeyEnum.ENTRY.getProcessDefinitionKey(), getBusinessKey(String.valueOf(staffId), userId), variables);

        return entry(request, response, model);
    }
    
    @RequestMapping(value = "/entryTodo", method = RequestMethod.GET)
    public String entryTodo(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "modules/personnel/entryTodo";
    }

    @RequestMapping(value = "/entryTodoList", method = RequestMethod.GET)
    public String entryTodoList(HttpServletRequest request, HttpServletResponse response, Model model) {

        String loginName = UserUtils.getUser().getLoginName();

        List<Task> list = activitiService.getTasks(ProcessDefinitionKeyEnum.ENTRY.getProcessDefinitionKey(), loginName);

        List<StaffVo> staffList = new ArrayList<StaffVo>();
        List<String> departmentIds = new ArrayList<String>();
        for (Task task : list) {
            ProcessInstance pi = activitiService.getProcessInstance(task.getProcessInstanceId());
            String staffId = getValueFromBusinessKey(pi.getBusinessKey(), 0);

            StaffVo vo = new StaffVo();
            Staff staff = personnelService.getStaff(Long.valueOf(staffId));
            vo.setDepartment(staff.getDepartment());
            vo.setId(staff.getId());
            vo.setName(staff.getName());
            vo.setIdNum(staff.getIdNum());
            vo.setPhone(staff.getPhone());
            vo.setBirthday(staff.getBirthday());
            vo.setEntryDate(staff.getEntryDate());
            vo.setRole(staff.getRole());
            vo.setApplyUser(UserUtils.get(getValueFromBusinessKey(pi.getBusinessKey(), 1)).getName());
            vo.setStatus(staff.getStatus());
            vo.setTaskId(task.getId());
            vo.setProcessDefinitionId(task.getProcessDefinitionId());
            vo.setProcessInstanceId(task.getProcessInstanceId());
            departmentIds.add(staff.getDepartment());
            staffList.add(vo);
        }
        Map<String, String> departmentNameMap = departmentService.getDepartmentNameMap(departmentIds);
        Map<String, String> roleNameMap = roleService.getAllRoleName(null);

        model.addAttribute("staffList", staffList);
        model.addAttribute("departmentNameMap", departmentNameMap);
        model.addAttribute("roleNameMap", roleNameMap);

        return "modules/personnel/entryTodoList";
    }

    @RequestMapping(value = "/auditPage", method = RequestMethod.GET)
    public String auditPage(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(value = "taskId", required = true) String taskId, @RequestParam(value = "staffId", required = true) long staffId) {

        Staff staff = personnelService.getStaff(staffId);

        Department department = departmentService.getDepartment(staff.getDepartment());
        Role role = roleService.getRoleById(staff.getRole());
        staff.setDepartment(department.getName());
        staff.setRole(role.getName());

        model.addAttribute("staff", staff);

        model.addAttribute("taskId", taskId);

        return "modules/personnel/auditPage";
    }

    @RequestMapping(value = "/completeTask", method = RequestMethod.POST)
    public String completeTask(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(value = "taskId", required = true) String taskId, @RequestParam(value = "reason", required = true) String reason,
            @RequestParam(value = "status", required = true) Integer status) {
        
        model.addAttribute("taskId", taskId);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("hr", "hr");
        model.addAttribute("message", "操作成功");
        activitiService.completeTask(taskId, variables);
        return entryTodoList(request, response, model);
    }

    private String uploadImg(HttpServletRequest request, CommonsMultipartFile file) throws IOException {

        @SuppressWarnings("deprecation")
        String basePath = request.getRealPath("/") + imgPath;
        File photoFile = new File(basePath + file.getOriginalFilename());
        FileUtils.writeByteArrayToFile(photoFile, file.getBytes());
        return imgPath + file.getOriginalFilename();
    }
}
