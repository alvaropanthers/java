package Weapons;

import Interfaces.Removeable;

import java.awt.*;

public class Bullet extends Weapon implements Removeable{

    public Bullet(int x, int y, int xSpeed, int ySpeed, final int WIDTH, final int HEIGHT, Color color){
        super(x + (WIDTH), y, xSpeed, ySpeed, WIDTH, HEIGHT, color);
    }

    public void render(Graphics2D g2d){
        g2d.setColor(getColor());
        g2d.fillOval(getX(), getY(), getWIDTH(), getHEIGHT());
    }

    @Override
    public boolean isRemoveable(int xBound, int yBound) {
        if(((getX() + getxSpeed()+ getWIDTH()) >= xBound) || ((getY() + getySpeed()) <= 0)){
            return true;
        }

        return false;
    }
}
