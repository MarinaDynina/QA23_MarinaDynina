package com.qa.trello.tests.model;

public class BoardData {
    private String nameOfBoard;
    private String colorsOfBoard;

//    public BoardData(String nameOfBoard, String colorsOfBoard) {
//        this.nameOfBoard = nameOfBoard;
//        this.colorsOfBoard = colorsOfBoard;
//    }


    public BoardData withNameOfBoard(String nameOfBoard) {
        this.nameOfBoard = nameOfBoard;
        return this;
    }

    public BoardData withColorsOfBoard(String colorsOfBoard) {
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
