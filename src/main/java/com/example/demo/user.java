package com.example.demo;

public class user {
    private int id;
    private String username;
    private String department;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public user() {
    }

    public user(int id, String username, String department) {
        this.id = id;
        this.username = username;
        this.department = department;
    }
}
