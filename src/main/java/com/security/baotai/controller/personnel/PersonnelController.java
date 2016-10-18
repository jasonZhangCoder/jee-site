package com.security.baotai.controller.personnel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.security.baotai.bean.StaffSearch;
import com.security.baotai.core.util.Page;
import com.security.baotai.model.personnel.Staff;
import com.security.baotai.service.department.IDepartmentService;
import com.security.baotai.service.personnel.IPersonnelService;
import com.thinkgem.jeesite.common.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/personnel")
public class PersonnelController extends BaseController {

    @Autowired
    private IPersonnelService personnelService;
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping(value = "/entry", method = RequestMethod.GET)
    public String entry(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "modules/personnel/entry";
    }

    @RequestMapping(value = "/entryList", method = RequestMethod.GET)
    public String entryList(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(value = "entryDateStart", required = false) Date entryDateStart,
            @RequestParam(value = "entryDateEnd", required = false) Date entryDateEnd,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        StaffSearch search = new StaffSearch();
        search.setStart((pageNo - 1) * pageSize);
        search.setMaxRows(pageSize);
        search.setEntryDateStart(entryDateStart);
        search.setEntryDateEnd(entryDateEnd);
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
        model.addAttribute("staffList", staffList);
        model.addAttribute("departmentNameMap", departmentNameMap);
        model.addAttribute("page", page);

        return "modules/personnel/entryList";
    }

    @RequestMapping(value = "/entryAdd", method = RequestMethod.GET)
    public String entryAdd(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "modules/personnel/entryAdd";
    }

    @RequestMapping(value = "/entrySave", method = RequestMethod.POST)
    public String entrySave(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(value = "name", required = true) String name, @RequestParam(value = "department", required = true) String department,
            @RequestParam(value = "phone", required = true) String phone, @RequestParam(value = "idNum", required = true) String idNum,
            @RequestParam(value = "isSoldier", required = true) String isSoldier, @RequestParam(value = "entryDate", required = true) Date entryDate,
            @RequestParam(value = "photo", required = true) CommonsMultipartFile photo,
            @RequestParam(value = "idPhotoAbove", required = true) CommonsMultipartFile idPhotoAbove,
            @RequestParam(value = "idPhotoBack", required = true) CommonsMultipartFile idPhotoBack,
            @RequestParam(value = "politicalExamination", required = true) CommonsMultipartFile politicalExamination) {
        
        System.out.println(photo.getContentType() + "--" + photo.getOriginalFilename() + "--" + photo.getSize());
        System.out.println(idPhotoAbove.getContentType() + "--" + idPhotoAbove.getOriginalFilename() + "--" + idPhotoAbove.getSize());
        System.out.println(idPhotoBack.getContentType() + "--" + idPhotoBack.getOriginalFilename() + "--" + idPhotoBack.getSize());
        System.out.println(politicalExamination.getContentType() + "--" + politicalExamination.getOriginalFilename() + "--" + politicalExamination.getSize());
        model.addAttribute("message", "操作成功");
        return entry(request, response, model);
    }
}
