package com._520it.crm.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Menu {
	
    private Long id;

    private String text;

    private String url;

    private Menu parent;
    //菜单对应的权限
    private Permission permission;

    private List<Menu> children = new ArrayList<>();

}