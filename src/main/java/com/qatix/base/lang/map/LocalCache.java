package com.qatix.base.lang.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Logan.Tang
 * @Date: 2018/10/18 2:46 PM
 */
public class LocalCache {



//    public static void main(String[] args) {
//
//        Map<String,String> localCache ;
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Map<String,String> cache = new HashMap<>();
//                cache.put("k1","v1-"+System.currentTimeMillis());
//                cache.put("k2","v2-"+System.currentTimeMillis());
//                cache.put("k3","v3-"+System.currentTimeMillis());
//                localCache = cache;
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//
//        for (int i=0;i<10;i++) {
//            Thread t2 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true) {
//                        System.out.println(localCache.get("k1"));
//                        System.out.println(localCache.get("k2"));
//                        System.out.println(localCache.get("k3"));
//                    }
//                }
//            });
//            t2.start();
//        }
//    }

}
