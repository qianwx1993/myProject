package io;

import java.io.*;
import java.net.Socket;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2021/3/30 22:41
 */
public class SocketClientDemo {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8080);
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write("我是客户端，发送了一条消息\n");
			bufferedWriter.flush();

			//输入流
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String serverLine = bufferedReader.readLine();
			System.out.println("我收到了一条消息："+serverLine);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
