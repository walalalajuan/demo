package com.example.demo.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan.Juan
 *
 */

@Data
@ApiModel("Company Model")
public class CompanyBO {

    @ApiModelProperty(value = "Name")
    private String name;

    @ApiModelProperty(value = "Address")
    private String address;

}
