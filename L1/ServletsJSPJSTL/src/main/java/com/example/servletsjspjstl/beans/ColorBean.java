package com.example.servletsjspjstl.beans;

public class ColorBean {

    private String foregroundColor;
    private String backgroundColor;
    private String isBorder;
    public ColorBean() {
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getIsBorder() {
        return isBorder;
    }

    public void setIsBorder(String isBorder) {
        this.isBorder = isBorder;
    }

}
