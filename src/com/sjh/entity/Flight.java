package com.sjh.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Flight {
    private Integer id;

    private String flightnum;

    private Integer takeoff;

    private Integer landing;

    private String actail2;

    private String actype;
    
  
    private Date flightdate;

    private Float price;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightnum() {
        return flightnum;
    }

    public void setFlightnum(String flightnum) {
        this.flightnum = flightnum;
    }

    public Integer getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(Integer takeoff) {
        this.takeoff = takeoff;
    }

    public Integer getLanding() {
        return landing;
    }

    public void setLanding(Integer landing) {
        this.landing = landing;
    }

    public String getActail2() {
        return actail2;
    }

    public void setActail2(String actail2) {
        this.actail2 = actail2;
    }

    public String getActype() {
        return actype;
    }

    public void setActype(String actype) {
        this.actype = actype;
    }

    public Date getFlightdate() {
        return flightdate;
    }

    public void setFlightdate(Date flightdate) {
        this.flightdate = flightdate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}