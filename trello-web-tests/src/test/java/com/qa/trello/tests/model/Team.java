package com.qa.trello.tests.model;

public class Team {
    private String nameOfTeam;
    private String fieldOfTeam;

    public Team withNameOfTeam(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
        return this;
    }

    public Team withFieldOfTeam(String fieldOfTeam) {
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
