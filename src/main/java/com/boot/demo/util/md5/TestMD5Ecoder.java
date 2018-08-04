package com.boot.demo.util.md5;

import com.boot.demo.util.MD5Encoder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 * https://www.ibm.com/developerworks/cn/java/l-security/
 * @author cui
 * @create 2018-06-14 15:47
 **/
public class TestMD5Ecoder {
    private static Map users = new HashMap();

    /**
     * 注册用户
     *
     * @param userName
     * @param password
     */
    public static void registerUser(String userName,String password){
        String encryptedPwd = null;
        try {
            encryptedPwd = MD5Encoder.getEncryptedPwd(password);

            users.put(userName, encryptedPwd);

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 验证登陆
     *
     * @param userName
     * @param password
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static boolean loginValid(String userName,String password)
            throws NoSuchAlgorithmException, UnsupportedEncodingException{
        String pwdInDb = (String)users.get(userName);
        if(null!=pwdInDb){ // 该用户存在
            return MD5Encoder.validPassword(password, pwdInDb);
        }else{
            System.out.println("不存在该用户！！！");
            return false;
        }
    }

    public static void main(String[] args){
        //注册用户密码
        String userName = "zyg";
        String password = "123";
        registerUser(userName,password);

        userName = "changong";
        password = "456";
        registerUser(userName,password);
        //测试登录用户名密码
        String loginUserId = "zyg";
        String pwd = "1232";
        try {
            if(loginValid(loginUserId,pwd)){
                System.out.println("欢迎登陆！！！");
            }else{
                System.out.println("口令错误，请重新输入！！！");
            }
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
