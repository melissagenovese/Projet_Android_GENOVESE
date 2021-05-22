package org.esiea.genovese.myapplication.model;

import android.support.v7.app.AppCompatActivity;

public class PlayersModel extends AppCompatActivity {

    private String firstName;
    private String lastName;
    private int playerId;
    private String teamId;
    private String imgUrl;

    public PlayersModel() {
    }

    public PlayersModel(String firstName, String lastName, int playerId, String teamId, String imgUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerId = playerId;
        this.teamId = teamId;
        this.imgUrl = imgUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getImgUrl(){
        return imgUrl;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
}

