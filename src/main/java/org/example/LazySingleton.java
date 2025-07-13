package org.example;

import java.io.Serial;
import java.io.Serializable;

public class LazySingleton implements Serializable {
    private static  LazySingleton instance=null;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }

    @Serial
    protected Object readResolve() {
        return instance;
    }
}
