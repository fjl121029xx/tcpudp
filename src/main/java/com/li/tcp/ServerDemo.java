package com.li.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public class ServerDemo {

    private static String TAG = "SocketTcp: ";

    public static void main(String[] args) {


        try {
            ServerSocket server = new ServerSocket();
            SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 10001);
            server.bind(address);
            System.out.println("服务端启动");
            Socket client = server.accept();//在接收到客户端消息之前阻塞

            System.out.println("远程客户端地址是 " +
                    client.getRemoteSocketAddress());

            PrintWriter socketOut = new PrintWriter(client.getOutputStream());

            System.out.println("等待客户端消息");

            byte buf[] = new byte[1024];
            if (client.getInputStream().read(buf) > 0) {
                System.out.println("收到的消息是: " + new String(buf));
            }

            System.out.println("收到消息,回应客户端.");
            String sendStr = "服务端收到消息了";
            socketOut.write(sendStr);
            socketOut.flush();

            socketOut.close();
            client.close();
            server.close();
        } catch (IOException e) {
            System.out.println(TAG + e.getMessage());
            e.printStackTrace();
        }
    }
}
