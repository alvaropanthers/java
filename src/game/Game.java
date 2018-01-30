package game;

import Models.Player;
import Models.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    private static final int HEIGHT = 600;
    private static final int WIDTH = 600;
    private boolean running;
    private Thread thread;
    private Board board;

    public Game(){
        thread = new Thread(this);
        board = new Board();
        addKeyListener(board);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }


    /**
     * Sets appropriate variables and starts thread
     */
    public void start(){
        if(running){
            return;
        }

        running = true;
        thread.start();
    }

    /**
     * Stops thread
     */
    public void stop(){
        if(running){
            running = false;
            try{
                thread.join();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void move(){
        board.move(getWidth(), getHeight());
        board.remove(getWidth(), getHeight());
    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        board.render(g2d);

        g2d.dispose();
        bs.show();
    }

    public void run(){
        int count = 0;
        while(running){
            //System.out.println("Count = " + count);
            count += 1;
            render();
            move();

            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args){
        Game game = new Game();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setVisible(true);
        frame.add(game);
        game.start();
    }



}
