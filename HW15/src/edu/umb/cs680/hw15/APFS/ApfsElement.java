package edu.umb.cs680.hw15.APFS;

import edu.umb.cs680.hw15.FSFoundation.FSElement;

import java.time.LocalDateTime;

public abstract class ApfsElement extends FSElement {
    private LocalDateTime creationTime;
    private LocalDateTime lastModified;

    protected ApfsDirectory parent;

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(name, size);
        this.parent = parent;
        this.creationTime = creationTime;
        this.lastModified = creationTime;
    }

    public ApfsDirectory getParent() {
        return this.parent;
    }

    public void setParent(ApfsDirectory parent) {
        this.parent = parent;
    }

    public int getSize() {
        return this.size;
    }

    public abstract boolean isLink();

    public String getName() {
        return this.name;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public LocalDateTime getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(LocalDateTime time) {
        this.lastModified = time;
    }

}
