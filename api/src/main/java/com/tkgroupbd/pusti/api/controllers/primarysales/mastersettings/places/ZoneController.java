package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Zone;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.ZoneRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.places.ZoneServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Zone")
@RestController
@RequestMapping("/zone")
public class ZoneController {
    @Autowired
    ZoneServiceImpl service;

    @GetMapping("/getAllZones")
    public ResponseEntity<List<Zone>> getZones() {
        List<Zone> zone = service.getAllZone();
        return new ResponseEntity<>(zone, HttpStatus.OK);
    }

    @PostMapping("/addNewZone")
    public ResponseEntity<MessageResponse> addZones(@RequestBody @Valid ZoneRequest zoneRequest) {
        MessageResponse newZones = service.createZone(zoneRequest);
        return new ResponseEntity<>(newZones, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteZoneById/{id}")
    public ResponseEntity<?> deleteZones(@PathVariable("id") Integer id) {
        service.deleteZone(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getZoneById/{id}")
    public ResponseEntity<Zone> getZoneById(@PathVariable("id") Integer id) {
        Zone zone = service.getZoneById(id);
        return new ResponseEntity<>(zone, HttpStatus.OK);
    }

    @PutMapping("/updateZone/{id}")
    public ResponseEntity<Optional<Zone>> updateZone(@PathVariable Integer id, @RequestBody ZoneRequest zoneRequest) {
        Optional<Zone> zone = service.updateZone(id, zoneRequest);
        return new ResponseEntity<Optional<Zone>>(zone, HttpStatus.OK);
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<Optional<Zone>> updateZoneStatus(@PathVariable Integer id,
            @RequestBody ZoneRequest zoneRequest) {
        Optional<Zone> updateZone = service.zoneStatusChange(id, zoneRequest);
        return new ResponseEntity<Optional<Zone>>(updateZone, HttpStatus.OK);
    }

    @GetMapping("/search/Zone/by/name/{name}")
    private List<Zone> findZoneByNameByKey(@PathVariable String name) {
        List<Zone> allZones = service.findByZoneName(name);
        return allZones;
    }
}
