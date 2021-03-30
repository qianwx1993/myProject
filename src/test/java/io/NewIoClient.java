package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 非阻塞io(Nio)客户端
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2021/3/31 0:22
 */
public class NewIoClient {
	public static void main(String[] args) {
		try {
			SocketChannel socketChannel= SocketChannel.open();
			//!!!本demo中客户端不设置，否则会报错
			//socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("localhost", 8080));
			//不加下面这段会报错： java.nio.channels.NotYetConnectedException；
			//因为现在是异步的，如果需要确认连接是否已建立
			if (socketChannel.isConnected()){
				socketChannel.finishConnect();
			}
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			byteBuffer.put("Hello,qianduoduo".getBytes());
			byteBuffer.flip();
			socketChannel.write(byteBuffer);
			//读取数据
			byteBuffer.clear();
			int i = socketChannel.read(byteBuffer);
			if (i>0){
				System.out.println("收到服务端的数据"+new String(byteBuffer.array()));
			}else {
				System.out.println("没有收到数据");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
