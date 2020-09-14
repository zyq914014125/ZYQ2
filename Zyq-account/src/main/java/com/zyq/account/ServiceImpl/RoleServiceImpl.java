package com.zyq.account.ServiceImpl;


import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyq.account.mapper.roleMapper;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Mr.X
 */
@Service
public class RoleServiceImpl {
    @Autowired
    roleMapper roleMapper;

    public List<Role> getRoles() {
        return Optional.ofNullable(roleMapper.getRoles()).orElse(Collections.emptyList());
    }
    @Transactional
    public Result<Role> editRole(Role role) {
        Role roleTemp = roleMapper.getRoleByRoleName(role.getRoleName());
        if (roleTemp != null && roleTemp.getRoleId() != role.getRoleId()) {
            return new Result<Role>(Result.ResultState.SOMETHING_WRONG, "Role name is repeat.");
        }

        if (role.getRoleId() > 0) {
            roleMapper.updateRole(role);
        } else {
            roleMapper.addRole(role);
        }

        return new Result<Role>(Result.ResultState.SUCCESS_RESPONSE, "success", role);
    }

    @Transactional
    public Result<Role> deleteRole(int roleId) {
        roleMapper.deleteRole(roleId);
        return new Result<Role>(Result.ResultState.SUCCESS_RESPONSE, "");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public PageInfo<Role> getRoles(Serachvo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo(
                Optional.ofNullable(roleMapper.getRolesBySearchVo(searchVo))
                        .orElse(Collections.emptyList()));
    }


    public List<Role> getRolesByUserId(int userId) {
        return roleMapper.getRolesByUserId(userId);
    }

    public List<Role> getRolesByResourceId(int resourceId) {
        return roleMapper.getRolesByResourceId(resourceId);
    }


    public Role getRoleById(int roleId) {
        return roleMapper.getRoleById(roleId);
    }
}
