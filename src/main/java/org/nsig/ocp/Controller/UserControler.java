package org.nsig.ocp.Controller;

import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Servises.Impl.OpservicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserControler {

    @Autowired
    private OpservicesImpl userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello, test";
    }

    @RequestMapping("/login")
    public String login(ac_pass user, Map<String, Object> map){
        user = userService.login(user);
        //System.out.println(user);
        if(user != null){
            return "success";
        }
        //System.out.println("index输入正确，但是错误输出错");
        map.put("loginError", "用户名称或密码不正确，请重新输入");
        return "login";
    }


}