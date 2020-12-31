package org.nsig.ocp.Servises.Impl;

import org.nsig.ocp.Dao.ac_passDao;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Servises.Opservise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpservicesImpl implements Opservise {

    @Autowired
    private ac_passDao passDao;
    private ac_pass user;

    @Override
    public ac_pass login(ac_pass uesr){
        return passDao.login(user);
    }
}
