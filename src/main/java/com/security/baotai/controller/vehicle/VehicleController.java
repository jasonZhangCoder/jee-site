package com.security.baotai.controller.vehicle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.baotai.bean.VehicleInformationSearch;
import com.security.baotai.model.VehicleInformation;
import com.security.baotai.service.IVehicleInformationService;
import com.thinkgem.jeesite.common.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/vehicle")
public class VehicleController extends BaseController {

    @Autowired
    private IVehicleInformationService vehicleInformationService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "modules/vehicle/vehicle";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, HttpServletResponse response, VehicleInformationSearch search, Model model) {

        List<VehicleInformation> list = vehicleInformationService.getVehicleInformations(search);
        model.addAttribute("list", list);

        return "modules/vehicle/vehicleList";
    }

}
