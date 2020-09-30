package com.bkap.services;

import com.bkap.dto.CategoryDTO;

import java.util.List;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:59
 * @created_by Tung lam
 * @since 22/07/2020
 */
public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    List<CategoryDTO> getAllCategoryStatusActive();

    List<CategoryDTO> getAllCategoryStatusUnActive();

    CategoryDTO getCateById(Long id);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long id);

    void deleteCategory(Long id);


    Long countCategory();

}
