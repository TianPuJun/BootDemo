package com.boot.demo.controller;

import com.boot.demo.bean.Users;
import com.boot.demo.service.UsersService;
import com.boot.demo.util.MD5Encoder;
import com.boot.demo.util.ResponseBean;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
/**
 * 用户控制
 *
 * @author cui
 * @create 2018-07-24 15:04
 **/
@RestController
@RequestMapping("/rest/users.do")
public class UsersController {
    @Autowired
    private UsersService usersService;


    /**
     * 验证登录接口
     * @param userName
     * @param passWord
     * @return
     */
    @PostMapping("/login")
    public ResponseBean login(String userName, String passWord){
        ResponseBean res = new ResponseBean();
        boolean b = loginValid(userName, passWord);
        if (b==true){
            res.setFlag(true);
            res.setMsg("密码验证成功");
            return res;
        }
        res.setFlag(false);
        res.setMsg("密码验证失败");
        return res;
    }
    public boolean loginValid(String userName,String passWord){
        Users byUserName =usersService.findByUserName(userName);
        if (byUserName!=null){
            try {
                return MD5Encoder.validPassword(passWord, byUserName.getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 添加用户
     * @param userName
     * @param passWord
     * @return
     */
    @PostMapping("/addUser")
    public ResponseBean addUser(String userName,String passWord)  {
        ResponseBean res = new ResponseBean();
        if (StringUtil.isEmpty(userName)){
            res.setMsg("用户名为空");
            res.setFlag(true);
            return res;
        }
        if (StringUtil.isEmpty(passWord)){
            res.setMsg("密码为空");
            res.setFlag(false);
            return res;
        }
        int i = usersService.addUser(userName, passWord);
        if (i==0){
            res.setMsg("用户名已存在");
        }
        if (i==1){
            res.setMsg("添加成功");
        }
        return res;
    }

    /**
     * 根据用户名查询个人信息
     * @param userName
     * @return
     */
    @GetMapping("/findByUserName")
    public ResponseBean findByUserName(String userName){
        ResponseBean responseBean = new ResponseBean();
        Users byUserName = usersService.findByUserName(userName);
        if (byUserName!=null){
            responseBean.setMsg("查询成功");
            responseBean.setFlag(true);
            responseBean.setRes(byUserName);
        }
        responseBean.setMsg("没有查到个人信息");
        responseBean.setFlag(true);
        return responseBean;
    }
    /**
     * 根据主键id
     * 查询
     * @return
     */
    @GetMapping("/findByPrimaryKey")
    public ResponseBean ByPrimaryKey(int id){
        ResponseBean responseBean = new ResponseBean();
        Users all = usersService.ByPrimaryKey(id);
        responseBean.setFlag(true);
        responseBean.setMsg("查询成功");
        responseBean.setRes(all);
        return responseBean;
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/all")
    public ResponseBean findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        ResponseBean responseBean = new ResponseBean();
        PageInfo<Users> allUser = usersService.findAllUser(pageNum, pageSize);
        responseBean.setFlag(true);
        responseBean.setMsg("查询成功");
        responseBean.setRes(allUser);
        responseBean.setTotal(allUser.getSize());
        return responseBean;
    }
}
