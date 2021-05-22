package edu.umb.cs680.hw10;
import edu.umb.cs680.hw10.fs.FSElement;
import edu.umb.cs680.hw10.fs.FileSystem;
import edu.umb.cs680.hw10.fs.FSVisitor;
import edu.umb.cs680.hw10.apfs.ApfsDirectory;
import edu.umb.cs680.hw10.apfs.ApfsFile;
import edu.umb.cs680.hw10.apfs.ApfsLink;


public class ApfsVirusCheckingVisitor implements FSVisitor {
	
	private int quarantined = 0;
		
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
		if (file.getName().contains("virus")) {
			quarantined++;
		}
	}
	
	public int getQuarantinedNum() {
		return quarantined;
	}
}