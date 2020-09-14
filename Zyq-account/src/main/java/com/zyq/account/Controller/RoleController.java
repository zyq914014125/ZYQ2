package com.zyq.account.Controller;

import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageInfo;
import com.zyq.account.ServiceImpl.RoleServiceImpl;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.X
 **/
@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;
    @RequestMapping("/roles")
    List<Role> getRoles() {
        return roleService.getRoles();
    }
    @PostMapping(value = "/roles", consumes = "application/json")
    public PageInfo<Role> getRoles(@RequestBody Serachvo searchVo) {
        return roleService.getRoles(searchVo);
    }
    @PostMapping(value = "/role", consumes = "application/json")
    public Result<Role> insertRole(@RequestBody Role role) {
        return roleService.editRole(role);
    }
    @PutMapping(value = "/role", consumes = "application/json")
    public Result<Role> updateRole(@RequestBody Role role) {
        return roleService.editRole(role);
    }
    @RequestMapping("/role/{roleId}")
    public Role getRole(@PathVariable int roleId) {
        return roleService.getRoleById(roleId);
    }
    @DeleteMapping("/role/{roleId}")
    public Result<Role> deletRole(@PathVariable int roleId) {
        return roleService.deleteRole(roleId);
    }
}
