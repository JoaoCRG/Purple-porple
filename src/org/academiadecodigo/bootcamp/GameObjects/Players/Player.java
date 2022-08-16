package org.academiadecodigo.bootcamp.GameObjects.Players;

import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player extends GameObject implements KeyboardHandler, Runnable {

    private Picture picture;
    private int posX;
    private int posY;
    private boolean walk;

    private Grid grid;
    private Keyboard keyboard;

    public void init() {

    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int changeXtoCol(int x) {

        return (x - grid.getPADDING()) / grid.getCellSize();

    }

    public int changeYtoRow(int posY) {

        return ((posY - grid.getPADDING()) / grid.getCellSize());

    }

    public int changeColToX(int col) {

        return (col*grid.getCellSize()) + grid.getPADDING();

    }

    public int changeRowToY(int row) {

        return (row* grid.getCellSize()) + grid.getPADDING() + grid.getTitleSpace();

    }

}
