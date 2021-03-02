package com.codingfuture.coding_cloud_course.entity;

public class Banner {
private Integer id;
private String url;
private Integer courseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
