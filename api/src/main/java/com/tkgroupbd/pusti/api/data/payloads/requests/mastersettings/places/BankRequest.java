package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Distributor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class BankRequest extends BaseEntity {

    @NotBlank(message = "Invalid Bank Name: Bank Name  is empty.")
    @NotBlank(message = "Invalid Bank Name: Bank Name  is NULL")
    private String bankName;
    @NotBlank(message = "Invalid accountant: accountant is empty.")
    @NotBlank(message = "Invalid accountant: accountant  is NULL")
    private String accountant;
    @NotBlank(message = "Invalid Contact Number: Contact Number is empty.")
    @NotBlank(message = "Invalid Contact Number: Contact Number is NULL")
    private String contactNumber;
    private Distributor distributor;

}
