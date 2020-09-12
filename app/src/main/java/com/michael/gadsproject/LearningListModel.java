package com.michael.gadsproject;

import com.google.gson.annotations.SerializedName;

public class LearningListModel {

    String nameText, countryText, hoursText;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "hours")
    private String hours;

    @SerializedName(value = "country")
    private String country;

    public LearningListModel(String nameText, String countryText, String hoursText) {
        this.name = nameText;
        this.country = countryText;
        this.hours = hoursText;
    }

    public String getNameText() {
        return name;
    }

    public String getCountryText() {
        return countryText;
    }

    public String getHoursText() { return hours; }
}
