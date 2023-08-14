package com.thatchedcottage.common.file;

import com.thatchedcottage.common.util.ThreadLocalExample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class PathHelper {
    /* todo  日志路径*/
    static String logPath = "D:\\jhnwadminlog" ;//Configuration.logPath;
    /**
     * 将字符串写入文件中
     * @param str
     * @throws IOException
     */
    public static void writeDataToFile(String str) throws IOException {

        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        String logPresent = threadLocalExample.simpleDateFormatThreadLocal.get().format(new Date());
        threadLocalExample.simpleDateFormatThreadLocal.remove();

        logPresent = "["+logPresent+"] ";
        str = logPresent + str ;
        //文件目录
        File writefile;
        BufferedWriter bw;
        boolean append = true;  //  是否追加
        String path = logPath+  "\\" +"log.txt";

        writefile = new File(path);
        if (writefile.exists() == false)   // 判断文件是否存在，不存在则生成
        {
            try {
                // 获取文件所在的文件夹路径
                String folderPath = writefile.getParent();
                // 创建文件夹
                File folder = new File(folderPath);
                folder.mkdirs();

                writefile.createNewFile();
                writefile = new File(path);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fw = new FileWriter(writefile, append);
            bw = new BufferedWriter(fw);
            fw.write(str);
            fw.flush();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 将字符串写入文件中
     * @param str
     * @throws IOException
     */
    public static void writeDataToFileByName(String str,String name) throws IOException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        String logPresent = threadLocalExample.simpleDateFormatThreadLocal.get().format(new Date());
        threadLocalExample.simpleDateFormatThreadLocal.remove();

        logPresent = "["+logPresent+"] ";
        str = logPresent + str ;
        //文件目录
        File writefile;
        BufferedWriter bw;
        boolean append = true;  //  是否追加
        String path = logPath+  "\\" +"log"+name+".txt";
        writefile = new File(path);
        if (writefile.exists() == false)   // 判断文件是否存在，不存在则生成
        {
            try {
                // 获取文件所在的文件夹路径
                String folderPath = writefile.getParent();
                // 创建文件夹
                File folder = new File(folderPath);
                folder.mkdirs();

                writefile.createNewFile();
                writefile = new File(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fw = new FileWriter(writefile, append);
            bw = new BufferedWriter(fw);
            fw.write(str);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
