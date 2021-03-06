package org.nsig.ocp.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Entity.opac_inf;
import org.nsig.ocp.Servises.Impl.OpservicesImpl_9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    private Map<String, Object> data;

    @RequestMapping(value = "/index", method = RequestMethod.GET)//登录，用户后台登录。
    public String test() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody Map<String, Object> login(@RequestBody Map<String , Object> data) throws JsonProcessingException
    {
        this.data = data;
        System.out.println(data);
        String username = (String) data.get("username");
        String password = (String) data.get("password");
        ac_pass acpass1 = new ac_pass();
        ac_pass acPass = new ac_pass();
        acPass.setPass_usern(username);
        acpass1.setPass_usern(username);
        acpass1.setPass_pass(password);
        acPass = opservices.login(acpass1);
        Map<String, Object> map = new HashMap<>();
        System.out.println(acPass);
        System.out.println(acpass1);
        if (acPass != null &&acpass1.getPass_pass().equals(acPass.getPass_pass().substring(0,acPass.getPass_pass().length()-1)) )
        {
            List<Oprole> user2 =  opservices.findallOprole();
            map.put("mainpage.jsp", 0);
            map.put("user2",user2);
            return map;
        }
        map.put("msg", -1);
        map.put("loginerror","用户名或密码错误，请重新输入");
        return map;
    }
    //测试通过
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
    //测试通过
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
    //测试通过
    @RequestMapping("/findoprole")//查找oprole的信息
    public Map<String,Object> findoprole(Oprole oprole){
        List<Oprole> oproles =  opservices.findoprole(oprole);
        Map<String, Object> map = new HashMap<>();
        map.put("oprole",oproles);
        return map;
    }
    //测试通过
    @RequestMapping("/findopacinf")//查找opacinf的信息。
    public Map<String,Object> findipacinf(opac_inf opacInf){
        List<opac_inf> opac_infs =  opservices.findopacinf(opacInf);
        Map<String, Object> map = new HashMap<>();
        map.put("oprole",opac_infs);
        return map;
    }
    //测试成功
    @RequestMapping("/deleteoprole")//删除oprole的信息
    public  Map<String,String> deleteOprole(Oprole oprole){
        Map<String,String> map = new HashMap<>();
        Integer s1 = opservices.deleteoprole(oprole);
        if (s1 == 1)
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
    //测试成功
    @RequestMapping("/deleteacPassOpacInf")//删除opacinf的信息和acpass的信息
    public Map<String,String> deleteopac_inf(opac_inf opacInf){
        ac_pass acPass = new ac_pass();
        acPass.setPass_usern(opacInf.getInf_usern());
        Integer s1 = opservices.deleteacpass(acPass);
        Integer s2 = opservices.deleteopacinf(opacInf);
        Map<String,String> map = new HashMap<>();
        if (s1 == 1 && s2== 1)
        {
            map.put("flag", "1");
            map.put("message", "删除成功");
        }
        else {
            map.put("flag", "2");
            map.put("message", "删除失败");
        }
        return map;
    }
    //测试成功
    @RequestMapping("/updateAcPass")//改密码
    public Map<String,String> updateAcPAss(ac_pass acPass){
        Integer s1 = opservices.updateAcPass(acPass);
        Map<String,String> map = new HashMap<>();
        if (s1 == 1)
        {
            map.put("flag", "1");
            map.put("message", "修改成功");
        }
        else {
            map.put("flag", "2");
            map.put("message", "修改失败");
        }
        return map;
    }
    //测试成功
    @RequestMapping("/updateOpacInf")//修改用户信息
    public Map<String,String> updateOpacInf(opac_inf opacInf){
        Integer s1 = opservices.updateOpacInf(opacInf);
        Map<String,String> map = new HashMap<>();
        if (s1 == 1)
        {
            map.put("flag", "1");
            map.put("message", "修改成功");
        }
        else {
            map.put("flag", "2");
            map.put("message", "修改失败");
        }
        return map;
    }
    //测试成功
    @RequestMapping("/updateOprole")//修改oprole信息
    public Map<String,String> updateOprole(Oprole oprole){
        Integer s1 = opservices.updateOprole(oprole);
        Map<String,String> map = new HashMap<>();
        if (s1 == 1)
        {
            map.put("flag", "1");
            map.put("message", "修改成功");
        }
        else {
            map.put("flag", "2");
            map.put("message", "修改失败");
        }
        return map;
    }

    @RequestMapping("/deletelistOprole")//删除list Oprole
    public Map<String,String> deletelistOprole(List<Oprole> oproles){
        Map<String,String> map = new HashMap<>();
        Integer count = 0;
        for(int i = 0; i < oproles.size(); i++){
            Integer s1 = opservices.deleteoprole(oproles.get(i));
            if (s1 == 1)
            {
                count++;
            }
        }
        if (count == oproles.size())
        {
            map.put("flag", "1");
            map.put("message", "修改成功");
        }
        else {
            map.put("flag", "2");
            map.put("message", "修改失败");
        }
        return map;
    }

    @RequestMapping("/deleteListopacInf")//删除list opacinf
    public Integer deleteListopacInf(List<opac_inf> opacInfs){
        ac_pass acPass = new ac_pass();
        for(int i = 0 ; i < opacInfs.size(); i++){
            acPass.setPass_usern(opacInfs.get(i).getInf_usern());
            opservices.deleteacpass(acPass);
            opservices.deleteopacinf(opacInfs.get(i));
        }
        return 0;
    }
   //测试成功
    @RequestMapping("/limitoprolepage")//角色表分页操作
    public Map<String,Object> limitoprolepage(String nowpagenum)
    {
        String spPage = nowpagenum;
        //设置每页条数
        int pageSize=5;
        //页数
        int pageNo=0;
        if(spPage == null){
            pageNo=1;
        }else {
            pageNo = Integer.valueOf(spPage);
            if (pageNo < 1) {
                pageNo = 1;
            }
        }
        //设置最大页数
        int totalCount=0;
        int count=opservices.alloprole();
        if(count>0){
            totalCount=count;
        }
        int maxPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        if(pageNo>maxPage){
            pageNo=maxPage;
        }
        int  tempPageNo=(pageNo-1)*pageSize;
        //计算总数量
        //分页查询
        Oprole oprole = new Oprole();
        oprole.setPagenum(tempPageNo);
        oprole.setPagesize(pageSize);
        List<Oprole> list=opservices.limitoprole(oprole);
        //最后把信息放入model转发到页面把信息带过去
        Map<String,Object> map1 =new HashMap();
        map1.put("limitoprole", list);
        map1.put("totalcount", totalCount);
        map1.put("pagenumber", pageNo);
        map1.put("maxpage", maxPage);
        return map1;
    }
    //测试成功
    @RequestMapping("/limitopacinfpage")//用户信息表分页操作
    public Map<String,Object> limitopacinfpage(String nowpagenum)
    {
        String spPage = nowpagenum;
        //设置每页条数
        int pageSize=5;
        //页数
        int pageNo=0;
        if(spPage == null){
            pageNo=1;
        }else {
            pageNo = Integer.valueOf(spPage);
            if (pageNo < 1) {
                pageNo = 1;
            }
        }
        //设置最大页数
        int totalCount=0;
        int count=opservices.allopacinf();
        if(count>0){
            totalCount=count;
        }
        int maxPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        if(pageNo>maxPage){
            pageNo=maxPage;
        }
        int  tempPageNo=(pageNo-1)*pageSize;
        //计算总数量
        //分页查询
        opac_inf opacInf = new opac_inf();
        opacInf.setPagenum(tempPageNo);
        opacInf.setPagesize(pageSize);
        List<opac_inf> list=opservices.limitopacinf(opacInf);
        //最后把信息放入model转发到页面把信息带过去
        Map<String,Object> map1 =new HashMap();
        map1.put("limitopacinf", list);
        map1.put("totalcount", totalCount);
        map1.put("pagenumber", pageNo);
        map1.put("maxpage", maxPage);
        return map1;
    }

    @RequestMapping("/findBuyAnyOpacInf")//查找opacinf的信息。模糊查询
    public Map<String,Object> findByAnyOpacInf(opac_inf opacInf){
        List<opac_inf> opac_infs =  opservices.findByAnyOpacInf(opacInf);
        Map<String, Object> map = new HashMap<>();
        map.put("oprole",opac_infs);
        return map;
    }

    @RequestMapping("/findByAnyOprole")//查找oprole的信息  模糊查询
    public Map<String,Object> findByAnyOprole(Oprole oprole){
        List<Oprole> oproles =  opservices.findByAnyOprole(oprole);
        Map<String, Object> map = new HashMap<>();
        map.put("oprole",oproles);
        return map;
    }

    @RequestMapping("/updateuseOprole")//修改oprole中的信息，启用，禁用(1启用， 0禁用)
    public Map<String,String> updateuseOprole(Oprole oprole){
        if(oprole.getRole_con() == "启用"){
            oprole.setRole_con("禁用");
        }else{
            oprole.setRole_con("启用");
        }
        Integer s1 = opservices.updateOprole(oprole);
        Map<String,String> map = new HashMap<>();
        if (s1 == 1)
        {
            map.put("flag", "1");
            map.put("message", "修改成功");
        }
        else {
            map.put("flag", "2");
            map.put("message", "修改失败");
        }
        return map;
    }
}
