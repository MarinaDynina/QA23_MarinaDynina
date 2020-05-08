package com.qa.trello.tests.model;

public class BoardData {
    private final String nameOfBoard;
    private final String colorsOfBoard;

    public BoardData(String nameOfBoard, String colorsOfBoard) {
        this.nameOfBoard = nameOfBoard;
        this.colorsOfBoard = colorsOfBoard;
    }

    public String getNameOfBoard() {
        return nameOfBoard;
    }

    public String getColorsOfBoard() {
        return colorsOfBoard;
    }
}
