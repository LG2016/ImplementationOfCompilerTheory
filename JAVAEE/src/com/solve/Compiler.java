package com.solve;

import com.liguo.servlet.HelloWorldServlet;


public class Compiler  {
	
	public Compiler(String Text){
		
		boolean flage=false;//Ĭ��Ϊ�ʷ��������ɹ�
		String wordReuslt=null;//�ʷ������Ľ��
		String langResult="�ʷ���������ȷ�޷������﷨������";//�﷨�����Ľ��
		Data.initialize();// ��ʼ���ָ����б��������б���Сд��ĸ��0-9���ֱ�1-9���ֱ�
							//�ռ��������ս��������SNL�Ĺ���
		
		
		
		      System.out.println(Text); 
		      
		     
						
						
						
						
						
						
				if(DoToken.doToken(Text)){//���дʷ���������������������������
				//displayJTA.getText()--------�����в�����ı����ж�ȡ�����Ҫ����Դ�ļ�������
					//�����ڷ����Ĺ����гɹ�������ಿ��ʾ��ʽtokenShow���ⲿ��ʾ��ʽtokenShow2
					
				///////////////////////////////////////////////////////////	
				  flage=true;
				}else{
					flage=false;//�ʷ��������ɹ����﷨������ť���ǲ��ɼ�
				}
				
					wordReuslt= Data.tokenShow.toString();//���в��ұ��ı���������ⲿ��ʾ�Ĵʷ��������
				
		
		
		       if(flage){
	
				  langResult= DoGrammar.doGrammar();//���в��ұ��ı�������ʾ�﷨�����Ľ��
														   //��������������������������������
		       }
		HelloWorldServlet.wordAnalyFile=wordReuslt;
		HelloWorldServlet.langAnalyFile=langResult;
	}
	
		
	


}
