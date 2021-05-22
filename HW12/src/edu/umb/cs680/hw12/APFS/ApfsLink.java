package edu.umb.cs680.hw12.APFS;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {
    private ApfsElement target;

    public ApfsLink(ApfsDirectory parent, String name, ApfsElement target) {
        super(parent, name, 0, LocalDateTime.now());
        this.target = target;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return true;
    }

    public ApfsElement getTarget() {
        return this.target;
    }
}
