package com.piyushvj.etl_system.service;

import com.piyushvj.etl_system.helper.extractor.Extractor;
import com.piyushvj.etl_system.helper.FactoryProvider;
import com.piyushvj.etl_system.helper.SuperFactory;
import com.piyushvj.etl_system.helper.loader.CustomLoader;
import com.piyushvj.etl_system.helper.transformer.CustomTransformer;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ETLService {

    public String doEtlOperation(String inputFileName, String transformTo, String outputFileName){

        String readData="";
        String tranformedData="";
        boolean etl=false;

        // Preparing Factory
        SuperFactory<Extractor> extractFactory = FactoryProvider.getFactory("READER");
        SuperFactory<CustomTransformer> transformerFactory = FactoryProvider.getFactory("TRANSFORMER");
        SuperFactory<CustomLoader> loaderFactory = FactoryProvider.getFactory("LOADER");


        // FILE EXTRACTION START
        readData = extractFile(inputFileName, extractFactory);
        // FILE EXTRACTION END

        // TRANSFORMATION START
        tranformedData = transformData(readData, transformerFactory, transformTo);
        // TRANSFORMATION ENDS

        // LOAD DATA START
        etl = loadData(outputFileName,loaderFactory, tranformedData);
        // LOAD DATA ENDS

        if(etl)
            return "SUCCESS";
        else
            return "FAIL";
    }

    private String getFileType(String fileName){
        String fileType ="";
        int i = fileName.lastIndexOf('.');
        if(i>0){
            fileType = fileName.substring(i+1);
        }
        return fileType;
    }

    private String extractFile(String inputFileName, SuperFactory<Extractor> readerFactory){
        String fileType = getFileType(inputFileName);
        Extractor reader = readerFactory.create(fileType.toUpperCase());
        return reader.read(inputFileName);
    }

    private String transformData(String readData, SuperFactory<CustomTransformer> transformerFactory, String transformTo){
        CustomTransformer transformer = transformerFactory.create(transformTo.toUpperCase());
        return transformer.transform(readData);
    }

    private boolean loadData(String outputFileName, SuperFactory<CustomLoader> loaderFactory, String tranformData) {
        String outputFileType = getFileType(outputFileName);
        CustomLoader customLoader = loaderFactory.create(outputFileType.toUpperCase());
        return customLoader.loadData(tranformData, outputFileName);
    }
}
