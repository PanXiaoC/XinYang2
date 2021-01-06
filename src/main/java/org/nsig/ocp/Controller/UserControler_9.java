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

    @RequestMapping("/index")//登录，用户后台登录。
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
            List<Oprole> user2 =  opservices.findallOprole();
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

    @RequestMapping("/insert_oprole")//增加oprole
    public String insert_oprole(Oprole oprole){
        opservices.insert_oprole(oprole);
        return "mainpage";
    }

    @RequestMapping("/insert_opacinf")//插入函数，增加opacinf和acpass，切密码为123456
    public String insert_opacinf(opac_inf opacinf){
        ac_pass acPass = new ac_pass();
        acPass.setPass_usern(opacinf.getInf_usern());
        acPass.setPass_pass("123456");
        opservices.insert_pass(acPass);
        opservices.insert_opacinf(opacinf);
        return "mainpage";
    }

    @RequestMapping("/findoprole")//查找oprole的信息
    public List<Oprole> findoprole(Oprole oprole){
        return opservices.findoprole(oprole);
    }

    @RequestMapping("findopacinf")//查找opacinf的信息。
    public List<opac_inf> findipacinf(opac_inf opacInf){
        return opservices.findopacinf(opacInf);
    }

    @RequestMapping("deleteOProle")//删除oprole的信息
    public Integer deleteOprole(Oprole oprole){
        opservices.deletoprole(oprole);
        return 0;
    }

    @RequestMapping("deleteacPassOpacInf")//删除opacinf的信息和acpass的信息
    public Integer deleteopac_inf(opac_inf opacInf){
        opservices.deletopacinf(opacInf);
        ac_pass acPass = new ac_pass();
        acPass.setPass_usern(opacInf.getInf_usern());
        opservices.deletacpass(acPass);
        return 0;
    }

    @RequestMapping("updateAcPass")//改密码
    public void updateAcPAss(ac_pass acPass){
        opservices.updateAcPass(acPass);
    }

    @RequestMapping("updateOpacInf")//修改用户信息
    public void updateOpacInf(opac_inf opacInf){
        opservices.updateOpacInf(opacInf);
    }

    @RequestMapping("updateOprole")//修改oprole信息
    public void updateOprole(Oprole oprole){
        opservices.updateOprole(oprole);
    }
}
