package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QueryObject {
	//当前页
	private int page = 1;
	//每页显示的数量
	private int rows = 10;

	public int getStart(){
		return (page-1)*rows;
	}

}
