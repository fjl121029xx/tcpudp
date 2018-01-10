package com.li.udp;

import java.io.IOException;
import java.net.*;

public class ClientDemo {
    final private static String TAG = "SocketUdp: ";

    public static void main(String args[]) {
        try {
            DatagramSocket getSocket = new DatagramSocket();



            DatagramPacket datapacket = null;
            InetSocketAddress toAddress = new InetSocketAddress(InetAddress.getLocalHost(), 7778);

            String sendStr = "I'm client, this is the message for server.";
            byte buf[] = sendStr.getBytes();
            datapacket = new DatagramPacket(buf, buf.length);
            datapacket.setSocketAddress(toAddress);
            getSocket.send(datapacket);
            System.out.println("==message sended");

            System.out.println("==block for receive messages...");
            getSocket.receive(datapacket);
            buf = datapacket.getData();
            System.out.println("Message Content: " + new String(buf));
        } catch (SocketException e) {
            System.out.println(TAG + e.getMessage());
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println(TAG + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(TAG + e.getMessage());
            e.printStackTrace();
        }

    }
}
