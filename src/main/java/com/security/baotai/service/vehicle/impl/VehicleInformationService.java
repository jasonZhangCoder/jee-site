package com.security.baotai.service.vehicle.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.baotai.bean.VehicleInformationSearch;
import com.security.baotai.core.dao.Limit;
import com.security.baotai.mapper.vehicle.VehicleInformationMapper;
import com.security.baotai.model.vehicle.VehicleInformation;
import com.security.baotai.model.vehicle.VehicleInformationExample;
import com.security.baotai.service.vehicle.IVehicleInformationService;
import com.thinkgem.jeesite.common.utils.StringUtils;

@Service
public class VehicleInformationService implements IVehicleInformationService {

    @Autowired
    private VehicleInformationMapper vehicleInformationMapper;

    @Override
    public VehicleInformation getVehicleInformation(long id) {
        return vehicleInformationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addVehicleInformation(VehicleInformation vehicleInformation) {
        vehicleInformationMapper.insertSelective(vehicleInformation);
    }

    @Override
    public void updateVehicleInformation(VehicleInformation vehicleInformation) {
        vehicleInformationMapper.updateByPrimaryKeySelective(vehicleInformation);
    }

    @Override
    public void deleteVehicleInformation(long id) {
        vehicleInformationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<VehicleInformation> getVehicleInformations(VehicleInformationSearch search) {
        VehicleInformationExample example = new VehicleInformationExample();
        VehicleInformationExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(search.getLicenseNum())) {
            criteria.andLicenseNumLike("%" + search.getLicenseNum().trim() + "%");
        }
        if (StringUtils.isNotEmpty(search.getDepartment())) {
            criteria.andDepartmentEqualTo(search.getDepartment());
        }
        example.setLimit(new Limit(search.getStart(), search.getMaxRows()));
        example.setOrderByClause(" create_time desc");
        return vehicleInformationMapper.selectByExample(example);
    }

    @Override
    public int countVehicleInformations(VehicleInformationSearch search) {
        VehicleInformationExample example = new VehicleInformationExample();
        VehicleInformationExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(search.getLicenseNum())) {
            criteria.andLicenseNumLike("%" + search.getLicenseNum().trim() + "%");
        }
        if (StringUtils.isNotEmpty(search.getDepartment())) {
            criteria.andDepartmentEqualTo(search.getDepartment());
        }
        return vehicleInformationMapper.countByExample(example);
    }

}
