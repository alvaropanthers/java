package Models;

import Interfaces.Moveable;
import Interfaces.Renderable;

import java.awt.*;


public abstract class Sprite implements Renderable, Moveable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    private final int WIDTH;
    private final int HEIGHT;
    private Color color;

    public Sprite(int x, int y, int xSpeed, int ySpeed, final int WIDTH, final int HEIGHT, Color color){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.color = color;
    }

    public void move(int xBound, int yBound){
        if(((x + xSpeed + WIDTH) < xBound) && ((x + xSpeed) >= 0)){
            x += xSpeed;
        }


        if((y + ySpeed >= 0) && (y + HEIGHT + ySpeed) <= yBound){
            y += ySpeed;
        }
    }

    public void render(Graphics2D g2d){
        g2d.setColor(color);
        g2d.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void setxSpeed(int xSpeed) { this.xSpeed = xSpeed; }

    public void setySpeed(int ySpeed) { this.ySpeed = ySpeed; }

    public void setColor(Color color) { this.color = color; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public int getxSpeed() { return xSpeed; }

    public int getySpeed() { return ySpeed; }

    public Color getColor() { return color; }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getWIDTH() { return WIDTH; }

    public int getHEIGHT() { return HEIGHT; }
}
