package edu.grinnell.csc207.texting;

import java.util.HashMap;
import java.util.Set;

public class Inventory {
    
    public HashMap<String, Integer> inventory;

    /**
     * Initializes the inventory
     */
    public Inventory () {
        this.inventory = new HashMap<String, Integer>();
    }

    /**
     * Checks if the given item is possible to pickup.
     * If so, adds item to the inventory
     * @param item the given item by the user
     */
    public void pickUp(String item) {
        if (item.equals("pills") ||
            item.equals("paper") ||
            item.equals("piece of paper") ||
            item.equals("tape") ||
            item.equals("balloon") ||
            item.equals("jewelry") ||
            item.equals("coffee capsule") ||
            item.equals("ladder")) {
            // if a valid item, add to inventory
            inventory.put(item, 1);
            System.out.println("You picked up " + item + ".");
        } else {
            System.out.println("You try to pick up " + item + " but the universal forces stop you.");
        }   
    }

    /**
     * Removes an item from the inventory
     * As a precondition, the item should already be in the inventory
     * @param item the item to remove
     */
    public void remove(String item) {
        inventory.remove(item);
    }

    /**
     * Checks if the inventory contains an item
     * @param item an item to search for
     * @return true if the item is in the inventory, false otherwise
     */
    public boolean containsItem(String item) {
        if (inventory.containsKey(item)) {
            return true;
        } else { 
            return false;
        }
    }

    /**
     * Prints the current inventory
     */
    public void printInventory() {
        Set<String> items = inventory.keySet();
        System.out.println("------------------");
        System.out.println("Your Inventory");
        System.out.println("------------------");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("------------------");  
    }
}