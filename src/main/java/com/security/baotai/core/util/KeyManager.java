package com.security.baotai.core.util;

import com.thinkgem.jeesite.common.utils.StringUtils;

public class KeyManager {

    private static final String regex = ":";

    public static String generateBusinessKey(String value1, String value2) {
        return value1 + regex + value2;
    }

    public static String getValueFromBusinessKey(String businessKey, int index) {
        if (StringUtils.isNotEmpty(businessKey)) {
            String[] str = businessKey.split(regex);
            if(str.length<=index){
                return null;
            }
            return str[index];
        }
        return "";
    }
}
