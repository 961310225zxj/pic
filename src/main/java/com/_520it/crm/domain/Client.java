package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Setter
@Getter
@ToString
public class Client {
    private Long id;

    private String name;

    private Boolean isInsured;

    private Integer number;

    private String address;

    private Integer age;

    private String gender;

    private String profession;

    private Integer phone;

    private String email;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date inputtime;

    private boolean state;

    private Long employee_id;
}