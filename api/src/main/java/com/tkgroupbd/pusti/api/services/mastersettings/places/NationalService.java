package com.tkgroupbd.pusti.api.services.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Division;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.National;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.NationalRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface NationalService {
    MessageResponse saveNational(NationalRequest nationalRequest);

    public Optional<National> updateNational(int nationalId, NationalRequest nationalRequest);

    public List<National> getAllNational();

    public National findNationalById(int nationalId);

    public void deleteNationalId(int nationalId);
}
