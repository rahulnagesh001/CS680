package edu.umb.cs680.hw09.apfs;


import java.util.Date;


public class ApfsFile extends ApfsElement {
	private String name;
	private String owner;
	private Date created;
	private Date lastModified;
	private ApfsDirectory parent;
	private int size;
	
	public ApfsFile(ApfsDirectory parent, String name, int size, Date created, String owner, Date lastModified) {
		this.name = name;
		this.size = size;
		this.owner = owner;
		this.created = created;
		this.lastModified = lastModified;
		this.parent = parent;
	}

	public int getSize(){
		return this.size;
	}
	public String getName(){
		return this.name;
	}
	
	@Override
	public boolean isLeaf(){
		return true;
	}
	
	public ApfsDirectory getParent(){
		return this.parent;
	}
	
	
}
