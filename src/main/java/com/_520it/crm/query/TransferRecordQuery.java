package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TransferRecordQuery extends QueryObject{

	private String keyword;
	
	private String beginDate;
	
	private String endDate;
	
}
