package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SalaryQueryObject extends QueryObject {
	private String years;
	private String months;
	private String realname;
}
