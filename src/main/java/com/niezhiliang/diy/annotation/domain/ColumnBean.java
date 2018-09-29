package com.niezhiliang.diy.annotation.domain;

// 用于描述Column
public  class ColumnBean {
    final String type;
    final String name;
    final int length;
    final String defaultValue;

    public ColumnBean(String type, String name, int length, String defaultValue) {
        this.type = type;
        this.name = name;
        this.length = length;
        this.defaultValue = defaultValue;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}