package com.tkgroupbd.pusti.api.data.models.common;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;
import jakarta.persistence.MappedSuperclass;

import javax.validation.constraints.NotBlank;

@MappedSuperclass
@Data
@ToString
public class BaseEntity {

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
    private String browser;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private String ip;
    @NotBlank(message = "Invalid status: status is empty.")
    @NotBlank(message = "Invalid status: status is NULL")
    private boolean status ;


}
