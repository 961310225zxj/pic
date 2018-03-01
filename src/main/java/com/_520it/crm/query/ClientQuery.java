package com._520it.crm.query;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientQuery extends QueryObject{

	private Long id;
	
	private String beginDate;
	
	private String endDate;

	private String keyword;
	
	private boolean state=true;

	private boolean isInsured=false;
}
