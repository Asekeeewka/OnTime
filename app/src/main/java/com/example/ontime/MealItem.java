package com.example.ontime;

public class MealItem {
    private int backgroundImage;
    private String mealName;
    private Integer price;
    private Integer quantity;


    public MealItem(int bgImage, String mName, Integer prc) {
        backgroundImage = bgImage;
        mealName = mName;
        price = prc;
        quantity=0;
    }

    public int getBackgroundImage() {
        return backgroundImage;
    }

    public String getMealName() {
        return mealName;
    }

    public Integer getPrice() {
        return price;
    }


    public void setBackgroundImage(int backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public void setRestoranName(String restoranName) {
        this.mealName = restoranName;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {this.quantity=quantity;}

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
/*comment*/