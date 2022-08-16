package org.academiadecodigo.bootcamp.Grid;

import org.academiadecodigo.bootcamp.GameObjects.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid implements Runnable {

    private final int PADDING = 10;
    private Rectangle grid;
    private final int cellSize = 52;
    private final int titleSpace = 50;
    private int maxCols;
    private int maxRows;
    private int screenWidth;
    private int screenHeight;
    private GameObject[][] gameObjects;

    public Grid(int cols, int rows) {

        this.maxCols = cols;
        this.maxRows = rows;
        this.screenWidth = cols*cellSize;
        this.screenHeight = rows*cellSize;

        this.grid = new Rectangle(PADDING, (PADDING + titleSpace), screenWidth, screenHeight);
        this.grid.setColor(Color.GREEN);

    }

    @Override
    public void run() {

        drawGrid();

    }

    public void drawGrid() {

        this.grid.fill();

        gameObjects = makeGrid();

        for (int row = 0; row < maxRows; row++) {
            for (int col = 0; col < maxCols; col++) {

                if (gameObjects[row][col] != null) {

                    gameObjects[row][col].getPicture().draw();
                    //System.out.println(gameObjects[row][col].getPicture() + "row: " + row + " col: " + col);

                }

            }

        }
    }

    public GameObject[][] makeGrid () {

        int y = PADDING + titleSpace;
        gameObjects = new GameObject[maxRows][maxCols];

        for (int row = 0; row < maxRows; row++) {

            int x = PADDING;

            for (int col = 0; col < maxCols; col++) {

                if (row == 0 || col == 0 || row == maxRows - 1 || col == maxCols - 1) {

                    gameObjects[row][col] = CellFactory.getNewCell(x, y, CellType.WALL);

                } else if (row == maxRows - 2) {

                    gameObjects[row][col] = null;

                } else {

                    gameObjects[row][col] = CellFactory.fillCell(x, y);

                }

                x += cellSize;

            }

            y += cellSize;

        }

        return gameObjects;

    }

    public int getMaxCols() {
        return maxCols;
    }

    public int getMaxRows() {
        return maxRows;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public GameObject getGameObjects(int row, int col) {

        return gameObjects[row][col];


    }

    public void setGameObjects(GameObject[][] gameObjects) {
        this.gameObjects = gameObjects;
    }


    public int getPADDING() {
        return PADDING;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getTitleSpace() {
        return titleSpace;
    }

    public int changeXtoCol(int x) {

        return (x - PADDING) / cellSize;

    }

    public int changeYtoRow(int y) {

        return (y - PADDING) / cellSize;

    }

    public int changeColToX(int col) {

        return (col*cellSize) + PADDING;

    }

    public int changeRowToY(int row) {

        return (row*cellSize) + PADDING + titleSpace;

    }

    public void setObject(int row, int col) {

        gameObjects[row][col] = null;
       // gameObjects[row][col] = new Rectangle(changeColToX(col), changeRowToY(row), cellSize, cellSize );

    }



    public static class CellFactory {

        private static int maxPistol = 20;
        private static int maxSword = 20;
        public static int swordCounter = 0;
        public static int pistolCounter = 0;
        public static String pistolOrSword = "pistol";

            public static GameObject fillCell(int x, int y) {

                double random1 = Math.random();

                if (random1 < 0.18) {

                    //System.out.println("wall");
                    return getNewCell(x, y, CellType.WALL);

                } else if (random1 < 0.3) {

                    //double random2 = Math.random();

                    //if (random2 < 0.5 && maxPistol > 0) {
                    if (pistolOrSword.equals("pistol")) {
                        pistolCounter++;
                        //System.out.println("pistol");
                        maxPistol--;
                        pistolOrSword = "sword";
                        return getNewCell(x, y, CellType.PISTOL);
                    }
                    //} else if (maxSword > 0) {
                        if(pistolOrSword.equals("sword")) {
                        swordCounter++;
                        //System.out.println("sword");
                        maxSword--;
                        pistolOrSword = "pistol";
                        return getNewCell(x, y, CellType.SWORD);
                    }

                } else {

                    //System.out.println("null");
                    return null;

                }

                return null;
            }

            public static GameObject getNewCell(int x, int y, CellType cellType) {

                switch (cellType) {
                    case WALL:
                        return new Wall(x, y);
                    case PISTOL:
                        return new Pistol(x, y);
                    case SWORD:
                        return new Sword(x, y);
                    default:
                        return new Coin(x, y);
                }

            }


    }
}



