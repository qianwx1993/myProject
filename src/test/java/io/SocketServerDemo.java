package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2021/3/30 22:30
 */
public class SocketServerDemo {
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			serverSocket=new ServerSocket(8080);
			//监听客户端连接
			Socket socket = serverSocket.accept();
			System.out.println(socket.getPort());

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String s = bufferedReader.readLine();
			String clientStr=s;
			System.out.println("接受客户端的信息："+clientStr);

			//写回去
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write("我收到了消息\n");
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
