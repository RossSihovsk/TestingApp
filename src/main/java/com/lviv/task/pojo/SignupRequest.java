package com.lviv.task.pojo;

import java.util.Set;

public class SignupRequest {

    private String name;
    private String email;
    private Integer age;
    private Set<String> roles;
    private String password;

    public Integer getAge() {return age;}
    public void setAge(Integer age) {this.age = age;}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}