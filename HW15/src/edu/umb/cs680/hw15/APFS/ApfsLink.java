package edu.umb.cs680.hw15.APFS;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {
    private ApfsElement target;

    public ApfsLink(ApfsDirectory parent, String name, ApfsElement target) {
        super(parent, name, 0, LocalDateTime.now());
        this.target = target;
    }

    public boolean isDirectory() {
        return false;
    }
    public boolean isFile() {
        return false;
    }
    public boolean isLink() {
        return true;
    }

    public ApfsElement getTarget() {
        return this.target;
    }
}
