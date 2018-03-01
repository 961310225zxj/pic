package com._520it.crm.util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class
DataBaseBackUp {

	//备份
	public static void backup() {
		try {
			Runtime rt = Runtime.getRuntime();

			// 调用 调用mysql的安装目录的命令
			Process child = rt
					.exec("C:/Program Files/MySQL/MySQL Server 5.5/bin/mysqldump -h localhost -uroot -padmin picc");
			// 设置导出编码为utf-8。这里必须是utf-8
			// 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
			InputStream in = child.getInputStream();// 控制台的输出信息作为输入流

			InputStreamReader inputstream = new InputStreamReader(in, "utf-8");
			// 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码

			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			// 组合控制台输出信息字符串
			BufferedReader br = new BufferedReader(inputstream);
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			// 要用来做导入用的sql目标文件：
			FileOutputStream fout = new FileOutputStream("d:/backup.sql");
			OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
			writer.write(outStr);
			writer.flush();
			in.close();
			inputstream.close();
			br.close();
			writer.close();
			fout.close();
			System.out.println("");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//还原
	public static void restore(FileInputStream filepath) {
		try {
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime
					.exec("C:/Program Files/MySQL/MySQL Server 5.5/bin/mysql  -h localhost -uroot -padmin picc"
							);
			OutputStream outputStream = process.getOutputStream();
			/*BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), "utf-8"));*/
			BufferedReader br = new BufferedReader(new InputStreamReader(filepath, "utf-8"));
			String str = null;
			StringBuffer sb = new StringBuffer();
			while ((str = br.readLine()) != null) {
				sb.append(str + "\r\n");
			}
			str = sb.toString();
			// System.out.println(str);
			OutputStreamWriter writer = new OutputStreamWriter(outputStream, "utf-8");
			writer.write(str);
			writer.flush();
			outputStream.close();
			br.close();
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
