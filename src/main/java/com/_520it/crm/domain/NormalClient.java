package com._520it.crm.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//正式客户(已经投保的人),潜在客户(已经提交保单未缴费的)
@Getter
@Setter
@ToString
public class NormalClient {
    private Long id;

    private String name;

    private Byte isPersonal;

    private String level;

    private String numbertype;

    private String number;

    private String address;

    private String phone;

    private Boolean isInsured;

    private Integer age;

    private String email;

    private String gender;

    private String profession;



}