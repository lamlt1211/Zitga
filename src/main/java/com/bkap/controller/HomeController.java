package com.bkap.controller;

import com.bkap.dto.CategoryDTO;
import com.bkap.dto.NewsDTO;
import com.bkap.services.CategoryService;
import com.bkap.services.NewsService;
import com.bkap.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 24/09/2020 - 14:35
 * @created_by Tung lam
 * @since 24/09/2020
 */
@Controller
public class HomeController {
    private CategoryService categoryService;
    private ProjectService projectService;
    private NewsService newsService;

    @Autowired
    public HomeController(CategoryService categoryService, ProjectService projectService, NewsService newsService) {
        this.categoryService = categoryService;
        this.projectService = projectService;
        this.newsService = newsService;
    }

    @GetMapping("/category")
    public String category(Model model) {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/news")
    public String news(Model model, @RequestParam(value = "id", required = false) Long id) {
        NewsDTO newsDTO = newsService.getNewsById(id);
        CategoryDTO categoryDTO = categoryService.getCateById(newsDTO.getCategory_id());
        model.addAttribute("news", newsDTO);
        model.addAttribute("category", categoryDTO);
        return "news";
    }


    @GetMapping(value = {"/project", "/"})
    public String project(Model model) {
        Map<Integer, List<Object>> map = projectService.getAllProject();
        model.addAttribute("projects", map);
        return "project";
    }

}
