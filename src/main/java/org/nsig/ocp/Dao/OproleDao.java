package org.nsig.ocp.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.nsig.ocp.Entity.Oprole;

import java.util.List;

public interface OproleDao {
    @Select("select * from op_role")
    List<Oprole> findallop(Oprole oprole);
}
