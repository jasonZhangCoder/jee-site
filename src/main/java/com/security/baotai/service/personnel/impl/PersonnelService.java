package com.security.baotai.service.personnel.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.baotai.bean.StaffSearch;
import com.security.baotai.core.dao.Limit;
import com.security.baotai.mapper.personnel.StaffMapper;
import com.security.baotai.model.personnel.Staff;
import com.security.baotai.model.personnel.StaffExample;
import com.security.baotai.service.personnel.IPersonnelService;

@Service
public class PersonnelService implements IPersonnelService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> getStaffList(StaffSearch search) {
        StaffExample example = new StaffExample();
        StaffExample.Criteria criteria = example.createCriteria();
        if (search.getEntryDateStart() != null) {
            criteria.andEntryDateGreaterThan(search.getEntryDateStart());
        }
        if (search.getEntryDateEnd() != null) {
            criteria.andEntryDateLessThan(search.getEntryDateEnd());
        }
        example.setLimit(new Limit(search.getStart(), search.getMaxRows()));
        example.setOrderByClause(" create_time desc ");
        return staffMapper.selectByExample(example);
    }

    @Override
    public int countStaff(StaffSearch search) {
        StaffExample example = new StaffExample();
        StaffExample.Criteria criteria = example.createCriteria();
        if (search.getEntryDateStart() != null) {
            criteria.andEntryDateGreaterThan(search.getEntryDateStart());
        }
        if (search.getEntryDateEnd() != null) {
            criteria.andEntryDateLessThan(search.getEntryDateEnd());
        }
        return staffMapper.countByExample(example);
    }

    @Override
    public void addStaff(Staff staff) {

        staffMapper.insertSelective(staff);
    }

}
