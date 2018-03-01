package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class DictionaryItem {
    private Long id;

    private String name;

    private String intro;

    private Dictionary parent;

    private boolean state; //软删除状态

}