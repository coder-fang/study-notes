package com.kuang.state;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create By  on 2021/10/15.
 * 模拟倒计时
 */
public class TestSleep2 {
    public static void main(String[] args) throws InterruptedException {
//        tenDown();
        //打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis());  //获取当前系统时间
        while(true){

            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis()); //更新当前时间
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    //模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while(true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0){
                break;
            }

        }

    }
}
