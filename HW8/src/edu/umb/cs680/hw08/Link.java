package edu.umb.cs680.hw08;
import java.time.LocalDateTime;

public class Link extends FsElement {
     FsElement target;
     int size;
	 public Link(Directory parent,String name,int size,LocalDateTime creationtime,FsElement target){
		 super(parent, name, size, creationtime);
		 this.size=0;
		 this.target=target;}
	 
	 public FsElement getTarget(){
		 return this.target;
	 }
	 
	 public int getSize() {
			return size;
		}
		
		public int getTargetSize() {
			if(target instanceof Link)
				return ((Link) target).getTargetSize();
			else 
				return target.getSize();
		}
}
