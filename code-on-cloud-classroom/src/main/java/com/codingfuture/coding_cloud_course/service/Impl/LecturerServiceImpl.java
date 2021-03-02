package com.codingfuture.coding_cloud_course.service.Impl;

import com.codingfuture.coding_cloud_course.entity.Lecturer;
import com.codingfuture.coding_cloud_course.mapper.LecturerMapper;
import com.codingfuture.coding_cloud_course.service.LecturerService;
import com.codingfuture.coding_cloud_course.vo.LecturerCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {
    @Autowired(required = false)
    private LecturerMapper lecturerMapper;

    @Override
    public List<Lecturer> findByCondition(LecturerCondition lecturerCondition) {
        return lecturerMapper.findByCondition(lecturerCondition);
    }
}
