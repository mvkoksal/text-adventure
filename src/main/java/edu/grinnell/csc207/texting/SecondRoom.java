package edu.grinnell.csc207.texting;

public class SecondRoom extends Room {

    private boolean computerOn = false;

    /**
     * Prints information about the user's surroundings.
     */
    public void lookAround() {
        System.out.println("A bright industrial light washes the room in a harsh glow.");
        System.out.println("A ladder leans against the wall, and a desk with a computer, its screen completely black, rests nearby.");
        System.out.println("On the opposite side sits a couch that looks surprisingly cozy and inviting.");
        System.out.println("A closed door stands to the east, with no other way out.");
    }
    

    public void waitHere() {
        if (waitTime == 1) {
            System.out.println("You sneeze as dust swirls in the room. Your eyes struggle to adjust to the white bright light of the living room.");
            System.out.println("A hissing sound is coming from somewhere, seemingly from the cable of the computer.");
            System.out.println("A bed waiting for you to take a nap... With no guarantee of ever waking up again.");
        } else if (waitTime == 2) {
            System.out.println("It's way too warm in here...");
            System.out.println("You're not sure how much time has passed since you woke up..");
            System.out.println("You hear the buzzing sound.. from behind the locked door on the east side?");
        } else if (waitTime == 3) {
            System.out.println("The computer is exciting.. Maybe a possibility to reach the outside world?");
            System.out.println("The cable is ripped into two pieces... as if ripped by two sharp fangs..");
            System.out.println("You wonder whether this is a good time to give up..");
        }
    }
    public int go(String dir) {
        if (dir.equals ("east")) { 
            if (doorUnlocked) {
                System.out.println("You enter the storage room.");
                return STORAGE;
            } else {
                System.out.println("You approach the closed door...");
                return LIVINGROOM;
            }
        } else if(dir.equals("south")) {
            System.out.println("You enter the bedroom.");
            return BEDROOM;
        } else {
            System.out.println("Walls all around you... except for the door to the bedroom on the south and a new door on the east.");
            return LIVINGROOM;
        }
    }

    public void talkTo(String object) {
        System.out.println("You try talking to the " + object + ", doesn't seem to like communicating with humans.");
    }

    public void attack(String object) {
        if (object.equals("light")) {
            System.out.println("The light starts flickering after your hit. You question why you did that.");
        } else if(object.equals("bed")) {
            System.out.println("You give a punch to the pillow. Then feel guilty and give it a big hug.");
        } else if (object.equals("ladder")) {
            System.out.println("You kick the ladder and your feet hurts. That is going to blister.");
        } else {
            System.out.println("Your attack is unsuccessful.");
        }
    }

    public void lookAt(String object){
        if(object.equals("bed")) {
            System.out.println("The bed is soft, with a Shiba Inu comforter and a light orange pillow.");
            System.out.println("Looks like it has been slept in very recently...");
        } else if (object.equals("ladder")) {
            System.out.println("A pretty sturdy ladder made of wood.");
        } else if (object.equals("computer")) {
            System.out.println("The computer cable seems to be split into two.");
        } else {
            System.out.println("Just a regular " + object + ".");
        }
    }

    public void read(String object) {
        if(object.equals("text") && computerOn) {
            System.out.println("The computer screen reads: Why boba is unquestionably the best drink in the world");
            System.out.println("There is a long scientific paper under the title.");
            System.out.println("You look for a mouse or keyboard, there is none. No way to manipulate the screen.");
        } else if (object.equals("text")) {
            System.out.println("The computer screen is black.");
        } else {
            System.out.println("Can't read that.");
        }
    }
    public void open(String object) {
        if (object.equals("door")) {
            System.out.println("The door has a word-combination padlock.");
            openLock();
        } else {
            System.out.println("Can't open that.");
        }
    }

    public void eat(String object) {
        System.out.println("Nothing to eat here...");
        System.out.println("Your stomach grumbles as you ponder how long you could survive in here if you don't get out soon.");
    }

    public void openLock() {
        System.out.println("Enter a word: ");
        unlock("boba");
    }
        
    // preconditions : object is a valid object from the inventory
    public boolean use(String item) {
        if (item.equals("tape")){
            System.out.println("You tape the two ends of the cable together with the tape.");
            System.out.println("The computer screen lights up. Some text appears on the screen.");
            computerOn = true;
            return true;
        } else {
            System.out.println("Nowhere to use that here.");
            return false;
        }
    }
}
