package com.boot.demo.config;

/**
 * 第一步
 * 数据源类型
 *
 * @author cui
 * @create 2018-07-25 11:07
 **/
public enum DatabaseType {
    master("write"), slave("read");


    DatabaseType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DatabaseType{" +
                "name='" + name + '\'' +
                '}';
    }
}
