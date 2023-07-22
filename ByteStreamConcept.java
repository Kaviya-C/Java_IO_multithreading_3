package com.multithreading.end.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamConcept 
{
	public static void main(String...args)
	{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream("C:\\Users\\kaviy\\Kaviya_Eclipse_2023_03 _Workspace\\OnlineLearning\\src\\com\\multithreading\\end\\java\\io\\Demo.png");
			fos=new FileOutputStream("C:\\Users\\kaviy\\Kaviya_Eclipse_2023_03 _Workspace\\OnlineLearning\\src\\com\\multithreading\\end\\java\\io\\Output.png");
		     int temp;
		     while((temp=fis.read())!=-1)
		     {
		    	 fos.write(temp);
		     }
		
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(fis!=null)
			{
				try
				{
					fis.close();
				}
				catch(IOException e)
				{
					System.out.println(e.getMessage());
				}
			}
			if(fos!=null)
			{
				try
				{
					fos.close();
				}
				catch(IOException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		
		
	}

}
