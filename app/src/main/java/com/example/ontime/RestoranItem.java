package com.example.ontime;

public class RestoranItem {
    private int backgroundImage;
    private String restoranName;
    private String price;
    private String distance;

    public RestoranItem(int bgImage, String rName, String prc, String dist) {
        backgroundImage = bgImage;
        restoranName = rName;
        price = prc;
        distance = dist;
    }

    public int getBackgroundImage() {
        return backgroundImage;
    }

    public String getRestoranName() {
        return restoranName;
    }

    public String getPrice() {
        return price;
    }

    public String getDistance() {
        return distance;
    }
}
