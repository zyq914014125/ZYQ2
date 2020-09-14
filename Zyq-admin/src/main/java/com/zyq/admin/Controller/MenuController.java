package com.zyq.admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mr.X
 **/
@Controller
public class MenuController {
    @RequestMapping("/account/login")
    public String login(){
        return "indexSimple";
    }
    @RequestMapping("/common/dashboard")
    public String dashboard(){
        return "index";
    }
    @RequestMapping("/account/profile")
    public String profile(){
        return "index";
    }
    @RequestMapping("/account/users")
    public String users(){
        return "index";
    }
    @RequestMapping("/account/roles")
    public String roles(){
        return "index";
    }
    @RequestMapping("/account/resources")
    public String resources(){
        return "index";
    }

}
