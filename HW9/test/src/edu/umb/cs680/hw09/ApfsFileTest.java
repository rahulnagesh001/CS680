package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.fs.FileSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;


public class ApfsFileTest {
	
	FileSystem fs = FileSystem.getInstance();
	static Date d1 = new Date();
	static Date m1 = new Date();
	
	private String[] dirToStringArray(ApfsFile f){
		String[] dirInfo = {
			String.valueOf(f.isLeaf()), 
			f.getName(),  
			f.getParent().getName(),
			String.valueOf(f.getSize())
		};
		return dirInfo; 
	}

	
	@Test
	public void testFile() {
		
		String[] expected = {"true", "Pacman", "games", "300"};
		ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d1, "Rahul", m1);
		ApfsDirectory system = new ApfsDirectory(root, "system", 0, d1, "Rahul", m1);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, d1, "Rahul", m1);
		ApfsDirectory games = new ApfsDirectory(home, "games", 0, d1, "Rahul", m1);	
		ApfsFile actual = new ApfsFile(games, "Pacman", 300, d1, "Rahul", m1);
		fs.setRoot(root);
		fs.AddChild(root, home);
		fs.AddChild(root, system);
		fs.AddChild(home, games);
		fs.AddChild(games, actual);
		assertArrayEquals(expected, dirToStringArray(actual) ); 
		 	
	}
	
	
}