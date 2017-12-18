package edu.hznu.cliven.basicboot.entity;

public class User {
    private String username;
    private String password;
    private String passwordRep;

    public User() {
    }

    public String getPasswordRep() {
        return passwordRep;
    }

    public void setPasswordRep(String passwordRep) {
        this.passwordRep = passwordRep;
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
