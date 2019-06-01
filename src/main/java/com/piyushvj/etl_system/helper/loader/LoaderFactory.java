package com.piyushvj.etl_system.helper.loader;

import com.piyushvj.etl_system.helper.SuperFactory;

public class LoaderFactory implements SuperFactory<CustomLoader> {

    @Override
    public CustomLoader create(String type) {
        switch (type){
            case "TXT": return new TextLoader();
            //case "CSV" : return new CSVLoader(); // TODO: CSV LOADER
            default: return null;
        }
    }
}
