package com.ga.movies.models;

public class ProfileModel {
    private String applicationName;
    private String name;
    private String intro;
    private String facts;
    private String theme;

    public ProfileModel(){
        applicationName = "Movies";
        name = "Amna Abdulqader";
        intro = "I am now implementing movies app on my Java development course.";
        facts = "My favorite movie is Fast & Furious";
        theme = "Movie Profile";
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getFacts() {
        return facts;
    }

    public void setFacts(String facts) {
        this.facts = facts;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString(){
        return "The app name is: " + getApplicationName() +
                ", " + "intro: " +getIntro() +
                ", " + "facts about me: " + getFacts() +
                ", " + "the chosen theme: " + getTheme();
    }
}
