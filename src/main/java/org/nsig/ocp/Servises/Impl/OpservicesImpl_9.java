package org.nsig.ocp.Servises.Impl;

import org.nsig.ocp.Dao.OproleDao_9;
import org.nsig.ocp.Dao.addoprole;
import org.nsig.ocp.Dao.checkchac_9;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Entity.opac_inf;
import org.nsig.ocp.Servises.Opservise_9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class OpservicesImpl_9 implements Opservise_9 {
    @Resource
    private OproleDao_9 oproleDao9;

    @Resource
    private addoprole addoprole9;

    @Resource
    private checkchac_9 checkchac;

    @Override
    public ac_pass login(ac_pass acPass){
       return oproleDao9.login(acPass);
    }

    @Override
    public Integer insert_oprole(Oprole oprole){
        return addoprole9.addoprole1(oprole);
    }

    @Override
    public Integer insert_opacinf(opac_inf opacInf){
        return addoprole9.addoprole2(opacInf);
    }

    @Override
    public Integer insert_pass(ac_pass acPass){
        return  addoprole9.addoprole3(acPass);
    }

    @Override
    public List<Oprole> findallOprole(){
        return addoprole9.getallchac();
    }

    @Override
    public List<Oprole> findoprole(Oprole oprole){
        return checkchac.checkchac(oprole);
    }

    @Override
    public List<opac_inf> findopacinf(opac_inf opacInf){
        return checkchac.findopacinf(opacInf);
    }

    @Override
    public  Integer deleteoprole(Oprole oprole){
        return addoprole9.deleteoprole(oprole);
    }

    @Override
    public Integer deleteopacinf(opac_inf opacInf){
        return addoprole9.deleteopacinf(opacInf);
    }

    @Override
    public Integer deleteacpass(ac_pass acPass){
        return addoprole9.deleteacpass(acPass);
    }

    @Override
    public Integer updateAcPass(ac_pass acPass){
        return addoprole9.updateAcPass(acPass);
    }

    @Override
    public Integer updateOpacInf(opac_inf opacInf){
        return addoprole9.updateopacinf(opacInf);
    }

    @Override
    public Integer updateOprole(Oprole oprole){
        return addoprole9.updateOprole(oprole);
    }

    @Override
    public List<opac_inf> findByAnyOpacInf(opac_inf opacInf){
        return checkchac.findopacinf(opacInf);
    }

    @Override
    public List<Oprole> findByAnyOprole(Oprole oprole){
        return checkchac.checkchac(oprole);
    }
    @Override
    public Integer alloprole()
    {
        return addoprole9.alloprole();
    }
    @Override
    public Integer allopacinf()
    {
        return addoprole9.allopacinf();
    }
    @Override
    public List<Oprole> limitoprole(Oprole oprole){
        return  addoprole9.limitoprole(oprole);
    }
    @Override
    public List<opac_inf> limitopacinf(opac_inf opacInf){
        return addoprole9.limitopacinf(opacInf);
    }
}
