package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Players.Player;
import org.academiadecodigo.bootcamp.GameObjects.Players.Shellby;
import org.academiadecodigo.bootcamp.GameObjects.Players.Sshpartan;

//import org.academiadecodigo.bootcamp.Grid.CoinCounter;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private Grid grid;
    private Player spartan;
    private Player shellby;
    private Sound sound;
    private CollisionDetector collisionDetector;
    private Menu menu;



    public Game(int cols, int rows) {

        this.sound = new Sound("/resources/sounds/GameOfThronesSound.wav");
        this.grid = new Grid(cols, rows);
        menu = new Menu(grid, this);
        this.spartan = new Sshpartan(grid, menu);
        this.shellby = new Shellby(grid, menu);
        //this.coinCounter = new CoinCounter(grid,spartan);
        //this.collisionDetector = new CollisionDetector(spartan,grid);
    }

    public void init() {

        sound.play(true);
        menu.run();

    }

    public void loadGame() {

        grid.run();
        spartan.run();
        shellby.run();
        //timerCounter();
        collisionDetector.shellbyInit();
        collisionDetector.sshpartanInit();

    }



   /* public void timerCounter() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            int i = 5;

            public void run() {
                i++;

                Text txt = new Text(600, 30, "Time left:" + i);
                txt.setColor(Color.BLUE);
                txt.grow(60, 23);
                txt.draw();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                txt.delete();

            }
        }, 0, 1000);

    }*/


}
