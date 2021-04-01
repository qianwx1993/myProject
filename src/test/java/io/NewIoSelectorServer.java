package io;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用 nio服务端
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2021/3/31 0:11
 */
public class NewIoSelectorServer {
	static Selector selector;
	public static void main(String[] args) {
		//NIO,很重要的三个东西：【Channel、Buffer、Selector】
		//管道、缓冲区、多路复用器
		try {
			selector=Selector.open();
			ServerSocketChannel serverSocketChannel= ServerSocketChannel.open();
			//!!!表示设置为非阻塞；不设置会是阻塞
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(8080));
			//1.把连接事件注册到selector上
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true){
				//2.阻塞机制；只有事件到达的时候才会被唤醒，否则是阻塞
				selector.select();
				Set<SelectionKey> selectionKeySet = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeySet.iterator();
				while (iterator.hasNext()){
					SelectionKey key = iterator.next();
					//说明响应了，应该移除掉
					iterator.remove();

					if (key.isAcceptable()){//响应事件
						//TODO
						handleAccept(key);
					}else if(key.isReadable()){//读的就绪事件
						handleRead(key);
					}
				}

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

	private static void handleAccept(SelectionKey selectionKey){
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
		try {
			//一定会有一个连接
			SocketChannel socketChannel = serverSocketChannel.accept();
			socketChannel.configureBlocking(false);
			socketChannel.write(ByteBuffer.wrap("hello,wo shi server".getBytes()));
			//注册事件
			socketChannel.register(selector,SelectionKey.OP_READ);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private static void handleRead(SelectionKey selectionKey){
		SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		try {
			//代码走到这里一定有值
			socketChannel.read(byteBuffer);
			System.out.println("Server Receive msg:"+new String(byteBuffer.array()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
