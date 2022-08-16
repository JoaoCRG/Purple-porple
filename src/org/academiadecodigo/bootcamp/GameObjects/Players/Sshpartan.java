package org.academiadecodigo.bootcamp.GameObjects.Players;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.GameObjects.Wall;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Menu;
import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sshpartan extends Player{

    private Sound sound;
    private Picture picture;
    private int posX;
    private int posY;
    private boolean walk = true;

    private Grid grid;
    private GameObject[][] gridObjects;
    private Keyboard keyboard;
    private CollisionDetector collisionDetector;
    private Menu menu;

    public Sshpartan(Grid grid, Menu menu) {

        this.grid = grid;
        this.menu = menu;

        this.picture = new Picture((grid.getScreenWidth() + grid.getPADDING() - (2 * grid.getCellSize())),
                (grid.getScreenHeight() + grid.getPADDING() + grid.getTitleSpace() - (2 * grid.getCellSize())),
                "resources/SpartanDown.png");

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
        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(rightKeyPressed);


        //LEFT KEY
        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);
        //sound.play(true);
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(leftKeyPressed);


        //UP KEY
        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);
        //sound.play(true);
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(upKeyPressed);


        //DOWN KEY
        KeyboardEvent downKeyPressed = new KeyboardEvent();
        downKeyPressed.setKey(KeyboardEvent.KEY_DOWN);
        //sound.play(true);
        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(downKeyPressed);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {



    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        Sound sound1 = new Sound("/resources/sounds/Single-footstep-in-grass.wav");
        int row = (picture.getY() - grid.getPADDING())/ grid.getCellSize();
        int col = (picture.getX() - grid.getPADDING())/ grid.getCellSize();

            if( keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {

                picture.load("resources/SpartanLeft.png");
                if (!collisionDetector.checkWallLeft(row, col)) {
                    sound1.play(true);
                    picture.translate(-grid.getCellSize(), 0);
                    collisionDetector.checkSpartanCollision(row, col);
                }

            }else {

                picture.translate(0,0);

            }

            if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {

                picture.load("resources/SpartanRight.png");
                if (!collisionDetector.checkWallRight(row, col)) {
                    sound1.play(true);
                    picture.translate(grid.getCellSize(), 0);
                    collisionDetector.checkSpartanCollision(row, col);
                }

            }else {

                picture.translate(0,0);

            }

            if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {

                picture.load("resources/SpartanUp.png");
                if (!collisionDetector.checkWallUp(row, col)) {
                    sound1.play(true);
                    picture.translate(0, -grid.getCellSize());
                    collisionDetector.checkSpartanCollision(row, col);
                }

            }else {

                picture.translate(0,0);

            }

            if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {


                picture.load("resources/SpartanDown.png");
                if (!collisionDetector.checkWallDown(row, col)) {
                    sound1.play(true);
                    picture.translate(0, grid.getCellSize());
                    collisionDetector.checkSpartanCollision(row, col);
                }

            }else {

                picture.translate(0,0);

            }

    }


}
