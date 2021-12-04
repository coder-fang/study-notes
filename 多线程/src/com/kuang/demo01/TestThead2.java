package com.kuang.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Create By  on 2021/10/14.
 * 练习Thead，实现多线程同步下载图片
 */
public class TestThead2 extends Thread {
    private String url; //网络图片地址
    private String name;  //保存的文件名

    public TestThead2(String url, String name) {
        this.name = name;
        this.url = name;
    }

    @Override
    public void run() {
        super.run();
        WebDownloader webDownloader = new WebDownloader();
        try {
            webDownloader.downloader(url, name);
            System.out.println("下载了文件名为：" + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestThead2 t1 = new TestThead2("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/1.jpg","1.jpg");
        TestThead2 t2 = new TestThead2("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/1.jpg","2.jpg");
        TestThead2 t3 = new TestThead2("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/1.jpg","3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownloader {
    //下载方法
    public void downloader(String url, String name) throws IOException {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("io异常，download方法出现问题");
        }
    }

}
