package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.ProductItem;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.AssignedSalesOfficer;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Region;
import com.tkgroupbd.pusti.api.data.models.enums.AudienceType;
import com.tkgroupbd.pusti.api.data.models.enums.TargetType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SalesTargetRequest extends BaseEntity {

    @NotBlank(message ="Invalid targetType:Target Type is empty")
    @NotNull(message ="Invalid targetType:Target Type Name is NULL")
    @Enumerated(EnumType.STRING)
    private TargetType targetType;
    @NotBlank(message ="Invalid Audience Type:Audience Type is empty")
    @NotNull(message ="Invalid Audience Type:Audience Type Name is NULL")
    @Enumerated(EnumType.STRING)
    private AudienceType audienceType;
    private int audienceId;
    private String yearmonth;
    private String quantity;
    private String dp;
    private String tp;
    private String dealerId;
    private String tsoId;
    private String rsmId;
    private String asmId;
    private Region region;
    private ProductItem productItem;
    private AssignedSalesOfficer assignedSalesOfficer;
}
