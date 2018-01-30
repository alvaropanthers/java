package game;

import java.awt.*;

public class Container implements Runnable{
    private int number;

    public Container(){
        this.number = 0;
    }

    public void run(){
        System.out.println(this.number);
        this.number += 1;
    }

}
