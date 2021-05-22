package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.apfs.ApfsDirectory;
import edu.umb.cs680.hw10.apfs.ApfsLink;
import edu.umb.cs680.hw10.apfs.ApfsFile;

public interface FSVisitor {
	public void visit(ApfsLink link);
	public void visit(ApfsDirectory dir);
	public void visit(ApfsFile file);
}
