package edu.umb.cs680.hw15.APFS;

import edu.umb.cs680.hw15.FSFoundation.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFS extends FileSystem {
    private String ownerName;
    private LocalDateTime lastModified;

    public APFS(String ownerName) {
        this.ownerName = ownerName;
        this.lastModified = LocalDateTime.now();
    }

    public ApfsDirectory getRootDir() {
        ApfsDirectory rootDir = (ApfsDirectory) this.getRoot();
        return rootDir;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public LocalDateTime getLastModified() {
        return this.lastModified;
    }

    @Override
    protected FSElement createDefaultRoot() {
        return new ApfsDirectory(null, "root");
    }

    public static void main(String args[]) {
        APFS apfs = new APFS( "AnhVo");
        apfs.initFileSystem("Local Disk", 1000);
        ApfsDirectory root = apfs.getRootDir();

        ApfsDirectory applications, home, code;
        ApfsFile a, b, c, d, e, f;
        ApfsLink x, y;

        applications = new ApfsDirectory(root, "applications");
        home = new ApfsDirectory(root, "home");
        root.appendChild(applications);
        root.appendChild((home));

        a = new ApfsFile(applications, "a", 10);
        b = new ApfsFile(applications, "b", 10);
        applications.appendChild(a);
        applications.appendChild(b);

        c = new ApfsFile(home, "c", 10);
        d = new ApfsFile(home, "d", 10);
        code = new ApfsDirectory(home, "code");
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(code);

        e = new ApfsFile(code, "e", 10);
        f = new ApfsFile(code, "f", 10);
        code.appendChild(e);
        code.appendChild(f);

        x = new ApfsLink(home, "x", applications);
        y = new ApfsLink(code, "y", b);
        home.appendChild(x);
        code.appendChild(y);

        System.out.println("Root total size: " + root.getTotalSize());
        LinkedList<ApfsElement> rootChildren = root.getChildren();
        for (ApfsElement child : rootChildren) {
            System.out.println(child.getName());
        }
    }
}
