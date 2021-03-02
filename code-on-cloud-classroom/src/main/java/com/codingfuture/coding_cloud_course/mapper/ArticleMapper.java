package com.codingfuture.coding_cloud_course.mapper;

import com.codingfuture.coding_cloud_course.entity.Article;
import com.codingfuture.coding_cloud_course.vo.ArticleCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {

    List<Article> findByCondition(ArticleCondition articleCondition);


    List<Map<String, Object>> findByPageAndCate(@Param("start") int start, @Param("end") int end, @Param("categoryid") int categoryid);

    int getCountByPageAndCate(int categoryid);

    Map<String, Object> findById(int id);
}
