package complieofwordanaly;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

public class WordAnaly extends Frame {
	private static final long serialVersionUID = 1L;
   
	public static void main(String[] args) {
		WordAnaly wordAnaly=new WordAnaly();
		wordAnaly.init();
		

	}
    Frame frame=new Frame("compiling Analy");
	FileDialog openDialog=new FileDialog(frame, "open compilingFile",FileDialog.LOAD);
	private void init() {
		Button openButton=new Button("��Դ�ļ�");//��Դ�ļ�
		openButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openDialog.setVisible(true);
				
			}
		});
		
		Button wordAnalyButton=new Button("���дʷ�����");//��Ӵʷ�������ť
		wordAnalyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		Button openWordAnalyFileButton=new Button("�򿪴ʷ������ļ�");//�򿪴ʷ������ļ�
		openWordAnalyFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button langageAnalyButton=new Button("����LL1�﷨����");//����﷨������ť
		langageAnalyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		Button openlangageAnalyFileButton=new Button("����LL1�﷨�����ļ�");//���﷨�����ļ���ť
		langageAnalyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button openHelpMeaageButton=new Button("����LL1�﷨�����ļ�");//��Ӱ����ĵ�
		openHelpMeaageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Panel northPanel=new Panel();
		Panel  southPanel=new Panel();
		
		northPanel.setLayout(new FlowLayout());
		JTextField topJTextField=new JTextField("�ʷ�����  and   LL(1)�﷨������");
		topJTextField.setFont(new Font("����", Font.PLAIN, 20));
		topJTextField.setCaretColor(new Color(193,210,240));
		
	   northPanel.add(topJTextField);
	   
	   southPanel.setLayout(new GridLayout(2, 3, 5, 5));
	   southPanel.add(openButton);
	   southPanel.add(wordAnalyButton);
	   southPanel.add(langageAnalyButton);
	   
	   southPanel.add(openHelpMeaageButton);
	   southPanel.add(openWordAnalyFileButton);
	   southPanel.add(openlangageAnalyFileButton);
		
		frame.setLayout(new BorderLayout());
		frame.add(northPanel, BorderLayout.CENTER);//�ڲ��ֵ��в��������
		frame.add(southPanel, BorderLayout.SOUTH);//�ڲ����ϲ��������
		
		frame.setBounds(500, 300, 500, 500);
		frame.setVisible(true);
		
	}

}
