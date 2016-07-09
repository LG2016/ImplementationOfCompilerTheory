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
		Button openButton=new Button("打开源文件");//打开源文件
		openButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openDialog.setVisible(true);
				
			}
		});
		
		Button wordAnalyButton=new Button("进行词法分析");//添加词法分析按钮
		wordAnalyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		Button openWordAnalyFileButton=new Button("打开词法分析文件");//打开词法分析文件
		openWordAnalyFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button langageAnalyButton=new Button("进行LL1语法分析");//添加语法分析按钮
		langageAnalyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		Button openlangageAnalyFileButton=new Button("打开语LL1语法分析文件");//打开语法分析文件按钮
		langageAnalyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button openHelpMeaageButton=new Button("打开语LL1语法分析文件");//添加帮助文档
		openHelpMeaageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Panel northPanel=new Panel();
		Panel  southPanel=new Panel();
		
		northPanel.setLayout(new FlowLayout());
		JTextField topJTextField=new JTextField("词法分析  and   LL(1)语法分析器");
		topJTextField.setFont(new Font("宋体", Font.PLAIN, 20));
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
		frame.add(northPanel, BorderLayout.CENTER);//在布局的中部设置面板
		frame.add(southPanel, BorderLayout.SOUTH);//在布局南部设置面板
		
		frame.setBounds(500, 300, 500, 500);
		frame.setVisible(true);
		
	}

}
