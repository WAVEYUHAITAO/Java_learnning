package com.hito.lesson03;

import java.io.ByteArrayOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//还是要等到客户端的连接！
public class UdpServerDemo01 {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);

        //接收数据报
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);//阻塞接收
        System.out.println(packet.getAddress());
        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        System.out.println(new String(buffer));
        //通过ByteArray
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(buffer,0,buffer.length);
        System.out.println(baos);
        //关闭连接
        socket.close();
    }
}
