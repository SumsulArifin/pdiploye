package com.tkgroupbd.pusti.api.services.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SoWorkingDay;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.SoWorkingDayRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public interface SoWorkingDayService {
    MessageResponse createSoWorkingDay(SoWorkingDayRequest soWorkingDayRequest);

    Optional<SoWorkingDay> updateSoWorkingDay(Integer soId, SoWorkingDayRequest soWorkingDayRequest);

    void deleteSoWorkingDay(Integer soId);

    public List<SoWorkingDay> getSoWorkingDay(int assignedId, LocalDate startDate, LocalDate endDate);

}
