package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.OutletAmendment;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.OutletAmendmentRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.OutletAmendmentRepository;
import com.tkgroupbd.pusti.api.services.mastersettings.places.OutletAmendmentServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Outlet")
@RestController
@RequestMapping("/outletAmendment")
public class OutletAmendmentController {
    @Autowired
    OutletAmendmentServiceImpl service;

    @Autowired
    OutletAmendmentRepository repository;

    @PostMapping("/addNewOutlet")
    public ResponseEntity<List<OutletAmendment>> employeesSave(
            @RequestBody List<OutletAmendmentRequest> outletAmendmentRequestList) {
        MessageResponse newOutletAmendment = service.createOutletAmendment(outletAmendmentRequestList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateBulkOutlets")
    public ResponseEntity<List<OutletAmendment>> updateBulkOutletAmendments(
            @RequestBody List<OutletAmendmentRequest> outletAmendmentDTOList) {
        List<OutletAmendment> updatedOutletAmendments = service.updateBulkOutletAmendments(outletAmendmentDTOList);
        return ResponseEntity.ok(updatedOutletAmendments);
    }

    @PutMapping("/updateOutlet/latitudeAndLongitude/{id}")
    public ResponseEntity<Optional<OutletAmendment>> updateOutletAmendmentLatitudeAndLongitude(@PathVariable Integer id,
            @RequestBody OutletAmendmentRequest request) {
        Optional<OutletAmendment> outletAmendment = service.updateOutletAmendmentLatitudeAndLongitude(id, request);
        return new ResponseEntity<Optional<OutletAmendment>>(outletAmendment, HttpStatus.OK);
    }

}
