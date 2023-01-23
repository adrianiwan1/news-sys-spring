package com.example.newssysspring.services;

import com.example.newssysspring.dao.ArtykulyDAO;
import com.example.newssysspring.entities.Artykuly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ArticleDisplayService {

    @Autowired
    ArtykulyDAO dao;

    public Page<Artykuly> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Artykuly> list;
        List<Artykuly> allArticles = dao.getNewestArticles();
        if (allArticles.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, allArticles.size());
            list = allArticles.subList(startItem, toIndex);
        }
        return new PageImpl<Artykuly>(list, PageRequest.of(currentPage, pageSize), allArticles.size());
    }

    public Artykuly getArticleById(Integer id) {
        return dao.getOneArcitleById(id);
    }
}
