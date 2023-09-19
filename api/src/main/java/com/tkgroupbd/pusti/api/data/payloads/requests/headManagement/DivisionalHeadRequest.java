package com.tkgroupbd.pusti.api.data.payloads.requests.headManagement;
import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DivisionalHeadRequest extends BaseEntity {
    @NotBlank(message = "Invalid name: name is empty.")
    @NotNull(message = "Invalid name: name is NULL")
    private String name;
}
