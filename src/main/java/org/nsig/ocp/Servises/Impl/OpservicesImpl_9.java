package org.nsig.ocp.Servises.Impl;

import org.nsig.ocp.Dao.OproleDao_9;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Servises.Opservise_9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class OpservicesImpl_9 implements Opservise_9 {
    @Resource
    private OproleDao_9 oproleDao9;

    @Override
    public ac_pass login(ac_pass acPass){
       return oproleDao9.login(acPass);
    }
}
