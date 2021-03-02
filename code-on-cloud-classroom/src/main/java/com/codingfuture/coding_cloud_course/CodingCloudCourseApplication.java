package com.codingfuture.coding_cloud_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;


@MapperScan(basePackages = "com.codingfuture.coding_cloud_course.mapper")
@SpringBootApplication
public class CodingCloudCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingCloudCourseApplication.class, args);
    }

}
