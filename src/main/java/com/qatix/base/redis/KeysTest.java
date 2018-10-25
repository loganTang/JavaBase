package com.qatix.base.redis;

import org.apache.commons.lang3.time.FastDateFormat;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class KeysTest {

    private static final String redisHost = "localhost";

    private static final int redisPort = 6379;
    private static final String redisPassword = "";
//    private static final String redisPassword = "c03e0abdf8f44d45:Ccwk1804";

    public static void main2(String[] args) {
        Jedis jedis = new Jedis(redisHost,redisPort,60000);
        if(redisPassword.length() > 0) {
            jedis.auth(redisPassword);
        }

        Set<String> names=jedis.keys("bill_date:*:d:*");
        System.out.println(names.size());

        String todayStr = FastDateFormat.getInstance("yyyyMMdd").format(new Date(System.currentTimeMillis()-86400000));
        for (String key : names) {
            //            System.out.println(s);
            String dateStr = key.substring(key.length() - 8, key.length());
            System.out.println(key + " " + dateStr + " " + todayStr + " " + dateStr.compareTo(todayStr));

            if (dateStr.compareTo(todayStr) >= 0) {//比今天晚的日期不清空
                continue;
            }

            jedis.del(key);
        }
    }

}
