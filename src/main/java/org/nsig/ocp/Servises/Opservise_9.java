package org.nsig.ocp.Servises;

import org.nsig.ocp.Dao.addoprole;
import org.nsig.ocp.Entity.Oprole;
import org.nsig.ocp.Entity.ac_pass;
import org.nsig.ocp.Entity.opac_inf;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Opservise_9 {
    ac_pass login(ac_pass acPass);
    Integer insert_oprole(Oprole oprole);
    Integer insert_opacinf(opac_inf opacInf);
    Integer insert_pass(ac_pass acPass);
}
