package org.whitetown.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.executor.ExcelWriteExecutor;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteWorkbook;

import java.io.*;
import java.util.List;

/**
 * @author GrainRain
 * @date 2020/03/27 10:29
 **/
public class FileUtil {
    private String path;
    private String readPath;

    private ExcelWriter excelWriter;
    private ExcelReader excelReader;

    private OutputStream outputStream;
    private InputStream inputStream;

    private FileUtil(){}
    public static FileUtil getInstance(String path) throws IOException {
        FileUtil fileUtil = new FileUtil();
        fileUtil.path = path;
        File file = new File(path);
        if(!file.exists())
            file.createNewFile();

        fileUtil.outputStream = new FileOutputStream(file,true);
        fileUtil.inputStream = new FileInputStream(file);
        WriteWorkbook writeWorkbook = new WriteWorkbook();
        writeWorkbook.setOutputStream(fileUtil.outputStream);
        fileUtil.excelWriter = new ExcelWriter(writeWorkbook);
        return fileUtil;
    }

    public boolean write(String data){
        try {
            outputStream.write(data.getBytes());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public <T> boolean writeAsExcel(List<T> data, WriteSheet sheet){
        try {
            excelWriter.write(data,sheet);
            excelWriter.finish();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public String read(byte[] bytes) throws IOException {
        int len = inputStream.read(bytes);
        if (len > 0)
            return new String(bytes,0,len);
        else
            return null;
    }

    public <T> void initExcelReader(String readPath, ReadListener<T> listener) throws FileNotFoundException {
        InputStream in = new FileInputStream(readPath);
        excelReader = EasyExcelFactory.read(readPath,listener).build();
    }

    public void readExcel(ReadSheet sheet){
        if(excelReader==null)
            throw new NullPointerException("not init");
        excelReader.read(sheet);
    }

    public void readExcel(){
        if(excelReader==null)
            throw new NullPointerException("not init");
        excelReader.readAll();
    }
}
