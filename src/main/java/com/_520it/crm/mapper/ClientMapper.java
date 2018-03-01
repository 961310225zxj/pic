package com._520it.crm.mapper;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.Client;
import com._520it.crm.query.ClientQuery;

import java.util.List;

public interface ClientMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Client record);

	Client selectByPrimaryKey(Long id);

	List<Client> selectAll();

	int updateByPrimaryKey(Client record);

	Long queryPageCount(ClientQuery qo);

	List<Client> queryPageResult(ClientQuery qo);

	void transferCustomer(@Param("clientId") Long clientId, @Param("empId") Long empId);

	void changeState(Long clientId);

	// 吸纳客户
	void absorb(Long clientId);

}