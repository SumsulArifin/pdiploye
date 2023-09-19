package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.AssignedSalesOfficer;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.AssignedSalesOfficerRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.places.AssignedSalesOfficerServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Assigned Sales Officer")
@RestController
@RequestMapping("/assignedSalesOfficer")
public class AssignedSalesOfficerController {

    @Autowired
    AssignedSalesOfficerServiceImpl assignedSalesOfficerService;

    @PostMapping("/addNewSalesOfficer")
    public ResponseEntity<MessageResponse> assignedSalesOfficerSave(
            @RequestBody @Valid AssignedSalesOfficerRequest assigned_sales_officerRequest) {
        MessageResponse newAssignedSalesOfficer = assignedSalesOfficerService
                .saveAssignedSalesOfficer(assigned_sales_officerRequest);
        return new ResponseEntity<>(newAssignedSalesOfficer, HttpStatus.CREATED);
    }

    @GetMapping("/getAllSalesOfficers")
    public ResponseEntity<List<AssignedSalesOfficer>> getAssignedSalesOfficer() {
        List<AssignedSalesOfficer> assigned_sales_officers = assignedSalesOfficerService
                .getAllAssignedSalesOfficer();
        return new ResponseEntity<>(assigned_sales_officers, HttpStatus.OK);
    }

    @DeleteMapping("/deleteSalesOfficerById/{assignedId}")
    public ResponseEntity<?> deleteDistributorById(@PathVariable("assignedId") Integer assignedId) {
        assignedSalesOfficerService.deleteAssignedSalesOfficerById(assignedId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getSalesOfficerById/{assignedId}")
    public ResponseEntity<AssignedSalesOfficer> getDistributorById(@PathVariable("assignedId") Integer assignedId) {
        AssignedSalesOfficer assigned_sales_officer = assignedSalesOfficerService
                .findAssignedSalesOfficerById(assignedId);
        return new ResponseEntity<>(assigned_sales_officer, HttpStatus.OK);
    }

    @PutMapping("/updateSalesOfficer/{assignedId}")
    public ResponseEntity<Optional<AssignedSalesOfficer>> updateDistributor(@PathVariable Integer assignedId,
            @RequestBody AssignedSalesOfficerRequest assigned_sales_officerRequest) {
        Optional<AssignedSalesOfficer> assignedSalesOfficer = assignedSalesOfficerService
                .updateAssignedSalesOfficer(assignedId, assigned_sales_officerRequest);
        return new ResponseEntity<Optional<AssignedSalesOfficer>>(assignedSalesOfficer, HttpStatus.OK);
    }

    @PutMapping("/statusChange/{assignedId}")
    public ResponseEntity<Optional<AssignedSalesOfficer>> updateDistributorStatus(@PathVariable Integer assignedId,
            @RequestBody AssignedSalesOfficerRequest assigned_sales_officerRequest) {
        Optional<AssignedSalesOfficer> assigned_sales_officer = assignedSalesOfficerService
                .updateAssignedSalesOfficerStatus(assignedId, assigned_sales_officerRequest);
        return new ResponseEntity<Optional<AssignedSalesOfficer>>(assigned_sales_officer, HttpStatus.OK);
    }

    @GetMapping("/getSortedSalesOfficersByKey/{field}")
    private ApiResponse<List<AssignedSalesOfficer>> getSortedDistributorByKey(@PathVariable String field) {
        List<AssignedSalesOfficer> assignedSalesOfficer = assignedSalesOfficerService
                .findSortedAssignedSalesOfficerByKey(field);
        return new ApiResponse(assignedSalesOfficer.size(), assignedSalesOfficer);
    }

    @GetMapping("/getSoByRouteId/{routeId}")
    public List<AssignedSalesOfficer> soFindByRouteId(@PathVariable String routeId) {
        int routeIds = Integer.parseInt(routeId);
        return assignedSalesOfficerService.getAssignedSalesOfficerListByRouteID(routeIds);
    }
}
