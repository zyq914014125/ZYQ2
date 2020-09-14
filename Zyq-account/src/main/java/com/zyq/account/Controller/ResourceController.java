package com.zyq.account.Controller;

import Serach.Result;
import Serach.Serachvo;
import com.github.pagehelper.PageInfo;
import com.zyq.account.ServiceImpl.ResourceServiceImpl;
import entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.X
 **/
@RestController
@RequestMapping("api")
public class ResourceController {
    @Autowired
    ResourceServiceImpl resourceService;
    @GetMapping("/resource/{resourceId}")
    public List<Resource> getResourcesByRoleId(@PathVariable int resourceId){
        return resourceService.getResourcesByRoleId(resourceId);
    }

    @PostMapping(value = "/resources", consumes = "application/json")
    public PageInfo<Resource> getResources(@RequestBody Serachvo searchVo) {
        return resourceService.getResources(searchVo);
    }

    @PostMapping(value = "/resource", consumes = "application/json")
    public Result<Resource> insertResource(@RequestBody Resource resource) {
        return resourceService.editResource(resource);
    }

    @PutMapping(value = "/resource", consumes = "application/json")
    public Result<Resource> updateResource(@RequestBody Resource resource) {
        return resourceService.editResource(resource);
    }

    @RequestMapping("/resource/{resourceId}")
    public Resource getResourceById(@PathVariable int resourceId) {
        return resourceService.getResourceById(resourceId);
    }

    @DeleteMapping("/resource/{resourceId}")
    public Result<Resource> deleteResource(@PathVariable int resourceId) {
        return resourceService.deleteResource(resourceId);
    }
}
