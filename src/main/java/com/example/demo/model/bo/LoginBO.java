package com.example.demo.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan.Juan
 *
 */
@Data
@ApiModel("Login Model")
public class LoginBO {
    
    @ApiModelProperty(value = "UserName")
    private String username;

    @ApiModelProperty(value = "Password")
    private String password;
    
}
