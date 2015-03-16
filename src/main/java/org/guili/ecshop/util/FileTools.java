package org.guili.ecshop.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 文件操作工具类
 * @ClassName:   FileTools 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2013-11-28 上午10:47:48 
 */
public class FileTools {
	
	
	/**
	 * 读取文件
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String read(String filepath) throws FileNotFoundException, IOException {  
		String returnstr="";
        File file = new File(filepath);// 指定要读取的文件 
        // 获得该文件的缓冲输入流  
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));  
        String line = "";// 用来保存每次读取一行的内容  
        while ((line = bufferedReader.readLine()) != null) {  
        	returnstr=returnstr+line;
        }  
        bufferedReader.close();// 关闭输入流  
        return returnstr;
     }  
	
	 public static void appendToFile(String file, String conent) {  
	        BufferedWriter out = null;  
	        try {  
	            out = new BufferedWriter(new OutputStreamWriter(  
	                    new FileOutputStream(file, true)));  
	            out.write(conent);
	            out.newLine();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                out.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }
	 
	//写文件
	public static void write(String path, String content) {
		      String s1 = new String();
		      try {
		       File f = new File(path);
		       if (f.exists()) {
		        System.out.println("文件存在");
		       } else {
		        System.out.println("文件不存在，正在创建...");
		        if (f.createNewFile()) {
		         System.out.println("文件创建成功！");
		        } else {
		         System.out.println("文件创建失败！");
		        }
		       }
		       s1+=content;
		       BufferedWriter output = new BufferedWriter(new FileWriter(f));
		       output.write(s1);
		       output.close();
		      } catch (Exception e) {
		       e.printStackTrace();
		      }
		}
		public static void main(String[] args) {
			 String filename="E:/newProject/tmallbacktest.txt";
			 try {
					File file=new File(filename);
					if(!file.exists()){
						file.createNewFile();
					}
					FileTools.appendToFile(filename, "test");
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
}
