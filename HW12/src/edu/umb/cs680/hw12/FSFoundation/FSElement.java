package edu.umb.cs680.hw12.FSFoundation;

public abstract class FSElement {
    protected String name;
    protected int size;

    public FSElement(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public abstract boolean isDirectory();

    public abstract boolean isFile();
}
