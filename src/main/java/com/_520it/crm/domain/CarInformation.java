package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by LK on 2017-08-26.
 */
@Getter
@Setter
public class CarInformation {
    private Long id;
    private Integer is_license;
    private Integer is_newCar;
    private Integer is_foreignCar;
    private Integer is_transfer;
    private CarBrand carBrand;
    private String cartypeinformation;
    private String carIdType;
    private String carId;
}
