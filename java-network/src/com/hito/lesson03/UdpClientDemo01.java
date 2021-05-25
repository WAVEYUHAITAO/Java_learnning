package com.hito.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

//UDP消息传输
//不需要连接服务器
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.建立一个socket
        DatagramSocket socket = new DatagramSocket();

        //2.建一个包
        String msg = "你好啊，服务器";

        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes(StandardCharsets.UTF_8).length, localhost, port);
        //3.发送包
        socket.send(packet);
        //4.关闭流
        socket.close();
    }

}
