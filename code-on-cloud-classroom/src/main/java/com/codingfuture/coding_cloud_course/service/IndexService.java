package com.codingfuture.coding_cloud_course.service;

import com.codingfuture.coding_cloud_course.entity.Banner;
import com.codingfuture.coding_cloud_course.entity.Course;
import com.codingfuture.coding_cloud_course.entity.Lecturer;

import java.util.List;

public interface IndexService {
    //查banner
    List<Banner> findAllBanner();
    //查热门课
    List<Course> findHotCourse();
    //查金牌讲师
    List<Lecturer> findTopLecturer();
    //根据courseId 查课程详情
    Course findByCourseId(Integer courseId);
    //全部课程
    List<Course> findAllCourses();
    //全部老师
    List<Lecturer> findAllLecturers();
}


