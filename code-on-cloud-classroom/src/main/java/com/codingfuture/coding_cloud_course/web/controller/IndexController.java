package com.codingfuture.coding_cloud_course.web.controller;

import com.codingfuture.coding_cloud_course.entity.Banner;
import com.codingfuture.coding_cloud_course.entity.Course;
import com.codingfuture.coding_cloud_course.entity.Lecturer;
import com.codingfuture.coding_cloud_course.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    //首页显示
    @RequestMapping("/index")
    @ResponseBody
    public HashMap<Object, Object> findIndex() {
        //banner
        List<Banner> allBanner = indexService.findAllBanner();
        System.out.println(allBanner);
        //热门课
        List<Course> hotCourse = indexService.findHotCourse();
        System.out.println(hotCourse);
        //金牌讲师
        List<Lecturer> topLecturer = indexService.findTopLecturer();
        System.out.println(topLecturer);
        //三个集合存入map
        HashMap<Object, Object> indexcontent = new HashMap<>();
        indexcontent.put("allBanner",allBanner);
        indexcontent.put("hotCourse",hotCourse);
        indexcontent.put("topLecturer",topLecturer);
        return indexcontent;
    }

    //点轮播图/课程，跳转到课程详情页
    @RequestMapping("/course")
    @ResponseBody
    public Course findCourse(@RequestParam(value = "courseId", required = false) Integer courseId){
        Course course = indexService.findByCourseId(courseId);
        System.out.println("课程详情"+course);
        return course;
    }

    //全部课程
    @RequestMapping("/courses")
    @ResponseBody
    public  List<Course> findAllCourses(){
        List<Course> courses = indexService.findAllCourses();
        System.out.println("全部课程"+ courses);
        return  courses;
    }

    //全部老师
    @RequestMapping("/lecturers")
    @ResponseBody
    public List<Lecturer> findAllLecturers(){
        List<Lecturer> lecturers = indexService.findAllLecturers();
        System.out.println("全部老师"+lecturers);
        return lecturers;
    }


}
