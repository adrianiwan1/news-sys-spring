package com.example.newssysspring.controllers;

import com.example.newssysspring.dto.ArtykulyDTO;
import com.example.newssysspring.dto.KomentarzeDTO;
import com.example.newssysspring.dto.UserRegistrationDTO;
import com.example.newssysspring.entities.Artykuly;
import com.example.newssysspring.entities.Komentarze;
import com.example.newssysspring.exceptions.UserExistsException;
import com.example.newssysspring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class NewsController {

    @Autowired
    private ArticleDisplayService articleDisplayService;
    @Autowired
    private CommentDisplayService komentarzeDisplayService;
    @Autowired
    private UserRegistrationService userRegistrationService;
    @Autowired
    private ArticleSaveService articleSaveService;
    @Autowired
    private ArticleDeleteService articleDeleteService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String getAllArticles(Model model, Optional<Integer> page, Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Artykuly> articlePage = articleDisplayService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("articles", articlePage);

        int totalPages = articlePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "index";
    }

    @GetMapping("/article/")
    public String getFullArticle(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        Integer articleId = Integer.parseInt(id);
        Artykuly artykul = articleDisplayService.getArticleById(articleId);
        List<Komentarze> comments = komentarzeDisplayService.getCommentsForArticle(articleId);
        KomentarzeDTO commentDto = new KomentarzeDTO();
        model.addAttribute("article", artykul);
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", commentDto);

        return "fullarticle";
    }

    @GetMapping("register")
    public String registerUser(Model model) {
        model.addAttribute("form", new UserRegistrationDTO());
        return "register";
    }

    @PostMapping("register")
    public String registerEffect(Model model, UserRegistrationDTO dto) {
        model.addAttribute("form", dto);

        try {
            userRegistrationService.registerUser(dto);
        } catch (UserExistsException ex) {
            model.addAttribute("userExistsException", "User with this username exists!");
            return "register";
        }
        return getAllArticles(model, Optional.of(1), Optional.of(5));
    }

    @GetMapping("addArticle")
    public String addArticle(Model model) {
        model.addAttribute("form", new ArtykulyDTO());
        return "writeArticle";
    }

    @PostMapping("addArticle")
    public String addArticleEffect(Model model, ArtykulyDTO dto) {
        articleSaveService.saveArticle(dto);
        return getAllArticles(model, Optional.of(1), Optional.of(5));
    }

    @PostMapping("article/deleteArticle")
    public String deleteArticle(Model model, HttpServletRequest request) {
        Integer articleId = Integer.valueOf(request.getParameter("id"));
        Artykuly article = articleDisplayService.getArticleById(articleId);
        articleDeleteService.deleteArticle(article);
        return "redirect:/";
    }

    @PostMapping("article/addComment")
    public String addComment(Model model, HttpServletRequest request, KomentarzeDTO dto) {
        commentService.addCommentToArticle(dto);

        return "redirect:/article/?id=" + dto.getArticleId();
    }

    @PostMapping("article/deleteComment")
    public String deleteComment(Model model, HttpServletRequest request){
        Integer commentId = Integer.valueOf(request.getParameter("id"));
        Komentarze comment = komentarzeDisplayService.getCommentById(commentId);
        commentService.deleteComment(comment);
        return "redirect:/article/?id=" + comment.getArtykul().getId();
    }


}