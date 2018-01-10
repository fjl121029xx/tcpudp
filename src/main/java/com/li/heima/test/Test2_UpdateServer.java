package com.li.heima.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test2_UpdateServer {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //3,�������̵߳ķ�����
        ServerSocket server = new ServerSocket(12345);
        System.out.println("����������,��12345�˿ں�");

        //4.��ȡ�ļ���
        while (true) {
            final Socket socket = server.accept();                    //��������
            new Thread() {
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        String fileName = br.readLine();

                        //5.�ж��ļ��Ƿ����, ��������ؿͻ���
                        File dir = new File("update");
                        dir.mkdir();                                //�����ļ���
                        File file = new File(dir, fileName);            //��װ��File����

                        if (file.exists()) {                            //����������Ѿ���������ļ�
                            ps.println("����");                        //������д���ͻ���
                            socket.close();                            //�ر�socket
                            return;
                        } else {
                            ps.println("������");
                        }

                        //8.����FileOutputStream, �������ȡ����, �洢������
                        FileOutputStream fos = new FileOutputStream(file);
                        byte[] arr = new byte[8192];
                        int len;

                        while ((len = is.read(arr)) != -1) {
                            fos.write(arr, 0, len);
                        }

                        fos.close();
                        socket.close();
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }.start();
        }


    }
}
