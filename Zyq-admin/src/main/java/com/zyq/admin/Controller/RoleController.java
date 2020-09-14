package com.zyq.admin.Controller;

import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageInfo;
import com.zyq.admin.Service.roleService;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.X
 **/
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private roleService roles;
    @RequestMapping("/roles")
    List<Role> getRoles() {
        return roles.getRoles();
    }
    @PostMapping(value = "/roles", consumes = "application/json")
    public PageInfo<Role> getRoles(@RequestBody Serachvo searchVo) {
        return roles.getRoles(searchVo);
    }
    @PostMapping(value = "/role", consumes = "application/json")
    public Result<Role> insertRole(@RequestBody Role role) {
        return roles.editRole(role);
    }
    @PutMapping(value = "/role", consumes = "application/json")
    public Result<Role> updateRole(@RequestBody Role role) {
        return roles.editRole(role);
    }
    @RequestMapping("/{roleId}")
    public Role getRole(@PathVariable int roleId) {
        return roles.getRoleById(roleId);
    }
    @DeleteMapping("/{roleId}")
    public Result<Role> deletRole(@PathVariable int roleId) {
        return roles.deleteRole(roleId);
    }
}
