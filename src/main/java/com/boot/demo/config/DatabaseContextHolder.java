package com.boot.demo.config;

/**
 * 第二步创建线程安全的databaseType容器
 * 多线程容器
 *
 * @author cui
 * @create 2018-07-25 11:08
 **/
public class DatabaseContextHolder {
    //用于存放多线程环境下的成员变量
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);


    }

    public static DatabaseType getDatabaseType() {
        return contextHolder.get();
    }
}
