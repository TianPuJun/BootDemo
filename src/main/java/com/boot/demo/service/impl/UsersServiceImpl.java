package com.boot.demo.service.impl;

import com.boot.demo.bean.Users;
import com.boot.demo.dao.UsersDao;
import com.boot.demo.service.UsersService;
import com.boot.demo.util.MD5Encoder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * 服务实现类
 *
 * @author cui
 * @create 2018-07-24 15:17
 **/
@Service(value = "UsersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;
    //测试提交是否成功
    /*
     * 根据id查
     * @param id
     * @return
     */
    @Override
    public Users findAll(Integer id) {
        return usersDao.selectByPrimaryKey(id);
    }

    @Override
    public Users findByUserName(String userName) {
        Users byUserName = usersDao.findByUserName(userName);
        return byUserName;
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<Users> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Users> users = usersDao.findAllUser();
        PageInfo result = new PageInfo(users);
        return result;
    }

    /**
     * 添加用户
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public int addUser(String userName, String passWord) {
        Users byUserName = usersDao.findByUserName(userName);
        //判断用户名的唯一性，防止登录出问题
        if (byUserName!=null){
            return 0;
        }
        String encryptedPwd =null;
        try {
            encryptedPwd=MD5Encoder.getEncryptedPwd(passWord);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Users users  = new Users();
        users.setUsername(userName);
        users.setPassword(encryptedPwd);
        int insert = usersDao.insert(users);
        return insert;
    }

}
