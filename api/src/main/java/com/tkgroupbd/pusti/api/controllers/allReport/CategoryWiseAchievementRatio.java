package com.tkgroupbd.pusti.api.controllers.allReport;

import com.tkgroupbd.pusti.api.services.salesOrder.SalesOrderService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Category Wise Achievement")
@RequestMapping("/categoryWiseAchievementRatio")
public class CategoryWiseAchievementRatio {

    @Autowired
    SalesOrderService salesOrderService;

    @GetMapping("/categoryWiseSales")
    public Integer findCategoryWiseAchievementRatio() {
        return null;
    }
}
