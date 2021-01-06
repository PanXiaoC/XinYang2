package org.nsig.ocp.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Entity.opac_inf;

import java.util.List;

@Mapper
public interface checkchac_9 {
    List<Oprole> checkchac(Oprole oprole);
    List<opac_inf> findopacinf(opac_inf opacInf);
    Integer deletopacinf(opac_inf opacInf);
    Integer deletacpass(ac_pass acPass);
}

