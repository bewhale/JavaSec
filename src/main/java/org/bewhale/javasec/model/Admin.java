package org.bewhale.javasec.model;

import java.io.Serializable;

public class Admin implements Serializable {
    String id;
    String username;
    String password;

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    String perms;
    String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "用户ID: " + id + "<br/>" +
                "用户名: " + username + "<br/>" +
                "用户密码: " + password + "<br/>";
    }
}
