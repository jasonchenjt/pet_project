package com.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public void login(@RequestParam String username, @RequestParam String password){
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }
}
