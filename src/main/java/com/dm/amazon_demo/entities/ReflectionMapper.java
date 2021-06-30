package com.dm.amazon_demo.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class ReflectionMapper {
    protected final Map<String, Consumer<String>> reflectionMap;

    protected ReflectionMapper() {
        reflectionMap = new HashMap<>();
        initReflectionMapper();
    }

    protected abstract void initReflectionMapper();

    public void setByName(String field, String value) {
        reflectionMap.get(field).accept(value);
    }
}
