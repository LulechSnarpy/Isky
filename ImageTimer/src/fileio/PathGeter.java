package fileio;

import java.io.File;
import java.util.ArrayList;


/*
 * ��ȡ����ָ��β׺���ļ���·�������ļ�·���ַ�������
 * */
public class PathGeter {
	private ArrayList<String> images;
	
	/*��ȡ·��ǰ��Ҫ��ʼ��*/
	public void init(){
		images = new ArrayList<>();
	}
	
	/*��ȡָ��·����β׺Ϊpng��PNG��jpg��JPG���ļ�·��*/
	public ArrayList<String> getImageFiles(String filePath){
	     File root = new File(filePath);
	       File[] files = root.listFiles();
	       for(File file:files){     
		        if(file.isDirectory()){
		        	getImageFiles(file.getAbsolutePath());
		        }
		        else{
		        	
		        	String s = file.getAbsolutePath();
		        	if( s.endsWith("png") || s.endsWith("PNG") || s.endsWith("jpg") || s.endsWith("JPG"))
		        	{
		        		images.add(file.getAbsolutePath());
		             }
		        }  
	       }
	    return images;
	}
}
