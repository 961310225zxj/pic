package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by LK on 2017-08-26.
 */
@Getter
@Setter
@ToString
public class InsuredPerson {
    private Long id;
    private String name;
    private Integer is_personal;
    private String level;
    private String numberType;
    private String number;
    private String address;
    private String phone;
    private Integer is_insured;
    private String gender;
    private Integer age;
    private String email;
    private String profession;
}
