package org.nsig.ocp.Servises;

import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Opservise_9 {
    ac_pass login(ac_pass acPass);
    List<Oprole> getallchac();
}
