package cn.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FileReadUtil {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		String html = readTxtFile("/Users/chuck/Desktop/second.html");
		
	
		
		
		
		
		
		
//		Document doc = Jsoup.parse(html);
//		
////		Elements id = doc.select("#ios").removeAttr("href");
//		Element id = doc.select("a").first();
//		id.html("<a id=\"ios\" title=\"iPhone\" href=\"www.baidu.com\">Iphone Download</a>");
////		id.attr("href", "www.baidu.com"); 
//		System.out.println("====="+id+"=====");
//		System.out.println(html);
		
		
		
//		Document doc = Jsoup.connect("http://www.open-open.com").get();
//		Element link = doc.select("a").first();
//		String relHref = link.attr("href"); 
//		// == "/" String absHref = link.attr("abs:href"); 
		// "http://www.open-open.com/" 
		
		
		
//		System.out.println(readTxtFile("/Users/chuck/Desktop/second.html"));
	}

	
	public static String readTxtFile(String filePath){
		
		String html = "";
		
        try {
                String encoding="utf-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        html = html+lineTxt+"\n";
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return html;
    }
	
}
