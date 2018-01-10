package com.li.heima.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Demo1_Send {

    /**
     * * 1.����Send
     * ����DatagramSocket, ����˿ں�
     * ����DatagramPacket, ָ������, ����, ��ַ, �˿�
     * ʹ��DatagramSocket����DatagramPacket
     * �ر�DatagramSocket
     *
     * @throws SocketException
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws Exception {
        String str = "what are you Ūɶ��?";
        DatagramSocket socket = new DatagramSocket();                //����Socket�൱�ڴ�����ͷ
        DatagramPacket packet =                                    //����Packet�൱�ڼ�װ��
                new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
        socket.send(packet);                                        //����,�����ݷ���ȥ
        socket.close();                                                //�ر���ͷ
    }

}
