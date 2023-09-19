package com.tkgroupbd.pusti.api.controllers.headManagement;
import com.tkgroupbd.pusti.api.data.models.entity.headManagement.DivisionalHead;
import com.tkgroupbd.pusti.api.data.payloads.requests.headManagement.DivisionalHeadRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.headManagement.DivisionalHeadServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "DivisionalHead")
@RestController
@RequestMapping("/divisionalHead")
public class DivisionalHeadController {
    @Autowired
    DivisionalHeadServiceImpl divisionalHeadService;

    @PostMapping("/addNewDivisionHead")
    public ResponseEntity<MessageResponse> divisionHeadSave(@RequestBody @Valid DivisionalHeadRequest divisionalHeadRequest) {
        MessageResponse newDivisionHead = divisionalHeadService.addDivisionalHead(divisionalHeadRequest);
        return new ResponseEntity<>(newDivisionHead, HttpStatus.CREATED);
    }

    @GetMapping("/getAllDivisionalHead")
    @ResponseBody
    public ResponseEntity<List<DivisionalHead>> getAllDivisionalHead() {
        List<DivisionalHead> divisionalHeads = divisionalHeadService.getAllDivisionalHead();
        return new ResponseEntity<>(divisionalHeads, HttpStatus.OK);
    }

    @PutMapping("/updateDivisionHead/{divisionHeadId}")
    public ResponseEntity<Optional<DivisionalHead>> updateDivisionalHead(@PathVariable Integer divisionHeadId, @RequestBody DivisionalHeadRequest divisionalHeadRequest) {
        Optional<DivisionalHead> divisionalHead = divisionalHeadService.updateDivisionalHead(divisionHeadId, divisionalHeadRequest);
        return new ResponseEntity<Optional<DivisionalHead>>(divisionalHead, HttpStatus.OK);
    }

    @PutMapping("/statusChange/{divisionHeadId}")
    public ResponseEntity<Optional<DivisionalHead>> changeDivisionalHeadStatus(@PathVariable int divisionHeadId, @RequestBody DivisionalHeadRequest divisionalHeadRequest) {
        Optional<DivisionalHead> divisionalHead = divisionalHeadService.updateDivisionalHeadStatus(divisionHeadId, divisionalHeadRequest);
        return new ResponseEntity<Optional<DivisionalHead>>(divisionalHead, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDivisionalHead/{divisionHeadId}")
    public ResponseEntity<?> deleteDivisionHeadById(@PathVariable("divisionHeadId") int divisionHeadId) {
        divisionalHeadService.deleteDivisionalHeadById(divisionHeadId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // API to retrieve Division by id
    @GetMapping("/getDivisionHeadById/{divisionHeadId}")
    public ResponseEntity<DivisionalHead> getDivisionHeadById(@PathVariable("divisionHeadId") int divisionHeadId) {
        DivisionalHead divisionalHead = divisionalHeadService.findById(divisionHeadId);
        return new ResponseEntity<>(divisionalHead, HttpStatus.OK);
    }

}
