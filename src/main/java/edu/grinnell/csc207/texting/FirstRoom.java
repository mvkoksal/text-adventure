package edu.grinnell.csc207.texting;

public class FirstRoom extends Parser {
    
    private boolean isVisionFiolet;

    public static final int BEDROOM = 1;
    public static final int LIVINGROOM = 2;
    public static final int STORAGE = 3;


    public FirstRoom() {
        doorUnlocked = false;
        isAlive = true;
        isVisionFiolet = false;
    }

    public void waitHere() {
        if (waitTime == 1) {
            System.out.println("Nothing but the slow tick of the old clock...");
            System.out.println("You hear a buzzing from far away, maybe from another room?");
            System.out.println("The carpet feels soft under your feet.");
        } else if (waitTime == 2) {
            System.out.println("The bright light from the windows reflects off the earrings, blinding you for a second... ");
            System.out.println("There's a slight smell of... coffee?");
            System.out.println("Your head aches...");
        } else if (waitTime == 3) {
            System.out.println("You feel an aching hunger hit you... There seems to be nothing to eat.");
            System.out.println("You wonder how long you can survive in this small room if you just waited like this... forever...");
            System.out.println("Your head spins as you feel like dozing off to a mortal sleep...");
        }
    }

    public int go(String dir) {
        if (dir.equals ("north")) { 
            if (doorUnlocked) {
                System.out.println("You enter the living room.");
                return LIVINGROOM;
            } else {
                System.out.println("You approach the closed door...");
                return BEDROOM;
            }
        } else {
            System.out.println("Walls all around you... except for the door on north.");
            return BEDROOM;
        }

    }

    public void talkTo(String object) {
        System.out.println("You try talking to the " + object + ", doesn't seem to like communicating with humans.");
    }

    // returns the item dropped by the object being attacked if it drops something
    public void attack(String object) {
        if (object.equals("window")) {
            System.out.println("You give a punch to the window. It doesn't budge.");
        } else if ((object.equals("balloon")) || object.equals("balloons") || object.equals("red balloon")) {
            System.out.println("You attack the balloons hugging and squeezing them.");
            System.out.println("You pop one, you pop two, and you don't stop there.");
            System.out.println("When you pop the last balloon, a single piece of paper falls out.");
        } else if (object.equals("jewelry")) {
            System.out.println("Necklaces and earrings scatter to the floor.");
        } else if(object.equals("carpet")){
            System.out.println("You take the carpet off the floor and shake it in the air.");
            System.out.println("You catch a glimpse of a trapdoor under the carpet.");
        } 
        else {
            System.out.println("Now, what did you gain by attacking me?!, says the " + object);
        }
    }

    public void lookAt(String object) {
        if (object.equals("carpet")) {
            System.out.println("On a closer look, the carpet is crooked, as if it has been moved recently.");
        } else if (object.equals("mirror") && isVisionFiolet){
            System.out.println("You notice something you hadn't before on the mirror...");
            System.out.println("A large red '4' seemingly written in blood.");
        } else if (object.equals("mirror")){
            System.out.println("You take a closer look at yourself in the mirror.");
            System.out.println("You are looking pretty fine today.");
            System.out.println("Your attention goes to the reflection of the jewelry hanger behind you.");
        } else if (object.equals("slippers")) {
            System.out.println("On a close look, you realize these are pink bunny slippers! So cute!");
        } else if (object.equals("window")) {
            System.out.println("You look at the window closely.. You notice a latch on the bottom.");
        } else if (object.equals("balloons")){
            System.out.println("All the balloons are green, except for one - a red heart shaped balloon.");
        } else if (object.equals("jewelry")) {
            System.out.println("There are earrings and necklaces on the hanger, and...");
            System.out.println("Is that a coffee capsule behind the jewelry hanger?");
            System.out.println("You would give anything for a coffee right now.");
        } else {
            System.out.println("Just a regular " + object);
        }
    }

    public void read(String object) {
        if (object.equals("paper")) {
            System.out.println("On the paper, there's a single digit written: 9"); 
        } else if (object.equals("label")) {
            System.out.println("The label reads  sleep - ..., ultraviolet - ..., poison - ...");
            System.out.println("The colors beside each word have faded beyond recognition.");
        } else {
            System.out.println("Nothing to read here.");
        }
    }

    public void open(String object) {
        if (object.equals("window")) {
            System.out.println("You pull the latch up, and manage to open up the window for an inch.");
            System.out.println("On the window sill you see a single digit carved out: 3");
            System.out.println("The window shuts back down as you let the latch go.");
        } else if (object.equals("bottle")) {
            System.out.println("You open the bottle of pills. There are 3 pills - green, blue and yellow - inside with a label.");
        } else if (object.equals("trapdoor")) {
            System.out.println("To your surprise, the trapdoor is unlocked! It opens easily with a pull on its handle.");
            System.out.println("Inside, there's a bottle of pills, and tape.");
        } else if (object.equals("door")) {
            System.out.println("The door has a 3-digit combination padlock.");
            openLock();
        } else {
            System.out.println("Nothing to unlock here.");
        }
    }

    public void eat(String object){
        if (object.equals("green pill")) {
            System.out.println("Your vision fades as you fall into a deep sleep...");
            System.out.println("You wake up in a daze.");
        } else if (object.equals("blue pill")) {
            System.out.println("Your eyes burn and your vision blurs.");
            System.out.println("Your head spins");
            System.out.println("Suddenly, the colors around you seem unfamiliar.");
            isVisionFiolet = true;
        } else if (object.equals("yellow pill")) {
            System.out.println("Your vision fades as you fall into a deep sleep...");
            System.out.println("And you die.");
            isAlive = false;
        } else if (object.equals("pill")) {
            System.out.println("You're not sure what color of pill to eat.");
        } else {
            System.out.println("Nothing to eat here.");
        }
    }

    public void openLock() {
        System.out.println("Enter a 3-digit combination:");
        unlock("439");
    }

    public void use(String item){
        System.out.println("Nowhere to use that here.");
    }

}