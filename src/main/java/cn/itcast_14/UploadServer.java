package cn.itcast_14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 通过while循环可以改进一个服务器接收多个客户端。
 * 但是这个是有问题的。
 * 如果是这种情况，假设我还有张三，李四，王五这三个人分别执行客户端
 * 张三：好好学习.avi(100M)			256k
 * 李四：天天向上.mp3(3M)				1M
 * 王五：ILoveJava.txt(1k)			100M
 */
public class UploadServer {
	public static void main(String[] args) throws IOException {
		// 创建服务器端的Socket对象
		ServerSocket ss = new ServerSocket(10086);

		while (true) {
			// 监听客户端连接
			Socket s = ss.accept();// 阻塞

			// 封装通道内的流
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));


			String line = null;
			while ((line = br.readLine()) != null) { // 阻塞

				System.out.println("line.content\t"+line);
				System.out.println("line.length\t"+line.length());
			}


			// 释放资源
			s.close();
		}
	}
}
