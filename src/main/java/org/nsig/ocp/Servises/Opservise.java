package org.nsig.ocp.Servises;

import org.apache.ibatis.annotations.Mapper;
import org.nsig.ocp.Entity.ac_pass;
import org.springframework.stereotype.Service;

@Mapper
public interface Opservise {
    public ac_pass login(ac_pass user);
}
