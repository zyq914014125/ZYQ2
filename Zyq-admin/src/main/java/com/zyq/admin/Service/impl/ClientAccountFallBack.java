package com.zyq.admin.Service.impl;

import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageInfo;
import com.zyq.admin.Service.Interface.ClientAccountFeign;
import entity.Resource;
import entity.Role;
import entity.user;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.X
 **/
@Component
public class ClientAccountFallBack implements ClientAccountFeign {
    @Override
    public user selectByusername(String username) {
        return null;
    }
    @Override
    public Result<user> insert(user user) {
        return null;
    }
    @Override
    public List<Resource> getResourcesByRoleId(int resourceId) {
        return null;
    }
    @Override
    public PageInfo<user> getusersBySerchvo(Serachvo serachvo) {
        return null;
    }
    @Override
    public List<Role> getRoles() {
        return null;
    }
    @Override
    public PageInfo<Role> getRoles(Serachvo searchVo) {
        return null;
    }
    @Override
    public Result<Role> editRole(Role role) {
        return null;
    }
    @Override
    public Role getRole(int roleId) {
        return null;
    }

    @Override
    public Result<Role> deletRole(int roleId) {
        return null;
    }

    @Override
    public user getUserById(int userId) {
        return null;
    }

    @Override
    public Result<user> update(user user) {
        return null;
    }

    @Override
    public Result<Object> delete(int userId) {
        return null;
    }
}
