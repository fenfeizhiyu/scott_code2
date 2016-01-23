package org.apache.mylog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.CharBuffer;

public class FileSource {

	private String basePath="";
	private File srcFileDir=null;
	

	FileSource(String path)
	{
		this.basePath=path;
		init();
	}
	
	private void init()
	{
		 srcFileDir=new File(basePath);
		if(!srcFileDir.exists())
		{
			srcFileDir.mkdirs();
		}
	}
	
	
	public String[] getFileNames()
	{
		File[] files=srcFileDir.listFiles();
		if(files!=null&&files.length>0)
		{
			String[] res=new String[files.length];
			for(int i=0;i<files.length;i++)
			{
				res[i]=files[i].getName();
			}
			return res;
		}
		else
			return null;
	}
	
	public String[] getFilesPath()
	{
		File[] files=srcFileDir.listFiles();
		if(files!=null&&files.length>0)
		{
			String[] res=new String[files.length];
			for(int i=0;i<files.length;i++)
			{
				res[i]=basePath+File.separator+files[i].getName();
			}
			return res;
		}
		else
			return null;
	}
	
	public Byte[] readFileByte(String filePath)
	{
		return null;
	}
	
	public String readFileString(String filePath)
	{
		File file=new File(filePath);
		BufferedReader bfd=null;
		StringBuilder sb=new StringBuilder(300);
		try
		{
			bfd=new BufferedReader(new FileReader(file));
			boolean flag=true;
			
			while(flag)
			{
				String s=bfd.readLine();
				if(s==null)
				{
					flag=false;
					break;
				}else
				{
					sb.append(s);
				}
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bfd.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	
}
