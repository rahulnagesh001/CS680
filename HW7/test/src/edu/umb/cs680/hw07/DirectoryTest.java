package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class DirectoryTest {

	static LocalDateTime localTime = LocalDateTime.now();
	
	Directory root = new Directory(null, "root", 0, localTime);
	Directory home = new Directory(root, "home", 0, localTime);
	Directory applications = new Directory(root, "applications", 0, localTime);
	Directory code = new Directory(home, "code", 0, localTime);
    

	File a = new File(applications, "a", 18, localTime);
	File b = new File(applications, "b", 17, localTime);
	File c = new File(home, "c", 28, localTime);
	File d = new File(home, "d", 29, localTime);
	File e = new File(code, "e", 25, localTime);
	File f = new File(code, "f", 8, localTime);
	
	private String[] dirToStringArray(Directory d) {
		String parentName = null;
		Directory parent = d.getParent();
		if (parent != null) {
			parentName = parent.getName();
		}
		String[] dirInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(),parentName, Integer.toString(d.countChildren()),Integer.toString(d.getTotalSize()) };
		return dirInfo;
	}

	@Test
	public void checkDirectory() {
		assertFalse(a.isDirectory());
		assertFalse(b.isDirectory());
		assertFalse(c.isDirectory());
		assertFalse(d.isDirectory());
		assertFalse(e.isDirectory());
		assertFalse(f.isDirectory());	
		assertTrue(root.isDirectory());
		assertTrue(home.isDirectory());
		assertTrue(applications.isDirectory());
		assertTrue(code.isDirectory());
		
	}
	
	
	  @Test public void checkFiles() {
		  assertTrue(a.isFile());
		  assertTrue(b.isFile());
		  assertTrue(c.isFile());
		  assertTrue(d.isFile());
		  assertTrue(e.isFile());
		  assertTrue(f.isFile());	
		  assertFalse(root.isFile());
		  assertFalse(home.isFile());
		  assertFalse(applications.isFile());
		  assertFalse(code.isFile());
	 }
	 
	
	@Test
	public void checkGetChildren() {
		assertEquals(applications, root.getChildren().get(1));
		assertEquals(home, root.getChildren().get(0));
		assertEquals(code,home.getChildren().get(0));
	}
	
	
	
	@Test
	public void checkCount() {
		assertEquals(2, root.countChildren());
		assertEquals(2, applications.countChildren());
		assertEquals(3, home.countChildren());
		assertEquals(2, code.countChildren());
	}

	@Test
	public void checkSize() {
		assertEquals(125, root.getTotalSize());
		assertEquals(90, home.getTotalSize());
		assertEquals(35, applications.getTotalSize());
		assertEquals(33, code.getTotalSize());
	}

	@Test
	public void checkSubDirectories() {
		assertSame("home", root.getSubDirectories().get(0).getName());
		assertSame("code",home.getSubDirectories().get(0).getName());
		assertSame("applications",root.getSubDirectories().get(1).getName());

	}

	@Test
	public void checkDirectoryRoot() {
		String[] expected = { "true", "root", "0", localTime.toString(), null, "2","125" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void checkDirectoryHome() {
		String[] expected = { "true", "home", "0", localTime.toString(),"root", "3","90" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}


	@Test
	public void checkDirectoryCode() {
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "2","33" };
		Directory actual = code;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	@Test
	public void checkDirectoryApplications() {
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "2","35" };
		Directory actual = applications;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
}