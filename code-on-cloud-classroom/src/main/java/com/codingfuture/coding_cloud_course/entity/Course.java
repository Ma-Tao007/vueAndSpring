package com.codingfuture.coding_cloud_course.entity;

public class Course {
    private Integer id;
    private String name;
    private Integer ccid;
    private Integer lecturerId;
    private String picture;//图片路径
    private String courseUrl;
    private Integer type;
    private String profile;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCourseUrl() {
        return courseUrl;
    }

    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ccid=" + ccid +
                ", lecturerId=" + lecturerId +
                ", picture='" + picture + '\'' +
                ", courseUrl='" + courseUrl + '\'' +
                ", type=" + type +
                ", profile='" + profile + '\'' +
                ", price=" + price +
                '}';
    }
}
