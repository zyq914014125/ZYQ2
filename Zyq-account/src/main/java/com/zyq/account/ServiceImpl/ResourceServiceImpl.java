package com.zyq.account.ServiceImpl;


import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.zyq.account.mapper.ResourceMapper;
import com.zyq.account.mapper.RoleResourceMapper;
import entity.Resource;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Mr.X
 **/
@Service
public class ResourceServiceImpl {

    @Autowired
    private ResourceMapper resourceDao;
    @Autowired
    private RoleResourceMapper roleResourceDao;


    @Transactional
    public Result<Resource> editResource(Resource resource) {
        Resource resourceTemp = resourceDao.getResourceByPermission(resource.getPermission());
        if (resourceTemp != null && resourceTemp.getResourceId() != resource.getResourceId()) {
            return new Result<Resource>(Result.ResultState.ERROR_RESPONSE, "Resource permission is repeat.");
        }

        // 添加 resource
        if (resource.getResourceId() > 0) {
            resourceDao.updateResource(resource);
        } else {
            resourceDao.addResource(resource);
        }

        // 添加 roleResource
        roleResourceDao.deletRoleResourceByResourceId(resource.getResourceId());
        if (resource.getRoles() != null && !resource.getRoles().isEmpty()) {
            for (Role role : resource.getRoles()) {
                roleResourceDao.addRoleResource(role.getRoleId(), resource.getResourceId());
            }
        }

        return new Result<Resource>(Result.ResultState.SUCCESS_RESPONSE, "success", resource);
    }


    @Transactional
    public Result<Resource> deleteResource(int resourceId) {
        roleResourceDao.deletRoleResourceByResourceId(resourceId);
        resourceDao.deleteResource(resourceId);
        return new Result<Resource>(Result.ResultState.SUCCESS_RESPONSE, "");
    }

    public PageInfo<Resource> getResources(Serachvo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo(
                Optional.ofNullable(resourceDao.getResourcesBySearchVo(searchVo))
                        .orElse(Collections.emptyList()));
    }


    public List<Resource> getResourcesByRoleId(int roleId) {
        return resourceDao.getResourcesByRoleId(roleId);
    }


    public Resource getResourceById(int resourceId) {
        return resourceDao.getResourceById(resourceId);
    }
}
