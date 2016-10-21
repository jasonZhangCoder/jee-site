package com.security.baotai.bean;

public enum BusinessKeyEnum {

    ENTRY("entry", "入职流程");

    private BusinessKeyEnum(String businessKey, String businessDesc) {
        this.businessKey = businessKey;
        this.businessDesc = businessDesc;
    }
    private String businessKey;

    private String businessDesc;

    public String getBusinessKey() {
        return businessKey;
    }

    public String getBusinessDesc() {
        return businessDesc;
    }

}
