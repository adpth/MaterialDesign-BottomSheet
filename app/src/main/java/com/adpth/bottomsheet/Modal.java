package com.adpth.bottomsheet;

public class Modal {

    private String title;
    private String size;
    private int image;

    public Modal(String title, String size, int image) {
        this.title = title;
        this.size = size;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
