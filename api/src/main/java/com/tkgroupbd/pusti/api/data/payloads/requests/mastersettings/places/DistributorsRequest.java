package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)

public class DistributorsRequest extends BaseEntity {
    private int depot_id;
    @NotBlank(message = "Invalid Distributor Name: Distributor Name is empty.")
    @NotBlank(message = "Invalid Distributor Name: Distributor Name is NULL")
    private String distributorName;
    private String erp_id;
    @NotBlank(message = "Invalid Proprietor_name:Name can't  is empty.")
    @NotBlank(message = "Invalid Proprietor_name:Name can't  is null")
    private String proprietor_name;

    private String proprietor_dob;
    @NotBlank(message = "Invalid mobile:Mobile can't  is empty.")
    @NotBlank(message = "Invalid mobile:Mobile can't  is null")
    private String mobile;
    private String address;
    private String has_pc;
    private String has_printer;
    private String has_live_app;
    private String has_direct_sale;
    private String opening_date;
    @NotBlank(message = "Invalid  Name:Name can't  is empty")
    @NotBlank(message = "Invalid  Name:Name can't  is null")
    private String emergency_contact_name;
    @NotBlank(message = "Invalid mobile:Mobile can't  is empty")
    @NotBlank(message = "Invalid mobile:Mobile can't  is null")
    private String emergency_contact_number;
    private String emergency_person_relation;
    private Route route;
}
