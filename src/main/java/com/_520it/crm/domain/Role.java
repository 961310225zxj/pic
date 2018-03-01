package com._520it.crm.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Role {
    private Long id;

    private String sn;

    private String name;

    //权限集合 permissions[0].id = 1
    private List<Permission> permissions = new ArrayList<>();

}