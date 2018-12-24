package com.lusr.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by ownlove on 2018/12/20.
 */

@Entity
@Table(name="room")
public class Room {

    @Id
    private int id;
    private BigDecimal price;
    private String type;
    private Integer statu;
    private Timestamp start_time;
    private Timestamp end_time;

}
