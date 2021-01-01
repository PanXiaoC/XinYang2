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
    private String inf_usern;
    private String inf_realn;
    private String inf_org;
    private String inf_pro;
    private String inf_role;
    private String inf_sex;
    private String inf_tel;
    private String inf_mail;
}
