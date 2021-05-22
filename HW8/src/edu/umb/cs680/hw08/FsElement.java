package edu.umb.cs680.hw08;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FsElement {
private String name;
private int size;
private static LocalDateTime creationtime; 
private Directory parent;
LocalDateTime now=LocalDateTime.now();

FsElement(Directory parent, String name, int size, LocalDateTime creationtime) {
	this.parent=parent;
	this.name=name;
	this.size=size;
	FsElement.creationtime=creationtime;
	
	if(parent!=null){ 
		parent.addChild(this);
           }
	
	}

public Directory getparent(){
	return this.parent;
	}

public String getName() {
	return name;
	}

public void setName(String name) {
	this.name=name;
	}

public String getTime() {
   
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM");
    String time=creationtime.format(formatter);
	return time;
	}

public int getSize() {
	FsElement dir= this;
	
	if(dir.isFile()==true) 
		{
		return size;
		} else
			{
			Directory d=(Directory) dir;
			int i;
			int z=0;
			z=d.getFiles().size();
			for(i=0;i<d.getSubDirs().size();i++){		
			z=z+d.getSubDirs().get(i).getFiles().size();	
				}
			this.size=z;
			return size;
			}
	}

public boolean isFile() {
	if(this instanceof File) 
		return true;
	
	else return false;
	}

public boolean isLink() {
        if(this instanceof Link)
            return true;        
        else return false;
    }
}
