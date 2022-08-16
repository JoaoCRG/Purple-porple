package org.academiadecodigo.bootcamp.GameObjects.Players;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Menu;
import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Shellby extends Player {

    private Picture picture;
    private int posX;
    private int posY;

    private Grid grid;
    private GameObject[][] gridObjects;
    private Keyboard keyboard;
    CollisionDetector collisionDetector;
    private Menu menu;

    public Shellby(Grid grid, Menu menu) {

        this.grid = grid;
        this.menu = menu;

        this.picture = new Picture(grid.getPADDING() + grid.getCellSize(),
                (grid.getScreenHeight()+ grid.getPADDING()+ grid.getTitleSpace() - (2* grid.getCellSize())) - 10,
                "resources/Shellby.png");

        this.posX = picture.getX();
        this.posY = picture.getY();

        keyboard = new Keyboard(this);
        init();

        collisionDetector = new CollisionDetector(this, grid, menu);

    }

    @Override
    public synchronized void run() {

        this.picture.draw();


    }

    public void init() {

        //RIGHT KEY
        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        rightKeyPressed.setKey(KeyboardEvent.KEY_A);
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(rightKeyPressed);


        //LEFT KEY
        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKey(KeyboardEvent.KEY_D);
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(leftKeyPressed);

        //UP KEY
        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKey(KeyboardEvent.KEY_W);
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(upKeyPressed);

        //DOWN KEY
        KeyboardEvent downKeyPressed = new KeyboardEvent();
        downKeyPressed.setKey(KeyboardEvent.KEY_S);
        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(downKeyPressed);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        Sound sound1 = new Sound("/resources/sounds/Single-footstep-in-grass.wav");
        int row = (picture.getY() - grid.getPADDING()) / grid.getCellSize();
        int col = (picture.getX() - grid.getPADDING()) / grid.getCellSize();

        // if (canWalk(row, col)) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A && picture.getX() > grid.getPADDING()) {

            picture.load("resources/ShellbyLeft.png");
            if (!collisionDetector.checkWallLeft(row, col)) {
                sound1.play(true);
                picture.translate(-grid.getCellSize(), 0);
                collisionDetector.checkShellbyCollision(row, col);
            }

        } else {

            picture.translate(0, 0);

        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D &&
                picture.getX() < ((grid.getMaxCols() * grid.getCellSize()) - grid.getCellSize()) - grid.getCellSize()) {

            picture.load("resources/ShellbyRight.png");
            if (!collisionDetector.checkWallRight(row, col)) {
                sound1.play(true);
                picture.translate(grid.getCellSize(), 0);
                collisionDetector.checkShellbyCollision(row, col);
            }

        } else {

            picture.translate(0, 0);

        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W &&
                picture.getY() > grid.getPADDING() + grid.getTitleSpace()) {

            picture.load("resources/ShellbyUp.png");
            if (!collisionDetector.checkWallUp(row, col)) {
                sound1.play(true);
                picture.translate(0, -grid.getCellSize());
                collisionDetector.checkShellbyCollision(row, col);
            }

        } else {

            picture.translate(0, 0);

        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S &&
                picture.getY() < (grid.getMaxRows() * grid.getCellSize() + grid.getPADDING() + grid.getTitleSpace() - grid.getCellSize())) {


            picture.load("resources/ShellbyDown.png");
            if (!collisionDetector.checkWallDown(row, col)) {
                sound1.play(true);
                picture.translate(0, grid.getCellSize());
                collisionDetector.checkShellbyCollision(row, col);
            }

        } else {

            picture.translate(0, 0);

        }


    }


}