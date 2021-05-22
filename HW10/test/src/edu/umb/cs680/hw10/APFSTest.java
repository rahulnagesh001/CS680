package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.apfs.APFS;
import edu.umb.cs680.hw10.apfs.ApfsDirectory;
import edu.umb.cs680.hw10.apfs.ApfsElement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class APFSTest {
	APFS apfs = new APFS();
	private String name = "home";
	private int capacity = 3000;
	
	@Test
	public void MakingSingleapfsTest() {
		APFS apfs1 = APFS.getInstance();
		APFS apfs2 = APFS.getInstance();
		assertEquals(apfs1.hashCode(), (apfs2.hashCode()));
	}
	
	@Test
	public void GetSingleRootTest() {
		 apfs.initFileSystem(name, capacity);
		 APFS apfs = APFS.getInstance();
		 ApfsDirectory root = apfs.getRootDir();
		 ApfsDirectory expected = root.getParent();
		 ApfsDirectory actual = null;
		 assertEquals(actual, (expected));
	}
	
	@Test
	public void apfsCapacityTest() {
		 apfs.initFileSystem(name, capacity);
		 int actual = apfs.getCapacity();
		 int expected = 3000;
		 assertEquals(actual, (expected));
	}


}