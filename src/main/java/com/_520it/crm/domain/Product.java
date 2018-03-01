package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by LK on 2017-08-26.
 */
@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private BigDecimal salePrice;
    private Integer safetyDate;
    private ProductOrganization productOrganization;
    private String introduce;
    private BigDecimal compensation;
}
