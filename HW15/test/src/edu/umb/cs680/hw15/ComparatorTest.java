package edu.umb.cs680.hw15;

import edu.umb.cs680.hw15.APFS.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ComparatorTest {

    private String[] APFSElementToString(LinkedList<ApfsElement> elements) {
        String[] elems = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            elems[i] = elements.get(i).getName();
        }
        return elems;
    }

    private String[] APFSDirectoryToString(LinkedList<ApfsDirectory> elements) {
        String[] elems = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            elems[i] = elements.get(i).getName();
        }
        return elems;
    }

    private String[] APFSFileToString(LinkedList<ApfsFile> elements) {
        String[] elems = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            elems[i] = elements.get(i).getName();
        }
        return elems;
    }

    private static APFS apfs;
    private static ApfsDirectory root, applications, home, code;
    private static ApfsFile a, b, c, d, e, f;
    private static ApfsLink x, y;

    @BeforeAll
    public static void setUp() {
        apfs = new APFS("AnhVo");
        apfs.initFileSystem("Local Disk", 1000);
        root = apfs.getRootDir();

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

    
        root.setLastModified(LocalDateTime.of(2021, 5, 1, 12, 0));
        home.setLastModified(LocalDateTime.of(2021, 5, 3, 12, 0));
        applications.setLastModified(LocalDateTime.of(2021, 2, 5, 12, 0));
        code.setLastModified(LocalDateTime.of(2021, 5, 2, 12, 0));

        a.setLastModified(LocalDateTime.of(2021, 5, 5, 12, 0));
        b.setLastModified(LocalDateTime.of(2021, 5, 5, 12, 0));
        c.setLastModified(LocalDateTime.of(2021, 5, 6, 12, 0));
        d.setLastModified(LocalDateTime.of(2021, 5, 3, 12, 0));
        e.setLastModified(LocalDateTime.of(2021, 5, 5, 12, 0));
        f.setLastModified(LocalDateTime.of(2021, 5, 5, 12, 0));

        x.setLastModified(LocalDateTime.of(2021, 5, 4, 12, 0));
        y.setLastModified(LocalDateTime.of(2021, 5, 5, 12, 0));
    }

    @Test
    public void testGetChilrenOfRoot() {
        String[] expected = {"applications", "home"};
        LinkedList<ApfsElement> children = root.getChildren();
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSubDirOfRoot() {
        String[] expected = {"applications", "home"};
        LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories();
        String[] actual = APFSDirectoryToString(subDirectories);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSubDirOfRootReversedAlphabetical() {
        String[] expected = {"home", "applications"};
        LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories(Comparator.comparing((ApfsElement element) -> element.getName(), Comparator.reverseOrder()));
        String[] actual = APFSDirectoryToString(subDirectories);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetChilrenOfHome() {
        String[] expected = {"c", "code", "d", "x"};
        LinkedList<ApfsElement> children = home.getChildren();
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortChildrenOfHomeReverseAlphabetical() {
        String[] expected = {"x", "d", "code", "c"};
        LinkedList<ApfsElement> children = home.getChildren(Comparator.comparing((ApfsElement element) -> element.getName(), Comparator.reverseOrder()));
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortFileOfHomeReverseAlphabetical() {
        String[] expected = {"d", "c"};
        LinkedList<ApfsFile> files = home.getFiles(Comparator.comparing(ApfsElement::getName, Comparator.reverseOrder()));
        String[] actual = APFSFileToString((files));
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortChildrenOfTimeStampBased() {
        String[] expected = {"c", "x", "d", "code"};
        LinkedList<ApfsElement> children = home.getChildren(Comparator.comparing(ApfsElement::getLastModified, Comparator.reverseOrder()));
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }
}
