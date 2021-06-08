package io.nio;

import io.RequestHandler;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/2/4 22:19
 */
public class NioServer {
    public static void main(String[] args) throws Exception {
        //1.创建一个服务端的Channel
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        //serverChannel需要绑定一个端口
        socketChannel.bind(new InetSocketAddress(6666));
        System.out.println("Nio 启动，监听端口："+socketChannel.getLocalAddress());
        //2.selector，专门用来轮询，判断io的状态
        Selector selector = Selector.open();
        //将一个channel注册到selector,channel初始状态
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //ByteBuffer进行数据的临时存储
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        RequestHandler requestHandler = new RequestHandler();
        //对Selector里面的handler进行轮询，判断谁需要进行后续io操作
        while (true){
            int select = selector.select();
            if (select==0){
                continue;
            }
            //selector中有channel
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                //selectionKeys已经保存了channel的各种信息
                SelectionKey key = iterator.next();
                //加入channel状态是acceptable
                if (key.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = channel.accept();
                    System.out.println("连接来自："+clientChannel.getRemoteAddress());
                    clientChannel.configureBlocking(false);
                    //将该channel改变状态，read、write
                    clientChannel.register(selector,SelectionKey.OP_READ);
                }
                if (key.isReadable()){
                    //数据交互了
                    SocketChannel channel = (SocketChannel) key.channel();
                    //将数据读取到buffer
                    channel.read(buffer);
                    String request = new String(buffer.array()).trim();
                    buffer.clear();
                    //写数据
                    System.out.println(String.format("From %s : %s",channel.getRemoteAddress(),request));
                    String response = requestHandler.handle(request);
                    channel.write(ByteBuffer.wrap(request.getBytes()));
                }
                iterator.remove();
            }
        }
    }
}
