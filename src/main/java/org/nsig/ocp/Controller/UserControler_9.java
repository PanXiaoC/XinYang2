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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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

    @RequestMapping("/insert_oprole")//增加oprole
    public Map<String,String> insert_oprole(Oprole oprole){
        Integer s1 = opservices.insert_oprole(oprole);
        Map<String,String> map = new HashMap<>();
        if (s1== 1)
        {
            map.put("flag", "1");
            map.put("message", "success");
        }
        else
        {
            map.put("flag", "2");
            map.put("message", "default");
        }
        return map;
    }

    @RequestMapping("/insert_opacinf")//插入函数，增加opacinf和acpass，切密码为123456
    public Map<String,String> insert_opacinf(opac_inf opacinf){
        ac_pass acPass = new ac_pass();
        acPass.setPass_usern(opacinf.getInf_usern());
        acPass.setPass_pass("123456");
        Integer s2 = opservices.insert_opacinf(opacinf);
        Integer s1=  opservices.insert_pass(acPass);
        Map<String,String> map = new HashMap<>();
        if (s1== 1 && s2==1)
        {
            map.put("flag", "1");
            map.put("message", "success");
        }
        else
        {
            map.put("flag", "2");
            map.put("message", "default");
        }
        return map;
    }

    @RequestMapping("/findoprole")//查找oprole的信息
    public Map<String,Object> findoprole(Oprole oprole){
        List<Oprole> oproles =  opservices.findoprole(oprole);
        Map<String, Object> map = new HashMap<>();
        map.put("oprole",oproles);
        System.out.println(map);
        return map;
    }

    @RequestMapping("findopacinf")//查找opacinf的信息。
    public Map<String,Object> findipacinf(opac_inf opacInf){
        List<opac_inf> opacInfs = opservices.findopacinf(opacInf);
        Map<String, Object> map = new HashMap<>();
        map.put("opacInf",opacInfs);
        return map;
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

    @RequestMapping("deletelistOprole")//连续删除多个Oprole,检查删除数目是否正确，多一个或少删一个
    public Integer deletelistOprole(List<Oprole> oproles){
        for (int i = 0 ; i < oproles.size(); i++){
            opservices.deletoprole(oproles.get(i));
        }
        return 0;
    }

    @RequestMapping("deletelistopacInf")//连续删除多个opacinf，注意删除的个数
    public Integer deletelistopacInf(List<opac_inf> opacInfs){
        ac_pass acPass = new ac_pass();
        for (int i = 0 ; i < opacInfs.size() ; i++){
            opservices.deletopacinf(opacInfs.get(i));
            acPass.setPass_usern(opacInfs.get(i).getInf_usern());
            opservices.deletacpass(acPass);
        }
        return 0;
    }
}
