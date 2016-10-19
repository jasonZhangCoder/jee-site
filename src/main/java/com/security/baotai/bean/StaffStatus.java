package com.security.baotai.bean;

import java.util.HashMap;
import java.util.Map;

public enum StaffStatus {
    APPLYING(0, "提交申请"), APPROVED(1, "审批通过"), NOT_APPROVED(2, "审批不通过"), SPARED(3, "待岗");

    private StaffStatus(int value, String status) {
        this.value = value;
        this.status = status;

    }
    private int value;

    private String status;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Map<Integer, String> getStatusMap() {
        Map<Integer, String> statusMap = new HashMap<Integer, String>();
        for (StaffStatus staffStatus : values()) {
            statusMap.put(staffStatus.getValue(), staffStatus.getStatus());
        }
        return statusMap;
    }
}
