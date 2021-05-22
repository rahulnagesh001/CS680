package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.fs.FSElement;
import edu.umb.cs680.hw10.fs.FileSystem;
import edu.umb.cs680.hw10.fs.FSVisitor;
import edu.umb.cs680.hw10.apfs.APFS;
import edu.umb.cs680.hw10.apfs.ApfsDirectory;
import edu.umb.cs680.hw10.apfs.ApfsFile;
import edu.umb.cs680.hw10.apfs.ApfsLink;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.ArrayList;

public class ApfsFileCrawlingVisitorTest {

	APFS fs = APFS.getInstance();
	static Date d1 = new Date();
	static Date m1 = new Date();
	ApfsDirectory root;
	ApfsFileCrawlingVisitor visitor;
	
	@Test
	public void getFilesTest1() {
		ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d1, "Azamk", m1);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, d1, "Azamk", m1);
		ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d1, "Azamk", m1);	
		ApfsFile f1 = new ApfsFile(pictures, "OOP1", 2000, d1, "Azamk", m1);
		ApfsFile f2 = new ApfsFile(pictures, "OOP2", 5000, d1, "Azamk", m1);
		fs.setRoot(root);
		fs.AddChild(root, home);
		fs.AddChild(home, pictures);
		fs.AddChild(pictures, f1);
		fs.AddChild(pictures, f2);
		ApfsLink a = new ApfsLink(home, "a", 0, d1, "Azamk", m1, f1);
		ApfsLink b = new ApfsLink(pictures, "b", 0, d1, "Azamk", m1, a);
		fs.AddChild(home, a);
		fs.AddChild(pictures, b);
		
		visitor = new ApfsFileCrawlingVisitor("OP");
		root.accept(visitor);
		
		int actual = visitor.getFiles().size();
		int expected = 2;
		assertEquals(actual, expected);
		
	}
	
	@Test
	public void getFilesTest2() {
		ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d1, "Azamk", m1);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, d1, "Azamk", m1);
		ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d1, "Azamk", m1);	
		ApfsFile f1 = new ApfsFile(pictures, "OOP", 2038, d1, "Azamk", m1);
		ApfsFile f2 = new ApfsFile(pictures, "jsx", 5000, d1, "Azamk", m1);
		fs.setRoot(root);
		fs.AddChild(root, home);
		fs.AddChild(home, pictures);
		fs.AddChild(pictures, f1);
		fs.AddChild(pictures, f2);
		ApfsLink a = new ApfsLink(home, "a", 0, d1, "Azamk", m1, f1);
		ApfsLink b = new ApfsLink(pictures, "b", 0, d1, "Azamk", m1, a);
		fs.AddChild(home, a);
		fs.AddChild(pictures, b);
		
		visitor = new ApfsFileCrawlingVisitor("OP");
		root.accept(visitor);
		
		String actual = visitor.getFiles().get(0).getName();
		String expected = "OOP";
		assertEquals(actual, expected);
		
	}

}
