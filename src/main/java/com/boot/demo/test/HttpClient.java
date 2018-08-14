package com.boot.demo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端(不会使用)
 *
 * @author cui
 * @create 2018-08-10 16:18
 **/
public class HttpClient {
    public static void main(String[] args){
    try {
        String readline;
        Socket socket = new Socket("192.168.1.194",8888);
        BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter os = new PrintWriter(socket.getOutputStream());
        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        readline = sin.readLine();
        while(!readline.equals("close")){
            os.println(readline);
            os.flush();
            System.out.println("Client:1"+readline);
            System.out.println("Server1:"+is.readLine());
            readline =sin.readLine();
        }
        os.close();
        is.close();
        socket.close();
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
