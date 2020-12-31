package org.nsig.ocp.Entity;

public class ac_pass {
    private String pass_usern;
    private String pass_pass;

    public ac_pass(String pass_usern) {
        this.pass_usern = pass_usern;
    }

    public void setPass_pass(String pass_pass) {
        this.pass_pass = pass_pass;
    }

    public String getPass_pass() {
        return pass_pass;
    }

    public void setPass_usern(String pass_usern) {
        this.pass_usern = pass_usern;
    }
}
