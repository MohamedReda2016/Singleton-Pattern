package org.example.test;

import org.example.EnumSingleton;
import org.example.LazySingleton;
import org.example.MultiThreadSingleton;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    void lazySingletonShouldPreserveIdentityAfterSerialization()
            throws IOException, ClassNotFoundException {

        LazySingleton original = LazySingleton.getInstance();

        byte[] serialized;
        try (ByteArrayOutputStream bytes = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bytes)) {

            out.writeObject(original);
            serialized = bytes.toByteArray();
        }

        LazySingleton restored;
        try (ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(serialized))) {

            restored = (LazySingleton) in.readObject();
        }

        assertSame(original, restored,
                "Deserialization should return the same singleton instance");
    }

    @Test
    void multiThreadSingletonShouldResistReflection()
            throws ReflectiveOperationException {

        MultiThreadSingleton original =
                MultiThreadSingleton.getInstance();

        Constructor<MultiThreadSingleton> constructor =
                MultiThreadSingleton.class.getDeclaredConstructor();

        constructor.setAccessible(true);


    }

    @Test
    void enumSingletonShouldPreserveIdentity() {
        EnumSingleton first = EnumSingleton.INSTANCE;
        EnumSingleton second = EnumSingleton.INSTANCE;

        assertSame(first, second);
    }
}

