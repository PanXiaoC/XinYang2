package org.nsig.ocp.Dao;

import org.apache.ibatis.annotations.*;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Entity.opac_inf;

import java.util.List;

@Mapper
public interface addoprole {
    @Insert("insert into op_role (role_name,role_des) values (#{role_name},#{role_des})")
    Integer addoprole1(Oprole oprole);
    @Insert("insert into opac_inf (inf_usern,inf_realn,inf_org,inf_pro,inf_role,inf_sex,inf_tel,inf_mail) values (#{inf_usern}," +
            "#{inf_realn},#{inf_org},#{inf_pro},#{inf_role},#{inf_sex},#{inf_tel},#{inf_mail})")
    Integer addoprole2(opac_inf opacinf);

    @Insert("insert into ac_pass (pass_usern,pass_pass) values (#{pass_usern},#{pass_pass})")
    Integer addoprole3(ac_pass acPass);
    @Select("select * from op_role")
    List<Oprole> getallchac();
    @Update("update ac_pass set pass_pass =#{pass_pass} where pass_usern = #{pass_usern}")
    Integer updateAcPass(ac_pass acPass);//测试一下，可能有问题。更新密码
    @Update("update opac_inf set inf_realn =#{inf_realn}, inf_org =#{inf_org}, inf_pro =#{inf_pro}, inf_role =#" +
            "{inf_role}, inf_sex =#{inf_sex}, inf_tel =#{inf_tel}, inf_mail =#{inf_mail} where inf_usern = #{inf_usern}")
    Integer updateopacinf(opac_inf opacInf);//更新opacinf信息
    @Update("update op_role set role_des = #{role_des} where role_name = #{role_name}")
    Integer updateOprole(Oprole oprole);
    @Delete("delete from op_role where role_name = #{role_name}")
    Integer deleteoprole(Oprole oprole);
    @Delete("delete from opac_inf where inf_usern = #{inf_usern}")
    Integer deleteopacinf(opac_inf opacInf);
    @Delete("delete from ac_pass where pass_usern = #{pass_usern}")
    Integer deleteacpass(ac_pass acPass);
    @Select("select count(*) from op_role")
    Integer alloprole();
    @Select("select count(*) from opac_inf")
    Integer allopacinf();
}
