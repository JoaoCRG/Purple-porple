package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sword extends GameObject{

    private Picture picture;

    public Sword(int x, int y) {
        this.picture = new Picture(x, y, "resources/Sword.png");
        //this.pos = new Position(x, y, this.gd);

        this.posX = x;
        this.posY = y;

    }

    public Picture getPicture() {
        return picture;
    }

}
