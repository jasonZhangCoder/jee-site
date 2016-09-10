package com.security.baotai.bean;

import java.io.Serializable;

public class VehicleInformationBean implements Serializable {

    private static final long serialVersionUID = 7555262134584118589L;

    private String licenseNum;

    private String department;

    private String driver;

    private Double mileage;

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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }
}
