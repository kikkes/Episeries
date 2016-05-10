package com.example.kim.episeries;

/**
 * Created by kim on 9/05/2016.
 */
public class Serie {


    int episode_id;
    String serieName ;
    String epiName ;
    String episode ;
    String releaseDate;
    String season;
    boolean isSeen ;

    public Serie(int episode_id, String serieName, String epiName, String episode, String releaseDate, String season) {
        this.episode_id = episode_id;
        this.serieName = serieName;
        this.epiName = epiName;
        this.episode = episode;
        this.releaseDate = releaseDate;
        this.season = season;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }

    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName;
    }

    public String getEpiName() {
        return epiName;
    }

    public void setEpiName(String epiName) {
        this.epiName = epiName;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setIsSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "serieName='" + serieName + '\'' +
                ", epiName='" + epiName + '\'' +
                ", episode='" + episode + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}

