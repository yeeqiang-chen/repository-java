package com.yiqiang.repository.javase.thread.collection.linkedblockingdeque;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 * Create Time: 2017/1/21 0021 15:44
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Client implements Runnable{

    private LinkedBlockingDeque<String> requestList;

    public Client (LinkedBlockingDeque<String> requestList) {
        this.requestList=requestList;
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<5; j++) {
                StringBuilder request=new StringBuilder();
                request.append(i);
                request.append(":");
                request.append(j);
                try {
                    requestList.put(request.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Client: %s at %s.\n",request,new Date());
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Client: End.\n");
    }


}
