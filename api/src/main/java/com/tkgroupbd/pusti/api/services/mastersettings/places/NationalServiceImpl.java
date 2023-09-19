package com.tkgroupbd.pusti.api.services.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.National;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.NationalRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.NationalRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationalServiceImpl implements NationalService {
    @Autowired
    private NationalRepository nationalRepository;

    @Override
    public MessageResponse saveNational(NationalRequest nationalRequest) {
        National national = new National();
        national.setNationalName(nationalRequest.getNationalName());
        national.setStatus(nationalRequest.isStatus());
        national.setCreatedBy(nationalRequest.getCreatedBy());
        national.setUpdatedBy(nationalRequest.getUpdatedBy());
        national.setCreatedAt(nationalRequest.getCreatedAt());
        national.setUpdatedAt(nationalRequest.getUpdatedAt());
        national.setDeletedAt(nationalRequest.getDeletedAt());
        national.setBrowser(nationalRequest.getBrowser());
        national.setIp(nationalRequest.getIp());
        nationalRepository.save(national);
        return new MessageResponse(Message.SUCCESS_CREATION);
    }

    @Override
    public Optional<National> updateNational(int nationalId, NationalRequest nationalRequest) {
        Optional<National> result = nationalRepository.findById(nationalId);
        if (result.isPresent()) {
            National national = result.get();
            national.setStatus(nationalRequest.isStatus());
            national.setNationalName(nationalRequest.getNationalName());
            national.setCreatedBy(nationalRequest.getCreatedBy());
            national.setUpdatedBy(nationalRequest.getUpdatedBy());
            national.setCreatedAt(nationalRequest.getCreatedAt());
            national.setUpdatedAt(nationalRequest.getUpdatedAt());
            national.setDeletedAt(nationalRequest.getDeletedAt());
            national.setBrowser(nationalRequest.getBrowser());
            national.setIp(nationalRequest.getIp());
            nationalRepository.save(national);
        } else {
            throw new ResourceNotFoundException("National", "nationalId", nationalId);
        }

        return result;
    }

    @Override
    public List<National> getAllNational() {
        return nationalRepository.findAll();
    }

    @Override
    public National findNationalById(int nationalId) {
        return nationalRepository.findById(nationalId).get();
    }

    @Override
    public void deleteNationalId(int nationalId) {
        nationalRepository.deleteById(nationalId);
    }
}
