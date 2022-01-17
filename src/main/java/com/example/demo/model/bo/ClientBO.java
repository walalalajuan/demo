package com.example.demo.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan.Juan
 *
 */

@Data
@ApiModel("Client Model")
public class ClientBO {

    @ApiModelProperty(value = "Name")
    private String name;

    @ApiModelProperty(value = "Email")
    private String email;
    
    @ApiModelProperty(value = "Phone")
    private String phone;

}
