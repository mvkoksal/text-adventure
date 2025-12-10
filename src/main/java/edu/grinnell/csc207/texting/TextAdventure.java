package edu.grinnell.csc207.texting;

import java.util.Scanner;

public class TextAdventure {

    public static final int BEDROOM = 1;
    public static final int LIVINGROOM = 2;
    public static final int STORAGE = 3;

    public static final int DEATH = 0;
    public static final int ALIVE = 1;

    public static void main(String[] args) {

        // There's a door on the north side.

        Scanner scanner = new Scanner(System.in);
        boolean gameContinue = true;

        // Initialize the rooms
        Parser bedroom = new FirstRoom();
        Parser livingroom = new SecondRoom();
        Parser storage = new ThirdRoom();

        // Start from the bedroom
        Parser room = bedroom;

        Inventory inventory = new Inventory(); 


        //Print game start text
        System.out.println("Welcome to Escape the Bunker.");
        System.out.println("Your goal is to escape the bunker before a slow death from hunger and thirst.\n");
        System.out.println("Type 'inventory' to print your inventory.");
        System.out.println("Type 'look' to remind yourself of your surroundings.");
        System.out.println("Type 'help' for a list of commands as a last resort before death.\n");
        System.out.println("Have fun, and don't get caught by the... aflvbssksdsfdbgnfhdgsfa");
        System.out.println("Connection Closed.\n");

        System.out.println("Game Start.");
        System.out.println("You wake up in a daze.");
        System.out.println("You rub your eyes and look around.");
        System.out.println("You're in a small bunker, with no memory of how you got here.");

        while(gameContinue) {
            if (Parser.gameOver) {
                System.out.println("Congratulations!");
                System.out.println("You've escaped the bunker!");
                System.out.println("What adventures await you now?");
                System.out.println("And what was that growling sound you just heard?");
                System.out.println("TO BE CONTINUED.");
                break;
            } else if (!Parser.isAlive) {
                System.out.println("You have died.");
                System.out.println("Try again next time.");
                System.out.println("Toodles.");
                break;
            }
            String input = scanner.nextLine();
            String[] inputs = input.split(" ");

            if (inputs.length < 1) {
                System.out.println("Please input a command.");
            } 
            String command = inputs[0];
            if (command.equals("wait")) {
                int state = room.waiting();
                if (state == DEATH) {
                    System.out.println("You didn't survive the hunger and thirst after waiting for too long...");
                    gameContinue = false;
                }
            } else if (command.equals("go")) {
                if (inputs.length == 1) {
                    System.out.println("You're not sure which way to go.");
                } else {
                    String dir = inputs[1];
                    if (dir.equals("north") || dir.equals("east") ||dir.equals("south")||dir.equals("west")) {
                        int newRoom = room.go(dir);
                        if (newRoom == BEDROOM) {
                            room = bedroom;
                        } else if (newRoom == LIVINGROOM) {
                            room = livingroom;
                        } else if (newRoom == STORAGE) {
                            room = storage;
                        } else {
                            //debugging
                            System.out.println("Error in the go command.");
                        }
                    } else {
                        System.out.println("You're not sure which way to go.");
                    }
                    
                }
            } else if (command.equals("talk")) {
                if (inputs.length == 1) {
                    System.out.println("You talk to yourself as loneliness creeps in...");
                    System.out.println("Better get out of here soon...");
                } else if (inputs.length == 3) {
                    String preposition = inputs[1]; //to
                    String object = inputs[2];
                    if (preposition.equals("to")) {
                        room.talkTo(object);
                    } else {
                       System.out.println("Your speech was unintelligible to them.."); 
                    }
                } else {
                    System.out.println("You cannot talk with that...");
                }
            } else if (command.equals("pick")) {
                if (inputs.length == 1) {
                    System.out.println("You try to pick what you want to pick up...");
                } else if (inputs.length == 3) {
                    String phrasal = inputs[1]; //up
                    String object = inputs[2];
                    if (phrasal.equals("up")) {
                        if (inventory.containsItem(object)) {
                        System.out.println("You have already picked up this item.");
                        } else {
                            inventory.pickUp(object);
                        }
                    } 
                } else if (inputs.length == 4) {
                    // COFFEE CAPSULE
                    String phrasal = inputs[1]; //up
                    String object = inputs[2] + " " + inputs[3];
                    inventory.pickUp(object);
                } else {
                    System.out.println("That's not possible.");
                }
                
            } else if (command.equals("use")) {
                if (inputs.length == 1) {
                    System.out.println("You wonder what to use...");
                } else if (inputs.length == 2) {
                    String object = inputs[1];
                    if (inventory.use(object)) {
                        room.use(object);
                    }
                } else if (inputs.length == 3) {
                    String object = inputs[1] + inputs[2];
                    // if in the inventory, remove and use it.
                    if (inventory.use(object)) {
                        room.use(object);
                    }
                } else {
                    System.out.println("You can only use items in your inventory.");
                }
            } else if (command.equals("attack")) {
                if (inputs.length == 1) {
                    System.out.println("Nothing to attack here, just existential dread...");
                } else if (inputs.length == 2) {
                    String object = inputs[1];
                    room.attack(object);
                } else {
                    System.out.println("You attack, and question why you did that.");
                }   
            } else if (command.equals("look")) {
                if (inputs.length == 1) {
                    room.lookAround();
                } else if(inputs.length == 3) {
                    String object = inputs[2];
                    room.lookAt(object);
                } else if(inputs.length == 2) {
                    String object = inputs[1];
                    room.lookAt(object);
                } else if (inputs.length == 4) {
                    String object = inputs[2] + inputs[3];
                    room.lookAt(object);
                } else {
                    System.out.println("Looking there doesn't help, you lose hope slowly...");
                }
            } else if (command.equals("read")) {
                if (inputs.length == 1) {
                    System.out.println("You read your own thoughts...");
                    System.out.println("Your overthinking is not helpful to get out of this room.");
                } else if (inputs.length == 2) {
                    String object = inputs[1];
                    room.read(object);
                } else {
                    System.out.println("Reading that doesn't help as you wallow in despair..");
                }
            } else if (command.equals("open")) {
                if (inputs.length == 1) {
                    System.out.println("You ponder what to open..");
                    System.out.println("...your diary? Regret incoming.");
                } else if (inputs.length == 2) {
                    String object = inputs[1];
                    room.open(object);
                } else {
                    System.out.println("Command not recognized.");
                }
            } else if (command.equals("eat")) {
                if (inputs.length == 1) {
                    System.out.println("You hunger as you look for something to eat.");
                    System.out.println("You check your pockets - nothing but some cookie crumbs.");
                } else if (inputs.length == 2) {
                    String object = inputs[1];
                    room.eat(object);
                } else if (inputs.length == 3) {
                    //PILLS
                    String object = inputs[1];
                    String color = inputs[2];
                    room.eat(object+ " " + color);
                }
            } else if (command.equals("inventory")) {
                inventory.printInventory();
            } else if (command.equals("exit")) {
                System.out.println("Giving up so quickly?"); 
                System.out.println("Until next time then..."); 
                gameContinue = false;
            } else if (command.equals("help")) {
                System.out.println("look - look at your surroundings");
                System.out.println("inventory - see your inventory");
                System.out.println("exit - exit the game");

                System.out.println("List of Commands");
                System.out.println("------------------");
                System.out.println("wait");
                System.out.println("go <direction>");
                System.out.println("talk to <object>");
                System.out.println("pick up <item>");
                System.out.println("use <item>");
                System.out.println("attack <object>");
                System.out.println("look at <object>");
                System.out.println("read <object>");
                System.out.println("open <object>");
                System.out.println("eat <object>");
            } else {
                System.out.println("Not a recognized command.");
            }
        }
        scanner.close();
    }
}


    // Wait: wait in the room for one turn
    // Go <direction>: go in the given cardinal direction, e.g., north or south
    // Talk to <object>: talk to the given object found in the room
    // Pick up <item>: pick up the given item found in the room
    // Use <item>: use the given item found in the player's inventory
    // Attack <object>: attack the given object found in the room
    // Look at <object>: look at the given object found in the room
    
    
    // public abstract void waitHere();
    // public abstract int go(String dir);
    // public abstract void talkTo(String object);

    // // // inventory methods
    // // public abstract void pickUp(String dir);
    // // public abstract void use(String item);

    // public abstract void attack(String object);
    // public abstract void lookAt(String object);
    // public abstract void read(String object);
    // public abstract void open(String object);
    // public abstract void eat(String object);