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
@ConfigurationProperties(prefix = "oprole")
public class Oprole implements Serializable {
    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_des() {
        return role_des;
    }

    public void setRole_des(String role_des) {
        this.role_des = role_des;
    }

    public String getRole_con() {
        return role_con;
    }

    public void setRole_con(String role_con) {
        this.role_con = role_con;
    }

    private Integer role_id;
    private String role_name;
    private String role_des;
    private String role_con;

    private Integer pagenum;
    private Integer pagesize;
}
