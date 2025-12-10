package edu.grinnell.csc207.texting;

public class ThirdRoom extends Parser {
    private boolean ladderUp = false;

    public static final int BEDROOM = 1;
    public static final int LIVINGROOM = 2;
    public static final int STORAGE = 3;
    
private boolean trapdoorUnlocked = false;

    public void lookAround() {
        System.out.println("A coffee machine buzzes softly in the corner.");
        System.out.println("A small low table sits on the floor with a half-finished piece of brown knitting resting on it.");
        System.out.println("A newspaper clipping is nailed to the right wall. ");
        System.out.println("The wooden walls are covered in deep scratches that look disturbingly like claw marks.");
        System.out.println("You look up, and notice a trapdoor set into the ceiling.");
    }

    public void waitHere() {
         if (waitTime == 1) {
            System.out.println("The storage room is cozy with the fireplace in the corner of the room.");
            System.out.println("The coffee machine buzzes.");
            System.out.println("The knit on the table glints from the fireplace light.");
        } else if (waitTime == 2) {
            System.out.println("A breeze brushes past you from the small trapdoor on the ceiling.");
            System.out.println("The newspaper snippet on the wall also flies up with it.");
            System.out.println("The air smells damp.");
        } else if (waitTime == 3) {
            System.out.println("You feel another pang of hunger and thirst.");
            System.out.println("Lying down and taking a nap sounds really good...");
            System.out.println("Your eyelids get heavy...");
        }
    }
    public int go(String dir) {
        if (dir.equals ("west")) { 
            System.out.println("You enter the living room.");
            return LIVINGROOM;
        } else if (dir.equals("up")) {
            if (trapdoorUnlocked) {
                gameOver = true;
            }
            if (ladderUp) {
                System.out.println("You climb up the ladder.");
                System.out.println("You trapdoor seems stuck.");
            } else {
                System.out.println("Gravity keeps you on the floor.");
            }
            return STORAGE;
        } else {
            System.out.println("Walls all around you... except for the door to the living room on the west.");
            return STORAGE;
        }
    }
    public void talkTo(String object) {
        System.out.println("You try talking to the " + object + ", doesn't seem to like communicating with humans.");
    }

    public void attack(String object) {
        if (object.equals("knit")) {
            System.out.println("You grab the knit off the table and fling it to the wall.");
            System.out.println("As it flies, it cathes onto the table, and most of it gets frogged.");
            System.out.println("The owner will not be happy about that...");
        } else if (object.equals("trapdoor")) {
            if (ladderUp) {
                System.out.println("You ram your shoulder into the ceiling trapdoor.");
                System.out.println("It budges a little.");
                System.out.println("You push up with all your power - and the trapdoor gives in, swinging open upwards.");
                System.out.println("Sunlight floods the storage room, as you climb up the last few steps of the ladder out into the world.");
                System.out.println("A growling sound comes from nearby that gives you the chills.");
                System.out.println("Must be nothing, right?");
                trapdoorUnlocked = true;
            } else {
                System.out.println("The trapdoor is out of your reach.");
            }
        } else if (object.equals("fireplace")) {
            System.out.println("You throw a piece of wood into the fireplace.");
            System.out.println("The wood burns, and the room heats up.");
        }  else if (object.equals("newspaper")) {
            System.out.println("You give a punch to the newspaper piece on the wall.");
            System.out.println("Your hand aches.");
        } else {
            System.out.println("Your attack is unsuccessful.");
        }
    }
    public void lookAt(String object){
        if (object.equals("knit")) {
            System.out.println("You take a closer look at the knit - looks like one arm of a wool sweater.");
        } else if (object.equals("coffee machine")) {
            System.out.println("A couple used coffee capsules are next to the coffee machine.");
            System.out.println("A couple used coffee capsules are next to the coffee machine.");
        } else if (object.equals("trapdoor")) {
            if(ladderUp) {
                System.out.println("The trapdoor seems old and worn.");
                System.out.println("You knock on it. The material seems to be empty inside.");
            } else {
                System.out.println("The trapdoor is too far up for you to see anything.");
            }
        } else if (object.equals("fireplace")) {
            System.out.println("The fireplace is warm. A raw piece of lumber lies on top of the pile.");
            System.out.println("Someone seems to have been here very recently.");
        } else if (object.equals("newspaper")) {
            System.out.println("A news story has been ripped out of the newspaper and hung on the wall.");
            System.out.println("Above it, a blurry picture of a wolf-like animal.");
        } else {
            System.out.println("Not a valid thing to look at.");
        }
    }

    public void read(String object) {
        if (object.equals("newspaper")) {
            System.out.println("You take a closer look at the article.");
            System.out.println("The title reads: Hikers flee after encounter with large, unknown beast.");
            System.out.println("The owner must be interested in mythical stories.");
        } else {
            System.out.println("Can't read that.");
        }
    }

    public void open(String object) {
        if (object.equals("trapdoor")) {
            if (ladderUp) {
                System.out.println("There is no latch to open the trapdoor.");
            } else {
                System.out.println("The trapdoor is out of your reach.");
            }
        } else {
            System.out.println("Can't open that.");
        }
    }

    public void eat(String object) {
       System.out.println("Nothing to eat here.");
    }

    public void use(String item){
        if (item.equals("ladder")) {
            System.out.println("You lean the ladder on the edge of the trapdoor on the ceiling.");
            System.out.println("It feels pretty stable.");
            ladderUp = true;
        } else if (item.equals("coffee capsule")){
            System.out.println("You put the capsule in the coffee machine and brew.");
            System.out.println("A deep earthy smell fills the room.");
            System.out.println("You really have missed this.");
            System.out.println("You take a sip and sigh.");
        } else {
            System.out.println("Nowhere to use that here.");
        }
    }
}
