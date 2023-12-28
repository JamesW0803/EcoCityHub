package com.example.rewardsandpointssystem;

public class leaderboardHelper {
    private String username;
    private String points;
    private String ranking;

    public leaderboardHelper(String username, int points, String ranking) {
        this.username = username;
        this.points = String.valueOf(points);
        this.ranking = ranking;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(){
        this.username = username;
    }

    public String getPoints(){
        return points;
    }

    public void setPoints(){
        this.points = points;
    }

    public String getRanking(){
        return ranking;
    }

    public void setRanking(){
        this.ranking = ranking;
    }
}
