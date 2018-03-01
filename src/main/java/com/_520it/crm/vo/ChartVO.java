package com._520it.crm.vo;

import com._520it.crm.util.ExcelField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter@ToString
public class ChartVO {
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@ExcelField(title = "创建时间")
	private Date creatTime;//创建时间
	@ExcelField(title = "ID")
	private Long id;//
	@ExcelField(title = "姓名")
	private String realname;//负责人姓名
	@ExcelField(title = "新增数量")
	private Integer count;//新增数量
	
	
	//饼图需要的字段

	private String productName;//车险产品名称
	
	
	
	
}
