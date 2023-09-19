package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.enums.NoticeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NoticesRequest extends BaseEntity {
    @NotBlank(message = "Invalid Notice Type: Notice Type is empty")
    @NotNull(message = "Invalid Notice Type: Notice Type is NULL")
    @Enumerated(EnumType.STRING)
    private NoticeType noticeType;
    private String noticeDetails;
    private String effectiveDate;
}
