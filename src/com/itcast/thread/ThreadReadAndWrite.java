package com.itcast.thread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadReadAndWrite implements Runnable{

    private String srcFileName;
    private String destFileName;

    public ThreadReadAndWrite(String srcFileName, String destFileName) {
        this.srcFileName = srcFileName;
        this.destFileName = destFileName;
    }
    @Override
    public void run() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFileName);
            fos = new FileOutputStream(destFileName);
            byte[] buf = new byte[1024 * 4];
            int len;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf,0,len);
                System.out.println(destFileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
