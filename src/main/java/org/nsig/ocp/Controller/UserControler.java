package org.nsig.ocp.Controller;

import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Servises.Impl.OpservicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class UserControler {
    @Resource
    private OpservicesImpl opservices;
    @Resource
    private Oprole oprole;
    @RequestMapping("/index0")
    public void AddOprole(Oprole oprole)
    {
        opservices.AddOprole(oprole);
    }
}
