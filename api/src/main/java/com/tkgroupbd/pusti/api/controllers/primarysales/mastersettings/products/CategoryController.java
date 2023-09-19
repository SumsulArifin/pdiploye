package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Category;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.CategoryRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.products.CategoryServiceImpl;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Category")
@RestController
@RequestMapping("/category")
@CacheConfig(cacheNames = "category")
public class CategoryController {
    @Autowired
    @SuppressWarnings(Message.AUTOWIRED_OK)
    CategoryServiceImpl categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = categoryService.getAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addCategory(@RequestBody CategoryRequest categoryRequest) {
        MessageResponse newCategory = categoryService.createCategory(categoryRequest);
        System.out.println("working category-----------");
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        System.out.println("working category-----------");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Optional<Category>> updateCategory(@PathVariable Integer id,
            @RequestBody CategoryRequest categoryRequest) {
        Optional<Category> updateCategory = categoryService.updateCategory(id, categoryRequest);
        System.out.println("working category-----------");
        return new ResponseEntity<Optional<Category>>(updateCategory, HttpStatus.OK);
    }

    @PutMapping("/updateCategoryStatus/{id}")
    public ResponseEntity<Optional<Category>> updateCategoryStatus(@PathVariable Integer id,
            @RequestBody CategoryRequest categoryRequest) {
        Optional<Category> updateCategory = categoryService.categoryStatusChange(id, categoryRequest);
        System.out.println("working category-----------");
        return new ResponseEntity<Optional<Category>>(updateCategory, HttpStatus.OK);
    }

}
