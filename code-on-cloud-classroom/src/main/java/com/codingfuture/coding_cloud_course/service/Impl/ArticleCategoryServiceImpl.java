package com.codingfuture.coding_cloud_course.service.Impl;

import com.codingfuture.coding_cloud_course.mapper.ArticleCategoryMapper;
import com.codingfuture.coding_cloud_course.service.ArticleCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Resource
    private ArticleCategoryMapper articleCategoryMapper;


    @Override
    public List<Map<String, Object>> getAllCategory() {
        return articleCategoryMapper.getAllCategory();
    }
}
