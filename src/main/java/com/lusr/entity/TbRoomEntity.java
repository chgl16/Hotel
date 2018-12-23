package com.lusr.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by ownlove on 2018/12/20.
 */
@Entity
@Data
@Table(name="tb_room")
public class TbRoomEntity implements Serializable {

    @Id
    @Column(name="pk_id")
    private int pk_id;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="type")
    private String  type;
    @Column(name="statu")
    private Integer statu;
    @Column(name="start_time")
    private Timestamp start_time;
    @Column(name="end_time")
    private Timestamp end_time;
}
