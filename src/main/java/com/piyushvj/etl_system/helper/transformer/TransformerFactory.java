package com.piyushvj.etl_system.helper.transformer;

import com.piyushvj.etl_system.helper.SuperFactory;

public class TransformerFactory implements SuperFactory<CustomTransformer> {
    @Override
    public CustomTransformer create(String type) {
        switch (type){
            case "CAPITAL" : return new CapitalTransformer();
            //case "SMALL" : return new SmallTransformer();// TODO: return small object
            default:return null;
        }
    }
}
