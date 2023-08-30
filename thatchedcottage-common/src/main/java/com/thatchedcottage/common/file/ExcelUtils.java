package com.thatchedcottage.common.file;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: thatchedcottage
 * @description: Excel表格操作
 * @author:
 * @create: 2023-08-22 09:43
 **/
public class ExcelUtils {


    public void importExcel() {
        /*//从文件中读取Excel为ExcelReader
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("test.xlsx"));
        //从流中读取Excel为ExcelReader（比如从ClassPath中读取Excel文件）
        ExcelReader reader = ExcelUtil.getReader(ResourceUtil.getStream("aaa.xlsx"));

        //读取指定的sheet
        ExcelReader reader;
        //通过sheet编号获取
        reader = ExcelUtil.getReader(FileUtil.file("test.xlsx"), 0);
        //通过sheet名获取
        reader = ExcelUtil.getReader(FileUtil.file("test.xlsx"), "sheet1");*/

        String url = "";
        //通过sheet名获取
        ExcelReader reader = ExcelUtil.getReader(url);
        //List<List<Object>> readAll = reader.read();
        List<Map<String,Object>>  readAllMap = reader.readAll();

        try {
            //关闭IO流
            reader.close();
        }catch (Exception e){

        }finally {

        }

        for (Map<String,Object> readMap:readAllMap){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("==========遍历Map集合============");
            Set<Map.Entry<String, Object>> entries = readMap.entrySet();
            for (Map.Entry<String, Object> entrie:entries){
                System.err.println(entrie.getKey() +" = "+entrie.getValue());
            }

        }
    }
}
