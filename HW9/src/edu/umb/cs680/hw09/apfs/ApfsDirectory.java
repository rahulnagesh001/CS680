package edu.umb.cs680.hw09.apfs;

import java.util.LinkedList;
import java.util.Date;
import java.util.Iterator;

import edu.umb.cs680.hw09.fs.FSElement;



public class ApfsDirectory extends ApfsElement{
	private String name;
	private String owner;
	private Date created;
	private Date lastModified;
	private ApfsDirectory parent;
	private int size;
	private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();
	
	public ApfsDirectory(ApfsDirectory parent, String name, int size, Date created, String owner, Date lastModified) {
		this.name = name;
		this.size = size;
		this.owner = owner;
		this.created = created;
		this.lastModified = lastModified;
		this.parent = parent;
	}
	 
	@Override
	public boolean isLeaf(){
		return false;
	}
	public String getName(){
		return this.name;
	}
	
	public ApfsDirectory getParent(){
		return this.parent;
	}
	
	@Override
	public int getSize(){
		return this.size;
	}
	
	@Override
	public Date getCreationTime(){
		return this.created;
	}

	public LinkedList<ApfsElement> getChildren() {
		return children;	
	}
	public void appendChild(ApfsElement child){
		children.add(child);
	}
	
	public void AddChild(ApfsDirectory parent, ApfsElement child){
		parent.appendChild(child);
	}
	
	/*
	 * public void accept(FSVisitor v) { v.visit(this); for (ApfsElement e:
	 * children) { e.accept(v); } }
	 */
	
	public int getTotalSize(){
		Iterator<ApfsElement> childIterator = getChildren().iterator();
		int count = 0;
		
		while(childIterator.hasNext()) {
			FSElement e = childIterator.next();
			 if(e.isLeaf()){
			    count += e.getSize();
			 }
			 else {
				 count +=0;
				 ((ApfsDirectory) e).getSubDirectories();
			 }
		}
		return count;
	}
	
	public void getSubDirectories() {
	
		Iterator<ApfsElement> childIterator = getChildren().iterator();
		while(childIterator.hasNext()) {
			FSElement e = childIterator.next();
			 if(e.isLeaf()){
			    System.out.println(" -> "+ e.getName());
			 }
			 else {
				 System.out.println(" .......");
				 System.out.println("|"+e.getName() +"|");
				 System.out.println(" .......");
				 ((ApfsDirectory) e).getSubDirectories();
			 }
		}
		
	}

}
