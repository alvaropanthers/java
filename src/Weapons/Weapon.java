package Weapons;

import Models.Sprite;

import java.awt.Color;

public abstract class Weapon extends Sprite {

    public Weapon(int x, int y, int xSpeed, int ySpeed, final int WIDTH, final int HEIGHT, Color color){
        super(x, y, xSpeed, ySpeed, WIDTH, HEIGHT, color);
    }


}
