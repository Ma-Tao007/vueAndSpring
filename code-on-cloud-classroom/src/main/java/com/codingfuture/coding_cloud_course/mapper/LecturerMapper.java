package com.codingfuture.coding_cloud_course.mapper;

import com.codingfuture.coding_cloud_course.entity.Lecturer;
import com.codingfuture.coding_cloud_course.vo.LecturerCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LecturerMapper {
    List<Lecturer> findByCondition(LecturerCondition lecturerCondition);
}
