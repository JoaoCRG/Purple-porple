package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.GameObjects.Pistol;
import org.academiadecodigo.bootcamp.GameObjects.Players.Player;
import org.academiadecodigo.bootcamp.GameObjects.Players.Shellby;
import org.academiadecodigo.bootcamp.GameObjects.Players.Sshpartan;
import org.academiadecodigo.bootcamp.GameObjects.Sword;
import org.academiadecodigo.bootcamp.GameObjects.Wall;
//import org.academiadecodigo.bootcamp.Grid.CoinCounter;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class CollisionDetector {
    private Text shellbyTxt;
    private Text sshpartanTxt;
    private Player player;
    private Text sshpartanTxtTitle;
    private Integer shpartanCoin = 0;
    private Text shellbyTxtTitle;
    private Integer shellbyCoin = 0;
    private Grid grid;
    private Sound sound;
    private Menu menu;

    public Integer getShpartanCoin() {
        return shpartanCoin;
    }

    public Integer getShellbyCoin() {
        return shellbyCoin;
    }

    public CollisionDetector(Player player, Grid grid, Menu menu) {

        this.player = player;
        this.grid = grid;
        this.menu = menu;

        if (player instanceof Sshpartan) {
            this.sshpartanTxtTitle = new Text(1042.0, 30.0, "SSHPARTAN: ");
            this.sshpartanTxt = new Text (1200.0, 30, shpartanCoin.toString());
            sshpartanInit();
        }
        if (player instanceof Shellby) {
            this.shellbyTxtTitle = new Text(52.0, 30.0, "SHELLBY: ");
            this.shellbyTxt = new Text (182, 30, shellbyCoin.toString());
            shellbyInit();
        }

    }

    public void shellbyInit() {

        this.shellbyTxtTitle.setColor(Color.BLUE);
        this.shellbyTxtTitle.grow(30, 15);
        this.shellbyTxt.grow(30,15);
        this.shellbyTxtTitle.draw();
        this.shellbyTxt.setColor(Color.BLUE);
        //this.shellbyTxt.draw();

    }

    public void sshpartanInit() {

        this.sshpartanTxtTitle.setColor(Color.BLUE);
        this.sshpartanTxtTitle.grow(40,15);
        this.sshpartanTxt.grow(35,15);
        this.sshpartanTxtTitle.draw();
        this.sshpartanTxt.setColor(Color.BLUE);
        //this.sshpartanTxt.draw();

    }

    public void checkSpartanCollision(int row, int col) {


        GameObject objectForCheck = grid.getGameObjects(row, col);
        //System.out.println(objectForCheck);

        if (objectForCheck != null && objectForCheck.isActive()) {
            if (objectForCheck instanceof Pistol) {
                sound = new Sound("/resources/sounds/shotGunSound.wav");
                sound.play(true);
                shpartanCoin -= 20;
                Grid.CellFactory.pistolCounter--;
                //System.out.println(Grid.CellFactory.pistolCounter);
                sshpartanTxt.delete();
                sshpartanTxt.setText(shpartanCoin.toString());
                sshpartanTxt.draw();

                objectForCheck.getPicture().delete();

                objectForCheck.setActive(false);

                if (Grid.CellFactory.pistolCounter == 0 || Grid.CellFactory.swordCounter == 0){

                    if (shpartanCoin > shellbyCoin){
                        menu.setSpartanVictoryDrawStatus(true);
                        menu.drawSpartanVictory();

                    }
                    if (shpartanCoin < shellbyCoin){
                        menu.setShellbyVictoryDrawStatus(true);
                        menu.drawShellbyVictory();

                    }
                }
            }
            if (objectForCheck instanceof Sword) {
                sound = new Sound("/resources/sounds/swordSound.wav");
                sound.play(true);
                shpartanCoin += 20;
                Grid.CellFactory.swordCounter--;
                //System.out.println(Grid.CellFactory.swordCounter);
                sshpartanTxt.delete();
                sshpartanTxt.setText(shpartanCoin.toString());
                sshpartanTxt.draw();

                objectForCheck.getPicture().delete();

                objectForCheck.setActive(false);

                if (Grid.CellFactory.pistolCounter == 0 || Grid.CellFactory.swordCounter == 0){
                    if (shpartanCoin < shellbyCoin){
                        menu.setShellbyVictoryDrawStatus(true);
                        menu.drawShellbyVictory();
                    }
                    if (shpartanCoin > shellbyCoin){
                        menu.setSpartanVictoryDrawStatus(true);
                        menu.drawSpartanVictory();
                    }
                }

            }

        }

    }

    public void checkShellbyCollision(int row, int col) {

        GameObject objectForCheck = grid.getGameObjects(row, col);
        //System.out.println(objectForCheck);

        if (objectForCheck != null && objectForCheck.isActive()) {
            if (objectForCheck instanceof Pistol) {
                sound = new Sound("/resources/sounds/shotGunSound.wav");
                sound.play(true);
                shellbyCoin += 20;
                Grid.CellFactory.pistolCounter--;
                //System.out.println(Grid.CellFactory.pistolCounter);
                shellbyTxt.delete();
                shellbyTxt.setText(shellbyCoin.toString());
                shellbyTxt.draw();

                objectForCheck.getPicture().delete();

                objectForCheck.setActive(false);

                if (Grid.CellFactory.pistolCounter == 0 || Grid.CellFactory.swordCounter == 0){
                    if (shpartanCoin > shellbyCoin){
                        //sound = new Sound("/resources/sounds/thisIsSpartaSound.wav");
                        sound.play(false);
                        menu.setSpartanVictoryDrawStatus(true);
                        menu.drawSpartanVictory();
                    }
                    if (shpartanCoin < shellbyCoin){
                        menu.setShellbyVictoryDrawStatus(true);
                        menu.drawShellbyVictory();
                    }
                }

            }
            if (objectForCheck instanceof Sword) {
                sound = new Sound("/resources/sounds/swordSound.wav");
                sound.play(true);
                shellbyCoin -= 20;
                Grid.CellFactory.swordCounter--;
                //System.out.println(Grid.CellFactory.swordCounter);
                shellbyTxt.delete();
                shellbyTxt.setText(shellbyCoin.toString());
                shellbyTxt.draw();

                objectForCheck.getPicture().delete();

                objectForCheck.setActive(false);

                if (Grid.CellFactory.pistolCounter == 0 || Grid.CellFactory.swordCounter == 0){
                    if (shpartanCoin > shellbyCoin){
                        sound.play(false);
                        menu.setSpartanVictoryDrawStatus(true);
                        menu.drawSpartanVictory();
                    }
                    if (shpartanCoin < shellbyCoin){
                        menu.setShellbyVictoryDrawStatus(true);
                        menu.drawShellbyVictory();
                    }
                }



            }

        }

    }


    public boolean checkWallUp(int row, int col) {

        if (grid.getGameObjects(row - 1, col) instanceof Wall) {
            return true;
        }
        return false;
    }

    public boolean checkWallDown(int row, int col) {

        if (grid.getGameObjects(row + 1, col) instanceof Wall) {
            return true;
        }
        return false;
    }

    public boolean checkWallLeft(int row, int col) {

        if (grid.getGameObjects(row, col - 1) instanceof Wall) {
            return true;
        }
        return false;
    }

    public boolean checkWallRight(int row, int col) {

        if (grid.getGameObjects(row, col + 1) instanceof Wall) {
            return true;
        }
        return false;
    }
}
