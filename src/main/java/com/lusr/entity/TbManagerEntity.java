package com.lusr.entity;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ownlove on 2018/12/20.
 */
@Entity
@Table(name="tb_manager")
@Data
@ManagedBean
public class TbManagerEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_id;
    private String uk_phone;
    private String uk_identity;
    private String name;
    private String shadow;
}
