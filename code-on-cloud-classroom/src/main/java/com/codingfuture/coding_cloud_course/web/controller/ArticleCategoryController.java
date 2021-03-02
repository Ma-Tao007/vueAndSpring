package com.codingfuture.coding_cloud_course.web.controller;

import com.codingfuture.coding_cloud_course.service.ArticleCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("getAllCategory")
public class ArticleCategoryController {

    @Resource
    private ArticleCategoryService articleCategoryService;

    //获取所有文章分类
    @GetMapping("getAllCategory")
    public List<Map<String,Object>> getAllCategory(){
        return articleCategoryService.getAllCategory();
    }
}
