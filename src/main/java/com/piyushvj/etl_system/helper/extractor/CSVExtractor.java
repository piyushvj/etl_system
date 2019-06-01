package com.piyushvj.etl_system.helper.extractor;

import org.springframework.util.ResourceUtils;

import java.io.*;

public class CSVExtractor implements Extractor {
    public String read(String fileName){
        StringBuilder readData = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:"+fileName)))){
            String line = "";
            while(null != (line =reader.readLine())){
                readData.append(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return readData.toString();
    }
}