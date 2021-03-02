package com.codingfuture.coding_cloud_course.entity;

import java.util.Date;


public class Lecturer {
    private Integer id;
    private String name;
    private String pic_url;
    private String profile;
    private Integer type;
    private String career;
    private Integer sort;
    private Integer is_deleted;
    private Date create_time;
    private Date update_time;

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

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", profile='" + profile + '\'' +
                ", type=" + type +
                ", career='" + career + '\'' +
                ", sort=" + sort +
                ", is_deleted=" + is_deleted +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
