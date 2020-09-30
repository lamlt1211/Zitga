package com.bkap.services.impl;

import com.bkap.dto.CategoryDTO;
import com.bkap.entity.Category;
import com.bkap.exceptions.NotFoundException;
import com.bkap.repositories.CategoryRepository;
import com.bkap.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:57
 * @created_by Tung lam
 * @since 22/07/2020
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

    @Override
    public List<CategoryDTO> getAllCategoryStatusActive() {
        List<Category> categoryList = categoryRepository.getAllCategoryStatusActive();
        if (categoryList.isEmpty()) {
            throw new NotFoundException("Empty.category");
        }
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

    @Override
    public List<CategoryDTO> getAllCategoryStatusUnActive() {
        List<Category> categoryList = categoryRepository.getAllCategoryStatusUnActive();
        if (categoryList.isEmpty()) {
            throw new NotFoundException("Empty.category");
        }
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

    @Override
    public CategoryDTO getCateById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            CategoryDTO categoryDTO = modelMapper.map(categoryOptional.get(), CategoryDTO.class);
            return categoryDTO;
        }
        throw new NotFoundException("NotFound.id");
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category check = categoryRepository.findByName(categoryDTO.getName());
        if (check == null) {
            Category category = modelMapper.map(categoryDTO, Category.class);
            category.setStatus(1);
            return modelMapper.map(categoryRepository.save(category), CategoryDTO.class);
        }
        return null;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = modelMapper.map(categoryDTO, Category.class);
            category.setId(id);
            return modelMapper.map(categoryRepository.save(category), CategoryDTO.class);
        }
        throw new NotFoundException("NotFound.id");
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.delete(categoryOptional.get());
        }
        throw new NotFoundException("NotFound.id");
    }


    public Long countCategory() {
        return categoryRepository.count();
    }
}
