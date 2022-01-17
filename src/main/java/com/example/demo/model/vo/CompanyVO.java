package com.example.demo.model.vo;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.example.demo.repository.entity.Company;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alan.Juan
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("Company Output Model")
public class CompanyVO {

    @ApiModelProperty(value = "CompanyID")
    private long id;

    @ApiModelProperty(value = "Name")
    private String name;

    @ApiModelProperty(value = "Address")
    private String address;

    @ApiModelProperty(value = "CreatedBy")
    private String created_by;

    @ApiModelProperty(value = "CreatedAt")
    private ZonedDateTime created_at;

    @ApiModelProperty(value = "UpdatedBy")
    private String updated_by;

    @ApiModelProperty(value = "UpdatedAt")
    private ZonedDateTime updated_at;

    public static CompanyVO toCompanyVO(Company company) {
        if (Objects.isNull(company)) return null;
        return CompanyVO.builder()
                .id(company.getId())
                .name(company.getName())
                .address(company.getAddress())
                .created_by(company.getCreated_by())
                .created_at(company.getCreated_at())
                .updated_by(company.getUpdated_by())
                .updated_at(company.getUpdated_at())
                .build();
    }
    
}
