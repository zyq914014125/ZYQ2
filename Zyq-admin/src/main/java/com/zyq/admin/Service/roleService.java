package com.zyq.admin.Service;

import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageInfo;
import com.zyq.admin.Service.Interface.ClientAccountFeign;
import entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.X
 **/
@Service
public class roleService {
    @Autowired
    @SuppressWarnings("all")
    ClientAccountFeign clientAccountFeign;
    public List<Role> getRoles() {
        return clientAccountFeign.getRoles();
    }
    public PageInfo<Role> getRoles(Serachvo searchVo) {
        return clientAccountFeign.getRoles(searchVo);
    }

    public Result<Role> editRole(Role role) {
        return clientAccountFeign.editRole(role);
    }

    public Role getRoleById(int roleId) {
        return clientAccountFeign.getRole(roleId);
    }

    public Result<Role> deleteRole(int roleId) {
        return clientAccountFeign.deletRole(roleId);
    }
}
