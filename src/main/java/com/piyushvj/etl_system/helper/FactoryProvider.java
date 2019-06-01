package com.piyushvj.etl_system.helper;

import com.piyushvj.etl_system.helper.extractor.ExtractorFactory;
import com.piyushvj.etl_system.helper.loader.LoaderFactory;
import com.piyushvj.etl_system.helper.transformer.TransformerFactory;

public class FactoryProvider {
    public static SuperFactory getFactory(String type){
        switch (type) {
            case "READER" : return new ExtractorFactory();
            case "TRANSFORMER" : return new TransformerFactory();
            case "LOADER" : return new LoaderFactory();
            default:return null;
        }
    }
}
