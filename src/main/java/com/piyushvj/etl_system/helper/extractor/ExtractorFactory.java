package com.piyushvj.etl_system.helper.extractor;

import com.piyushvj.etl_system.helper.SuperFactory;

public class ExtractorFactory implements SuperFactory<Extractor> {

    @Override
    public Extractor create(String type) {
        switch (type){
            case "CSV" : return new CSVExtractor();
            //case "TXT" : return new TXTReader(); // TODO: For TEXT FILE
            default: return null;
        }
    }
}
