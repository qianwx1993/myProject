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
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2021/3/31 22:51
 */
public class NewIoSelectorClient {
	static Selector selector;

	public static void main(String[] args) {
		try {
			selector = Selector.open();
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("localhost",8080));
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
			while (true){
				selector.select();
				Set<SelectionKey> selectionKeySet=selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeySet.iterator();
				while (iterator.hasNext()){
					SelectionKey key = iterator.next();
					//用完了就删除（下次再有请求，再去注册）
					iterator.remove();
					if (key.isConnectable()){//连接事件
						handleAccept(key);
					}else {//可读事件
						handleRead(key);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void handleAccept(SelectionKey selectionKey) throws IOException {
		SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
		if (socketChannel.isConnectionPending()){
			socketChannel.finishConnect();
		}
		socketChannel.configureBlocking(false);
		socketChannel.write(ByteBuffer.wrap("hello,wo shi client".getBytes()));
		//注册事件
		socketChannel.register(selector,SelectionKey.OP_READ);
	}

	private static void handleRead(SelectionKey selectionKey) throws IOException {
		SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		socketChannel.read(byteBuffer);
		System.out.println("client Receive msg:"+new String(byteBuffer.array()));

	}
}
