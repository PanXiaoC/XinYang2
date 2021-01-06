package org.nsig.ocp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "opacrole")

public class opac_inf implements Serializable {

    private Integer id;

    public String getInf_usern() {
        return inf_usern;
    }

    public void setInf_usern(String inf_usern) {
        this.inf_usern = inf_usern;
    }

    public String getInf_realn() {
        return inf_realn;
    }

    public void setInf_realn(String inf_realn) {
        this.inf_realn = inf_realn;
    }

    public String getInf_org() {
        return inf_org;
    }

    public void setInf_org(String inf_org) {
        this.inf_org = inf_org;
    }

    public String getInf_pro() {
        return inf_pro;
    }

    public void setInf_pro(String inf_pro) {
        this.inf_pro = inf_pro;
    }

    public String getInf_role() {
        return inf_role;
    }

    public void setInf_role(String inf_role) {
        this.inf_role = inf_role;
    }

    public String getInf_sex() {
        return inf_sex;
    }

    public void setInf_sex(String inf_sex) {
        this.inf_sex = inf_sex;
    }

    public String getInf_tel() {
        return inf_tel;
    }

    public void setInf_tel(String inf_tel) {
        this.inf_tel = inf_tel;
    }

    public String getInf_mail() {
        return inf_mail;
    }

    public void setInf_mail(String inf_mail) {
        this.inf_mail = inf_mail;
    }
    public String getInf_con() {
        return inf_con;
    }

    public void setInf_con(String inf_con) {
        this.inf_con = inf_con;
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    private String inf_usern;
    private String inf_realn;
    private String inf_org;
    private String inf_pro;
    private String inf_role;
    private String inf_sex;
    private String inf_tel;
    private String inf_mail;
    private String inf_con;
    private Integer pagenum;
    private  Integer pagesize;
}
