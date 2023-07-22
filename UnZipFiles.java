package com.multithreading.end.java.io;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
public class UnZipFiles 
{
	public static void unZipFile(String sourcePath,String destPath) throws IOException
	{
	
	Path destination =Paths.get(destPath).normalize();
	
	if( !Files.exists(destination))
	{
		Files.createDirectory(destination);
	}
	
	FileInputStream input=new FileInputStream(sourcePath);
	ZipInputStream zip=new ZipInputStream(input);
	
	ZipEntry entry=zip.getNextEntry();
	
	while(entry!=null)
	{
		Path path=destination.resolve(entry.getName()).normalize();
	
	     if(! path.startsWith(destination))
	     {
	    	 System.out.println(" Invalid zip entry ");
	     }
	     if(entry.isDirectory())
	     {
	    	 Files.createDirectory(path);
	     }
	     else
	     {
	    	 BufferedOutputStream bos=new BufferedOutputStream(Files.newOutputStream(path));
	       byte[] b=new byte[1024];
	       
	       while(zip.read(b) >=0)
	       {
	    	   bos.write(b, 0, b.length);
	       }
	       bos.close();
	     }
	     zip.closeEntry();
	     entry=zip.getNextEntry();
	     
	}
	
	zip.close();input.close();
	
	}
	public static void main(String...args) throws IOException
	{
		unZipFile("C:\\Users\\kaviy\\Kaviya_Eclipse_2023_03 _Workspace\\OnlineLearning\\src\\com\\multithreading\\end\\java\\io\\Zipped.zip","C:\\Users\\kaviy\\Kaviya_Eclipse_2023_03 _Workspace\\OnlineLearning\\src\\com\\multithreading\\end\\java\\io\\UnZipped");
		
	}

}
