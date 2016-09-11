package com.security.baotai.bean;

public class VehicleInformationSearch {
    private Integer start;

    private Integer maxRows;

    private String licenseNum;

    private String department;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(Integer maxRows) {
        this.maxRows = maxRows;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
