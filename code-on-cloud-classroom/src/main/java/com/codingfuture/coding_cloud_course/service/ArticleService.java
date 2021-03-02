package com.codingfuture.coding_cloud_course.service;

import com.codingfuture.coding_cloud_course.entity.Article;
import com.codingfuture.coding_cloud_course.vo.ArticleCondition;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    List<Article> findByCondition(ArticleCondition articleCondition);

    Map<String, Object> findByPageAndCate(int page, int limit, int categoryid);

    Map<String, Object> findById(int id);
}
