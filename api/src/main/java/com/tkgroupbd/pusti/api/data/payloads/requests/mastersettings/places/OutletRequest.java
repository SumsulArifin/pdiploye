package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;;

@Data
@EqualsAndHashCode(callSuper = false)
public class OutletRequest extends BaseEntity {
    @NotBlank(message ="Invalid Outlet Name: Outlet Name is empty")
    @NotNull(message ="Invalid Outlet Name: Outlet Name is NULL")
    private String outletName;
    private String contactPerson;
    private String mobile;
    private String address;
    private double salesPerMonth;
    private String outletKey;
    private String channelId;
    private boolean displayed;
    private double paidAmount;
    private String creditSalesId;
    private String businessType;
    private Route route;
}
