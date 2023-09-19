package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.AssignedSalesOfficer;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OutletAmendmentRequest extends BaseEntity {
    private int id;
    @NotBlank(message = "Invalid English Name: English Name is empty")
    @NotNull(message = "Invalid English Name: English Name is NULL")
    private String englishName;
    @NotBlank(message ="Invalid Bangla Name: English Name is empty")
    @NotNull(message ="Invalid  Bangle Name: English Name is NULL")
    private String banglaName;
    private String englishAddress;
    private String banglaAddress;
    private String contactPerson;
    private String mobile;
    private String businessType;
    private int salesPerMonth;
    private String outletKey;
    private String shopSign;
    private int creditSales;
    private String comments;
    private double shopSignAmount;
    private double latitude;
    private double longitude;
    private int channelId;
    private String salesGroup;
    private int marketSize;
    private Route route;
    private AssignedSalesOfficer assignedSalesOfficer;

}
