package com.boot.demo.dao;
/**
 * dao接口命名规则
 * read: get,select,count,list,query,find
 * write: add,create,update,delete,remove,insert
 */

import com.boot.demo.bean.Users;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    /**
     * 查询所有
     * @return
     */
    List<Users> findAllUser();

    /**
     * 根据用户名查询个人信息
     * @return
     */
    Users findByUserName(String userName);
}