package org.nsig.ocp.Servises;

import org.nsig.ocp.Dao.addoprole;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Entity.opac_inf;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface Opservise_9 {
    ac_pass login(ac_pass acPass);//登录
    Integer insert_oprole(Oprole oprole);//增加oprole
    Integer insert_opacinf(opac_inf opacInf);//增加opacinf
    Integer insert_pass(ac_pass acPass);//增加acpass
    List<Oprole> findallOprole();//查询所有的oprole
    List<Oprole> findoprole(Oprole oprole);//增加oprole
    List<opac_inf> findopacinf(opac_inf opacInf);//增加opacinf
    Integer deleteoprole (Oprole oprole);//删除oprole
    Integer deleteopacinf(opac_inf opacInf);//删除opacinf
    Integer deleteacpass(ac_pass acPass);//删除acpass
    Integer updateAcPass(ac_pass acPass);//修改acPass
    Integer updateOpacInf(opac_inf opacInf);//修改opacinf
    Integer updateOprole(Oprole oprole);//修改oprole
    List<opac_inf> findByAnyOpacInf(opac_inf opacInf);//关于opacinf的模糊查询
    List<Oprole> findByAnyOprole(Oprole oprole);//关于oprole的模糊查询
    Integer alloprole();
    Integer allopacinf();
    List<Oprole> limitoprole(Oprole oprole);
    List<opac_inf> limitopacinf(opac_inf opacInf);
}
