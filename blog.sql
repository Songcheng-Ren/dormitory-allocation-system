create table user_auth
(
    id         bigint auto_increment
        primary key,
    u_id       varchar(50)   not null comment '用户名 =》 学号
',
    u_password varchar(50)   not null comment '用户密码',
    u_email    varchar(50)   not null comment '邮箱',
    data_flag  int default 0 null comment '是否已经填写个人资料',
    constraint user_auth_id_uindex
        unique (id),
    constraint user_auth_u_id_uindex
        unique (u_id)
)
    comment '用户表';

create table user_form
(
    id             int auto_increment
        primary key,
    u_id           varchar(50)  not null,
    u_name         varchar(100) not null,
    u_college      varchar(50)  not null,
    u_major        varchar(50)  not null,
    u_city         varchar(50)  not null,
    u_phone        varchar(50)  not null,
    u_sex          int          null,
    u_smoke        int          null,
    u_clean        int          null,
    u_hulu         int          null,
    u_game         int          null,
    u_social       int          null,
    u_interest     int          null,
    u_smell        int          null,
    u_introduction varchar(300) null,
    u_sleep        int          null,
    u_gameName     varchar(50)  null,
    u_interestName varchar(50)  null,
    constraint test_id_uindex
        unique (id)
);

create table user_info
(
    id             int auto_increment
        primary key,
    u_id           varchar(50)   not null comment '用户名/学号',
    u_name         varchar(50)   not null comment '用户姓名',
    u_sex          int default 0 not null comment '男0女1',
    u_city         varchar(50)   not null comment '用户省份',
    u_collage      varchar(50)   not null comment '用户学院',
    u_major        varchar(50)   not null comment '用户专业',
    u_email        varchar(50)   not null comment '用户邮箱',
    u_introduction varchar(50)   not null comment '用户个人简介',
    u_phone        varchar(50)   not null comment '用户手机号',
    constraint user_info_id_uindex
        unique (id),
    constraint user_info_u_id_uindex
        unique (u_id)
)
    comment '用户资料表';


