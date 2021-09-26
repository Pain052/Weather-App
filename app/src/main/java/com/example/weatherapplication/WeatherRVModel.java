package com.example.weatherapplication;

public class WeatherRVModel {
    private String time;
    private String temp_c;
    private String icon;
    private String wind_kph;

    public WeatherRVModel() {
    }

    public WeatherRVModel(String time, String temp_c, String icon, String wind_kph) {
        this.time = time;
        this.temp_c = temp_c;
        this.icon = icon;
        this.wind_kph = wind_kph;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(String temp_c) {
        this.temp_c = temp_c;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(String wind_kph) {
        this.wind_kph = wind_kph;
    }
}
