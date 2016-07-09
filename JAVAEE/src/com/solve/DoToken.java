package com.solve;
import java.util.ArrayList;
import java.util.List;

public class DoToken {
	public static List<String> identifier; // 标识符列表
	public static List<String> INTC; // 常量列表
	
	public static boolean isIdentifier(String s) { // 标识符自动机
		if (!Data.L.contains(s.charAt(0))) {
			return false;
		}
		for (int i = 1; i < s.length(); i++) {
			if (!Data.L.contains(s.charAt(i)) && !Data.D.contains(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean isINTC(String s) { // 数字常量自动机
		if (s.charAt(0) == '0') {
			if (s.length() == 1) {
				return true;
			} else {
				return false;
			}
		}
		if (!Data.D1.contains(s.charAt(0))) {
			return false;
		}
		for (int i=1; i < s.length(); i++) {
			if (!Data.D.contains(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean doToken(String s) { // 词法分析主方法
		identifier = new ArrayList<String>(); // 每次调用词法分析方法时要先重新初始化各列表和缓冲字符串
		INTC = new ArrayList<String>();//实例化一个常量列表
		
		Data.token = new ArrayList<Token>();//实例化一个内部表示taken列表
		Data.tokenShow = new StringBuffer();//token显示的字符串缓存
		Data.tokenShow2 = new StringBuffer();//测试token的字符串缓存
		
		int line = 1; // 行数初始化为1
		String ss; // s是全部的字符串，ss是分隔出的字符串
		StringBuffer sb = new StringBuffer(); // sb用来保存分隔中的字符串
		Token t; // 新建的token对象
		for (int i = 0; i < s.length(); i++) { // 从源程序中一个字符一个字符地进行读取，并逐个分离出单词，然后构造它们的机内表示Token
			if (s.charAt(i) != ' ' && s.charAt(i) != '\n' && s.charAt(i) != '\t'
					&& !Data.separator.contains(String.valueOf((s.charAt(i))))) { // 如果该字符不是分隔符则直接追加到sb中
				sb.append(s.charAt(i));//如果读入的是一个单词就追加到sb中
			} else { // 如果该字符是分隔符
				// 处理分离出的单词
				if (sb.length() != 0) { // 若分离出的单词长度为零，则跳过此部分而直接进入后面的分隔符生成部分
					ss = sb.toString();
					if (Character.isLetter(ss.charAt(0))) {//判断单词第一个字符是不是字母，是的话要么是保留字，要么是标识符
						if (Data.reservedWord.contains((ss))) { // 如果分隔出的字符串是保留字则在token和tokenShow都要追加
							t = new Token(2, Data.reservedWord.indexOf(ss),line);//保留字Token  2类   保留字列表的下标  当前保留字在那一行
							Data.token.add(t);//将当前保留字token放入token列表中
							Data.tokenShow.append("(2," + ss + ")");//将保留字按照外部表示存放到tokenshow中
							Data.tokenShow2.append("("+line+",2," + Data.reservedWord.indexOf(ss)//将保留字按照内部表示形式存放到tokenshow中
									+ ")");
						} else if (isIdentifier(ss)) { // 如果分隔出的字符串是标识符则在token和tokenShow都要追加
							if (!identifier.contains(ss)) {//查找标识符列表中是否有当前的输入的单词
								identifier.add(ss); // 如果标识符列表中没有该标识符则添加
							}
							t = new Token(3, identifier.indexOf(ss),line);//标识符的token表示，3类   在标识符列表的下标   当前哪一行
							Data.token.add(t);//将标识符token添加到Token列表中
							Data.tokenShow.append("(3," + ss + ")");//标识符的外部表示
							Data.tokenShow2.append("("+line+",3," + identifier.indexOf(ss)//标识符的内部表示
									+ ")");
						} else {//不是标识符也不是保留字，给出错误提示信息
							// 用*号行标识的代码行为方法的可能出口
							// ************************************************************************************************
							Data.tokenShow.append("\n词法分析失败：第" + line + "行发生词法错误：无法识别\""//类部表示的错误提示信息
									+ ss + "\"");
							Data.tokenShow2.append("\n词法分析失败：第" + line + "行发生词法错误：无法识别\""//外部表示的类部提示信息
									+ ss + "\"");
							return false;
						}
					} else { //第一个字符不是字母
						if (isINTC(ss)) {// 如果是数字常量
							if (!INTC.contains(ss)) { // 如果数字常量列表中没有该数字常量则添加
								INTC.add(ss);
							}
							t = new Token(4, INTC.indexOf(ss),line);
							Data.token.add(t);
							Data.tokenShow.append("(4," + ss + ")");
							Data.tokenShow2.append("("+line+",4," + INTC.indexOf(ss) + ")");
						} else {
							// ************************************************************************************************
							Data.tokenShow.append("\n词法分析失败：第" + line + "行发生词法错误：无法识别\""
									+ ss + "\"");
							Data.tokenShow2.append("\n词法分析失败：第" + line + "行发生词法错误：无法识别\""
									+ ss + "\"");
							return false;
						}
					}
					sb = new StringBuffer(); // 重新初始化用以分离单词的缓冲字符串
				}
				// 处理分隔符
				if (s.charAt(i) == ' ') { // 如果分隔符是空格则在tokenShow中追加空格
					Data.tokenShow.append(" ");
					Data.tokenShow2.append(" ");
					continue;
				}
				if (s.charAt(i) == '\n') { // 如果分隔符是换行符则在tokenShow中追加空格
					line++; // 将行号+1
					Data.tokenShow.append("\n");
					Data.tokenShow2.append("\n");
					continue;
				}
				if (s.charAt(i) == '\t') { // 如果分隔符是制表符则在tokenShow中追加制表符
					Data.tokenShow.append("\t");
					Data.tokenShow2.append("\t");
					continue;
				}
				if (s.charAt(i) == ':') {
					if (s.charAt(++i) == '=') {
						t = new Token(1, Data.separator.indexOf(":="),line); // 如果分隔符是赋值符则在token和tokenShow都要追加
						Data.token.add(t);
						Data.tokenShow.append("(1,:=)");
						Data.tokenShow2.append("("+line+",1," + Data.separator.indexOf(":=") + ")");
						continue;
					} else {
						// ************************************************************************************************
						Data.tokenShow.append("\n词法分析失败：第" + line
								+ "行发生词法错误：\":\"后应该接\"=\"");
						Data.tokenShow2.append("\n词法分析失败：第" + line
								+ "行发生词法错误：\":\"后应该接\"=\"");
						return false;
					}
				}
				if (s.charAt(i) == '.') {
					if((i+1)!=s.length() && s.charAt(i+1)=='.'){ // 如果是..则在token和tokenShow都要追加
						t = new Token(1, Data.separator.indexOf(".."),line); // 如果分隔符是数组间符则在token和tokenShow都要追加
						Data.token.add(t);
						Data.tokenShow.append("(1,..)");
						Data.tokenShow2.append("("+line+",1," + Data.separator.indexOf("..") + ")");
						i++;
						continue;
					}
					// 如果分隔符是域作用符或程序结束符则在token和tokenShow都要追加
					t = new Token(1, Data.separator.indexOf("."),line);
					Data.token.add(t);
					Data.tokenShow.append("(1,.)");
					Data.tokenShow2.append("("+line+",1," + Data.separator.indexOf(".") + ")");
					if((i+1)==s.length() || s.charAt(i+1)==' ' || s.charAt(i+1)=='\n' || s.charAt(i+1)=='\t'){ // 如果已到程序末尾或未达末尾但其后字符为空格、回车或制表符则结束词法分析
						// *********************************************************************
						Data.tokenShow.append("\n词法分析成功！");
						Data.tokenShow2.append("\n词法分析成功！");
						return true;
					}
					continue;
				}
				t = new Token(1, Data.separator.indexOf(String.valueOf(s.charAt(i))),line); // 如果分隔符是赋值符则在token和tokenShow都要追加
				Data.token.add(t);
				Data.tokenShow.append("(1," + s.charAt(i) + ")");
				Data.tokenShow2.append("("+line+",1,"
						+ Data.separator.indexOf(String.valueOf(s.charAt(i))) + ")");
			}
		}
		// ************************************************************************************************
		if (sb.length() != 0) { // 若程序结束时分离出的单词长度不为零，则处理为相应的Token（尽管词法分析已失败，因为程序未能成功结束）
			ss = sb.toString();
			if (Character.isLetter(ss.charAt(0))) {
				if (Data.reservedWord.contains((ss))) { // 如果分隔出的字符串是保留字则在token和tokenShow都要追加
					t = new Token(2, Data.reservedWord.indexOf(ss),line);
					Data.token.add(t);
					Data.tokenShow.append("(2," + ss + ")");
					Data.tokenShow2.append("("+line+",2," + Data.reservedWord.indexOf(ss)
							+ ")");
				} else if (isIdentifier(ss)) { // 如果分隔出的字符串是标识符则在token和tokenShow都要追加
					if (!identifier.contains(ss)) {
						identifier.add(ss); // 如果标识符列表中没有该标识符则添加
					}
					t = new Token(3, identifier.indexOf(ss),line);
					Data.token.add(t);
					Data.tokenShow.append("(3," + ss + ")");
					Data.tokenShow2.append("("+line+",3," + identifier.indexOf(ss)
							+ ")");
				} else {
					// 用*号行标识的代码行为方法的可能出口
					// ************************************************************************************************
					Data.tokenShow.append("\n词法分析失败：第" + line + "行发生词法错误：无法识别\""
							+ ss + "\"");
					Data.tokenShow2.append("\n词法分析失败：第" + line + "行发生词法错误：无法识别\""
							+ ss + "\"");
					return false;
				}
			} else { // 如果是数字常量
				if (isINTC(ss)) {
					if (!INTC.contains(ss)) { // 如果数字常量列表中没有该数字常量则添加
						INTC.add(ss);
					}
					t = new Token(4, INTC.indexOf(ss),line);//数字常量的token，4类    数字在数字列表中所在的位置   当前的行号
					Data.token.add(t);//将数字常量添加到Token列表中
					Data.tokenShow.append("(4," + ss + ")");//外部表示
					Data.tokenShow2.append("("+line+",4," + INTC.indexOf(ss) + ")");//类部表示
				} else {//单词不是数字
					// ************************************************************************************************
					Data.tokenShow.append("\n词法分析失败：第" + line + "行发生词法错误：无法识别\""
							+ ss + "\"");
					Data.tokenShow2.append("\n词法分析失败：第" + line + "行发生词法错误：无法识别\""
							+ ss + "\"");
					return false;
				}
			}
			sb = new StringBuffer(); // 重新初始化用以分离单词的缓冲字符串
		}
		Data.tokenShow.append("\n词法分析失败：程序未能正常结束");
		Data.tokenShow2.append("\n词法分析失败：程序未能正常结束");
		return false;
	}
}
