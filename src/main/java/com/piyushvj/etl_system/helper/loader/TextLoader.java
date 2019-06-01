package com.piyushvj.etl_system.helper.loader;

import org.springframework.util.ResourceUtils;

import java.io.*;

public class TextLoader implements CustomLoader {

    @Override
    public boolean loadData(String data, String outputFile) {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(ResourceUtils.getFile("classpath:"+outputFile)))){
            writer.write(data);
        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }
}
