-- encoding utf8  --

DROP DATABASE IF EXISTS hotel_management_system;
CREATE DATABASE hotel_management_system DEFAULT CHARACTER SET utf8;
USE hotel_management_system;


create table member(
	id int PRIMARY key AUTO_INCREMENT comment '序号,自增',
	phone VARCHAR(11) UNIQUE comment '手机号，作为登录',
	identity	VARCHAR(30) not null comment '身份证',
	username VARCHAR(20) not null comment '用户名',
	password	VARCHAR(70) not null comment 'BCrypt'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table manager(
	id int PRIMARY key auto_increment comment '序号，自增',
	phone varchar(11) UNIQUE comment '手机号，凭证',
	identity varchar(30) not null comment '身份证',
	username varchar(20) not null comment '用户名',
	password varchar(70) not null comment 'BCrypt'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table room(
	id int PRIMARY key comment '房间号',
	price decimal(6,2) not null comment '价格',
	type varchar(10) not null comment '房间类型',
	statu TINYINT DEFAULT 0 comment '0可预订，1已经预定',
	start_time TIMESTAMP not null DEFAULT now() comment '房间开始时间',
	end_time TIMESTAMP not null DEFAULT now() comment '房间结束时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table transaction(
	id int PRIMARY key auto_increment comment '序号',
	transaction_id varchar(20) unique comment '订单号',
	member_id int comment '会员Id',
	phone varchar(11) not null comment '手机号',
	identity varchar(20) not null comment '身份证',
	room_id int not null comment '房间号',
	time TIMESTAMP not null DEFAULT now() comment '订单时间',
	days smallint not null comment '订购天数',
	money DECIMAL(7,2) not null comment '订单金额',
	statu TINYINT DEFAULT 0 comment '订单状态',
	start_time TIMESTAMP not null DEFAULT now() comment '房间开始时间',
	end_time TIMESTAMP not null DEFAULT now() comment '房间结束时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

