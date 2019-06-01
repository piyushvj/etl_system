package com.piyushvj.etl_system.helper.transformer;

public class CapitalTransformer implements CustomTransformer {

    @Override
    public String transform(String readData) {
        return readData.toUpperCase();
    }
}
