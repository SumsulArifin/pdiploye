package com.tkgroupbd.pusti.api.services.headManagement;
import com.tkgroupbd.pusti.api.data.models.entity.headManagement.DivisionalHead;
import com.tkgroupbd.pusti.api.data.payloads.requests.headManagement.DivisionalHeadRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public interface DivisionalHeadService  {
    public MessageResponse addDivisionalHead(DivisionalHeadRequest divisionalHeadRequest);
    public List<DivisionalHead> getAllDivisionalHead();
    public Optional<DivisionalHead>  updateDivisionalHead(int divisionalHeadId, DivisionalHeadRequest divisionalHeadRequest);
    public DivisionalHead findById(int divisionalHeadId);
    public void deleteDivisionalHeadById(int divisionalHeadId);
    public Optional<DivisionalHead> updateDivisionalHeadStatus(int divisionalHeadId, DivisionalHeadRequest divisionalHeadRequest);


}
