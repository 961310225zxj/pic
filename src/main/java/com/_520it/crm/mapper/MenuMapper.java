package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    Menu selectByPrimaryKey(Long id);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);

    List<Menu> getRootMenu();

	List<Menu> getChildrenMenuByName(String title);
}