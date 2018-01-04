package com.li.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ClientDemo {

    private static String TAG = "SocketTcp: ";

    public static void main(String[] args) {

        try {
            final Socket socket = new Socket();
            SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 10001);

            System.out.println("连接服务端");
            socket.connect(address);

            PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
            BufferedReader socketIn = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()) );

            String sendStr = "向客户端发送的消息";
            System.out.println("向服务端发送消息...");

            socketOut.write(sendStr);
            socketOut.flush();
            System.out.println("等待服务端相应");
            String receiveStr = socketIn.readLine();
            System.out.println("从服务端收到的消息: " + receiveStr);

            socketOut.close();
            socketIn.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(TAG + e.getMessage());
            e.printStackTrace();
        } finally {

        }

    }
}
