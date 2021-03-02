package com.codingfuture.coding_cloud_course.web.controller;

import com.codingfuture.coding_cloud_course.entity.Lecturer;
import com.codingfuture.coding_cloud_course.service.LecturerService;
import com.codingfuture.coding_cloud_course.vo.LecturerCondition;
import com.codingfuture.coding_cloud_course.vo.PageData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @GetMapping("/lecturer")
    public PageData findByPage(@RequestParam("page") int page,
                               @RequestParam("limit") int limit,
                               LecturerCondition lecturerCondition) {
        Page<Lecturer> list = PageHelper.startPage(page, limit);
        System.out.println(list);
        lecturerService.findByCondition(lecturerCondition);
        long count = list.getTotal();
        PageData pageData = new PageData();
        pageData.setRows(list.getResult());
        pageData.setTotal(count);
        return pageData;
    }
}
