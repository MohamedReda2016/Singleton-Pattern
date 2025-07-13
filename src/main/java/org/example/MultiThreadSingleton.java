package org.example;

public class MultiThreadSingleton {
    private static MultiThreadSingleton instance;

    private MultiThreadSingleton(){}

    public static MultiThreadSingleton getInstance() {
        if(instance == null) {
            synchronized (MultiThreadSingleton.class) {
                if(instance == null) {
                    instance = new MultiThreadSingleton();
                }
            }

        }
        return instance;
    }
}
