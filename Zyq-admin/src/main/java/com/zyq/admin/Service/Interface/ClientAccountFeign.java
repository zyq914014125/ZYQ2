package com.zyq.admin.Service.Interface;

import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageInfo;
import com.zyq.admin.Service.impl.ClientAccountFallBack;
import entity.Resource;
import entity.Role;
import entity.user;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.X
 **/
@FeignClient(value = "client-account", fallback = ClientAccountFallBack.class)
public interface ClientAccountFeign {
    @PostMapping(value = "api/user",consumes = "application/json")
    user selectByusername( @RequestBody String username);
    @PostMapping(value = "api/user/post",consumes = "application/json")
    Result<user> insert(@RequestBody user user);
    @GetMapping("api/resource/{resourceId}")
    List<Resource> getResourcesByRoleId(@PathVariable int resourceId);
    @PostMapping(value = "api/users",consumes = "application/json")
    PageInfo<user> getusersBySerchvo(@RequestBody Serachvo serachvo);
    @RequestMapping("api/roles")
    List<Role> getRoles();
    @PostMapping(value = "api/roles", consumes = "application/json")
    PageInfo<Role> getRoles(@RequestBody Serachvo searchVo);
    @PostMapping(value = "api/role", consumes = "application/json")
    Result<Role> editRole(@RequestBody Role role);
    @RequestMapping("api/role/{roleId}")
    Role getRole(@PathVariable int roleId);
    @DeleteMapping("/role/{roleId}")
    Result<Role> deletRole(@PathVariable int roleId);
    @GetMapping("api/user/get/{userId}")
    user getUserById(int userId);
    @PutMapping(value = "api/user/put",consumes = "application/json")
    Result<user> update(user user);
    @DeleteMapping("api/user/{userId}")
    Result<Object> delete(int userId);
}
