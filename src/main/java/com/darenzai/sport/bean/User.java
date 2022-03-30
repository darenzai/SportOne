package com.darenzai.sport.bean;



public class User {

    private int id;
    private String username;
    private String password;
    private String role;
    private String email;
    private boolean state;

    public User(String username, String password, String role, String email, boolean state) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.state = state;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
