package org.esiea.genovese.myapplication.model;

import android.support.v7.app.AppCompatActivity;

public class TeamsModel extends AppCompatActivity{

    private String teamName;
    private String abbreviation;
    private String location;
    private String logoUrl;
    private String arena;
    private String description;

    public TeamsModel() {
    }

    public TeamsModel(String teamName, String abbreviation, String location, String logoUrl, String arena, String description) {
        this.teamName = teamName;
        this.abbreviation = abbreviation;
        this.location = location;
        this.logoUrl = logoUrl;
        this.arena = arena;
        this.description = description;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena){
        this.arena = arena;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
