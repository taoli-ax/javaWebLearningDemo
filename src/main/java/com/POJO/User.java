package com.POJO;

public class User {
    private long id;
    private String name;
    private String password;
    private String email;
    private int status;
    private String activateCode;

    public User(int id,String name, String password, String email, int status, String activateCode) {
        this.id=id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.status = status;
        this.activateCode = activateCode;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    public User() {
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id+ '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", activateCode='" + activateCode + '\'' +
                '}';
    }
}
