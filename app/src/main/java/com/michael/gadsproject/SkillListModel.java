package com.michael.gadsproject;

import com.google.gson.annotations.SerializedName;

public class SkillListModel {

    String nameText, countryText, hoursText;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "score")
    private String score;

    @SerializedName(value = "country")
    private String country;

    public SkillListModel(String nameText, String countryText, String scoreText) {
        this.name = nameText;
        this.country = countryText;
        this.score = scoreText;
    }

    public String getNameText() {
        return name;
    }

    public String getCountryText() {
        return countryText;
    }

    public String getHoursText() { return country; }
}
