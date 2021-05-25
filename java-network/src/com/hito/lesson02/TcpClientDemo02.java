package com.hito.lesson02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo02 {
    public static void main(String[] args) throws IOException {
        //1.创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
        //2.创建一个输出流
        OutputStream os = socket.getOutputStream();
        //3.读取文件
        //这里如果只写名字，相对地址就是名字本身，路径在java-network之下
        //如果是放在lesson02下要写 src/com/hito/lesson02/名字
        //服务端如果只写名字也是保存在了java-network之下
        FileInputStream fileInputStream = new FileInputStream("7层网络结构.jpg");
        //4.写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        //通知服务器,我已经结束了
        //要使用socket的inputStream,需要先关闭之前使用过的outputStream
        socket.shutdownOutput(); //我已经传输完了

        //确定服务器接收完毕，才能够断开连接
        InputStream inputStream = socket.getInputStream();
        //String byte[]
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = inputStream.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos);


        //5.关闭资源
        baos.close();
        fileInputStream.close();
        os.close();
        socket.close();
    }

}
