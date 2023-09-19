package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;
import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Zone;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
public class RouteRequest extends BaseEntity {
    @NotBlank(message = "Invalid Route Name: Route Name is empty.")
    @NotBlank(message = "Invalid Route Name: Route Name is NULL")
    private String routeName;
    private String assignedDistributorId;
    private Zone zone;
}
