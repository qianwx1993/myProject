package io;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 非阻塞io(Nio)服务端
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2021/3/31 0:11
 */
public class NewIoServer {
	public static void main(String[] args) {
		//NIO,很重要的三个东西：【Channel、Buffer、Selector】
		//管道、缓冲区、多路复用器
		try {
			ServerSocketChannel serverSocketChannel= ServerSocketChannel.open();
			//!!!表示设置为非阻塞；不设置会是阻塞
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(8080));
			while (true){
				//监听一个客户端请求
				SocketChannel socketChannel = serverSocketChannel.accept();
				if (socketChannel!=null){
					//分配缓冲区的大小
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
					//把数据加载到缓冲区
					socketChannel.read(byteBuffer);
					//读取
					System.out.println(new String(byteBuffer.array()));
					/*写出数据*/
					//反转，读出来的数据和写出去的数据是相反的
					byteBuffer.flip();
					//写出
					socketChannel.write(byteBuffer);

				}else {
					Thread.sleep(1000);
					System.out.println("连接未就绪");
				}
			}


		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
