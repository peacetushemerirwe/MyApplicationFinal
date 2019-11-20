package com.peace.myapplication;

public class Items {
    private int ImageRes;
    private String Line1;
    private String Line2;

    public Items(int Image, String L1, String L2) {
        ImageRes = Image;
        Line1 = L1;
        Line2 = L2;

    }

    public int getImageRes() {
        return ImageRes;
    }

    public String getLine1() {
        return Line1;
    }

    public String getLine2() {
        return Line2;
    }
}
