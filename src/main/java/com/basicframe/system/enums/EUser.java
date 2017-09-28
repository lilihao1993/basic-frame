package com.basicframe.system.enums;

/**
 * 描述：用户枚举
 */
public enum EUser {
    /**
     * 用户状态：正常
     */
    STATUS_NORMAL("1", "正常"),

    /**
     * 用户状态：禁用
     */
    STATUS_DISABLE("2", "禁用");

    private String value;

    private String desc;

    EUser(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}

