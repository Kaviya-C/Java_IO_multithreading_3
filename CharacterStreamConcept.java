package com.multithreading.end.java.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamConcept
{
	public static void main(String...args)
	{
		FileReader f=null;
		FileWriter fw=null;
		
		try
		{
			f=new FileReader("C:\\Users\\kaviy\\Kaviya_Eclipse_2023_03 _Workspace\\OnlineLearning\\src\\com\\multithreading\\end\\java\\io\\Sample.txt");
			fw=new FileWriter("C:\\Users\\kaviy\\Kaviya_Eclipse_2023_03 _Workspace\\OnlineLearning\\src\\com\\multithreading\\end\\java\\io\\new.txt");
		    
			int temp;
			
			while((temp=f.read())!=-1)
			{
				System.out.println(temp);
				fw.write(temp);
			}
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		 finally
	        {
	            if (f != null) 
	            {
	                try
	                {
	                    f.close();
	                } 
	                catch (IOException e) 
	                {
	                    e.printStackTrace();
	                }
	            }
	             
	            if (fw != null)
	            {
	                try
	                {
	                    fw.close();
	                } 
	                catch (IOException e) 
	                {
	                    e.printStackTrace();
	                }
	            }
	        }
	}

}
