package com.bkap.controller;

import com.bkap.dto.CategoryDTO;
import com.bkap.dto.NewsDTO;
import com.bkap.dto.ProjectDTO;
import com.bkap.dto.UserDTO;
import com.bkap.securities.WebUtils;
import com.bkap.services.CategoryService;
import com.bkap.services.NewsService;
import com.bkap.services.ProjectService;
import com.bkap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * service
 *
 * @author Tung lam
 * @created_at 24/09/2020 - 15:25
 * @created_by Tung lam
 * @since 24/09/2020
 */
@Controller
@RequestMapping("/zitga")
public class AdminController {
    private CategoryService categoryService;
    private ProjectService projectService;
    private NewsService newsService;
    private UserService userService;

    @Autowired
    public AdminController(UserService userService, CategoryService categoryService, ProjectService projectService, NewsService newsService) {
        this.categoryService = categoryService;
        this.projectService = projectService;
        this.newsService = newsService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("news", newsService.getAllNews());
        model.addAttribute("projects", projectService.findAllProject());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin";
    }

    @GetMapping("/news")
    public String news(Model model, @RequestParam(value = "id", required = false) Long id){
        List<CategoryDTO> categories  = categoryService.getAllCategories();
        if(id!=null){
            model.addAttribute("news",newsService.getNewsById(id));
        }else{
            model.addAttribute("news",new NewsDTO());
        }

        model.addAttribute("categories",categories);
        return "news_add";
    }

    @GetMapping("/project")
    public String project( @RequestParam(value = "id", required = false) Long id, Model model){
        if(id!=null){
            model.addAttribute("project",projectService.findById(id));
        }else {
            model.addAttribute("project",new ProjectDTO());
        }
        return "project_add";
    }

    @GetMapping("/category")
    public String category(Model model, @RequestParam(value = "id", required = false) Long id){
        if(id!=null){
            model.addAttribute("category",categoryService.getCateById(id));
        }else {
            model.addAttribute("category",new CategoryDTO());
        }
        return "category_add";
    }

    @GetMapping("/account")
    public String account(Model model){
        String username = WebUtils.getUserDetail().getUsername();
        model.addAttribute("username",username);
        return "account";
    }
}
