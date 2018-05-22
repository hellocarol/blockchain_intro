package com.sjh.entity;

public class Airport {
    private Integer id;

    private String airportname;

    private String city;

    private Integer runwaycount;

    private String wordcode3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAirportname() {
        return airportname;
    }

    public void setAirportname(String airportname) {
        this.airportname = airportname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getRunwaycount() {
        return runwaycount;
    }

    public void setRunwaycount(Integer runwaycount) {
        this.runwaycount = runwaycount;
    }

    public String getwordcode3() {
        return wordcode3;
    }

    public void setwordcode3(String wordcode3) {
        this.wordcode3 = wordcode3;
    }
}