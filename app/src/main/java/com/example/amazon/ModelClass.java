package com.example.amazon;

public class ModelClass {

    String img, text, id, price, desc1, desc2, desc3, desc4;

    public ModelClass() {
    }

    public ModelClass(String img, String text, String id, String price, String desc1, String desc2, String desc3, String desc4) {
        this.img = img;
        this.text = text;
        this.id = id;
        this.price = price;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;
        this.desc4 = desc4;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }

    public String getDesc4() {
        return desc4;
    }

    public void setDesc4(String desc4) {
        this.desc4 = desc4;
    }
}
