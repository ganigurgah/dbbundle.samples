package com.valora.test.dbbundlejsfcontrol.bean;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("loginBean")
@ViewScoped
public class LoginBean {
    private String username;
    private String password;

    public LoginBean() {
    }

    public void doLogin() {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("System Loged-In");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
