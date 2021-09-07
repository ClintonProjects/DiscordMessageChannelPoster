package com.mycompany.model;

public class DiscordLogin {

    private String username;
    private String password;
    private String twoFaCode;
    private boolean isLoggedIn;

    public DiscordLogin(String username, String password, String twoFaCode) {
        super();
        this.username = username;
        this.password = password;
        this.twoFaCode = twoFaCode;
        isLoggedIn = false;
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

    public String getTwoFaCode() {
        return twoFaCode;
    }

    public void setTwoFaCode(String twoFaCode) {
        this.twoFaCode = twoFaCode;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
}
