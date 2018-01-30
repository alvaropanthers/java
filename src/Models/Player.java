package Models;

import java.awt.Color;

public class Player extends Sprite{

    private int speed;

    public Player(int x, int y, int xSpeed, int ySpeed, final int WIDTH, final int HEIGHT, Color color){
        super(x, y, xSpeed, ySpeed, WIDTH, HEIGHT, color);
        setSpeed(10);
    }

    public void setSpeed(int speed) { this.speed = speed; }

    public int getSpeed() { return speed; }
}
