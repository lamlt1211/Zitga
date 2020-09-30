package com.bkap.api;

import com.bkap.dto.APIResponse;
import com.bkap.dto.CategoryDTO;
import com.bkap.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:23
 * @created_by Tung lam
 * @since 22/07/2020
 */
@RestController
@RequestMapping("api/categories")
public class CategoryApi {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<APIResponse<CategoryDTO>> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO categoryDTO1 = categoryService.createCategory(categoryDTO);
        APIResponse<CategoryDTO> response = new APIResponse<>();
        response.setData(categoryDTO1);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Message.statusAPI.ok");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }
}
