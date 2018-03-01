package com._520it.crm.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//行程安排
public class Journeyplan {
	private Long id;
	//标题
	private String title;
	//是否是全天
	private Boolean allday;
	//开始时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end;
	
	private String url;
	//给标题设置的颜色
	private String color;

}