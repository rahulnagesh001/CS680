package edu.umb.cs680.hw12.APFS;

import java.util.Comparator;

public class TimeStampBasedComparator implements Comparator<ApfsElement>{
    public int compare(ApfsElement element1, ApfsElement element2) {
        // Recent
        return element2.getLastModified().compareTo(element1.getLastModified());
    }
}
