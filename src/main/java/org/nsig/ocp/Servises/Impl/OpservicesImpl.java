package org.nsig.ocp.Servises.Impl;

import org.nsig.ocp.Dao.OproleDao;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Servises.Opservise;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
public class OpservicesImpl implements Opservise {
    @Resource
    private OproleDao oproleDao;
    @Override
    public Integer AddOprole(Oprole oprole){
        Integer x = oproleDao.AddOprole(oprole);
        return x;
    }
}
