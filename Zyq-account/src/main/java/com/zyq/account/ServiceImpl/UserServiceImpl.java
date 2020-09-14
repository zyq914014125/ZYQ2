package com.zyq.account.ServiceImpl;
import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.zyq.account.mapper.userMapper;
import entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Mr.X
 **/
@Service
public class UserServiceImpl {
    @Autowired
    userMapper userMapper;
//    @Autowired
//    ResourceConfig resourceConfig;

    //新增
    @Transactional
    public Result<user> InsertUser(user user) {
        if (userMapper.selectByPrimaryKey(user.getUserName()) != null) {
            return new Result<user>(Result.ResultState.SOMETHING_WRONG, "用户名已存在", user);
        }


        LocalDateTime date = LocalDateTime.now();
        user.setCreateDate(date);
        userMapper.insert(user);
        return new Result<user>(Result.ResultState.SUCCESS_RESPONSE, "注册成功", user);
    }

    //分页
    public PageInfo<user> getusersBySerchvo(Serachvo serachvo) {
        PageHelper.startPage(serachvo.getCurrentPage(), serachvo.getPageSize());
        PageInfo<user> pageInfo = new PageInfo<user>(userMapper.getusersBySerchvo(serachvo));
        return Optional.ofNullable(pageInfo).orElse(new PageInfo<>());
    }

    //删除
    public Result<Object> delete(int userId) {
        userMapper.delete(userId);
        return new Result<>(Result.ResultState.SUCCESS_RESPONSE, "删除成功");
    }

    //更新
    public Result<user> update(user user) {
        userMapper.update(user);
        return new Result<user>(Result.ResultState.SUCCESS_RESPONSE, "更新成功", user);
    }

    //Id获取
    public user getUserById(int userId) {
        return userMapper.getuserById(userId);
    }
//    //图片设置
//    public Result<String> setImg(MultipartFile multipartFile) {
//        //判空
//        if (multipartFile.isEmpty()) {
//            return new Result<>(Result.ResultState.SOMETHING_WRONG, "please select img");
//        }
//        String relativePath = "";
//        String destFilePath = "";
//        //获取本机mac
//        try {
//            String osname = System.getProperty("os.name");
//            if (osname.toLowerCase().startsWith("win"))
//                destFilePath = resourceConfig.getLocationPathForWindows() + multipartFile.getOriginalFilename();
//            else
//                destFilePath = resourceConfig.getLocationPathForLinux() + multipartFile.getOriginalFilename();
//            relativePath = resourceConfig.getRelativePath() + multipartFile.getOriginalFilename();
//            File destFile = new File(destFilePath);
//            multipartFile.transferTo(destFile);
//        } catch (IOException e) {
//          return new Result<String> (Result.ResultState.SOMETHING_WRONG,"upload Fail");
//        }
//        return new Result<String>(
//                Result.ResultState.SUCCESS_RESPONSE, "Upload success.", relativePath);
//    }

    //用户名更改
    @Transactional
    public Result<user> updateProfile(user user){
        user user1=userMapper.selectByPrimaryKey(user.getUserName());
       //检测用户名是否被其他人使用
        if(user1!=null&&user1.getUserId()!=user.getUserId()){
            return new Result<user>(Result.ResultState.SOMETHING_WRONG, "User name have been used.");
        }
        userMapper.update(user);
        return new Result<user>(Result.ResultState.SUCCESS_RESPONSE, "Update success.",user);
    }

    public user selectByusername(String userName) {
        return userMapper.selectByPrimaryKey(userName);
    }
}
