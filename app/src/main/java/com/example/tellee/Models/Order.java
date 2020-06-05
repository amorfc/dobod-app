package com.example.tellee.Models;

import java.util.Calendar;
import java.util.Date;

public class Order  {
    public String c_name;
    public int cuba_count;
    public int turkish_count;
    public int romeo_count;
    public int monte_count;
    public int maca_count;
    public String date;
    public int totalCheck;
    public double latitude;
    public double longtitude;


    public Order(String date,Integer totalCheck, Integer cuba_count,Integer maca_count,
                 double latitude, double longtitude,Integer turkish_count,String c_name,Integer romeo_count,Integer monte_count) {

        this.c_name = c_name;
        this.totalCheck = totalCheck;
        this.cuba_count = cuba_count;
        this.turkish_count = turkish_count;
        this.date = date;
        this.romeo_count = romeo_count;
        this.monte_count = monte_count;
        this.maca_count = maca_count;
        this.latitude=latitude;
        this.longtitude=longtitude;
    }
    public Order(){

    }
    public String getC_name() {
        return c_name;
    }

    public Integer getCuba_count() {
        return cuba_count;
    }

    public Integer getTurkish_count() {
        return turkish_count;
    }

    public Integer getRomeo_count() {
        return romeo_count;
    }

    public Integer getMonte_count() {
        return monte_count;
    }

    public Integer getMaca_count() {
        return maca_count;
    }

    public String getDate() {
        return date;
    }

    public Integer getTotalCheck() {
        return totalCheck;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }



}
