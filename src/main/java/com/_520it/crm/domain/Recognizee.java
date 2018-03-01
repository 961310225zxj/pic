package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by LK on 2017-08-26.
 */
@Getter
@Setter
public class Recognizee {
    private Long id;
    private String name;
    private Integer is_personal;
    private String level;
    private String numberType;
    private String number;
    private String address;
    private String phoneNumber;
}
