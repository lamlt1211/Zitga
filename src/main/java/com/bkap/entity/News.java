package com.bkap.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 15:01
 * @created_by Tung lam
 * @since 22/07/2020
 */
@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    @Column(name = "shortDescription")
    private String shortDescription;
    @CreationTimestamp
    @Column(name = "createdat", updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updatedat")
    private Date updatedAt;
    @Column(name = "status")
    private int status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
