package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.National;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.NationalRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.places.NationalServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "National")
@RestController

@RequestMapping("/national")
public class NationalController {
    @Autowired
    NationalServiceImpl nationalService;

    @PostMapping("/addNewNational")
    public ResponseEntity<MessageResponse> saveNational(@RequestBody NationalRequest nationalRequest) {
        MessageResponse response = nationalService.saveNational(nationalRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/updateNational/{nationalId}")
    public ResponseEntity<Optional<National>> updateNational(@PathVariable int nationalId,
            @RequestBody NationalRequest nationalRequest) {
        Optional<National> national = nationalService.updateNational(nationalId, nationalRequest);
        return new ResponseEntity<Optional<National>>(national, HttpStatus.OK);

    }

    @DeleteMapping("/deleteNational/{nationalId}")
    public ResponseEntity<?> deleteNationalId(@PathVariable("nationalId") Integer nationalId) {
        nationalService.deleteNationalId(nationalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllNationals")
    @ResponseBody
    public ResponseEntity<List<National>> getAllNational() {
        List<National> nationalList = nationalService.getAllNational();
        return new ResponseEntity<>(nationalList, HttpStatus.OK);
    }

    @GetMapping("/getNationalById/{nationalId}")
    public ResponseEntity<National> getNationalById(@PathVariable("nationalId") Integer nationalId) {
        National national = nationalService.findNationalById(nationalId);
        return new ResponseEntity<>(national, HttpStatus.OK);
    }
}
