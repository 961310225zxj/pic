package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Dictionary {
    private Long id;
    //字典编码
    private String sn;
    //字典名称
    private String name;
    //字典简介
    private String intro;
}