package com.liguo.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solve.Compiler;



@WebServlet("/HelloWord")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
   public static String wordAnalyFile="词法分析的信息";
	public static String langAnalyFile="语法分析的信息";
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
	String sourceFile=request.getParameter("source");/////////////////
	
	String fileName1="/temp/test.txt";
	
	String filePath1=this.getServletContext().getRealPath(fileName1);
	File file1=new File(filePath1);
	
	if(!file1.exists())file1.createNewFile();
	
	BufferedWriter bWriter=new BufferedWriter(new FileWriter(file1));
	 
	System.out.println(sourceFile);
	
	bWriter.write(sourceFile);
	bWriter.flush();
	bWriter.close();
	
	
	String result=null;
	String fileName="/temp/test.txt";
	String filePath=this.getServletContext().getRealPath(fileName);
    File file=new File(filePath);
		try {
			
			
			String s=null;
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((s=br.readLine())!=null)
			{
				result=result+"\n"+s;
			}
		    br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	
	
	
	
	request.setAttribute("sourceResult", sourceFile);
	
	int index=result.indexOf("program");
	result=result.substring(index);
	
	com.solve.Compiler compiler=new Compiler(result);/////////////////////////
	
	request.setAttribute("wordAnalyResult", wordAnalyFile);

	request.setAttribute("langAnalyResult", langAnalyFile);
	request.getRequestDispatcher("/result.jsp").forward(request,response);
	}
	
}
