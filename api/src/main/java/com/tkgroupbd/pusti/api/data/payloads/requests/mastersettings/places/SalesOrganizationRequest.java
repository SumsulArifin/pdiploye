package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class SalesOrganizationRequest extends BaseEntity {

    @NotBlank(message ="Invalid Sales Org Name:Sales Org Name is empty")
    @NotNull(message ="Invalid Sales Org Name:Sales Org Name is NULL")
    private String salesOrgName;
}
