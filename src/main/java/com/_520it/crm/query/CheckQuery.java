package com._520it.crm.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Jim on 2017/8/29.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CheckQuery extends QueryObject {
    //为了提交
    private String recognizee;
    private String insuredPerson;
    private Long checkId;
    private String product;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date beginTime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;
    private Integer checkstatus;
    private Integer moneystatus;
}
