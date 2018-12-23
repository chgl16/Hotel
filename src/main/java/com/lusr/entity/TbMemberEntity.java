package com.lusr.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ownlove on 2018/12/19.
 */
@Entity
@Table(name = "tb_member")
@Data
public class TbMemberEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_id;
    private String uk_phone;
    private String uk_identity;
    private String name;
    private String shadow;
}
