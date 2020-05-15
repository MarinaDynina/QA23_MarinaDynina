package com.qa.trello.tests.tests;
import com.qa.trello.tests.model.Board;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {

//    @DataProvider
//    public Iterator<Object[]> validBoards() throws IOException {
//        List<Object[]> list = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));
//        String line = reader.readLine();
//        while (line != null) {
//            String[] split = line.split(";");
//            list.add(new Object[]{new Board().withNameOfBoard(split[0])});
//            reader.readLine();
//        }
//        return list.iterator();
//    }

    @DataProvider
    public Iterator<Object[]> validBoardEasy() {
        List<Object[]> list = new  ArrayList<>();
list.add(new Object[]{"aaaaaaaaaaaaa"});
list.add(new Object[]{"1111111111111"});
list.add(new Object[]{"awsx okpopllki vgyu-jhgfyhjkl"});
        return list.iterator();
    }

        @Test(dataProvider = "validBoardEasy")
        public void testBoardCreation (String boardName) throws InterruptedException {
            Board board = new Board().withNameOfBoard(boardName);
            Thread.sleep(20000);
            int before = app.getBoard().getBoardsCount();
            app.getBoard().initBoardCreation();
            app.getBoard().fillBoardForm(board);
//                new Board()
//                .withNameOfBoard("My board" +System.currentTimeMillis())
//                .withColorsOfBoard("[title='green']"));
//                .withColorsOfBoard("//div[@class='photo-attribution-component large']/../../..//div[14]"));
            Thread.sleep(3000);
            app.getBoard().goToBoardsPageUrl();
            int after = app.getBoard().getBoardsCount();

            System.out.println("was: " + before + " now: " + after);
            Assert.assertEquals(after, before + 1);
        }
    }

