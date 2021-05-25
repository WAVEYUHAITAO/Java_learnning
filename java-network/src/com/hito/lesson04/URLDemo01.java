package com.hito.lesson04;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.bilibili.com/video/BV1LJ411z7vY?p=12&spm_id_from=pageDriver");
        System.out.println(url.getProtocol());//协议
        System.out.println(url.getHost());//主机
        System.out.println(url.getPort());//端口
        System.out.println(url.getPath());//路径
        System.out.println(url.getFile());//文件
        System.out.println(url.getQuery());//查询
    }
}
