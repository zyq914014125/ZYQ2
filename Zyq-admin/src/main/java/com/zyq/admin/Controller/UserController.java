package com.zyq.admin.Controller;

import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageInfo;
import com.zyq.admin.Service.userService;
import entity.user;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mr.X
 **/
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    userService Service;
    @PostMapping("/users")
    public PageInfo<user> getusersBySerchvo(@RequestBody Serachvo serachvo){
        return Service.getusersBySerchvo(serachvo);
    }
    @GetMapping("/get/{userId}")
    public user getUserById(@PathVariable int userId){
        return Service.getUserById(userId);
    }
    @PutMapping(value = "/put",consumes = "application/json")
    public Result<user> update(@RequestBody user user){
        return Service.update(user);
    }
    @DeleteMapping("/{userId}")
    public Result<Object> delete(@PathVariable int userId){
        return Service.delete(userId);
    }

}
