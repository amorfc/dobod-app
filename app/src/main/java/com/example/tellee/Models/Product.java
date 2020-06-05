package com.example.tellee.Models;

import java.io.Serializable;

public class Product implements Serializable {

    String img_Url;
    String p_name;
    String price ;
    String desc;

    public Product(String img_Url, String p_name, String price, String desc) {
        this.img_Url = img_Url;
        this.p_name = p_name;
        this.price = price;
        this.desc = desc;
    }

    public String getImg_Url() {
        return img_Url;
    }

    public String getP_name() {
        return p_name;
    }

    public String getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }
}
