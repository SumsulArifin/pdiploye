package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.PurchaseOrders;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.PurchaseOrdersRequest;
import com.tkgroupbd.pusti.api.services.mastersettings.places.PurchaseOrdersService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Purchase Orders")
@RestController
@RequestMapping("/purchaseOrders")
public class PurchaseOrdersController {
    @Autowired
    PurchaseOrdersService purchaseOrdersService;

    @GetMapping("/getAllPurchaseOrders")
    public ResponseEntity<List<PurchaseOrders>> getAllOrder() {
        List<PurchaseOrders> orders = purchaseOrdersService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/getPurchaseOrderById/{orderId}")
    public ResponseEntity<PurchaseOrders> getOrdersById(@PathVariable("orderId") Integer orderId) {
        PurchaseOrders orders = purchaseOrdersService.findOrdersById(orderId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/addNewPurchaseOrder")
    public ResponseEntity<PurchaseOrders> addOrders(
            @RequestBody PurchaseOrdersRequest orderRequest) {
        PurchaseOrders newOrders = purchaseOrdersService.saveOrder(orderRequest);
        return new ResponseEntity<>(newOrders, HttpStatus.CREATED);
    }

    @PutMapping("/updatePurchaseOrder/{orderId}")
    public ResponseEntity<Optional<PurchaseOrders>> updateOrderById(@PathVariable Integer orderId,
            @RequestBody PurchaseOrdersRequest orderRequest) {
        Optional<PurchaseOrders> orders = purchaseOrdersService.updateOrders(orderId, orderRequest);
        return new ResponseEntity<Optional<PurchaseOrders>>(orders, HttpStatus.OK);
    }

    @PutMapping("/updateStatus/{orderId}")
    public ResponseEntity<Optional<PurchaseOrders>> updateSalesOrganizationStatus(@PathVariable Integer orderId,
            @RequestBody PurchaseOrdersRequest orderRequest) {
        Optional<PurchaseOrders> orders = purchaseOrdersService.updateOrdersStatus(orderId, orderRequest);
        return new ResponseEntity<Optional<PurchaseOrders>>(orders, HttpStatus.OK);
    }
}
