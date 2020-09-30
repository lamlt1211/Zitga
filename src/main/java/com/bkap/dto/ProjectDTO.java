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
 * @created_at 06/08/2020 - 11:02
 * @created_by Tung lam
 * @since 06/08/2020
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectDTO {
    private Long id;
    private String name;
    private String url;
    private String description;
    private Date publish;
    private Date createdAt;
    private Date updatedAt;
    private int status;
}
