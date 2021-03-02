package com.codingfuture.coding_cloud_course.vo;

import javax.xml.soap.Text;
import java.util.Date;

public class ArticleCondition {
    private Integer id;
    private String title;
    private String author;
    private String text;
    private Integer acid;
    private String img;
    private String acname;
    private Date create_time;
    private Date update_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAcname() {
        return acname;
    }

    public void setAcname(String acname) {
        this.acname = acname;
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
}
