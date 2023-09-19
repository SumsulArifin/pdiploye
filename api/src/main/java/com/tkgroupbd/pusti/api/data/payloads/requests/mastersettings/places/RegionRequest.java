package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Division;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegionRequest extends BaseEntity {
    @NotBlank(message = "Invalid Region Name: Region Name is empty.")
    @NotNull(message = "Invalid Region Name: Region Name is NULL")
    private String regionName;
    private Division division;
}
