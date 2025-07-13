package org.example;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        LazySingleton lazySingleton = LazySingleton.getInstance();
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("myObject.obj"));
        outputStream.writeObject(lazySingleton);
        outputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("myObject.obj"));
        LazySingleton lazySingleton1 = (LazySingleton) inputStream.readObject();
        inputStream.close();
        System.out.println("hash code for the original lazy singleton object " + lazySingleton.hashCode());
        System.out.println("hash code for the second lazy singleton object " + lazySingleton1.hashCode());

        MultiThreadSingleton multiThreadSingleton=MultiThreadSingleton.getInstance();
        Constructor[] contstructors = MultiThreadSingleton.class.getDeclaredConstructors();
        Constructor currentConstructor= contstructors[0];
        currentConstructor.setAccessible(true);
        MultiThreadSingleton multiThreadSingleton2 = (MultiThreadSingleton)currentConstructor.newInstance();
        System.out.println("hash code for the original MultiThread singleton object " + multiThreadSingleton.hashCode());
        System.out.println("hash code for the second MultiThread singleton object " + multiThreadSingleton2.hashCode());

        EnumSingleton instance=EnumSingleton.INSTANCE;
        EnumSingleton instance2=EnumSingleton.INSTANCE;
        instance.doSomeThing();
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}