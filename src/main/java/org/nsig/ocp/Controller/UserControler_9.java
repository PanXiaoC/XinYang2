package org.nsig.ocp.Controller;

import org.mybatis.spring.annotation.MapperScan;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Entity.opac_inf;
import org.nsig.ocp.Servises.Impl.OpservicesImpl_9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    public String login(ac_pass acPass, Map map, HttpSession session)
    {
        ac_pass acpass1 = new ac_pass();
        acpass1 = opservices.login(acPass);
        if (acpass1 != null &&acpass1.getPass_pass().equals(acPass.getPass_pass().substring(0,acPass.getPass_pass().length()-1)) )
        {
            session.setAttribute("user",acpass1);
            List<Oprole> user2 =  opservices.getallchac();
            map.put("user2",user2);
            return "dlist";
        }
        map.put("loginerror","用户名或密码错误，请重新输入");
        return "login2";
    }
    @RequestMapping("/dslist")
    public String dlist() {
        return "dlist";
    }

    @RequestMapping("/insert_oprole")
    public String insert_oprole(Oprole oprole){
        opservices.insert_oprole(oprole);
        return "mainpage";
    }

    @RequestMapping("/insert_opacinf")
    public String insert_opacinf(opac_inf opacinf){
        ac_pass acPass = new ac_pass();
        acPass.setPass_usern(opacinf.getInf_usern());
        acPass.setPass_pass("123456");
        opservices.insert_pass(acPass);
        opservices.insert_opacinf(opacinf);
        return "mainpage";
    }

    @RequestMapping("/findoprole")
    public List<Oprole> findoprole(Oprole oprole){
        return opservices.findoprole(oprole);
    }

    @RequestMapping("findopacinf")
    public List<opac_inf> findipacinf(opac_inf opacInf){
        return opservices.findopacinf(opacInf);
    }
}
