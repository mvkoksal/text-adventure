package edu.grinnell.csc207.texting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Inventory {
    
    public HashMap<String, Integer> inventory;

    public Inventory () {
        this.inventory = new HashMap<String, Integer>();
    }

    public void pickUp(String item) {
        if (item.equals("pill bottle") ||
            item.equals("paper") ||
            item.equals("piece of paper") ||
            item.equals("tape") ||
            item.equals("balloon") ||
            item.equals("jewelry")) {
            // if a valid item, add to inventory
            inventory.put(item, 1);
        } else {
            System.out.println("You try to pick up " + item + " but the universal forces stop you.");
        }   
    }

    public String use(String item) {
        if (containsItem(item)) {
            inventory.remove(item);
            return item;
        } else {
            System.out.println("You do not have this item in your inventory");
            return "";
        }
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
        for (String item : items) {
            System.out.println(item);
        }  
    }
}