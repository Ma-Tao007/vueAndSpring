package com.codingfuture.coding_cloud_course.service.impl;


import com.codingfuture.coding_cloud_course.entity.Banner;
import com.codingfuture.coding_cloud_course.entity.Course;
import com.codingfuture.coding_cloud_course.entity.Lecturer;
import com.codingfuture.coding_cloud_course.mapper.IndexMapper;
import com.codingfuture.coding_cloud_course.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired(required = false)
    private IndexMapper indexMapper;

    @Override
    public List<Banner> findAllBanner() {
        List<Banner> allBanner = indexMapper.findAllBanner();
        return allBanner;
    }

    @Override
    public List<Course> findHotCourse() {
        List<Course> hotCourse = indexMapper.findHotCourse();
        return hotCourse;
    }

    @Override
    public List<Lecturer> findTopLecturer() {
        List<Lecturer> topLecturer = indexMapper.findTopLecturer();
        return topLecturer;
    }

    @Override
    public Course findByCourseId(Integer courseId) {
        Course course = indexMapper.findByCourseId(courseId);
        return course;
    }

    @Override
    public List<Course> findAllCourses() {
        List<Course> courses = indexMapper.findAllCourses();
        return courses;
    }

    @Override
    public List<Lecturer> findAllLecturers() {
        List<Lecturer> lecturers = indexMapper.findAllLecturers();
        return lecturers;
    }
}
