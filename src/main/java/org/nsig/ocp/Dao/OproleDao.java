package org.nsig.ocp.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;

import java.util.List;

public interface OproleDao {
    @Select("select * from op_role")
    List<Oprole> findallop(Oprole oprole);
    @Insert("insert into op_role (role_name, role_des, role_con) values (#{role_name},#{role_des}, #{role_con})")
    Integer AddOprole(Oprole oprole);
    @Select("select * from ac_pass where pass_usern= #{pass_usern}, pass_pass= #{pass_pass}")
    ac_pass login(ac_pass acPass);
}
