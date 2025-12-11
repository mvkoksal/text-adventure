package edu.grinnell.csc207.texting;

import java.util.HashMap;
import java.util.Set;

public class Inventory {
    
    public HashMap<String, Integer> inventory;

    public Inventory () {
        this.inventory = new HashMap<String, Integer>();
    }

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


    // preconditon that item is in the inveneroy
    public void remove(String item) {
        inventory.remove(item);
    }

    public boolean containsItem(String item) {
        if (inventory.containsKey(item)) {
            return true;
        } else { 
            return false;
        }
    }

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