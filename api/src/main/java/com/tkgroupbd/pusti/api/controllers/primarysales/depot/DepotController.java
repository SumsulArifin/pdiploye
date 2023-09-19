package com.tkgroupbd.pusti.api.controllers.primarysales.depot;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.depot.Depot;
import com.tkgroupbd.pusti.api.data.payloads.requests.depot.DepotRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.depot.DepotService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Tag(name = "Depot")
@RestController
@RequestMapping("/depot")
@CacheConfig(cacheNames = "depot")
public class DepotController {
    @Autowired
    DepotService depotService;

    // Get all the depot information
    @GetMapping("/getAllDepots")
    public ResponseEntity<List<Depot>> getAllDepots() {
        List<Depot> depots = depotService.getAllDepots();
        return new ResponseEntity<>(depots, HttpStatus.OK);
    }

    // Create a new depot
    @PostMapping("/addNewDepot")
    public ResponseEntity<MessageResponse> addDepot(@RequestBody DepotRequest depotRequest) {
        MessageResponse newDeport = depotService.addDepot(depotRequest);
        return new ResponseEntity<>(newDeport, HttpStatus.CREATED);
    }

    // Delete depot by id
    @DeleteMapping("/deleteDepot/{depotId}")
    public ResponseEntity<?> deleteDepot(@PathVariable("depotId") Integer depotId) {
        depotService.deleteDepot(depotId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Find by id Api
    @GetMapping("/getDepotById/{depotId}")
    public ResponseEntity<Depot> getDeportById(@PathVariable("depotId") Integer depotId) {
        Depot depot = depotService.getDeportById(depotId);
        if (depot != null) {
            return new ResponseEntity<>(depot, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a depot information
    @PutMapping("/updateDepot/{depotId}")
    public ResponseEntity<Optional<Depot>> updateDepot(@PathVariable Integer depotId,
            @RequestBody DepotRequest depotRequest) {
        Optional<Depot> updateDepot = depotService.updateDepot(depotId, depotRequest);
        return new ResponseEntity<Optional<Depot>>(updateDepot, HttpStatus.OK);
    }

    @GetMapping("/getSortedDepotByKey/{field}")
    public ApiResponse<List<Depot>> getSortedDepotByKey(@PathVariable String field) {
        List<Depot> depotList = depotService.findSortedDepotsByKey(field);
        return new ApiResponse(depotList.size(), depotList);
    }

    @GetMapping("/getPaginatedDepots/{offset}/{pageSize}")
    public ApiResponse<Page<Depot>> getPaginatedDepots(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Depot> paginatedDepots = depotService.findDepotByPagination(offset, pageSize);
        return new ApiResponse(paginatedDepots.getSize(), paginatedDepots);
    }

    @GetMapping("/getSortedPaginatedDepots/{offset}/{pageSize}/{field}")
    public ApiResponse<Page<Depot>> getSortedPaginatedDepots(
            @PathVariable int offset,
            @PathVariable int pageSize,
            @PathVariable String field) {
        Page<Depot> paginatedSortedDepots = depotService.findSortedDepotByPagination(offset, pageSize, field);
        return new ApiResponse(paginatedSortedDepots.getSize(), paginatedSortedDepots);
    }

    @GetMapping("/search/depot/by/name/{name}")
    public List<Depot> findUserByName(@PathVariable String name) {
        List<Depot> allDepots = depotService.findUserByName(name);
        return allDepots;
    }

}
