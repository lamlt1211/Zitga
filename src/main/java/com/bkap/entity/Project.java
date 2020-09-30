package com.bkap.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 06/08/2020 - 11:02
 * @created_by Tung lam
 * @since 06/08/2020
 */
@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "description")
    private String description;
    @Column
    private Date publish;
    @CreationTimestamp
    @Column(name = "createdat", updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updatedat")
    private Date updatedAt;
    @Column(name = "status")
    private int status;
}
