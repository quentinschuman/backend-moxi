package com.example.backendmoxi.controller;

import com.example.backendmoxi.model.News;
import com.example.backendmoxi.model.NewsCategory;
import com.example.backendmoxi.service.NewsCategoryService;
import com.example.backendmoxi.service.NewsService;
import com.example.backendmoxi.util.Constant;
import com.example.backendmoxi.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend-moxi
 * User: quent
 * Date: 2018/6/24
 * Time: 10:20
 */
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsCategoryService newsCategoryService;

    @RequestMapping("/admin/newsManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String newsManage(News news, @PathVariable Integer pageCurrent, @PathVariable Integer pageSize, @PathVariable Integer pageCount, Model model){
        if (pageSize == 0)
            pageSize = 10;
        if (pageCurrent == 0)
            pageCurrent = 1;
        int rows = newsService.count(news);
        if (pageCount == 0)
            pageCount = rows % pageSize == 0 ? (rows/pageSize) : (rows/pageSize+1);

        news.setStart((pageCurrent - 1)*pageSize);
        news.setEnd(pageSize);
        if (news.getOrderBy() == null){
            news.setOrderBy(Constant.OrderByAddDateDesc);
        }
        List<News> newsList = newsService.list(news);

        NewsCategory newsCategory = new NewsCategory();
        newsCategory.setStart(0);
        newsCategory.setEnd(Integer.MAX_VALUE);
        List<NewsCategory> newsCategoryList = newsCategoryService.list(newsCategory);

        model.addAttribute("newsCategoryList",newsCategoryList);
        model.addAttribute("newsList",newsList);
        String pageHTML = PageUtil.getPageContent("newsManage_{pageCurrent}_{pageSize}_{pageCount}?title=" + news.getTitle() + "&category=" + news.getCategory() + "&commendState=" + news.getCommendState() + "&orderBy=" + news.getOrderBy(),pageCurrent,pageSize,pageCount);
        model.addAttribute("pageHTML",pageHTML);
        model.addAttribute("news",news);

        return "news/newsManage";
    }

    @GetMapping("/admin/newsEdit")
    public String newsEditGet(Model model,News news){
        NewsCategory newsCategory = new NewsCategory();
        newsCategory.setStart(0);
        newsCategory.setEnd(Integer.MAX_VALUE);
        List<NewsCategory> newsCategoryList = newsCategoryService.list(newsCategory);
        model.addAttribute("newsCategoryList",newsCategoryList);
        if (news.getId() != 0){
            News newT = newsService.findById(news);
            model.addAttribute("newT",newT);
        }
        return "news/newsEdit";
    }
}

