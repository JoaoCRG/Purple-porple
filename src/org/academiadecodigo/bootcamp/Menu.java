package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private Picture mainMenu;
    private Picture guideMenu;
    private Picture spartanVictory;
    private Picture shellbyVictory;
    private Keyboard keyboard;
    private Game game;
    private boolean mainMenuDrawStatus = false;
    private boolean guideMenuDrawStatus = false;
    private boolean spartanVictoryDrawStatus = false;
    private boolean shellbyVictoryDrawStatus = false;
    private boolean gameStart;


    public Menu(Grid grid, Game game) {

        this.mainMenu = new Picture(grid.getPADDING(), grid.getPADDING(), "resources/mainMenu.png");
        this.guideMenu = new Picture(grid.getPADDING(), grid.getPADDING(), "resources/guideMenu.png");
        this.spartanVictory = new Picture(grid.getPADDING(), grid.getPADDING(), "resources/sshpartanVictory.png");
        this.shellbyVictory = new Picture(grid.getPADDING(), grid.getPADDING(), "resources/shellby_Victory.png");
        this.keyboard = new Keyboard(this);
        this.game = game;
        init();

    }

    public void drawSpartanVictory() {
        spartanVictory.draw();
    }

    public void drawShellbyVictory() {
        shellbyVictory.draw();
    }

    public void run() {

        mainMenu.draw();
        setMainMenuDrawStatus(true);

    }

    public void init() {

        KeyboardEvent mainMenu = new KeyboardEvent();
        mainMenu.setKey(KeyboardEvent.KEY_M);
        mainMenu.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(mainMenu);

        KeyboardEvent guideMenu = new KeyboardEvent();
        guideMenu.setKey(KeyboardEvent.KEY_G);
        guideMenu.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(guideMenu);

        KeyboardEvent returnMenu = new KeyboardEvent();
        returnMenu.setKey(KeyboardEvent.KEY_R);
        returnMenu.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(returnMenu);

        KeyboardEvent startGame = new KeyboardEvent();
        startGame.setKey(KeyboardEvent.KEY_SPACE);
        startGame.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(startGame);

    }


        @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        try {

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_M) {
                System.exit(0);
                if (getSpartanVictoryDrawStatus()) {
                    setSpartanVictoryDrawStatus(false);
                    spartanVictory.delete();
                    mainMenu.draw();
                    setGuideMenuDrawStatus(true);
                }
                if (getShellbyVictoryDrawStatus()) {
                    setShellbyVictoryDrawStatus(false);
                    shellbyVictory.delete();
                    mainMenu.draw();
                    setMainMenuDrawStatus(true);
                }

            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_G) {

                if (getMainMenuDrawStatus()) {
                    guideMenu.draw();
                    setGuideMenuDrawStatus(true);
                }

            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {

                if (getGuideMenuDrawStatus()) {
                    guideMenu.delete();
                    setGuideMenuDrawStatus(false);
                }

            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

                if (getMainMenuDrawStatus() && !getGuideMenuDrawStatus()) {
                   // gameStart = true;
                    mainMenu.delete();
                    mainMenuDrawStatus = false;
                    this.game.loadGame();

                }

            }


        }catch (Exception e) {
            System.out.println("No picture to access.");
        }

    }

    public void setMainMenuDrawStatus(boolean mainMenuDrawStatus) {
        this.mainMenuDrawStatus = mainMenuDrawStatus;
    }

    public boolean getMainMenuDrawStatus() {
        return mainMenuDrawStatus;
    }

    public boolean getGuideMenuDrawStatus() {
        return guideMenuDrawStatus;
    }

    public boolean getSpartanVictoryDrawStatus() {
        return spartanVictoryDrawStatus;
    }

    public boolean getShellbyVictoryDrawStatus() {
        return shellbyVictoryDrawStatus;
    }

    public void setGuideMenuDrawStatus(boolean guideMenuDrawStatus) {
        this.guideMenuDrawStatus = guideMenuDrawStatus;
    }

    public void setSpartanVictoryDrawStatus(boolean spartanVictoryDrawStatus) {
        this.spartanVictoryDrawStatus = spartanVictoryDrawStatus;
    }

    public void setShellbyVictoryDrawStatus(boolean shellbyVictoryDrawStatus) {
        this.shellbyVictoryDrawStatus = shellbyVictoryDrawStatus;
    }

    public boolean isGameStart() {
        return gameStart;
    }
}
