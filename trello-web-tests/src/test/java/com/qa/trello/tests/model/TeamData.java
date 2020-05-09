package com.qa.trello.tests.model;

public class TeamData {
    private String nameOfTeam;
    private String fieldOfTeam;

    public TeamData withNameOfTeam(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
        return this;
    }

    public TeamData withFieldOfTeam(String fieldOfTeam) {
        this.fieldOfTeam = fieldOfTeam;
        return this;
    }

    public String getNameOfTeam() {
        return nameOfTeam;
    }

    public String getFieldOfTeam() {
        return fieldOfTeam;
    }
}
