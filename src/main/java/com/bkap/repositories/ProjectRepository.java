package com.bkap.repositories;

import com.bkap.entity.Category;
import com.bkap.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:50
 * @created_by Tung lam
 * @since 22/07/2020
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Category findByName(String name);
}
