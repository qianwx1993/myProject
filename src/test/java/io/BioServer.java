package io;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 等待客户端请求过来
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/2/4 0:28
 */
public class BioServer {
    public static void main(String[] args) {
        try( ServerSocket serverSocket = new ServerSocket(8888);) {
            System.out.println("BioServer已经启动，监听接口:"+serverSocket.getLocalSocketAddress());
            //为了处理很多客户端请求
            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("请求来自："+clientSocket.getRemoteSocketAddress());
                //针对每个Socket进行数据交互的操作，看看是否真的阻塞？当前线程只能等待i/o完成 main-Thread
                try (Scanner input = new Scanner(clientSocket.getInputStream())){
                    //不断地和Socket进行数据交互
                    while (true){
                        String request = input.nextLine();
                        if ("quit".equals(request)){
                            break;
                        }
                        System.out.println(String.format("From %s : %s",clientSocket.getRemoteSocketAddress(),request));
                        String response = "From BioServer Hello " + request + ".\n";
                        clientSocket.getOutputStream().write(response.getBytes());
                    }
                }
            }
        }catch (Exception e){

        }
    }
}
