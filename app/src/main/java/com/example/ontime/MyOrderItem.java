package com.example.ontime;

public class MyOrderItem {
    private int restoranImage;
    private String restoranName;
    private String order;
    private String status;
    private String quantity;

    public MyOrderItem(int bgImage, String rName, String ord, String stat, String q) {
        restoranImage = bgImage;
        restoranName = rName;
        order = ord;
        status = stat;
        quantity = q;
    }

    public String getQuantity(){
        return quantity;
    }

    public int getRestoranImage() {
        return restoranImage;
    }

    public String getRestoranName() {
        return restoranName;
    }

    public String getOrder() {
        return order;
    }

    public String getStatus() {
        return status;
    }

    public void setRestoranImage(int backgroundImage) {
        this.restoranImage = backgroundImage;
    }

    public void setRestoranName(String restoranName) {
        this.restoranName = restoranName;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
}
/*comment*/