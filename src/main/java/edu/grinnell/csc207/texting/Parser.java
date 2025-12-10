package edu.grinnell.csc207.texting;

import java.util.Scanner;

public abstract class Parser {

    public static final int DEATH = 0;
    public static final int ALIVE = 1;
    
    public static boolean isAlive = true;
    public static boolean gameOver = false;
    
    protected int waitTime;
    protected boolean doorUnlocked;

    public Parser(){
        this.waitTime = 0;
        this.doorUnlocked = false;
    }
    
    public int waiting() {
        waitTime +=1;
        if (waitTime > 3) { 
            return DEATH;
        } else {
            waitHere();
            return ALIVE;
        }
    }

    public abstract void lookAround();
    public abstract void waitHere();
    public abstract int go(String dir);
    public abstract void talkTo(String object);

    // // inventory methods
    // public abstract void pickUp(String dir);
    
    public abstract void use(String item);
    public abstract void attack(String object);
    public abstract void lookAt(String object);
    public abstract void read(String object);
    public abstract void open(String object);
    public abstract void eat(String object);

    public void unlock(String key) {
        Scanner scanner = new Scanner(System.in);
        String combination = scanner.nextLine();
        if (combination.equals(key)) {
            System.out.println("The door opens with a creak.");
            doorUnlocked = true;
        } else {
            System.out.println("The lock does not budge.");
        }
    }

}