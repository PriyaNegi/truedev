package com.truedev.application;

/**
 * Created by Lakshay on 19-02-2015.
 */
public class ImageInfo {

    Long id;
    String imagePath;

    public ImageInfo(String imagePath) {
        this.imagePath = imagePath;
        this.id = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
