package edu.umb.cs680.hw10.apfs;

import java.util.Date;
import edu.umb.cs680.hw10.fs.FSElement;
import edu.umb.cs680.hw10.fs.FSVisitor;

public class ApfsElement extends FSElement {
	private ApfsDirectory parent;
	private String name;
	private String owner;
	private Date created;
	private Date lastModified;
	private int size;
	
	public ApfsElement(ApfsDirectory parent, String name, int Size, Date created, String owner, Date lastModified) {
		this.name = name;
		this.size = size;
		this.owner = owner;
		this.created = created;
		this.lastModified = lastModified;
		this.parent = parent;
	}
	public ApfsElement() {
	}
	
	public ApfsDirectory getParent(){
		return this.parent;
	}
	
	public boolean isLeaf(){
		return false;
	}
	
	public boolean isLink(){
		return false;
	}
		
	public int getSize(){
		return this.size;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Date getCreationTime(){
		return this.created;
	}
	
	
	 public void accept(FSVisitor v) { return; }
	 
}