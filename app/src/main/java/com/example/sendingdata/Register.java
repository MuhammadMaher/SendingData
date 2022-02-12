package com.example.sendingdata;

import com.google.gson.annotations.SerializedName;

public class Register {
    private String name;
    private String password;
    private String email;
    @SerializedName("password_confirmation")
    private String confirmPassword;

    public Register(String name, String password, String email, String confirmPassword) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.confirmPassword = confirmPassword;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
