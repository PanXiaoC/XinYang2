package org.nsig.ocp.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class user implements Serializable {
    private static final long SerVersionUID = 1L;
    private  Integer userid;
    private String username;
    private String userpass;
    private  String sex;
}
