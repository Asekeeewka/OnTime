package com.example.ontime;

public class MealItem {
    private int backgroundImage;
    private String mealName;
    private String price;
    private String quantity;


    public MealItem(int bgImage, String mName, String prc) {
        backgroundImage = bgImage;
        mealName = mName;
        price = prc;
    }

    public int getBackgroundImage() {
        return backgroundImage;
    }

    public String getMealName() {
        return mealName;
    }

    public String getPrice() {
        return price;
    }


    public void setBackgroundImage(int backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public void setRestoranName(String restoranName) {
        this.mealName = restoranName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {this.quantity=quantity;}
}
