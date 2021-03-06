package com.security.baotai.service.personnel;

import java.util.List;

import com.security.baotai.bean.StaffSearch;
import com.security.baotai.model.personnel.Staff;

public interface IPersonnelService {

    List<Staff> getStaffList(StaffSearch search);

    int countStaff(StaffSearch search);

    long addStaff(Staff staff, String operator);

    Staff getStaff(long id);

    void updateStaffStatus(long staffId, String reason);
}
