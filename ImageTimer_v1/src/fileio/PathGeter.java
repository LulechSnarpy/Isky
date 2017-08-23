package fileio;

import java.io.File;
import java.util.ArrayList;


/*
 * 获取所有指定尾缀的文件的路径返回文件路径字符串数组
 * */
public class PathGeter {
	private ArrayList<String> images;
	
	/*获取路径前需要初始化*/
	public void init(){
		images = new ArrayList<>();
	}
	
	/*获取指定路径下尾缀为png，PNG，jpg，JPG的文件路径*/
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
