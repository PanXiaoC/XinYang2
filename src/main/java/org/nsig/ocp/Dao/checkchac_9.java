package org.nsig.ocp.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;

import java.util.List;

@Mapper
public interface checkchac_9 {
    List<Oprole> checkchac(Oprole oprole);
}

