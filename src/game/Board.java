package game;

import Interfaces.Moveable;
import Interfaces.Removeable;
import Interfaces.Renderable;
import Models.Player;
import Models.Sprite;
import Weapons.Bullet;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Board implements Renderable, Moveable, KeyListener{

    private Player player;
    private ArrayList<Sprite> sprites;
    private ArrayList<Removeable>removeables;

    public Board(){
        sprites = new ArrayList<>();
        removeables = new ArrayList<>();
        player = new Player(0, 0, 0, 0, 50, 50, Color.RED);
        addSprite(player);
    }

    public void addSprite(Sprite sprite){
        sprites.add(sprite);
    }

    public void removeSprite(Sprite sprite){
        if(sprites.indexOf(sprite) > 0){
            sprites.remove(sprite);
        }
    }

    public void render(Graphics2D g2d){
        for(Renderable render: sprites){
            render.render(g2d);
        }
    }

    public void move(int width, int height){
        for(Moveable move: sprites){
            move.move(width, height);
        }
    }

    public void remove(int width, int height){
        for(Iterator<Removeable>iterator = removeables.iterator(); iterator.hasNext();){
            Removeable rm = iterator.next();
            if(rm.isRemoveable(width, height)){
                removeSprite((Sprite)rm);
                iterator.remove();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_D) {
            player.setxSpeed(player.getSpeed());
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_A){
            player.setxSpeed(-player.getSpeed());
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_S){
            player.setySpeed(player.getSpeed());
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_W) {
            player.setySpeed(-player.getSpeed());
        }
        System.out.println("x = " + player.getX() + " y = " + player.getY());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_D){
            player.setxSpeed(0);
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_A){
            player.setxSpeed(0);
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_S){
            player.setySpeed(0);
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_W){
            player.setySpeed(0);
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_SPACE){
            Bullet bullet = new Bullet(player.getX(), player.getY(), 0, -20, 10, 10, Color.WHITE);
            sprites.add(bullet);
            removeables.add(bullet);
        }
    }
}
