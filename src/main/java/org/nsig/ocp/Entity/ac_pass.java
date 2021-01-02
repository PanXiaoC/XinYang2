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
@ConfigurationProperties(prefix = "acpass")
public class ac_pass implements Serializable  {
    private static final long SerVersionUID = 1L;

    public String getPass_usern() {
        return pass_usern;
    }

    public void setPass_usern(String pass_usern) {
        this.pass_usern = pass_usern;
    }

    public String getPass_pass() {
        return pass_pass;
    }

    public void setPass_pass(String pass_pass) {
        this.pass_pass = pass_pass;
    }

    private String pass_usern;
    private String pass_pass;
}
 