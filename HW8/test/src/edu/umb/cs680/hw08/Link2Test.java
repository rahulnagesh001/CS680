package edu.umb.cs680.hw08;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.format.DateTimeFormatter;

public class Link2Test {
    public static String[] dirToStringArray(Link L){
        
        String LinkInfo[] = {
        Boolean.toString(L.isLink()), L.getName(), Integer.toString(L.getSize()), L.getTime(), L.getTarget().getName(), Integer.toString(L.getTargetSize()), Integer.toString(L.getTarget().getSize())};
        int i;
        
        for(i=0;i<LinkInfo.length;i++) 
        {
            System.out.println(LinkInfo[i]);
        }
        return LinkInfo;
    }
    
    LocalDateTime creationtime=LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM");
    String time=creationtime.format(formatter);
    
    LocalDateTime creationtime1=LocalDateTime.now();
    Directory root=new Directory(null,"Root",0,creationtime );
    
   
    LocalDateTime creationtime2=LocalDateTime.now();
    Directory home=new Directory(root,"home",0,creationtime1 );
    Directory system=new Directory(root,"system",0,creationtime1 );
    Directory pictures=new Directory(home,"pictures",0,creationtime1 );
    File file_d=new File(home,"file:d",1,creationtime2 );
    File file_a=new File(system,"file:a",1,creationtime2 );
    File file_b=new File(system,"file:b",1,creationtime2 );
    File file_c=new File(system,"file:c",1,creationtime2 );
    File file_e=new File(pictures,"file:e",1,creationtime2 );
    File file_f=new File(pictures,"file:f",1,creationtime2 );
    Link a=new Link(home,"link:a",0,creationtime1,system);
    Link b=new Link(pictures,"link:b",0,creationtime1,file_e);
    
    @Test
    public void verifyDirectoryEqualityLinka() {
        String[] expected={"true","link:a","0",time,"system","3","3"};
        assertArrayEquals(expected,dirToStringArray(a));
    }
    
    @Test
    public void verifyDirectoryEqualityLinkb() {
        String[] expected={"true","link:b","0",time,"file:e","1","1"};
        assertArrayEquals(expected,dirToStringArray(b));
    }    
}


