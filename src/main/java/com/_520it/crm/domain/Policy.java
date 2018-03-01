package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by LK on 2017-08-26.
 */
@Getter
@Setter
public class Policy {
    //默认状态false
    public static final int STATUS_NORMAL = 0;
    //改变后的状态true
    public static final int STATUS_AUDIT = 1;
    //保单编号
    private Long id;
    //保单是否交钱状态
    private Integer moneystatus = STATUS_NORMAL;
    //保单是否审核状态
    private Integer checkstatus = STATUS_NORMAL;
    //审核意见
    private String suggestion;
    //录入时间
    @JsonFormat(pattern = "yyyy-MM-dd",locale = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputtime;
    //录入人
    private Employee employee;
    //保险信息
    private Product product;
    //投保人信息
    private Recognizee recognizee;
    //被保人信息
    private InsuredPerson insuredPerson;
    //车辆信息
    private CarInformation carInformation;


/*    public String getInsuredPerson(){
        return insuredPerson.getName();
    }*/
}
