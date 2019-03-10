package com.example.backendmoxi.controller;

import com.example.backendmoxi.model.Ads;
import com.example.backendmoxi.model.AdsCategory;
import com.example.backendmoxi.service.AdsCategoryService;
import com.example.backendmoxi.service.AdsService;
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
public class AdsController {

    @Autowired
    private AdsService adsService;

    @Autowired
    private AdsCategoryService adsCategoryService;

    @RequestMapping("/admin/adsManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String adsManage(Ads ads, @PathVariable Integer pageCurrent, @PathVariable Integer pageSize, @PathVariable Integer pageCount, Model model) {
        if (pageSize == 0)
            pageSize = 10;
        if (pageCurrent == 0)
            pageCurrent = 1;
        int rows = adsService.count(ads);
        if (pageCount == 0)
            pageCount = rows % pageSize == 0 ? (rows / pageSize) : (rows / pageSize + 1);

        ads.setStart((pageCurrent - 1) * pageSize);
        ads.setEnd(pageSize);
        if (ads.getOrderBy() == null) {
            ads.setOrderBy(Constant.OrderByAddDateDesc);
        }
        List<Ads> adsList = adsService.list(ads);

        AdsCategory adsCategory = new AdsCategory();
        adsCategory.setStart(0);
        adsCategory.setEnd(Integer.MAX_VALUE);
        List<AdsCategory> adsCategoryList = adsCategoryService.list(adsCategory);

        model.addAttribute("adsCategoryList", adsCategoryList);
        model.addAttribute("adsList", adsList);
        String pageHTML = PageUtil.getPageContent("adsManage_{pageCurrent}_{pageSize}_{pageCount}?title=" + ads.getTitle() + "&category=" + ads.getCategory() + "&commendState=" + ads.getCommendState() + "&orderBy=" + ads.getOrderBy(), pageCurrent, pageSize, pageCount);
        model.addAttribute("pageHTML", pageHTML);
        model.addAttribute("ads", ads);

        return "ads/adsManage";
    }

    @GetMapping("/admin/adsEdit")
    public String adsEditGet(Model model, Ads ads) {
        AdsCategory adsCategory = new AdsCategory();
        adsCategory.setStart(0);
        adsCategory.setEnd(Integer.MAX_VALUE);
        List<AdsCategory> adsCategoryList = adsCategoryService.list(adsCategory);
        model.addAttribute("adsCategoryList", adsCategoryList);
        if (ads.getId() != 0) {
            Ads newT = adsService.findById(ads);
            model.addAttribute("newT", newT);
        }
        return "ads/adsEdit";
    }
}

