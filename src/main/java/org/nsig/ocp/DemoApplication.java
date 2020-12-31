package org.nsig.ocp;

import org.nsig.ocp.Dao.ac_passDao;
import org.nsig.ocp.Entity.ac_pass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        System.out.println("开始：============");
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("结束：============");
    }

    @Autowired
    //private ac_passDao userDao;

    /*
    // http://localhost:8081/hello
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("运行成功");
        ac_pass user= new ac_pass() ;
        user.setUsername("abc");
        user.setPassword("1234");
        user.setSex("男");
        user = usersDao.login(user);
        System.out.println(user);
        user.setUserid(2);
        user.setSex("男");
        user.setUsername("尹西林");
        user.setPassword("1234");
        usersDao.insert(user);
        return "hello, 我的项目";
    }
     */

    @RequestMapping("/index")
    public String init(){
        System.out.println("运行成功，index");
        return "login";
    }
}
