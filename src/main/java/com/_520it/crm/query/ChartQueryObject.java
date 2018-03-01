package com._520it.crm.query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * 正式客户高级查询
 * @author Hanson
 *
 */
@Getter@Setter
public class ChartQueryObject extends QueryObject {
	
	public static final int POTENTIAL_STATE = 0; //潜在客户
	public static final int REAL_STATE = 1;     //正式客户 
	
	private String keyword;
	private Integer state;//客户状态
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDate;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
}
