package utils;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator {
    public static int get(){
        AtomicInteger idCounter =  new AtomicInteger(100);
        int timestamp = (int)System.currentTimeMillis();
        int nextInt = idCounter.incrementAndGet();
        Random rand = new Random();
        int randInt = rand.nextInt(timestamp);
        return (int)timestamp+nextInt-randInt; 
    }
}
