package com.codingfuture.coding_cloud_course.service;

import com.codingfuture.coding_cloud_course.entity.Lecturer;
import com.codingfuture.coding_cloud_course.vo.LecturerCondition;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LecturerService {
    List<Lecturer> findByCondition(LecturerCondition lecturerCondition);
}
