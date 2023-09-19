package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Distributor;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssignedSalesOfficerRequest extends BaseEntity {
    @NotBlank(message = "Invalid So Name: So Name  is empty.")
    @NotBlank(message = "Invalid So Name: So Name  is NULL")
    public String soName;
    private int soId;
    private int scheduleOutlet;
    private int visitedOutlet;
    private Route route;
    private Distributor distributor;
}
