package com.security.baotai.controller.vehicle;

import java.util.ArrayList;
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

import com.security.baotai.bean.VehicleInformationSearch;
import com.security.baotai.core.util.Page;
import com.security.baotai.model.VehicleInformation;
import com.security.baotai.model.department.Department;
import com.security.baotai.service.IVehicleInformationService;
import com.security.baotai.service.department.IDepartmentService;
import com.thinkgem.jeesite.common.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/vehicle")
public class VehicleController extends BaseController {

    @Autowired
    private IVehicleInformationService vehicleInformationService;
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "modules/vehicle/vehicle";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(value = "licenseNum", required = false) String licenseNum, @RequestParam(value = "department", required = false) String department,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {

        VehicleInformationSearch search = new VehicleInformationSearch();
        search.setStart((pageNo - 1) * pageSize);
        search.setMaxRows(pageSize);
        search.setLicenseNum(licenseNum);
        search.setDepartment(department);
        int count = vehicleInformationService.countVehicleInformations(search);
        Page page = new Page(pageNo, pageSize, count);
        List<VehicleInformation> vehicleList = vehicleInformationService.getVehicleInformations(search);
        List<String> ids = new ArrayList<String>();
        if (CollectionUtils.isNotEmpty(vehicleList)) {
            for (VehicleInformation vehicle : vehicleList) {
                ids.add(vehicle.getDepartment());
            }
        }
        Map<String, String> departmentNameMap = departmentService.getDepartmentNameMap(ids);
        model.addAttribute("vehicleList", vehicleList);
        model.addAttribute("departmentNameMap", departmentNameMap);
        model.addAttribute("page", page);
        return "modules/vehicle/vehicleList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "modules/vehicle/vehicleAdd";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "id", required = true) long id) {
        VehicleInformation vehicleInformation = vehicleInformationService.getVehicleInformation(id);
        Department department = departmentService.getDepartment(vehicleInformation.getDepartment());
        model.addAttribute("vehicleInformation", vehicleInformation);
        model.addAttribute("departmentName", department != null ? department.getName() : "");
        return "modules/vehicle/vehicleUpdate";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, HttpServletResponse response, Model model, VehicleInformation vehicleInformation) {
        if (vehicleInformation.getId() != null && vehicleInformation.getId() > 0) {
            vehicleInformationService.updateVehicleInformation(vehicleInformation);
        } else {
            vehicleInformationService.addVehicleInformation(vehicleInformation);
        }
        model.addAttribute("message", "操作成功");
        return info(request, response, model);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "id", required = true) long id) {
        vehicleInformationService.deleteVehicleInformation(id);
        model.addAttribute("message", "操作成功");
        return info(request, response, model);
    }
}
