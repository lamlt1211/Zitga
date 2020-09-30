package com.bkap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 28/08/2020 - 10:42
 * @created_by Tung lam
 * @since 28/08/2020
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageMetaData {
    private int page;
    private int size;
    private int number;
    private int totalPages;
    private long totalElements;
    private boolean last;
    private boolean first;
}
