package com.li.udp;

import java.io.IOException;
import java.net.*;

public class ServerDemo {

    final private static String TAG = "SocketUdp: ";

    public static void main(String args[]) {
        DatagramSocket socket = null;
        DatagramPacket datapacket = null;
        InetSocketAddress address = null;

        try {
            address = new InetSocketAddress(InetAddress.getLocalHost(), 7778);
            socket = new DatagramSocket(address);
            // socket.bind(address);

            byte buf[] = new byte[1024];
            datapacket = new DatagramPacket(buf, buf.length);
            System.out.println("==block for receive messages...");
            socket.receive(datapacket);
            buf = datapacket.getData();
            InetAddress addr = datapacket.getAddress();
            int port = datapacket.getPort();
            System.out.println("Message Content: " + new String(buf));
            System.out.println("Receive From " + addr + ":" + port);

            SocketAddress toAddress = datapacket.getSocketAddress();
            String sendStr = "I'm Server, this is the message for client.";
            buf = sendStr.getBytes();
            datapacket = new DatagramPacket(buf, buf.length);
            datapacket.setSocketAddress(toAddress);
            socket.send(datapacket);
            System.out.println("==message sended");

        } catch (UnknownHostException e) {
            System.out.println(TAG + e.getMessage());
            e.printStackTrace();
        } catch (SocketException e) {
            System.out.println(TAG + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(TAG + e.getMessage());
            e.printStackTrace();
        }
    }
}
