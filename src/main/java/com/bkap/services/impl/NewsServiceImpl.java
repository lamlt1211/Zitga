package com.bkap.services.impl;

import com.bkap.dto.NewsDTO;
import com.bkap.entity.Category;
import com.bkap.entity.News;
import com.bkap.entity.Status;
import com.bkap.exceptions.NotFoundException;
import com.bkap.repositories.CategoryRepository;
import com.bkap.repositories.NewsRepository;
import com.bkap.services.NewsService;
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
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<NewsDTO> getAllNews() {
        List<News> newsList = newsRepository.findAll();
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (News news : newsList) {
            NewsDTO newsDTO = modelMapper.map(news, NewsDTO.class);
            newsDTOList.add(newsDTO);
        }
        return newsDTOList;
    }

    @Override
    public List<NewsDTO> getAllProductByStatus() {
        List<News> newsList = newsRepository.findAllProductByStatus();
        if (newsList.isEmpty()) {
            throw new NotFoundException("Empty.category");
        }
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (News news : newsList) {
            NewsDTO newsDTO = modelMapper.map(news, NewsDTO.class);
            newsDTOList.add(newsDTO);
        }
        return newsDTOList;
    }

    @Override
    public NewsDTO getNewsById(Long id) {
        Optional<News> newsOptional = newsRepository.findById(id);
        if (newsOptional.isPresent()) {
            NewsDTO newsDTO = modelMapper.map(newsOptional.get(), NewsDTO.class);
            newsDTO.setCategory_id(newsOptional.get().getCategory().getId());
            return newsDTO;
        }
        throw new NotFoundException("NotFound.id");
    }

    @Override
    public NewsDTO createNews(NewsDTO newsDTO) {
        News check = newsRepository.findByName(newsDTO.getName());
        if (check != null) {
            return null;
        }
        Category category = categoryRepository.findById(newsDTO.getCategory_id()).get();
        News news = modelMapper.map(newsDTO, News.class);
        news.setCategory(category);
        news.setStatus(Status.ACTIVE.getValue());
        return modelMapper.map(newsRepository.save(news), NewsDTO.class);
    }

    @Override
    public NewsDTO updateProduct(NewsDTO newsDTO) {
        Optional<News> productOptional = newsRepository.findById(newsDTO.getId());
        //List<Long> listId = Arrays.stream(newsDTO.getCategoryIds()).collect(Collectors.toList());
        //List<Category> categoryDTOS = categoryRepository.findAllById(listId);
        if (productOptional.isPresent()) {
            News news = modelMapper.map(newsDTO, News.class);
            //news.setCategories(categoryDTOS);
            news.setId(newsDTO.getId());
            return modelMapper.map(newsRepository.save(news), NewsDTO.class);
        }
        throw new NotFoundException("NotFound.id");
    }

    @Override
    public boolean deleteProductById(Long id) {
        newsRepository.deleteById(id);
        return true;
    }


    @Override
    public List<NewsDTO> getProductByCategoryId(Long id) {
        List<NewsDTO> listNewsDTO = new ArrayList<>();
        return listNewsDTO;
    }

}
