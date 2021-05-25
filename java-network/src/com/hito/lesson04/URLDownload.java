package com.hito.lesson04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDownload {
    public static void main(String[] args) throws IOException {
        //1.下载地址
        URL url = new URL("http://localhost:8080/hito/serverpasswd.txt");

        //2.连接带这个资源  HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("src/com/hito/lesson04/serverpasswd.txt");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
