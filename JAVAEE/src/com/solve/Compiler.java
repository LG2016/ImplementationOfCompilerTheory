package com.solve;

import com.liguo.servlet.HelloWorldServlet;


public class Compiler  {
	
	public Compiler(String Text){
		
		boolean flage=false;//默认为词法分析不成功
		String wordReuslt=null;//词法分析的结果
		String langResult="词法分析不正确无法进行语法分析！";//语法分析的结果
		Data.initialize();// 初始化分隔符列表、保留字列表、大小写字母表、0-9数字表、1-9数字表
							//终极符表、非终结符符表、和SNL的规则
		
		
		
		      System.out.println(Text); 
		      
		     
						
						
						
						
						
						
				if(DoToken.doToken(Text)){//进行词法分析，？？？？？？？？？？
				//displayJTA.getText()--------》从中部左边文本域中读取输出的要分析源文件的内容
					//并且在分析的过程中成功构造好类部表示形式tokenShow和外部表示形式tokenShow2
					
				///////////////////////////////////////////////////////////	
				  flage=true;
				}else{
					flage=false;//词法分析不成功，语法分析按钮还是不可见
				}
				
					wordReuslt= Data.tokenShow.toString();//在中部右边文本域中输出外部表示的词法分析结果
				
		
		
		       if(flage){
	
				  langResult= DoGrammar.doGrammar();//在中部右边文本域中显示语法分析的结果
														   //？？？？？？？？？？？？？？？？
		       }
		HelloWorldServlet.wordAnalyFile=wordReuslt;
		HelloWorldServlet.langAnalyFile=langResult;
	}
	
		
	


}
