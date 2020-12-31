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
    private static final long SerVersionUID = 1L;
    private String role_name;
    private String role_des;
    private String role_con;
}
