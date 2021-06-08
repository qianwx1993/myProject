package io;

import java.net.Socket;
import java.util.Scanner;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/2/4 0:59
 */
public class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private final RequestHandler requestHandler;

    public ClientHandler(Socket clientSocket,RequestHandler requestHandler){
        this.clientSocket=clientSocket;
        this.requestHandler=requestHandler;
    }
    @Override
    public void run() {
        //针对每个Socket进行数据交互的操作，看看是否真的阻塞？当前线程只能等待i/o完成 main-Thread
        try (Scanner input = new Scanner(clientSocket.getInputStream())){
            //不断地和Socket进行数据交互
            while (true){
                String request = input.nextLine();
                if ("quit".equals(request)){
                    break;
                }
                System.out.println(String.format("From %s : %s",clientSocket.getRemoteSocketAddress(),request));
                String response =requestHandler.handle(request);
                clientSocket.getOutputStream().write(response.getBytes());
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
