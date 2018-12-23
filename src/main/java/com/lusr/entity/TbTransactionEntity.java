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
@Table(name="tb_transaction")
public class TbTransactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_id;
    private String transaction_id;
    private int member_id;
    private String phone;
    private String identity;
    private int room_id;
    private Timestamp time;
    private Integer days;
    private BigDecimal money;
    private Integer statu;
    private Timestamp start_time;
    private Timestamp end_time;
}
