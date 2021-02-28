package io;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/2/4 0:52
 */
public class BioServerThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        RequestHandler requestHandler = new RequestHandler();
        try(ServerSocket serverSocket = new ServerSocket(9999);) {
            System.out.println("BioServerThreadPool已经启动，监听接口:" + serverSocket.getLocalSocketAddress());
            while (true){
                Socket clientSocket = serverSocket.accept();
                //针对每个客户端分配一个线程
                executor.submit(new ClientHandler(clientSocket,requestHandler));
                System.out.println("连接来自于:"+clientSocket.getRemoteSocketAddress());
            }
        }catch (Exception e){

        }
    }
}
