package com.itcast.first;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Demo1 {
    public static void main(String[] args) throws FileNotFoundException {
        /*PrintWriter printWriter = new PrintWriter("1.txt");
        printWriter.println("hello everyone");
        printWriter.println("大家好，你们好吗？");
        printWriter.close();*/
        FileOutputStream fos = new FileOutputStream("2.txt");
        PrintWriter printWriter = new PrintWriter(fos, true);
        printWriter.println("hello,everyone");
        printWriter.println("大家好");
        printWriter.write("i love you");
        printWriter.close();
    }
}
