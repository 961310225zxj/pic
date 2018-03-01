package com._520it.crm.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//工资
public class Salary {
	private Long id;
	
	private Employee employee;

	private BigDecimal salary;
	//奖金
	private BigDecimal bonus;

	private String year;

	private String month;
	//工资总计
	private BigDecimal total;

}