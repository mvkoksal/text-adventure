package edu.grinnell.csc207.texting;

import java.util.Scanner;

public abstract class Room {

    public static final int BEDROOM = 1;
    public static final int LIVINGROOM = 2;
    public static final int STORAGE = 3;
    
    public static boolean isAlive = true;
    public static boolean gameOver = false;
    
    protected int waitTime;

    // The door to the next room
    protected boolean doorUnlocked;

    /**
     * Initialize the fields of a new room
     */
    public Room(){
        this.waitTime = 0;
        this.doorUnlocked = false;
    }

    /**
     * Prints information about the user's surroundings.
     */
    public abstract void lookAround();

    /**
     * Give information about the room three times.
     */
    public abstract void waitHere();

    /**
     * Take a direction and give corresponding info to the user.
     * @param dir the direction the user wants to go
     * @return the room the user is now in
     */
    public abstract int go(String dir);

     /**
     * Prints information corresponding to the object the user wants to talk to
     * @param object the object the user wants to talk to
     */
    public abstract void talkTo(String object);

    /**
     * Prints info about what happens when the user attacks a certain object.
     * @param object the object being attacked
     */
    public abstract void attack(String object);

    /**
     * Prints more detailed information about an object when the user looks at it.
     * @param object the object being looked at
     */
    public abstract void lookAt(String object);

    /**
     * Prints information about the object being read
     * @param object the object being read
     */
    public abstract void read(String object);

    /**
     * Prints information about what happens when the user opens something.
     * @param object the object beind opened
     */
    public abstract void open(String object);

    /**
     * Prints information about what happens when the user eats something.
     * @param object the thing being eaten
     */
    public abstract void eat(String object);

    /**
     * Checks if the given item is usable in this room
     * Prints information about what happens when item is used
     * @param item the item being used
     * @return true if the item is usable in this room
     */
    public abstract boolean use(String item);

    /**
     * If the user has waited for more then 3 times, end the game.
     */
    public void waiting() {
        waitTime +=1;
        if (waitTime > 3) { 
            System.out.println("You didn't survive the hunger and thirst after waiting for too long...");
            isAlive = false;
        } else {
            waitHere();
        }
    }

    /**
     * If the user inputs the given key, unlock the door to the next room.
     * @param key the input
     */
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