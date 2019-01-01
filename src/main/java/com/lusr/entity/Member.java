package com.lusr.entity;

import javax.persistence.*;

/**
 * Created by ownlove on 2018/12/19.
 */

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String phone;
    private String identity;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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

    public Member() {}

    public Member(String phone, String username, String identity, String password) {
        this.phone = phone;
        this.username = username;
        this.identity = identity;
        this.password = password;
    }

    @Override
    public String toString() {
        return "member: [id: " + id + ", phone: " + phone + ", username: " + username
                + ", identity: " + identity + ", password: " + password + "]";
    }
}
