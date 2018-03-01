package com._520it.crm.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//今日计划
public class Plan {
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date plandate;
	
	private Employee employee;
	//任务描述
	private String planmsg;
	//处理描述
	private String handlemsg;
	//完成状态
	private int state;

}