package com.piyushvj.etl_system.helper;

public interface SuperFactory<T> {
    T create(String type);
}
