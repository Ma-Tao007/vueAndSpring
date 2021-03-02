package com.codingfuture.coding_cloud_course.web.controller;

import com.codingfuture.coding_cloud_course.entity.Article;
import com.codingfuture.coding_cloud_course.service.ArticleService;
import com.codingfuture.coding_cloud_course.vo.ArticleCondition;
import com.codingfuture.coding_cloud_course.vo.PageData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    //分页
    @GetMapping("/article")
    @ResponseBody
    public PageData findByPage(@RequestParam("page") int page,
                               @RequestParam("limit") int limit,
                               ArticleCondition articleCondition) {
        Page<Object> list = PageHelper.startPage(page, limit);
        articleService.findByCondition(articleCondition);
        long count = list.getTotal();
        PageData pageData = new PageData();
        pageData.setRows(list.getResult());
        pageData.setTotal(count);
        return pageData;
    }

    //通过文章分类分页获取数据
        @GetMapping("/article/categoryid")
    @ResponseBody
    public Map<String,Object> findByPageAndCate(@RequestParam("page") int page,
                                                 @RequestParam("limit") int limit, @RequestParam("categoryid") int categoryid){

        return articleService.findByPageAndCate(page,limit,categoryid);
    }

    @GetMapping("/article/id")
    @ResponseBody
    public Map<String,Object> findById(@RequestParam("id") int id){
        return articleService.findById(id);
    }


}
