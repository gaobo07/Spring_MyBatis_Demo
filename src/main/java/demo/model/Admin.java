package demo.model;

import java.io.Serializable;

public class Admin implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String team;
    private String role;

    public Admin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String  getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String  getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}