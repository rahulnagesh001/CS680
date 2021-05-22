package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.fs.FSElement;
import edu.umb.cs680.hw09.fs.FileSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class ApfsLinkTest {
	FileSystem fs = FileSystem.getInstance();
	static Date d1 = new Date();
	static Date m1 = new Date();
	ApfsDirectory root;
	ApfsLink link;
	
	private String[] dirToStringArray(ApfsLink l){
		String[] dirInfo = {
			String.valueOf(l.isLink()), l.getName(),  
			l.getParent().getName(),
			l.getTargetName(),
			String.valueOf(l.getTargetSize())
		};
		return dirInfo; 
	}
	@Test
	public void test_ApfsLinkTargetSizeName() {
		root = new ApfsDirectory(null, "RootDir", 0, d1, "Rahul", m1);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, d1, "Rahul", m1);
		ApfsDirectory games = new ApfsDirectory(home, "games", 0, d1, "Rahul", m1);	
		ApfsFile file = new ApfsFile(games, "Pacman", 300, d1, "Rahul", m1);
		fs.setRoot(root);
		fs.AddChild(root, home);
		fs.AddChild(home, games);
		fs.AddChild(games, file);
	
		 link = new ApfsLink(home, "link", 0, d1, "Rahul", m1, file);
		 
		String[] expected = {"true", "link (Link)", "home", "Pacman", "300"}; 
		assertArrayEquals(expected, dirToStringArray(link) );
	}
		
}
