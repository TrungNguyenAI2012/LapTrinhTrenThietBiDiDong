package com.nguyenthanhphong.aquariumshop.HelperClasses.HomeAdapter;

public class MostHelperClass {
    int images;
    String titles, desceptions;

    public MostHelperClass(int images, String titles, String desceptions) {
        this.images = images;
        this.titles = titles;
        this.desceptions = desceptions;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getDesceptions() {
        return desceptions;
    }

    public void setDesceptions(String desceptions) {
        this.desceptions = desceptions;
    }
}
