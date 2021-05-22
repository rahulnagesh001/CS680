package edu.umb.cs680.hw08;
import java.util.LinkedList;

public class FileSystem  {
    
	private FileSystem() {};
	private static FileSystem instance = null;
	public static FileSystem getFileSystem() {
	if (instance == null) {
			instance = new FileSystem();
		}
		return instance;
	}
	
	LinkedList<Directory> directory1 =new LinkedList<Directory>();
	
	public void addRootDir(Directory d){
		      
		      this.directory1.add(d); 
	}
	
	public LinkedList<Directory> getRootDirs(){
		return this.directory1;
	}
	

		
	
	
		
}
