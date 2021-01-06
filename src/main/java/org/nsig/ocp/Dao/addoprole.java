package org.nsig.ocp.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Entity.opac_inf;

import java.util.List;

@Mapper
public interface addoprole {
    @Insert("insert into op_role (role_name,role_des) values (#{role_name},#{role_des})")
    Integer addoprole1(Oprole oprole);
    @Insert("insert into op_inf (inf_usern,inf_realn,inf_org,inf_pro,inf_role,inf_sex,inf_tel,inf_mail) values (#{inf_usern}," +
            "#{inf_realn}),#{inf_org},#{inf_pro},#{inf_role},#{inf_sex},#{inf_tel},#{inf_mail}")
    Integer addoprole2(opac_inf opacinf);

    @Insert("insert into ac_pass (pass_usern,pass_pass) values (#{pass_usern},#{pass_pass})")
    Integer addoprole3(ac_pass acPass);
    @Select("select * from op_role")
    List<Oprole> getallchac();
    @Update("update ac_pass set pass_pass =#{pass_pass} where pass_usern = #{pass_usern}")
    int updateAcPass(ac_pass acPass);
}
