package com.security.baotai.bean;

public enum ProcessDefinitionKeyEnum {

    ENTRY("entry", "入职流程");

    private ProcessDefinitionKeyEnum(String processDefinitionKey, String processDefinitionDesc) {
        this.processDefinitionKey = processDefinitionKey;
        this.processDefinitionDesc = processDefinitionDesc;
    }

    private String processDefinitionKey;

    private String processDefinitionDesc;

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public String getProcessDefinitionDesc() {
        return processDefinitionDesc;
    }


}
