package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    Picture picture;
    Grid grid;
    GameObject gameObjects;
    boolean active = true;

    int posX;
    int posY;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Picture getPicture() {
        return picture;
    }
    public void deleteObject(){

        gameObjects = null;

    }
}
