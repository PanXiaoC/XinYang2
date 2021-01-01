package org.nsig.ocp.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;

import java.util.List;

@Mapper
public interface OproleDao_9 {
    ac_pass login(ac_pass acPass);
}
