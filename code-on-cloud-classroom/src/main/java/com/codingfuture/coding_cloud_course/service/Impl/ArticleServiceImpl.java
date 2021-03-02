package com.codingfuture.coding_cloud_course.service.Impl;

import com.codingfuture.coding_cloud_course.entity.Article;
import com.codingfuture.coding_cloud_course.mapper.ArticleMapper;
import com.codingfuture.coding_cloud_course.service.ArticleService;
import com.codingfuture.coding_cloud_course.vo.ArticleCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired(required = false)
    private ArticleMapper articleMapper;

    @Override
    public List<Article> findByCondition(ArticleCondition articleCondition) {
        return articleMapper.findByCondition(articleCondition);
    }

    @Override
    public Map<String, Object> findByPageAndCate(int page, int limit, int categoryid) {

        List<Map<String,Object>> resultMap = articleMapper.findByPageAndCate((page-1)*limit,limit,categoryid);
        int count = articleMapper.getCountByPageAndCate(categoryid);
        Map<String,Object> result = new HashMap<>();
        result.put("list",resultMap);
        result.put("count",count);
        return result;
    }

    @Override
    public Map<String, Object> findById(int id) {
        return articleMapper.findById(id);
    }
}
