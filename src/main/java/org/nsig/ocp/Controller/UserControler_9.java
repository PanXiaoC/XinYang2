package org.nsig.ocp.Controller;

import org.mybatis.spring.annotation.MapperScan;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Servises.Impl.OpservicesImpl_9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class UserControler_9 {
    @Autowired
    private OpservicesImpl_9 opservices;
    @Autowired
    private Oprole oprole;


    @RequestMapping("/index")
    public String test() {
        return "login2";
    }
    @RequestMapping("/login")
    public String login(ac_pass acPass, Map map)
    {
        ac_pass acpass1 = new ac_pass();
        acpass1 = opservices.login(acPass);
        if (acpass1 != null &&acpass1.getPass_pass().equals(acPass.getPass_pass().substring(0,acPass.getPass_pass().length()-1)) )
        {
            return "mainpage";
        }
        map.put("loginerror","用户名或密码错误，请重新输入");
        map.put("user",acpass1.getPass_usern());
        return "login2";
    }
    @RequestMapping("/dlist")
    public String dlist() {
        return "dlist";
    }
}
