package edu.grinnell.csc207.texting;

public abstract class Item {
    private String name;
    protected boolean attackable;
    protected boolean readable;

    public Item (String name, boolean attackable, boolean readable) {
        this.name = name;
        this.attackable = attackable;
        this.readable = readable;
    }

    public abstract void attacked();
}
