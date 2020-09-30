package com.bkap.api;

import com.bkap.dto.APIResponse;
import com.bkap.dto.NewsDTO;
import com.bkap.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:24
 * @created_by Tung lam
 * @since 22/07/2020
 */
@RestController
@RequestMapping("/api/news")
public class NewsApi {
    @Autowired
    private NewsService newsService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public ResponseEntity<APIResponse<List<NewsDTO>>> getAllNews(Locale locale) {
        List<NewsDTO> newsDTOList = newsService.getAllNews();
        APIResponse<List<NewsDTO>> response = new APIResponse<>();
        response.setMessage(messageSource.getMessage("Message.statusAPI.ok", null, locale));
        response.setStatus(HttpStatus.OK.value());
        response.setData(newsDTOList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/create")
    public ResponseEntity<APIResponse<NewsDTO>> cresteNews(@RequestBody NewsDTO newsDTO) {
        NewsDTO newsDTO1 = newsService.createNews(newsDTO);
        APIResponse<NewsDTO> response = new APIResponse<>();
        response.setData(newsDTO1);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Message.statusAPI.ok");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Boolean>> deleteProductById(@PathVariable("id") Long id) {
        newsService.deleteProductById(id);
        APIResponse<Boolean> response = new APIResponse<>();
        response.setData(true);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Message.statusAPI.ok");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
