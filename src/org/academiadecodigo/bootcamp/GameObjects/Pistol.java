package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pistol extends GameObject{

    private Picture picture;
    public Pistol(int x, int y) {
        this.picture = new Picture(x, y, "resources/Pistol.png");
        //this.pos = new Position(x, y, this.gd);

        this.posX = x;
        this.posY = y;

    }

    public Picture getPicture() {
        return picture;
    }
}
