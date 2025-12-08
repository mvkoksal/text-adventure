package edu.grinnell.csc207.texting;

public abstract class Parser {

public static final int DEATH = 0;
public static final int ALIVE = 1;
    
// Wait: wait in the room for one turn
// Go <direction>: go in the given cardinal direction, e.g., north or south
// Talk to <object>: talk to the given object found in the room
// Pick up <item>: pick up the given item found in the room
// Use <item>: use the given item found in the player's inventory
// Attack <object>: attack the given object found in the room
// Look at <object>: look at the given object found in the room
    protected int waitTime;
    
    public int waiting() {
        waitTime +=1;
        if (waitTime > 3) { 
            return DEATH;
        } else {
            waitHere();
            return ALIVE;
        }
    }

    public abstract void waitHere();
    public abstract int go(String dir);
    public abstract void talkTo(String object);

    // // inventory methods
    // public abstract void pickUp(String dir);
    // public abstract void use(String item);

    public abstract void attack(String object);
    public abstract void lookAt(String object);
    public abstract void read(String object);
    public abstract void open(String object);
    public abstract void eat(String object);

}