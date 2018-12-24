package com.lusr.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ownlove on 2018/12/19.
 */
@Entity
@Table(name = "tb_member")
public class TbMemberEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_id;
    private String uk_phone;
    private String uk_identity;
    private String name;
    private String shadow;

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public String getUk_phone() {
        return uk_phone;
    }

    public void setUk_phone(String uk_phone) {
        this.uk_phone = uk_phone;
    }

    public String getUk_identity() {
        return uk_identity;
    }

    public void setUk_identity(String uk_identity) {
        this.uk_identity = uk_identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShadow() {
        return shadow;
    }

    public void setShadow(String shadow) {
        this.shadow = shadow;
    }
}
