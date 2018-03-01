package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeQuery extends QueryObject{
	
	private String keyword;

	private Long id;
	
	private String beginDate;
	
	private String endDate;

}
