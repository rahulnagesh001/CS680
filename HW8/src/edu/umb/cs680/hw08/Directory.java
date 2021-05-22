package edu.umb.cs680.hw08;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FsElement{
    
    public Directory(Directory parent, String name, int size, LocalDateTime creationtime) {
        super(parent, name, size, creationtime);
        if(parent!=null){
            parent.addSubDir(this);
        }
        
    }
    
    LinkedList<FsElement> children = new LinkedList<FsElement>();
    LinkedList<Directory> directory = new LinkedList<Directory>();
    LinkedList<File> file = new LinkedList<File>();
    
    public LinkedList<FsElement> getChildren(){
        return this.children;
    }
    //appendChild
    public void addChild(FsElement child ){
        this.children.add(child);
    }
    //countChildren
    public int getChildCount(){
        return children.size();
    }
    //appendSubDirectory
    public void  addSubDir(Directory sb){
        this.directory.add(sb);
    }
    //getSubDirectories
    public LinkedList<Directory> getSubDirs(){
        return this.directory;
    }
    //appendFile
    public void addFile(File f){
        this.file.add(f);
    }
    
    public LinkedList<File> getFiles(){
        return this.file;
    }
    
    public int getTotalsize(){
        FsElement dir= this;
        Directory d=(Directory) dir;
        int i;
        int z=0;
        for(i=0;i<d.getChildren().size();i++){
            z=z+d.getChildren().get(i).getSize();
        }
        return z;
    }
    
}

