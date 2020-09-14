package com.zyq.admin.Controller;

import Serach.Result;
import com.zyq.admin.Service.userService;
import entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.X
 **/
@RestController
@RequestMapping("/login")
public class loginController {
    @Autowired
    userService Service;
    //新增
    @PostMapping(value = "/post",consumes = "application/json")
    public Result<user> insert(@RequestBody user user){
        return Service.insert(user);
    }
    @PostMapping (value = "/index",consumes = "application/json")
    public Result<Object> login(@RequestBody user user) {
        return Service.login(user);
    }
}
