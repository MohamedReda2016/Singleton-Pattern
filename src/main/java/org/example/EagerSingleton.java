package org.example;

import java.io.Serial;
import java.io.Serializable;

public class EagerSingleton implements Serializable {

    private static final EagerSingleton instance= new EagerSingleton();

    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return instance;
    }

    @Serial
    protected Object readResolve() {
        return instance;
    }
}
