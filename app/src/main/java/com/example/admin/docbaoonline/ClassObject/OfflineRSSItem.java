package com.example.admin.docbaoonline.ClassObject;

import java.io.Serializable;

// Dùng để lưu trữ tin tức để người dùng đọc lại khi không có mạng

public class OfflineRSSItem implements Serializable{

    private String title;
    private String description;
    private String content;
    private String urlImg;

    public OfflineRSSItem() {
    }

    public OfflineRSSItem(String title, String description, String content, String urlImg) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.urlImg = urlImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "OfflineRSSItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", urlImg='" + urlImg + '\'' +
                '}';
    }
}
