package com._520it.crm.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonFormat;

@Setter
@Getter
@ToString
//签到表
public class Checktable {
	private Long id;

	//签到员工
	private Employee employee;

	private String employeeip;

	//签到状态  0:正常 , 1:请假,  2:补签
	private int state;

	//签到时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date signintime;

	//签退时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date signouttime;

	//补签人 :管理员(有权限才能给员工补签)
	private Employee checked;

	//补签时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date checkedTime;

}