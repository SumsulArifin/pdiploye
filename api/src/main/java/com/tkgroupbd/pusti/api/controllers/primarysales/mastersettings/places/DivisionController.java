package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Division;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.DivisionRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.places.DivisionServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Division")
@RestController
@RequestMapping("/divisionHead")
public class DivisionController {
    @Autowired
    DivisionServiceImpl divisionService;

    // Create a new Division

    @PostMapping("/addNewDivision")
    public ResponseEntity<MessageResponse> divisionSave(@RequestBody @Valid DivisionRequest divisionRequest) {
        MessageResponse newDivision = divisionService.saveDivision(divisionRequest);
        return new ResponseEntity<>(newDivision, HttpStatus.CREATED);
    }

    // retrieve all Division
    @GetMapping("/getAllDivisions")
    @ResponseBody
    public ResponseEntity<List<Division>> getAllBrand() {
        List<Division> divisions = divisionService.getAllDivision();
        return new ResponseEntity<>(divisions, HttpStatus.OK);
    }

    // Update a Division information
    @PutMapping("/updateDivision/{divisionId}")
    public ResponseEntity<Optional<Division>> updateDivision(@PathVariable Integer divisionId,
            @RequestBody DivisionRequest divisionRequest) {
        Optional<Division> updateDivision = divisionService.updateDivision(divisionId, divisionRequest);
        return new ResponseEntity<Optional<Division>>(updateDivision, HttpStatus.OK);
    }

    // Division Status Change API
    @PutMapping("/statusChange/{divisionId}")
    public ResponseEntity<Optional<Division>> changeDivisionStatus(@PathVariable int divisionId,
            @RequestBody DivisionRequest divisionRequest) {
        Optional<Division> updateDivision = divisionService.updateDivisionStatus(divisionId, divisionRequest);
        return new ResponseEntity<Optional<Division>>(updateDivision, HttpStatus.OK);
    }

    // Delete Division by id
    @DeleteMapping("/deleteDivision/{division_id}")
    public ResponseEntity<?> deleteDivisionById(@PathVariable("division_id") Integer division_id) {
        divisionService.deleteDivisionById(division_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // API to retrieve Division by id
    @GetMapping("/getDivisionById/{division_id}")
    public ResponseEntity<Division> getDivisionById(@PathVariable("division_id") Integer division_id) {
        Division division = divisionService.findDivisionById(division_id);
        return new ResponseEntity<>(division, HttpStatus.OK);
    }

    // API for search by keyword

    @GetMapping("/getSortedDivisionsByKey/{field}")
    private ApiResponse<List<Division>> getSortedDivisionByKey(@PathVariable String field) {
        List<Division> divisionList = divisionService.findSortedDivisionByKey(field);
        return new ApiResponse(divisionList.size(), divisionList);
    }

}
