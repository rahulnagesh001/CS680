package edu.umb.cs680.hw10;


import java.util.ArrayList;

import edu.umb.cs680.hw10.fs.FSElement;
import edu.umb.cs680.hw10.fs.FileSystem;
import edu.umb.cs680.hw10.fs.FSVisitor;
import edu.umb.cs680.hw10.apfs.ApfsDirectory;
import edu.umb.cs680.hw10.apfs.ApfsFile;
import edu.umb.cs680.hw10.apfs.ApfsLink;


public class ApfsFileCrawlingVisitor implements FSVisitor {

	private String item;
	private ArrayList<ApfsFile> files= new ArrayList<ApfsFile>();
	
	public ApfsFileCrawlingVisitor(String item) {
		this.item = item;
	}
	
 	@Override
	public void visit(ApfsLink link) {
		return;	
	}

	@Override
	public void visit(ApfsDirectory dir) {
		return;
	}

	@Override
	public void visit(ApfsFile file) {
		if (file.getName().contains(item)) {
			files.add(file);
		}
	}
	public ArrayList<ApfsFile> getFiles() {
		return files;	
	}

}