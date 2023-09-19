package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.enums.EmployeeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeRequest extends BaseEntity {
    @NotBlank(message = "Invalid Employee Type: Employee Type is empty")
    @NotNull(message = "Invalid Employee Type: Employee Type is NULL")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    private String dealingAreaId;
    private String salesOrgId;
    private String mobile;
    private String depotId;
    private String backPermit;
    private String designationId;
    private String dateOfJoining;
    private String dateOfResignation;
    private String basicSalary;
    private String houseRent;
    private String medicalAllowance;
    private String internetBills;
    private String otherAllowance;
    private String sscPassingYear;
    private String highestDegreeName;
    private String dateOfBirth;
    private String bloodGroup;
    private String bankId;
    private String backAccNumber;
    private String districtId;
    @NotNull(message = "email is null")
    @NotEmpty(message = "Email is empty")
    @Email(message = "Invalid email")
    private String email;
    @NotNull(message = "nid is null")
    @NotEmpty(message = "nid is empty")
    private String nid;
    private String travellingDailyAllowance;
    private String meetingTravellingAllowance;
    private String meetingDailyAllowance;
}
