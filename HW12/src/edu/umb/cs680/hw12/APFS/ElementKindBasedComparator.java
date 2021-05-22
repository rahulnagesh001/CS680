package edu.umb.cs680.hw12.APFS;

import java.util.Comparator;

public class ElementKindBasedComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement element1, ApfsElement element2) {
        //Directory first
        if (element1.isDirectory() && !element2.isDirectory()) {
            return -1;
        }

        if (!element1.isDirectory() && element2.isDirectory()) {
            return 1;
        }

        // Link last
        if (element1.isLink() && !element2.isLink()) {
            return 1;
        }

        if (!element1.isLink() && element2.isLink()) {
            return -1;
        }

        return element1.getName().compareTo(element2.getName());
    }
}
