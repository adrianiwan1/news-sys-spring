package com.example.newssysspring.controllers;

import com.example.newssysspring.entities.Artykuly;
import com.example.newssysspring.services.ArticleDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class NewsController {

    @Autowired
    private ArticleDisplayService articleDisplayService;

    @GetMapping("/")
    public String getAllArticles(Model model,Optional<Integer> page, Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Artykuly> articlePage = articleDisplayService.findPaginated(PageRequest.of(currentPage - 1,pageSize));

        model.addAttribute("articles",articlePage);

        int totalPages = articlePage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        return "index";
    }



}