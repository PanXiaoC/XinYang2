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
    private String pass_usern;
    private String pass_pass;
}
