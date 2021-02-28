package io;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/2/4 0:54
 */
public class RequestHandler {
    public String handle(String request){
        return "来自于BioServerThreadPool Hello"+request +".\n";
    }
}
