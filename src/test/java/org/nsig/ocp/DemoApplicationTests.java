package org.nsig.ocp;

import org.junit.jupiter.api.Test;
import org.nsig.ocp.Dao.OproleDao;
import org.nsig.ocp.Entity.Oprole;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Resource
    private OproleDao oproleDao;
    @Resource
    private Oprole oprole;

    @Test
    void testopdao()
    {
        System.out.println( "============>"+ this.oproleDao.findallop(oprole));
    }
}
