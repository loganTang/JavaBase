package com.qatix.base.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest {

    public static void main(String[] args) {

        BlockingQueue queue = new ArrayBlockingQueue(2);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Producer implements Runnable{

    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("producer run");
        try {
            queue.put("1");
            System.out.println("put e1");
            Thread.sleep(1000);
            queue.put("2");
            System.out.println("put e2");
            Thread.sleep(1000);
            queue.put("3");
            System.out.println("put e3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("consumer run");
        try {
            Thread.sleep(4000);
            System.out.println(queue.take());
            System.out.println("size:"+queue.size());
            Thread.sleep(4000);
            System.out.println(queue.take());
            Thread.sleep(4000);
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}