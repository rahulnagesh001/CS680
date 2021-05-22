package edu.umb.cs680.hw12.APFS;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {
    private LinkedList<ApfsElement> children;

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    public ApfsDirectory(ApfsDirectory parent, String name) {
        super(parent, name, 0, LocalDateTime.now());
        this.children = new LinkedList<>();
    }

    public int countChildren() {
        return this.children.size();
    }

    public void appendChild(ApfsElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public LinkedList<ApfsElement> getChildren() {
        Collections.sort(this.children, new AlphabeticalComparator());
        return this.children;
    }

    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> subDir = new LinkedList<>();
        for (ApfsElement element: this.children) {
            if (element.isDirectory()) {
                subDir.add((ApfsDirectory) element);
            }
        }
        Collections.sort(subDir, new AlphabeticalComparator());
        return subDir;
    }

    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<>();
        for (ApfsElement element: this.children) {
            if (element.isFile()) {
                files.add((ApfsFile) element);
            }
        }
        Collections.sort(files, new AlphabeticalComparator());
        return files;
    }

    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> sortPolicy) {
        LinkedList<ApfsElement> cloneChildren = getChildren();
        Collections.sort(cloneChildren, sortPolicy);
        return cloneChildren;
    }

    public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> sortPolicy) {
        LinkedList<ApfsDirectory> cloneSubDirs = getSubDirectories();
        Collections.sort(cloneSubDirs, sortPolicy);
        return cloneSubDirs;
    }

    public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> sortPolicy) {
        LinkedList<ApfsFile> cloneFiles = getFiles();
        Collections.sort(cloneFiles, sortPolicy);
        return cloneFiles;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (ApfsElement element : this.children) {
            if (element.isDirectory()) {
                ApfsDirectory subDir = (ApfsDirectory) element;
                totalSize += subDir.getTotalSize();

            } else if (element.isFile()) {
                totalSize += element.getSize();
            }

        }
        return totalSize;
    }
}
