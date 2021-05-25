package com.hito.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class TalkSend implements Runnable{
    DatagramSocket socket =null;
    BufferedReader reader =null;

    private  int fromPort;
    private  String toIP;
    private  int toPort;

    public TalkSend(String toIP, int fromPort, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(fromPort);
            //准备数据：控制台读取System in
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            String data = null;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes(StandardCharsets.UTF_8);
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(data.equals("bye")){
                break;
            }
        }


        socket.close();
    }
}
