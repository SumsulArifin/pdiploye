package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Region;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ZoneRequest extends BaseEntity {

    @NotBlank(message = "Invalid Zone Name: Zone Name is empty.")
    @NotNull(message = "Invalid Zone Name: Zone Name is NULL")
    private String zoneName;
    private Region region;
}
