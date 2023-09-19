package com.tkgroupbd.pusti.api.services.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SoWorkingDay;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.SoWorkingDayRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.SoWorkingDayRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SoWorkingDayServiceImpl implements SoWorkingDayService {

    @Autowired
    private SoWorkingDayRepository repository;

    @Override
    public MessageResponse createSoWorkingDay(SoWorkingDayRequest soWorkingDayRequest) {
        SoWorkingDay newSoWorkingDay = new SoWorkingDay();

        newSoWorkingDay.setWorkOnSat(soWorkingDayRequest.isWorkOnSat());
        newSoWorkingDay.setWorkOnSun(soWorkingDayRequest.isWorkOnSun());
        newSoWorkingDay.setWorkOnMon(soWorkingDayRequest.isWorkOnMon());
        newSoWorkingDay.setWorkOnTues(soWorkingDayRequest.isWorkOnTues());
        newSoWorkingDay.setWorkOnWed(soWorkingDayRequest.isWorkOnWed());
        newSoWorkingDay.setWorkOnThu(soWorkingDayRequest.isWorkOnThu());
        newSoWorkingDay.setWorkOnFri(soWorkingDayRequest.isWorkOnFri());
        newSoWorkingDay.setStatus(soWorkingDayRequest.isStatus());
        newSoWorkingDay.setCreatedAt(soWorkingDayRequest.getCreatedAt());
        newSoWorkingDay.setUpdatedAt(soWorkingDayRequest.getUpdatedAt());
        newSoWorkingDay.setDeletedAt(soWorkingDayRequest.getDeletedAt());
        newSoWorkingDay.setBrowser(soWorkingDayRequest.getBrowser());
        newSoWorkingDay.setIp(soWorkingDayRequest.getIp());
        newSoWorkingDay.setAssignedSalesOfficer(soWorkingDayRequest.getAssignedSalesOfficer());

        repository.save(newSoWorkingDay);

        return new MessageResponse(Message.SUCCESS_SOWORKINGDAY_CREATION);
    }

    @Override
    public Optional<SoWorkingDay> updateSoWorkingDay(Integer soId, SoWorkingDayRequest soWorkingDayRequest) {
        Optional<SoWorkingDay> soWorkingDay = repository.findById(soId);
        if (soWorkingDay.isEmpty()) {
            throw new ResourceNotFoundException("SoWorkingDay", "id", soId);
        } else
            soWorkingDay.get().setWorkOnSat(soWorkingDayRequest.isWorkOnSat());
        soWorkingDay.get().setWorkOnSun(soWorkingDayRequest.isWorkOnSun());
        soWorkingDay.get().setWorkOnMon(soWorkingDayRequest.isWorkOnMon());
        soWorkingDay.get().setWorkOnTues(soWorkingDayRequest.isWorkOnTues());
        soWorkingDay.get().setWorkOnWed(soWorkingDayRequest.isWorkOnWed());
        soWorkingDay.get().setWorkOnThu(soWorkingDayRequest.isWorkOnThu());
        soWorkingDay.get().setWorkOnFri(soWorkingDayRequest.isWorkOnFri());
        soWorkingDay.get().setStatus(soWorkingDayRequest.isStatus());
        soWorkingDay.get().setCreatedAt(soWorkingDayRequest.getCreatedAt());
        soWorkingDay.get().setUpdatedAt(soWorkingDayRequest.getUpdatedAt());
        soWorkingDay.get().setDeletedAt(soWorkingDayRequest.getDeletedAt());
        soWorkingDay.get().setBrowser(soWorkingDayRequest.getBrowser());
        soWorkingDay.get().setIp(soWorkingDayRequest.getIp());
        soWorkingDay.get().setAssignedSalesOfficer(soWorkingDayRequest.getAssignedSalesOfficer());

        repository.save(soWorkingDay.get());

        return soWorkingDay;
    }

    @Override
    public void deleteSoWorkingDay(Integer soId) {
        repository.deleteById(soId);
    }

    @Override
    public List<SoWorkingDay> getSoWorkingDay(int assignedId, LocalDate startDate, LocalDate endDate) {
        return repository.findSoWorkingDayByAssignedSalesOfficer_AssignedIdAndCreatedAtBetween(assignedId, startDate,
                endDate);
    }

}
