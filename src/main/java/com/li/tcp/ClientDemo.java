package com.li.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Date;

public class ClientDemo {

    private static String TAG = "SocketTcp: ";

    public static void main(String[] args) {

        try {
            final Socket socket = new Socket();
            SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 10001);

            socket.connect(address);

            PrintWriter socketOut = new PrintWriter(socket.getOutputStream());


            Message message = new Message()
                    .setControlC("C0")
                    .setAddressA("00005E270047")
                    .setAFN("0B")
                    .setDeviceAddrPN(04)
                    .setDataUintFN("01")
                    .setData("08" + "E71CE71C141D141DD61CD61C281D281D00002700270026002700260028002600984E000010018413FFFF640098261D095709C8091A011A011901A04E0000B3190000561A00007C1B0000854F0000000000002D0B000055BE0F00")
                    .setTime(new Date())
                    .setCheckOutAndCS("31");


            socketOut.write(message.toString());
            socketOut.flush();

            BufferedReader socketIn = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

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
