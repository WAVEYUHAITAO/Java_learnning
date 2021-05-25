package com.hito.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);

            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3); //获得主机名+私网ip地址

            InetAddress inetAddress4 = InetAddress.getByName("localhost");
            System.out.println(inetAddress4); //获得主机名+私网ip地址

            //常用方法
            System.out.println(inetAddress2.getAddress());
            System.out.println(inetAddress2.getCanonicalHostName());
            System.out.println(inetAddress2.getHostAddress());
            System.out.println(inetAddress2.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
