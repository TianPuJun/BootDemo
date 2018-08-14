package com.boot.demo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * http服务端(不会使用)
 *
 * @author cui
 * @create 2018-08-10 16:07
 **/
public class HttpServer {
    public static void main(String[] args){
        try {
            String line;
            ServerSocket serverSocket = null;
            try {
                //监听8888的端口请求
                serverSocket = new ServerSocket(8888);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Socket socket = null;
            try {
                //等待客户端请求
                socket = serverSocket.accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("client:" + is.readLine());
            line = sin.readLine();
            while (!line.equals("close")) {
                os.println(line);
                os.flush();
                System.out.println("Server:" + line);
                System.out.println("Client：" + is.readLine());
                line = sin.readLine();
            }
            os.close();
            is.close();
            serverSocket.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        }
}
