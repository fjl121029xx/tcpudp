package com.li.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public class ServerDemo {

    private static String TAG = "SocketTcp: ";

    public static void main(String[] args) {


        try {
            ServerSocket server = new ServerSocket(10001);

            Socket client = server.accept();//在接收到客户端消息之前阻塞

            System.out.println("远程客户端地址是 " +
                    client.getRemoteSocketAddress());

            PrintWriter socketOut = new PrintWriter(client.getOutputStream());


            byte buf[] = new byte[1024];
            String s = "";
            if (client.getInputStream().read(buf) > 0) {
                s = new String(buf);
            }

            System.out.println("从客户端收到的消息是 " + s);
            socketOut.write("2");
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
