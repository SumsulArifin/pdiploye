package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class BrandRequest extends BaseEntity {
    @NotBlank(message = "Invalid Brand Name: Brand Name  is empty.")
    @NotBlank(message = "Invalid Brand Name: Brand Name  is NULL")
    private String brandName;
    @NotBlank(message = "Invalid Brand Type: Brand Type  is empty.")
    @NotBlank(message = "Invalid Brand Type: Brand Type  is NULL")
    private String brandType;
}
