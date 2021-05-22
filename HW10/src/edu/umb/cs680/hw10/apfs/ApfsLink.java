package edu.umb.cs680.hw10.apfs;

import java.util.Date;
import edu.umb.cs680.hw10.fs.FSElement;
import edu.umb.cs680.hw10.fs.FileSystem;
import edu.umb.cs680.hw10.fs.FSVisitor;

public class ApfsLink extends ApfsElement {
	static Date d1 = new Date();
	static Date m1 = new Date();
	private String name;
	private String owner;

	ApfsElement target;
	public ApfsElement getTarget() {
		return target;
	}


	public ApfsLink(ApfsDirectory parent, String name, int size, Date created, String owner, Date lastModified, ApfsElement target) 
	{
		super(parent, name, size, d1, owner, m1);
		this.name = name;
		this.owner = owner;
		this.target = target;
	}
	public int getSize(){
		return 0;
	}
	
	public int getTargetSize(){
		return target.getSize();
	}
	
	@Override
	public boolean isLink(){
		return true;
	}
	
	public String getName(){
		return this.name + " (Link)";
	}
	
	public String getTargetName(){
		return target.getName();
	}
	
	
	  public void accept(FSVisitor v) { v.visit(this); }
	 


}
