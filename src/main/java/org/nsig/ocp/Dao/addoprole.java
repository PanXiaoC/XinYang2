package org.nsig.ocp.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.nsig.ocp.Entity.Oprole;

@Mapper
public interface addoprole {
    @Insert("insert into op_role (role_name,role_des) values (#{role_name},#{role_des})")
   Integer addoprole1(Oprole oprole);
}
