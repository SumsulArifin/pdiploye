package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SalesOrganization;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.SalesOrganizationRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.places.SalesOrgServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Tag(name = "Sales Organization")
@RestController
@RequestMapping("/")
public class SalesOrginationController {

    @Autowired
    SalesOrgServiceImpl salesOrgService;

    @GetMapping("/getAllSalesOrgs")
    public ResponseEntity<List<SalesOrganization>> getAllSalesOrgs() {
        List<SalesOrganization> salesOrganizations = salesOrgService.getAllSalesOrg();
        return new ResponseEntity<>(salesOrganizations, HttpStatus.OK);
    }

    @PostMapping("/addSalesOrganizations")
    public ResponseEntity<MessageResponse> addSalesOrganizations(
            @RequestBody SalesOrganizationRequest salesOrganizationRequest) {
        MessageResponse newSalesOrganization = salesOrgService.createSalesOrg(salesOrganizationRequest);
        return new ResponseEntity<>(newSalesOrganization, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteSalesOrganizations/{id}")
    public ResponseEntity<?> deleteSalesOrganizations(@PathVariable("id") Integer id) {
        salesOrgService.deleteSalesOrg(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getSalesOrganizationById/{id}")
    public ResponseEntity<SalesOrganization> getSalesOrganizationById(@PathVariable("id") Integer id) {
        SalesOrganization salesOrganizations = salesOrgService.getSalesOrgById(id);
        return new ResponseEntity<>(salesOrganizations, HttpStatus.OK);
    }

    @PutMapping("/updateSalesOrganization/{id}")
    public ResponseEntity<Optional<SalesOrganization>> updateSalesOrganization(@PathVariable Integer id,
            @RequestBody SalesOrganizationRequest SalesOrgRequest) {
        Optional<SalesOrganization> salesOrganization = salesOrgService.updateSalesOrg(id, SalesOrgRequest);
        return new ResponseEntity<Optional<SalesOrganization>>(salesOrganization, HttpStatus.OK);
    }

    @GetMapping("/getSortedSalesOrgByKey/{field}")
    private ApiResponse<List<SalesOrganization>> getsalesOrgSortedFor(@PathVariable String field) {
        List<SalesOrganization> salesOrgsList = salesOrgService.findSortedSalesOrgByKey(field);
        return new ApiResponse(salesOrgsList.size(), salesOrgsList);
    }

    @GetMapping("/getPaginatedSalesOrg/{offset}/{pageSize}")
    private ApiResponse<Page<SalesOrganization>> getPaginatedSalesOrg(@PathVariable int offset,
            @PathVariable int pageSize) {
        Page<SalesOrganization> paginatedSalesOrg = salesOrgService.findSalesOrgByPagination(offset, pageSize);
        return new ApiResponse(paginatedSalesOrg.getSize(), paginatedSalesOrg);
    }

    @GetMapping("/getSortedPaginatedSalesOrg/{offset}/{pageSize}/{field}")
    private ApiResponse<Page<SalesOrganization>> getPaginatedSalesOrgAndSort(@PathVariable int offset,
            @PathVariable int pageSize, @PathVariable String field) {
        Page<SalesOrganization> paginatedSalesOrg = salesOrgService.findSortedSalesOrgByPagination(offset, pageSize,
                field);
        return new ApiResponse(paginatedSalesOrg.getSize(), paginatedSalesOrg);
    }

    @GetMapping("/search/salesOrganizaion/pagination/by/name/{name}")
    private List<SalesOrganization> findSalesOrgByName(@PathVariable String name) {
        List<SalesOrganization> allSalesOrganization = salesOrgService.findSalesOrgBySalesOrgName(name);
        return allSalesOrganization;
    }

    @PutMapping("/updateSalesOrganizaionStatus/{id}")
    public ResponseEntity<Optional<SalesOrganization>> updateSalesOrganizationStatus(@PathVariable Integer id,
            @RequestBody SalesOrganizationRequest salesOrgRequest) {
        Optional<SalesOrganization> updateSalesOrganization = salesOrgService.SalesOrgStatusChange(id, salesOrgRequest);
        return new ResponseEntity<Optional<SalesOrganization>>(updateSalesOrganization, HttpStatus.OK);
    }
}
