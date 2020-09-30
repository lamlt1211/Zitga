package com.bkap.services;

import com.bkap.dto.NewsDTO;

import java.util.List;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:59
 * @created_by Tung lam
 * @since 22/07/2020
 */
public interface NewsService {
    List<NewsDTO> getAllNews();

    List<NewsDTO> getAllProductByStatus();

    NewsDTO getNewsById(Long id);

    NewsDTO createNews(NewsDTO newsDTO);

    NewsDTO updateProduct(NewsDTO newsDTO);

    boolean deleteProductById(Long id);

    List<NewsDTO> getProductByCategoryId(Long id);
}
