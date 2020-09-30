package com.bkap.repositories;

import com.bkap.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:50
 * @created_by Tung lam
 * @since 22/07/2020
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // lay ra category co stt  = 1
    @Query("from Category c where c.status =1")
    List<Category> getAllCategoryStatusActive();

    // lay ra category co stt  = 0
    @Query("from Category c where c.status =0")
    List<Category> getAllCategoryStatusUnActive();

    @Query("SELECT c FROM Category c"
            + " WHERE (c.name LIKE %:searchValue% OR c.description LIKE %:searchValue%)")
    Page<Category> findBySearchValue(@Param("searchValue") String searchValue, Pageable pageable);

    Category findByName(String name);
}
