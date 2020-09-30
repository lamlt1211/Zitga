package com.bkap.repositories;

import com.bkap.entity.Users;
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
 * @created_at 22/07/2020 - 17:51
 * @created_by Tung lam
 * @since 22/07/2020
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    @Query("from Users  u where  u.status = 1")
    List<Users> findAllUserEnable();

    Users findByEmail(String email);

    // search theo userName , fullName , email
    @Query("SELECT e FROM Users e INNER JOIN e.roles r"
            + " WHERE (e.username LIKE %:searchValue% OR e.fullName LIKE %:searchValue% OR e.email LIKE %:searchValue%)"
            + " AND r.name LIKE :roleName")
    Page<Users> findBySearchValueAndRoles_Name(@Param("searchValue") String searchValue, @Param("roleName") String roleName, Pageable pageable);
}

