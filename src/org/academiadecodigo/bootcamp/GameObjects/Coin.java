package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Coin extends GameObject{

    private Picture picture;

    public Coin(int x, int y) {
        this.picture = new Picture(x, y, "resources/Coin.png");
        //this.pos = new Position(x, y, this.gd);

        this.posX = x;
        this.posY = y;

    }

    public Picture getPicture() {
        return picture;
    }
}
