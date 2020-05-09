package com.qa.trello.tests.model;

public class Board {
    private String nameOfBoard;
    private String colorsOfBoard;

    public Board withNameOfBoard(String nameOfBoard) {
        this.nameOfBoard = nameOfBoard;
        return this;
    }

    public Board withColorsOfBoard(String colorsOfBoard) {
        this.colorsOfBoard = colorsOfBoard;
        return this;
    }

    public String getNameOfBoard() {
        return nameOfBoard;
    }

    public String getColorsOfBoard() {
        return colorsOfBoard;
    }
}
