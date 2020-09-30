package com.bkap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 23/07/2020 - 11:36
 * @created_by Tung lam
 * @since 23/07/2020
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
    private Long id;
    private String name;
    private String image;
    private String content;
    private String shortDescription;
    private Date createdAt;
    private Date updatedAt;
    private int status;
    private Long category_id;
}
