package org.nsig.ocp;

import org.junit.jupiter.api.Test;
import org.nsig.ocp.Dao.OproleDao_9;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Resource
    private OproleDao_9 oproleDao;
    @Resource
    private Oprole oprole;
    @Resource
    private ac_pass acPass;

    @Test
    void testopdao()
    {

    }
    @Test
    void testlogin(){
        System.out.println( "============>"+ this.oproleDao.login(acPass));
    }
}
