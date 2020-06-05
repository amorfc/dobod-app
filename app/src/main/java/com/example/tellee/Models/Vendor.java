package com.example.tellee.Models;

import java.io.Serializable;

public class Vendor implements Serializable {
    private String name;
    private String adress;
    private String visit_date;
    private String imgUrl;
    private String company_name;
    private Integer credit;
    private Integer dicount;
    private double lattitude;
    private double longitude;


    public Vendor(String name, String adress, String visit_date, String imgUrl,
                  String company_name, Integer credit, Integer dicount, double lattitude,
                  double longitude) {
        this.name = name;
        this.adress = adress;
        this.visit_date = visit_date;
        this.imgUrl = imgUrl;
        this.company_name = company_name;
        this.credit = credit;
        this.dicount = dicount;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public Vendor(){

    }

    public double getLattitude() {
        return lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getVisit_date() {
        return visit_date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getCompany_name() {
        return company_name;
    }

    public Integer getCredit() {
        return credit;
    }

    public Integer getDicount() {
        return dicount;
    }
}
