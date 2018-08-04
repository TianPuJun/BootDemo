package com.boot.demo.service;

import com.boot.demo.bean.Users;
import com.github.pagehelper.PageInfo;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 用户服务
 *
 * @author cui
 * @create 2018-07-24 15:05
 **/
public interface UsersService {
    /**
     * 根据id查
     * @param id
     * @return
     */
    Users findAll(Integer id);

    /**
     * 根据用户名查询个人信息
     * @param userName
     * @return
     */
    Users findByUserName(String userName);

    /**
     * 分页插件使用
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Users> findAllUser(int pageNum, int pageSize);

    int addUser(String userName,String passWord);
}
