/**
 * 
 */
package cn.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author chuck 读取并修改文件内容
 */
public class FileModify {

	public static void main(String[] args) {
		String filePath =  "/Users/chuck/Desktop/second.html";// 文件路径
		FileModify obj = new FileModify();
		obj.write(filePath, obj.read(filePath)); // 读取修改文件
	}

	/**
	 * 读取文件
	 * 
	 * @param filePath
	 * @return
	 */
	public String read(String filePath) {
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();

		try {
			// 根据文件路径创建缓冲输入流
			br = new BufferedReader(new FileReader(filePath));

			// 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
			while ((line = br.readLine()) != null) {
			
				if(line.indexOf(".plist")!=-1){
					System.out.println("包含plist内容==="+line);
					System.out.println("开始修改iOS链接...");
					buf.append(line);
					buf.delete(buf.length()-line.length()-1, buf.length());
					buf.append("<a>www.baidu.com</a>");
					System.out.println("修改后的内容==="+line);
				}else if(line.indexOf(".apk")!=-1){
					System.out.println("这是apk的链接==="+line);
					System.out.println("开始修改apk链接...");
					buf.append(line);
					buf.delete(buf.length()-line.length()-1, buf.length());
					buf.append("<a>www.android.com</a>");
					System.out.println("修改后的内容==="+line);
				}
				
//				// 此处根据实际需要修改某些行的内容
//				if (line.startsWith("<a")) {
//					buf.append(line).append(" start with a");
//				} else if (line.startsWith("b")) {
//					buf.append(line).append(" start with b");
//				}
				// 如果不用修改, 则按原来的内容回写
				else {
					buf.append(line);
				}
				buf.append(System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
				}
			}
		}

		System.out.println("read方法==="+buf.toString());
		
		return buf.toString();
	}

	/**
	 * 将内容回写到文件中
	 * 
	 * @param filePath
	 * @param content
	 */
	public void write(String filePath, String content) {
		BufferedWriter bw = null;

		try {
			// 根据文件路径创建缓冲输出流
			bw = new BufferedWriter(new FileWriter(filePath));
			// 将内容写入文件中
			bw.write(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					bw = null;
				}
			}
		}
	}

	public void fileAppender(String fileName, String content) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		// 一行一行的读
		StringBuilder sb = new StringBuilder();
		sb.append(content);
		while ((line = reader.readLine()) != null) {
			sb.append(line);
			sb.append("\r\n");
		}
		reader.close();

		// 写回去
		RandomAccessFile mm = new RandomAccessFile(fileName, "rw");
		mm.writeBytes(sb.toString());
		mm.close();
	}

}
