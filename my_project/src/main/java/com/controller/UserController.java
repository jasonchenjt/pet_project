package com.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jason
 * @since 2019-06-03
 */
@RestController
public class UserController {

    @RequestMapping("/login")
    public String  login( String username, String password){
        Map<String,String> map = new HashMap<>();
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, "123");
        try{
            subject.login(token);

            map.put("status","登录成功");
            map.put("code","9999");
        }catch (IncorrectCredentialsException e){
            map.put("status","密码错误");
            map.put("code","0000");
        }catch (AuthenticationException e) {
            map.put("status","用户不存在");
            map.put("code","0000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map.toString();
    }

    @RequestMapping("/notlogin")
    public String  notlogin(){
        Map<String,String> map = new HashMap<>();
        map.put("status","没有登录验证");
        map.put("code","0000");
        return map.toString();
    }
}
