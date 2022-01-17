package com.example.demo.model.vo;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.example.demo.repository.entity.Client;

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
@ApiModel("Client Output Model")
public class ClientVO {

    @ApiModelProperty(value = "ClientID")
    private long id;

    @ApiModelProperty(value = "CompanyID")
    private long company_id;

    @ApiModelProperty(value = "Name")
    private String name;

    @ApiModelProperty(value = "Email")
    private String email;

    @ApiModelProperty(value = "Phone")
    private String phone;

    @ApiModelProperty(value = "CreatedBy")
    private String created_by;

    @ApiModelProperty(value = "CreatedAt")
    private ZonedDateTime created_at;

    @ApiModelProperty(value = "UpdatedBy")
    private String updated_by;

    @ApiModelProperty(value = "UpdatedAt")
    private ZonedDateTime updated_at;

    public static ClientVO toClientVO(Client client) {
        if (Objects.isNull(client)) return null;
        return ClientVO.builder()
                .id(client.getId())
                .company_id(client.getCompany_id())
                .name(client.getName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .created_by(client.getCreated_by())
                .created_at(client.getCreated_at())
                .updated_by(client.getUpdated_by())
                .updated_at(client.getUpdated_at())
                .build();
    }
    
}
