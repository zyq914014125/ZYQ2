package com.zyq.account.Controller;

import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageInfo;

import com.zyq.account.ServiceImpl.UserServiceImpl;
import entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Mr.X
 **/
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    //新增
    @PostMapping(value = "/user/post",consumes = "application/json")
    public Result<user> insert(@RequestBody user user) {
        return userService.InsertUser(user);
    }
    //分页
    @PostMapping(value = "/users",consumes = "application/json")
    public PageInfo<user> getusersBySerchvo(@RequestBody Serachvo serachvo){
            return userService.getusersBySerchvo(serachvo);
    }
    //删除
    @DeleteMapping("/user/{userId}")
    public Result<Object> delete(@PathVariable int userId){
        return userService.delete(userId);
    }
    //更新
    @PutMapping(value = "/user/put",consumes = "application/json")
    public Result<user> update(@RequestBody user user){
        return userService.update(user);
    }
    //获取单个
    @GetMapping("/user/get/{userId}")
    public user getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }
    @PostMapping(value = "/user",consumes = "application/json")
    public user selectByusername(@RequestBody  String username){
        return userService.selectByusername(username);
    }
//
//    //图片上传
//    @PostMapping(value = "/Img",consumes = "multipart/form-data")
//    public Result<String> setImg(@RequestParam MultipartFile multipartFile){
//        return userService.setImg(multipartFile);
//    }
//    @PutMapping(value = "/profile", consumes = "application/json")
//    public Result<user> updateUserProfile(@RequestBody user user) {
//        return userService.updateProfile(user);
//    }


}
