package com.example.eurekaserver;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private static final ConcurrentHashMap<String, ReentrantLock> lock = new ConcurrentHashMap<>();

    public void doSomething() {
        String key = "需要锁的key";
        ReentrantLock l = null;
        try {
            if(lock.containsKey(key)) {
                l = lock.get(key);
            } else {
                l = new ReentrantLock();
                lock.put(key, l);
            }
            l.lock();
            // do something...
        } catch (Exception e) {

        } finally {
            if(l != null) {
                l.unlock();
            }
        }
    }
}
